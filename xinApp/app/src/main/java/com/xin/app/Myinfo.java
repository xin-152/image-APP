package com.xin.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class Myinfo extends Fragment{
    private View view;
    private Button bt_my_login;
    private TextView tv_userName;
    String str;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view==null){
            view=inflater.inflate(R.layout.fragment_myinfo, container, false);
        }
        initView();
        btclick();

        return view;
    }

    private void btclick() {
        bt_my_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),Login.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        bt_my_login=view.findViewById(R.id.bt_my_login);
        tv_userName=view.findViewById(R.id.my_userName);

        Intent intent=getActivity().getIntent();
        str=intent.getStringExtra("username");

        if (str==null||str.equals("")){
            tv_userName.setText("请先登录哦");
            bt_my_login.setVisibility(View.VISIBLE);
        }else {
            tv_userName.setText("欢迎"+str+"的到来");
            bt_my_login.setVisibility(View.INVISIBLE);
        }
    }


}