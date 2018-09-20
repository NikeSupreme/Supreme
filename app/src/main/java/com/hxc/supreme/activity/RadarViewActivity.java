package com.hxc.supreme.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.hxc.supreme.R;
import com.hxc.supreme.customView.RadarView;
import com.hxc.supreme.customView.SinSurfaceView;

/**
 * created by huxc  on 2017/9/28.
 * email: hxc242313@qq.com
 */

public class RadarViewActivity extends AppCompatActivity {
    private RadarView mRadarView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 取消状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_radarview);
        mRadarView = (RadarView) findViewById(R.id.radarView);
        mRadarView.setSearching(true);
        mRadarView.addPoint();
        mRadarView.addPoint();

    }


}
