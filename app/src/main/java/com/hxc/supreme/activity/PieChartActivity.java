package com.hxc.supreme.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hxc.supreme.R;
import com.hxc.supreme.bean.PieChartBean;
import com.hxc.supreme.customView.PieChartView;

import java.util.ArrayList;

/**
 * created by huxc  on 2017/9/28.
 * func：
 * email: hxc242313@qq.com
 */

public class PieChartActivity extends AppCompatActivity {
    private PieChartView pieChartView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);
        initView();
        initData();
    }

    protected void initView() {
        pieChartView = (PieChartView) findViewById(R.id.pie);
    }

    protected void initData() {
        PieChartBean bean1 = new PieChartBean("hxc", 40);
        PieChartBean bean2 = new PieChartBean("zs", 80);
        PieChartBean bean3 = new PieChartBean("zj", 30);
        PieChartBean bean4 = new PieChartBean("xx", 50);

        ArrayList<PieChartBean> list = new ArrayList<>();
        list.add(bean1);
        list.add(bean2);
        list.add(bean3);
        list.add(bean4);
        pieChartView.setData(list);
    }
}
