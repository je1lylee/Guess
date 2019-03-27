package com.example.guess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {
    private EditText userName,passWord,repeatt;
    private Button register;
    public static user User;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        userName = findViewById(R.id.login_username);
        passWord = findViewById(R.id.login_passwordd);
        repeatt = findViewById(R.id.login_repeatpassword);
        register = findViewById(R.id.register_button);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!userName.getText().toString().equals("")){
                    //TODO 检查空值
                    if (passWord.getText().toString().equals(repeatt.getText().toString())){
                         User = new user();
                         User.registerUser(userName.getText().toString(),passWord.getText().toString());
                        Toast.makeText(register.this, "注册成功！您的用户名是："+User.getUserName(), Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(register.this,login.class);
                        //如果需要使用intent用这个里面的代码;
                        /*intent.putExtra("Username",userName.getText().toString());
                        intent.putExtra("password",passWord.getText().toString());
                        startActivity(intent);*/

                    }
                    else{
                        Toast.makeText(register.this,"两次密码输入不一致，请检查后重新输入", Toast.LENGTH_SHORT).show();
                    }
                    
                }
                else{
                    Toast.makeText(register.this, "有项目还未填写", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
