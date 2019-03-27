package com.example.guess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    private EditText userName,passWord;
    private Button login_button,login_register;
    private String UserName,PassWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userName = findViewById(R.id.login_username);
        passWord = findViewById(R.id.login_passwordd);
        login_button = findViewById(R.id.login_button);
        login_register = findViewById(R.id.login_register);
        login_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this,register.class);
                startActivity(intent);
            }
        });
        /*login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                UserName = intent.getStringExtra("Username");
                PassWord = intent.getStringExtra("Password");
                if(!UserName.equals("")||!PassWord.equals("")){
                    if (UserName.equals(userName.getText().toString())&& PassWord.equals(passWord.getText().toString())){
                        //成功登录
                        Intent intent3 = new Intent(login.this,Entry.class);
                        startActivity(intent3);
                    }
                    else
                        Toast.makeText(login.this, "账号或密码输入不正确，请检查后重新输入", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(login.this, "账号或密码为空，请检查后重新输入", Toast.LENGTH_SHORT).show();

            }
        });*/
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if(userName.getText().toString()!=null && passWord.getText().toString()!=null){
                        if (userName.getText().toString().equals(register.User.getUserName())&&passWord.getText().toString().equals(register.User.getPassWord())){
                            Toast.makeText(login.this, "登录成功！欢迎您"+register.User.getUserName()+"您现在的等级是"+register.User.getRank(), Toast.LENGTH_SHORT).show();
                        register.User.setLoginFlag(1);
                            Intent intent = new Intent(login.this,Entry.class);
                            startActivity(intent);
                        }
                    }
                    else
                        Toast.makeText(login.this, "用户名或密码为空，请检查后重新输入~", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
