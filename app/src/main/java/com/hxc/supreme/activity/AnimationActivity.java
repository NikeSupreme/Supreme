package com.hxc.supreme.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hxc.supreme.R;
import com.hxc.supreme.customView.RoundImageView;
import com.hxc.supreme.customView.WhewView;

/**
 * created by huxc  on 2017/9/28.
 * func： 动画合集
 * email: hxc242313@qq.com
 */

public class AnimationActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnTween;
    private Button btnProperty;

    private WhewView wv;
    private RoundImageView my_photo;
    private TextView textView;

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
        wv = (WhewView) findViewById(R.id.wv);
        textView = (TextView) findViewById(R.id.tv_broadcast);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (wv.isStarting()) {//如果动画正在运行就停止，否则就继续执行
                    wv.stop();
                } else {// 执行动画
                    wv.start();
                }
            }
        });
        my_photo = (RoundImageView) findViewById(R.id.my_photo);
        my_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (wv.isStarting()) {//如果动画正在运行就停止，否则就继续执行
                    wv.stop();
                } else {// 执行动画
                    wv.start();
                }
            }
        });

    }

    protected void initListener() {
        btnTween.setOnClickListener(this);
        btnProperty.setOnClickListener(this);
    }

    protected void initData() {
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_tween:
                startActivity(new Intent(this, TweenAnimationActivity.class));
                break;
            case R.id.btn_property:
                startActivity(new Intent(this, PropertyAnimationActivity.class));
                break;
        }
    }
}
