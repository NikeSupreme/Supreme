package com.hxc.supreme.activity;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hxc.supreme.R;
import com.hxc.supreme.adapter.RecycleAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * created by huxc  on 2017/9/28.
 * func： recycleView
 * email: hxc242313@qq.com
 */

public class RecycleViewActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView mRecyclerView;
    private List<String> data;
    private RecycleAdapter adapter;
    private Button btnInsert, btnDelete;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);
        initView();
        initListener();
        initData();
    }

    protected void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycleView);
        btnInsert = (Button) findViewById(R.id.insert_item);
        btnDelete = (Button) findViewById(R.id.delete_item);
    }

    protected void initListener() {
        btnInsert.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
    }

    protected void initData() {
        adapter = new RecycleAdapter();
        getData();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.set(0, 0, 0, 3);
            }
        });
        mRecyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new RecycleAdapter.OnItemClickListener()
        {

            @Override
            public void onItemClick(View view, int position)
            {
                Toast.makeText(RecycleViewActivity.this, position + " click",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position)
            {
                Toast.makeText(RecycleViewActivity.this, position + " long click",
                        Toast.LENGTH_SHORT).show();
                adapter.removeData(position);
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


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.insert_item:
                adapter.addData(1);
                break;
            case R.id.delete_item:
                adapter.removeData(1);
                break;
        }

    }

}
