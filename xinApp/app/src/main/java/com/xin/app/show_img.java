package com.xin.app;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class show_img extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ImageView showimg_pic;

    private show_img_Adapter adapter;
    private List<Integer> imagesId=new ArrayList<>();
    private ImageView zan,bi,love;
    private boolean flag_zan,flag_bi,flag_love;
    private int imgs[]={R.drawable.p16, R.drawable.p20, R.drawable.p21, R.drawable.p28};

    int imgID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_img);
        getSupportActionBar().hide();
        initView();
        initDate();
        initRecyclerView();
        iv_onclick();
    }
    private void initDate() {
        for (int i = 0; i < imgs.length; i++) {
            imagesId.add(imgs[i]);
        }
        //接收数据
        Intent intent =getIntent();
        imgID=intent.getIntExtra("imgID",0);
        showimg_pic.setImageResource(imgID);
    }
    private void iv_onclick() {
        flag_zan=false;
        flag_bi=false;
        flag_love=false;
        zan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag_zan) {
                    zan.setSelected(false);
                    flag_zan=!flag_zan;
                }
                else {
                    zan.setSelected(true);
                    flag_zan=!flag_zan;
                }
            }
        });
        zan.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v) {
                zan_animate();
                bi_animate();
                love_animate();
                zan.setSelected(true);
                bi.setSelected(true);
                love.setSelected(true);
                flag_zan=true;
                flag_bi=true;
                flag_love=true;
                return true;
            }
        });
        bi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag_bi) {
                    bi.setSelected(false);
                    flag_bi=!flag_bi;
                }
                else {
                    bi.setSelected(true);
                    flag_bi=!flag_bi;
                }
            }
        });
        love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag_love) {
                    love.setSelected(false);
                    flag_love=!flag_love;
                }
                else {
                    love.setSelected(true);
                    flag_love=!flag_love;
                }
            }
        });
    }

    private void initView(){
        recyclerView= findViewById(R.id.rv_showimg);
        zan=findViewById(R.id.zan);
        bi=findViewById(R.id.bi);
        love=findViewById(R.id.love);
        showimg_pic=findViewById(R.id.showimg_pic);
    }

    private void initRecyclerView() {
        //设置瀑布流进行展示
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        //设置内部条目的边距(这里是图片的间距)
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {

            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.set(20,20,20,20);
            }
            //给每一张图片画一个边框 (为了好看点..)调用onDraw方法
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                super.onDraw(c, parent, state);
                Paint paint=new Paint();
                paint.setColor(Color.YELLOW);
                paint.setStrokeWidth(5);
                paint.setAntiAlias(true);
                paint.setStyle(Paint.Style.STROKE);

                for (int i = 0; i < parent.getChildCount(); i++) {
                    View view = parent.getChildAt(i);
                    //绘制图片的边框
                    c.drawRect(view.getLeft()-1,view.getTop()-1,view.getRight()+1,view.getBottom()+1,paint);
                }
            }
        });

        adapter=new show_img_Adapter(this,imagesId);
        recyclerView.setAdapter(adapter);
    }
    public void zan_animate(){
        ObjectAnimator anim = ObjectAnimator.ofFloat(zan, "rotation", 0f, 360f);
        anim.setDuration(450);
        anim.start();
    }
    public void bi_animate(){
        ObjectAnimator anim = ObjectAnimator.ofFloat(bi, "rotation", 0f, 360f);
        anim.setDuration(450);
        anim.start();
    }
    public void love_animate(){
        ObjectAnimator anim = ObjectAnimator.ofFloat(love, "rotation", 0f, 360f);
        anim.setDuration(450);
        anim.start();
    }
}