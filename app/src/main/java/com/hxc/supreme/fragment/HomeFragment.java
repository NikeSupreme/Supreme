package com.hxc.supreme.fragment;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.hxc.supreme.R;
import com.hxc.supreme.activity.AnimationActivity;
import com.hxc.supreme.activity.CheckPermissionActivity;
import com.hxc.supreme.activity.CustomViewActivity;
import com.hxc.supreme.activity.FrameActivity;
import com.hxc.supreme.activity.GlideTestActivity;
import com.hxc.supreme.activity.HandlerTestActivity;
import com.hxc.supreme.activity.AsyncTaskActivity;
import com.hxc.supreme.activity.RecycleViewActivity;

/**
 * created by huxc  on 2017/12/12.
 * func：HomeFragment
 * email: hxc242313@qq.com
 */

public class HomeFragment extends Fragment implements  AdapterView.OnItemClickListener {
    private ListView mListview;

    private String[] items;

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
        mListview = view.findViewById(R.id.main_listView);
    }

    private void initListener() {
        mListview.setOnItemClickListener(this);
    }

    private void initData() {
        items = getResources().getStringArray(R.array.item_list);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        switch (position) {
            case 0:
                startActivity(new Intent(getActivity(), CustomViewActivity.class));
                break;
            case 1:
                startActivity(new Intent(getActivity(), AnimationActivity.class));
                break;
            case 2:
                startActivity(new Intent(getActivity(), FrameActivity.class));
                break;
            case 3:
                startActivity(new Intent(getActivity(), RecycleViewActivity.class));
                break;
            case 4:
                startActivity(new Intent(getActivity(), AsyncTaskActivity.class));
                break;
            case 5:
                startActivity(new Intent(getActivity(), HandlerTestActivity.class));
                break;
            case 6:
                startActivity(new Intent(getActivity(), GlideTestActivity.class));
                break;
            case 7:
                startActivity(new Intent(getActivity(), CheckPermissionActivity.class));
                break;


        }

    }
}

