package com.xin.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity{
    Button bt_login_login;
    TextView bt_login_register,login_userNamer,forget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        //init
        bt_login_login=findViewById(R.id.bt_login);
        bt_login_register=findViewById(R.id.login_reg);
        login_userNamer=findViewById(R.id.login_uname);
        forget=findViewById(R.id.forget);

        //登录 单击
        bt_login_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //init
                Intent intent=new Intent(Login.this,MainActivity.class);
                intent.putExtra("username",login_userNamer.getText().toString().trim());
                //跳转
                startActivity(intent);
            }
        });
        //注册 单击
        bt_login_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,Register.class);
                startActivity(intent);
            }
        });
        //忘记密码 单击
        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,Forget.class);
                startActivity(intent);
            }
        });
    }
}