package com.xin.app;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ViewPager2 viewPager;
    private LinearLayout menu_one,menu_two,menu_three,menu_four;
    private ImageView menu_one_iv,menu_two_iv,menu_three_iv,menu_four_iv,menu_current_iv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        initViewpager();
        initButtonMenu();
        //
    }

    private void initButtonMenu() {
        menu_one=findViewById(R.id.menu_one);
        menu_two=findViewById(R.id.menu_two);
        menu_three=findViewById(R.id.menu_three);
        menu_four=findViewById(R.id.menu_four);

        menu_one.setOnClickListener(this);
        menu_two.setOnClickListener(this);
        menu_three.setOnClickListener(this);
        menu_four.setOnClickListener(this);

        menu_one_iv=findViewById(R.id.menu_one_iv);
        menu_two_iv=findViewById(R.id.menu_two_iv);
        menu_three_iv=findViewById(R.id.menu_three_iv);
        menu_four_iv=findViewById(R.id.menu_four_iv);

        menu_one_iv.setSelected(true);
        menu_current_iv=menu_one_iv;
    }

    private void initViewpager() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new img_waterfall());
        fragments.add(new Top());
        fragments.add(new Search());
        fragments.add(new Myinfo());

        viewPager = findViewById(R.id.viewpager);
        MyfragmentPagerAdapter pagerAdapter=new MyfragmentPagerAdapter(getSupportFragmentManager(),getLifecycle(),fragments);
        viewPager.setAdapter(pagerAdapter);

        //监听滑动
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            //滚动动画
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }
            //页面改变
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                changeMenu(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    private void changeMenu(int position) {
        menu_current_iv.setSelected(false);
        switch (position){
            case R.id.menu_one:
                viewPager.setCurrentItem(0);
            case 0:
                menu_one_iv.setSelected(true);
                menu_current_iv=menu_one_iv;
                break;
            case R.id.menu_two:
                viewPager.setCurrentItem(1);
            case 1:
                menu_two_iv.setSelected(true);
                menu_current_iv=menu_two_iv;
                break;
            case R.id.menu_three:
                viewPager.setCurrentItem(2);
            case 2:
                menu_three_iv.setSelected(true);
                menu_current_iv=menu_three_iv;
                break;
            case R.id.menu_four:
                viewPager.setCurrentItem(3);
            case 3:
                menu_four_iv.setSelected(true);
                menu_current_iv=menu_four_iv;
                break;
        }
    }

    @Override
    public void onClick(View view) {
        changeMenu(view.getId());
    }

}