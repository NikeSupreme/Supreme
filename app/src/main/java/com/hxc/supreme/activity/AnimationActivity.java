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
 * func：
 * email: hxc242313@qq.com
 */

public class AnimationActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnTween;
    private Button btnProperty;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        initView();
        initListener();
    }


    protected void initView() {
        btnTween = (Button) findViewById(R.id.btn_tween);
        btnProperty = (Button) findViewById(R.id.btn_property);
    }

    protected void initListener() {
        btnTween.setOnClickListener(this);
        btnProperty.setOnClickListener(this);
    }
    protected void initData() {
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_tween:
                startActivity(new Intent(this,TweenAnimationActivity.class));
                break;
            case R.id.btn_property:
                startActivity(new Intent(this,PropertyAnimationActivity.class));
                break;
        }
    }
}
