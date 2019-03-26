package com.example.guess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class shake_hands extends AppCompatActivity {
    ShakeUtils mShakeUtils;
    private Button begin;
    private TextView result;
    private ImageView image;
    private static final String TAG = "shake_hands";//logt快速生成

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shake_hands);
        //Get last acticity's data
        Intent intent = getIntent();
        String uname = intent.getStringExtra("data_username");
        //Use logcat print data;
        //Logcat have 5 leavel. In this demo use d. It means debug;
        Log.d(TAG,"My username is "+uname);
        result = findViewById(R.id.textView);
        image = findViewById(R.id.imageView);
        begin = findViewById(R.id.begin);
        begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                beginClick();
            }
        });
        mShakeUtils = new ShakeUtils( this );
        mShakeUtils.setOnShakeListener(new ShakeUtils.OnShakeListener() {

            @Override
            public void onShake() {
                //摇晃设备触发的功能
                Toast.makeText(shake_hands.this,"出拳", Toast.LENGTH_SHORT).show();
                begin.performClick();

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
        mShakeUtils.onPause( );
    }
    /**
     * 猜拳游戏开始业务处理
     */
    private void beginClick(){
        Random random = new Random();
        int index = random.nextInt(3);// 0 1 2
        switch (index){
            case 0:
                image.setImageResource(R.drawable.p1);
                result.setText("本局您出了  布");
                break;
            case 1:
                image.setImageResource(R.drawable.r1);
                result.setText("本局您出了  锤头");
                break;
            case 2:
                image.setImageResource(R.drawable.s1);
                result.setText("本局您出了  剪刀");
                break;
        }
    }
}
