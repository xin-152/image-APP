package com.xin.app;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class img_waterfall extends Fragment {
    private RecyclerView recyclerView;
    private List<Integer> imagesId=new ArrayList<>();
    private RvImageAdapter adapter;
    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //数据源(图片)
        initData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_img_waterfall, container, false);
        initView();
        initRecyclerView();
        return view;
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
//            @Override
//            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
//                super.onDraw(c, parent, state);
//                Paint paint=new Paint();
//                paint.setColor(Color.YELLOW);
//                paint.setStrokeWidth(5);
//                paint.setAntiAlias(true);
//                paint.setStyle(Paint.Style.STROKE);
//
//                for (int i = 0; i < parent.getChildCount(); i++) {
//                    View view = parent.getChildAt(i);
//                    //绘制图片的边框
//                    c.drawRect(view.getLeft()-1,view.getTop()-1,view.getRight()+1,view.getBottom()+1,paint);
//                }
//            }
        });

        adapter=new RvImageAdapter(getActivity(),imagesId);
        recyclerView.setAdapter(adapter);
    }
    private void initData() {
        String[] icons = getResources().getStringArray(R.array.iconsId);
        //将图片的标记取出来 得到一个数组
        for (int i = 0; i < icons.length; i++) {
            //遍历数组的到图片的id
            int id = getResources().getIdentifier(icons[i], "drawable", getActivity().getPackageName());
            //添加到图片id集合中 然后将集合作为数据源传给适配器
            imagesId.add(id);
        }
    }


    private void initView() {
        recyclerView= view.findViewById(R.id.recyclerView);
    }

}