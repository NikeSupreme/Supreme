package com.hxc.supreme.fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hxc.supreme.R;
import com.hxc.supreme.activity.RecycleViewActivity;
import com.hxc.supreme.adapter.RecycleAdapter;
import com.hxc.supreme.adapter.VerRecycleAdapter;
import com.hxc.supreme.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import static android.support.v7.widget.RecyclerView.SCROLL_STATE_IDLE;

/**
 * created by huxc  on 2017/12/12.
 * func：
 * email: hxc242313@qq.com
 */

public class SceneFragment extends Fragment {
    private RecyclerView horRecyclerView;
    private RecyclerView verRecyclerView;
    private List<String> data;
    private RecycleAdapter adapter;
    private VerRecycleAdapter verRecycleAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scene, container, false);
        initView(view);
        initData();
        return view;
    }

    protected void initView(View view) {
        horRecyclerView = (RecyclerView) view.findViewById(R.id.hor_recycleView);
        verRecyclerView = (RecyclerView) view.findViewById(R.id.ver_recycleView);
    }


    protected void initData() {
        adapter = new RecycleAdapter();
        verRecycleAdapter = new VerRecycleAdapter();
        getData();
        horRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        horRecyclerView.setItemAnimator(new DefaultItemAnimator());
        horRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.set(0, 0, 0, 3);
            }
        });
        horRecyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new RecycleAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getActivity(), position + " click",
                        Toast.LENGTH_SHORT).show();
                getVerData(position);
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(getActivity(), position + " long click",
                        Toast.LENGTH_SHORT).show();
//                adapter.removeData(position);
            }
        });
        verRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        verRecyclerView.setItemAnimator(new DefaultItemAnimator());
        verRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.set(0, 0, 0, 3);
            }
        });
        verRecyclerView.setAdapter(verRecycleAdapter);
        verRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == SCROLL_STATE_IDLE) {
                    getActivity().findViewById(R.id.btn_all).setVisibility(View.VISIBLE);
                } else {
                    getActivity().findViewById(R.id.btn_all).setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

        verRecycleAdapter.setOnItemClickListener(new VerRecycleAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getActivity(), position + " click",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(getActivity(), position + " long click",
                        Toast.LENGTH_SHORT).show();
//                adapter.removeData(position);
            }
        });

    }

    protected void getData() {
        data = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++) {
            data.add("" + (char) i);
        }
        adapter.setData(data);
    }

    private void getVerData(int number) {
        List<String> verData = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            verData.add(i + "");
        }
        verRecycleAdapter.setData(verData);
    }

}

