package com.hxc.supreme.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hxc.supreme.R;

/**
 * created by huxc  on 2017/11/24.
 * func：
 * email: hxc242313@qq.com
 */

public class FrameActivity extends Activity implements View.OnClickListener {
    private Button btnOkHttp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);
        initView();
        initListener();
        initData();
    }

    private void initView() {
        btnOkHttp = (Button) findViewById(R.id.btn_okhttp);
    }

    private void initListener() {
        btnOkHttp.setOnClickListener(this);
    }

    private void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_okhttp:
                startActivity(new Intent(this, OkhttpTestActivity.class));
                break;
        }
    }
}
