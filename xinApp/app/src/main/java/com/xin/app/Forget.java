package com.xin.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Forget extends AppCompatActivity implements View.OnClickListener {
    private Button bt_next;
    private TextView tv_f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
        getSupportActionBar().hide();

        //init
        bt_next=findViewById(R.id.bt_next);
        tv_f=findViewById(R.id.tv_f);
        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Forget.this,forget2.class);
                startActivity(intent);
            }
        });
        tv_f.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Forget.this.finish();
    }
}