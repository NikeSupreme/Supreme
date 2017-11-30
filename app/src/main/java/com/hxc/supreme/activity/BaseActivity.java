package com.hxc.supreme.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.hxc.supreme.R;

/**
 * created by huxc  on 2017/9/28.
 * func：
 * email: hxc242313@qq.com
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initListener();
        initData();
    }

    protected void initView() {
    }

    protected void initListener() {
    }

    protected void initData() {

    }
}
