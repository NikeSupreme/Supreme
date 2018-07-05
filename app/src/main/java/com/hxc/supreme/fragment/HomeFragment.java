package com.hxc.supreme.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hxc.supreme.R;
import com.hxc.supreme.activity.AnimationActivity;
import com.hxc.supreme.activity.CustomViewActivity;
import com.hxc.supreme.activity.FrameActivity;
import com.hxc.supreme.activity.HandlerTestActivity;
import com.hxc.supreme.activity.AsyncTaskActivity;
import com.hxc.supreme.activity.RecycleViewActivity;

/**
 * created by huxc  on 2017/12/12.
 * func：
 * email: hxc242313@qq.com
 */

public class HomeFragment extends Fragment implements View.OnClickListener{
    private Button btnCustomView;
    private Button animation;
    private Button btnFrame;
    private Button btnRecycleView;
    private Button btnMusic;
    private Button btnHandler;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        initListener();
        initData();
        return view;
    }

    private void initView(View view) {
        btnCustomView = (Button) view.findViewById(R.id.custom_view);
        animation = (Button) view.findViewById(R.id.animation);
        btnFrame = (Button) view.findViewById(R.id.frame);
        btnRecycleView = (Button)view. findViewById(R.id.recycleView);
        btnMusic = (Button)view. findViewById(R.id.btn_music);
        btnHandler = (Button)view. findViewById(R.id.btn_handler);
    }

    private void initListener() {
        btnCustomView.setOnClickListener(this);
        animation.setOnClickListener(this);
        btnFrame.setOnClickListener(this);
        btnRecycleView.setOnClickListener(this);
        btnMusic.setOnClickListener(this);
        btnHandler.setOnClickListener(this);
    }

    private void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.custom_view:
                startActivity(new Intent(getActivity(), CustomViewActivity.class));
                break;
            case R.id.animation:
                startActivity(new Intent(getActivity(), AnimationActivity.class));
                break;
            case R.id.frame:
                startActivity(new Intent(getActivity(), FrameActivity.class));
                break;
            case R.id.recycleView:
                startActivity(new Intent(getActivity(), RecycleViewActivity.class));
                break;
            case R.id.btn_music:
                startActivity(new Intent(getActivity(), AsyncTaskActivity.class));
                break;
            case R.id.btn_handler:
                startActivity(new Intent(getActivity(), HandlerTestActivity.class));
                break;
        }

    }

}

