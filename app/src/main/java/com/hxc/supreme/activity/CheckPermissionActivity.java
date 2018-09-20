package com.hxc.supreme.activity;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.hxc.supreme.R;
import com.hxc.supreme.utils.ToastUtil;
import com.hxc.supreme.utils.permission.XPermission;


/**
 * created by huxc  on 2017/9/28.
 * func：  Android M权限管理
 * email: hxc242313@qq.com
 */

public class CheckPermissionActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnSimple;
    private Button btnMulti;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_permission);
        initView();
        initListener();
    }


    protected void initView() {
        btnSimple = findViewById(R.id.btn_simple_permission);
        btnMulti = findViewById(R.id.btn_multi_permission);
    }

    protected void initListener() {
        btnSimple.setOnClickListener(this);
        btnMulti.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_simple_permission:
                checkSimplePermission();
                break;
            case R.id.btn_multi_permission:
                checkMultiPermission();
                break;

        }
    }

    private void checkSimplePermission() {
        XPermission.requestPermissions(this, 100, new String[]{Manifest.permission.CALL_PHONE}, new XPermission.OnPermissionListener() {
            @Override
            public void onPermissionGranted() {
                ToastUtil.show(CheckPermissionActivity.this, "请求权限成功");
            }

            @Override
            public void onPermissionDenied() {
                XPermission.showTipsDialog(CheckPermissionActivity.this);

            }
        });
    }

    private void checkMultiPermission() {
        XPermission.requestPermissions(this, 101, new String[]{Manifest.permission.CALL_PHONE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, new XPermission.OnPermissionListener() {
            @Override
            public void onPermissionGranted() {
                ToastUtil.show(CheckPermissionActivity.this, "请求权限成功");
            }

            @Override
            public void onPermissionDenied() {
                XPermission.showTipsDialog(CheckPermissionActivity.this);

            }
        });
    }


    /**
     * Android M 全局权限申请回调
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[]
            grantResults) {
        XPermission.onRequestPermissionsResult(requestCode, permissions, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
