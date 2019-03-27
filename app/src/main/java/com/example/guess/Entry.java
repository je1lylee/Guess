package com.example.guess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
//Think Young.
public class Entry extends AppCompatActivity {
    private Button button;
    private Button button3;
    private TextView rankView;
    private static final int REQUEAST_CODE_TO_SHAKE_HANDS = 1001;//request code means the flag of other acticity;
    private static final int REQUEAST_CODE_TO_SHAKE_6 = 1002;
    private static final String TAG = "Entry";

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        Log.d(TAG,"调试：回调启用");
        switch (requestCode){
            case REQUEAST_CODE_TO_SHAKE_6:
                if (resultCode==RESULT_OK){
                    String rank = data.getStringExtra("Rank");
                    Log.d(TAG,"调试：进入回调");
                    rankView.setText(rank);
                }
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rankView = findViewById(R.id.rank);
        button = findViewById(R.id.button);
        rankView = findViewById(R.id.rank);
        rankView.setText(register.User.getRank());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//Guess Box
                Toast.makeText(Entry.this,"即将开始猜拳游戏",Toast.LENGTH_SHORT).show();//short = 2s;long = 4s
                Intent intent3 = new Intent(Entry.this,shake_hands.class);
                intent3.putExtra("data_username","玩家姓名");//Give data to next activity
                startActivityForResult(intent3,REQUEAST_CODE_TO_SHAKE_HANDS);
//                intent3.setClass(Entry.this,shake_hands.class);//从当前页面，跳转到某一页面
//                startActivity(intent3);
//                startActivityForResult(intent3,int requestCode);//startActivityForResult(Intent intent, int requestCode)
            }
        });
        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//Shake
                Toast.makeText(Entry.this,"即将开始摇骰子游戏",Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(Entry.this,shake_6.class);
                intent3.putExtra("data_username","玩家姓名");
                startActivityForResult(intent3,REQUEAST_CODE_TO_SHAKE_6);
            }
        });

    }
}
