package com.hxc.supreme.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hxc.supreme.R;

/**
 * created by huxc  on 2017/12/12.
 * func：
 * email: hxc242313@qq.com
 */

public class FrdFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("FrdFragment","onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i("FrdFragment","onCreateView");
        View view = inflater.inflate(R.layout.tab2, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i("FrdFragment","onViewCreated");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("FrdFragment","onActivityCreated");

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("FrdFragment","onStart");
        if(getUserVisibleHint()){
            pullData();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("FrdFragment","onResume");
        if (getUserVisibleHint()) {
            pullData();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.i("FrdFragment","isVisibleToUser = "+isVisibleToUser);
    }

    private void pullData() {
        Log.i("FrdFragment", "pullData");
    }
}

