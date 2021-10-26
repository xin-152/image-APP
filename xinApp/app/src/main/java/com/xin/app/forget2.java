package com.xin.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class forget2 extends AppCompatActivity implements View.OnClickListener {
    private Button bt_f;
    private TextView tv_f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget2);
        getSupportActionBar().hide();
        //init
        bt_f=findViewById(R.id.bt_f);
        bt_f.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(forget2.this,Login.class);
        startActivity(intent);
    }
}