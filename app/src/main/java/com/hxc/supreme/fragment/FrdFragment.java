package com.hxc.supreme.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hxc.supreme.R;

/**
 * created by huxc  on 2017/12/12.
 * func：
 * email: hxc242313@qq.com
 */

public class FrdFragment extends Fragment implements View.OnClickListener {
    private TextView tvScene;
    private TextView tvHousekeeper;
    private TextView tvRecommend;
    private View contentLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("FrdFragment", "onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i("FrdFragment", "onCreateView");
        View view = inflater.inflate(R.layout.tab2, container, false);
        tvScene = view.findViewById(R.id.tv_scene);
        tvHousekeeper = view.findViewById(R.id.tv_housekeeper);
        tvRecommend = view.findViewById(R.id.tv_recommend);
        contentLayout = view.findViewById(R.id.layout);

        tvScene.setOnClickListener(this);
        tvHousekeeper.setOnClickListener(this);
        tvRecommend.setOnClickListener(this);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i("FrdFragment", "onViewCreated");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("FrdFragment", "onActivityCreated");

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("FrdFragment", "onStart");
        if (getUserVisibleHint()) {
            pullData();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("FrdFragment", "onResume");
        if (getUserVisibleHint()) {
            pullData();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.i("FrdFragment", "isVisibleToUser = " + isVisibleToUser);
    }

    private void pullData() {
        Log.i("FrdFragment", "pullData");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_scene:
                FragmentManager fm = getChildFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.layout, new SceneFragment()).commit();
                break;
            case R.id.tv_housekeeper:
                FragmentManager fm2 = getChildFragmentManager();
                FragmentTransaction ft2 = fm2.beginTransaction();
                ft2.replace(R.id.layout, new HouseKeeperFragment()).commit();
                break;
            case R.id.tv_recommend:
                FragmentManager fm3 = getChildFragmentManager();
                FragmentTransaction ft3 = fm3.beginTransaction();
                ft3.replace(R.id.layout, new RecommendFragment()).commit();
                break;
        }

    }
}

