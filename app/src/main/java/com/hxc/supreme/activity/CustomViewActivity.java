package com.hxc.supreme.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.hxc.supreme.R;

/**
 * created by huxc  on 2017/9/28.
 * func：  自定义view列表
 * email: hxc242313@qq.com
 */

public class CustomViewActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnPieChart;//饼状图
    private Button btnSurfaceView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        initView();
        initListener();
    }


    protected void initView() {
        btnPieChart = (Button) findViewById(R.id.btn_pie_chart);
        btnSurfaceView = (Button) findViewById(R.id.btn_surfaceView);
    }

    protected void initListener() {
        btnPieChart.setOnClickListener(this);
        btnSurfaceView.setOnClickListener(this);
    }
    protected void initData() {
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_pie_chart://饼状图
                startActivity(new Intent(this,PieChartActivity.class));
                break;
            case R.id.btn_surfaceView://sin函数
                startActivity(new Intent(this,SurfaceViewActivity.class));
                break;
        }
    }
}
