package com.example.guess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {
    private EditText userName,passWord,repeatt;
    private Button register;


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
                if(userName.getText()!=null&&passWord.getText()!=null&&repeatt.getText()!=null){
                    
                }
                else{
                    Toast.makeText(register.this, "有", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
