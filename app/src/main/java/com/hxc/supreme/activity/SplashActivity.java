package com.hxc.supreme.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.hxc.supreme.MainActivity;
import com.hxc.supreme.R;

/**
 * created by huxc  on 2017/11/28.
 * func： 启动页
 * email: hxc242313@qq.com
 */

public class SplashActivity extends Activity {
    private Handler handler = new Handler();
    private Button btnSkip;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
        initData();
        initListener();

    }

    private void initView() {
        btnSkip = (Button) findViewById(R.id.btn_skip);

    }

    private void initListener() {
        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        });

    }

    private void initData() {
        runnable = new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, GuideActivity.class));
                finish();
            }
        };
        handler.postDelayed(runnable, 3000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }
}
