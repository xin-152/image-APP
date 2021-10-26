package com.xin.app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class OpenImg extends AppCompatActivity {
    private ImageView openImg;

    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_open_img);
        //定义全屏参数
        int flag= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        //设置当前窗体为全屏显示
        getWindow().setFlags(flag, flag);
        setContentView(R.layout.activity_open_img);
        //去掉标题栏
        getSupportActionBar().hide();

        one();


    }

    private void one() {
        Animation aaa= new AlphaAnimation(1.0f,0.8f);
        //时长
        aaa.setDuration(2000);
        aaa.setFillAfter(true);
        openImg=findViewById(R.id.openImg);
        openImg.setAnimation(aaa);

        aaa.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}
            @Override
            public void onAnimationEnd(Animation animation) {
//                Intent intent=new Intent(OpenImg.this,MainActivity.class);
//                startActivity(intent);
                handler = new Handler();
                handler.postDelayed(runnable = new Runnable() {
                    @Override
                    public void run() {
                        //从闪屏界面跳转到首界面
                        Intent intent = new Intent(OpenImg.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }, 2000);//延迟5S后发送handler信息
            }
            @Override
            public void onAnimationRepeat(Animation animation) {}
        });
    }
}