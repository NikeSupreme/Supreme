package com.hxc.supreme.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hxc.supreme.R;
import com.hxc.supreme.customView.SinSurfaceView;

/**
 * created by huxc  on 2017/9/28.
 * func：sin曲线
 * email: hxc242313@qq.com
 */

public class SurfaceViewActivity extends AppCompatActivity {
    private SinSurfaceView sinSurfaceView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surfaceview);
        sinSurfaceView = (SinSurfaceView) findViewById(R.id.surfaceView);

    }


}
