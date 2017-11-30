package com.hxc.supreme.activity;

import android.app.Activity;
import android.os.Bundle;

import com.hxc.supreme.R;
import com.hxc.supreme.customView.MyAnimView;

/**
 * created by huxc  on 2017/10/19.
 * func：
 * email: hxc242313@qq.com
 */

public class PointAnimationActivity extends Activity {
    MyAnimView myAnimView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point_animation);
        myAnimView = (MyAnimView) findViewById(R.id.myAnimation);
    }
}
