package com.example.guess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class shake_6 extends AppCompatActivity {
    ShakeUtils mShakeUtils;
    private ImageView left, right;
    private Button button;
    private TextView result,nameView;
    private int leftr, rightr;
    private String testt;
    private int times = 0;
    private int high = 0;
    private String username;
    private static final String TAG = "shake_6";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shake_6);
        left = findViewById(R.id.imageView1);
        right = findViewById(R.id.imageView2);
        button = findViewById(R.id.btn_click);
        result = findViewById(R.id.textView3);
        nameView = findViewById(R.id.txt_username);
        Intent intent3 = getIntent();
        username = intent3.getStringExtra("data_username");
        nameView.setText(username);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                times++;
                leftr = beginClick(left);
                rightr = beginClick(right);
                if(leftr+rightr>=8){
                    high++;
                }
                testt = String.valueOf(leftr + rightr);
                result.setText(testt);
                Log.d(TAG,"Rank is"+makeRank(high,times));

            }

        });
        mShakeUtils = new ShakeUtils(this);
        mShakeUtils.setOnShakeListener(new ShakeUtils.OnShakeListener() {
            @Override
            public void onShake() {
                //摇晃设备触发的功能，模拟按钮被按下
                button.performClick();

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mShakeUtils.onResume();
    }

    @Override
    protected void onPause(){
        super.onPause();
        mShakeUtils.onPause();
    }
    //初学乍到 等级1 游学四方 等级2 有学而志 等级3 青年俊才 等级4 学长师友 等级5
    //INPUT:
    //Point:How many times score >= 8;
    //Times:The total times of the game;
    //Return: Rank's String;
    private String makeRank(int high,int times){
        float index;
        index = (float) high/times;
        Log.d(TAG,String.valueOf(index));
        if(index>=0.8 &&index<1)//else if 一个为true就不执行
            return "学长师友";
        else if(index>0.6)
            return "青年俊才";
        else if(index>0.4)
            return "有学而志";
        else if(index>0.2)
            return "游学四方";
        else if(index>=0)
            return "初学乍到";
        else
            return "无法获取等级";
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        //按下Back键的回调方法
        Intent intent = new Intent();
        intent.putExtra("Rank",makeRank(high,times));
        setResult(RESULT_OK,intent);
        finish();
    }

    //传入ImageView实现替换图片的功能
    private int beginClick(ImageView image){
        Random random = new Random();
        int index = random.nextInt(6);// 0 1 2
        switch (index){
            case 0:
                image.setImageResource(R.drawable.t1);
                break;
            case 1:
                image.setImageResource(R.drawable.t2);
                break;
            case 2:
                image.setImageResource(R.drawable.t3);
                break;
            case 3:
                image.setImageResource(R.drawable.t4);
                break;
            case 4:
                image.setImageResource(R.drawable.t5);
                break;
            case 5:
                image.setImageResource(R.drawable.t6);
                break;
        }
        return index+1;
    }
}
