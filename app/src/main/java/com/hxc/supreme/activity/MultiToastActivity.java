package com.hxc.supreme.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.hxc.supreme.R;
import com.hxc.supreme.utils.XToast;


/**
 * created by huxc  on 2017/9/28.
 * func：  Toast
 * email: hxc242313@qq.com
 */

public class MultiToastActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnInfoToast;
    private Button btnWarnToast;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_toast);
        initView();
        initListener();
    }


    protected void initView() {
        btnInfoToast = findViewById(R.id.btn_info_toast);
        btnWarnToast = findViewById(R.id.btn_warn_toast);
    }

    protected void initListener() {
        btnInfoToast.setOnClickListener(this);
        btnWarnToast.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_info_toast:
                XToast.success("success",3000);
                break;
            case R.id.btn_warn_toast:
                XToast.warning("warning",3000);
                break;

        }
    }

}
