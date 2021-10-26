package com.xin.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Top extends Fragment {
    private View view;//定义view用来设置fragment的layout
    public RecyclerView recyclerView;//定义RecyclerView
    private TopRecycleAdapter myAdpter;

    int imgs[]={R.drawable.p10, R.drawable.p7, R.drawable.p19, R.drawable.p18, R.drawable.p45, R.drawable.p26, R.drawable.p3, R.drawable.p2, R.drawable.p24, R.drawable.p30};
    String title[]={"JOJO","幽灵公主","龙猫","哈尔","面麻","怪物之子","千与千寻","阿莉埃蒂","饭","鬼灭之刃"};
    String authors[]={"张三","李四","王五","赵六","世新雷","罗裳","李琪楯","黄骏","柳阐","段紫衣"};
    String imgtxt[]={
            "漫画家绿川幸著作的漫画。故事讲述了夏目贵志从外祖母夏目玲子的遗物中得到了那些..",
            "在京都居住的内向男高中生直实(北村匠海 配音)的面前,突然出现从10年后穿越而来26岁的自己",
            "是由铃木JULIETTA创作的漫画作品 ，连载于《花与梦》杂志。漫画讲述女主角奈奈生离家出走后遇到神秘男...",
            "是由山田尚子执导，吉田玲子剧本，京都动画制作的动画电影。影片于2016年9月17日在日本上映...",
            "是日本吉卜力工作室制作的动画电影，宫崎骏担任原作、监督、脚本设计、角色设定及导演...",
            "这个世上，存在着与人类的世界有所不同的，另一个世界。那是怪物的世界。人类世界的“涩谷”与怪物世...",
            "是宫崎骏执导、编剧，柊瑠美、入野自由、中村彰男、夏木真理等配音，吉卜力工作室制作的动画...",
            "是日本吉卜力工作室制作的动画电影，也是米林宏昌执导的首部电影。影片剧改编自英国作家玛丽·...",
            "悬崖上的金鱼姬一般指崖上的波妞《崖上的波妞》是由吉卜力工作室制作,宫崎骏执导、...",
            "是日本漫画家吾峠呼世晴所著的少年漫画，自2016年2月15日—2020年5月11日在集英社《。.."};

    List<Map<String,Object>> imageInfo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_top, container, false);
        initView();
        initRecyclerView();
        return view;
    }

    private void initView() {
        recyclerView=view.findViewById(R.id.rv_top);
    }


    private void initRecyclerView() {
        myAdpter=new TopRecycleAdapter(getActivity(),imageInfo);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(myAdpter);
    }

    private void initData() {
         String[] top_icon= getResources().getStringArray(R.array.top);

        imageInfo=new ArrayList<>();
        for (int i=0;i<imgs.length;i++){
            int id = getResources().getIdentifier(top_icon[i], "drawable", getActivity().getPackageName());
            Map<String,Object> map=new HashMap<>();
            map.put("id",imgs[i]);
            map.put("icon",id);
            map.put("title",title[i]);
            map.put("author",authors[i]);
            map.put("txt",imgtxt[i]);
            imageInfo.add(map);
        }

    }
}