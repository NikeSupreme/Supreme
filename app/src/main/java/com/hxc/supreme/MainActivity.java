package com.hxc.supreme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hxc.supreme.activity.AnimationActivity;
import com.hxc.supreme.activity.FrameActivity;
import com.hxc.supreme.activity.RecycleViewActivity;
import com.hxc.supreme.activity.TweenAnimationActivity;
import com.hxc.supreme.activity.CustomViewActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnCustomView;
    private Button animation;
    private Button btnFrame;
    private Button btnRecycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
        initData();
    }

    private void initView() {
        btnCustomView = (Button) findViewById(R.id.custom_view);
        animation = (Button) findViewById(R.id.animation);
        btnFrame = (Button) findViewById(R.id.frame);
        btnRecycleView = (Button) findViewById(R.id.recycleView);
    }

    private void initListener() {
        btnCustomView.setOnClickListener(this);
        animation.setOnClickListener(this);
        btnFrame.setOnClickListener(this);
        btnRecycleView.setOnClickListener(this);
    }

    private void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.custom_view:
                startActivity(new Intent(this, CustomViewActivity.class));
                break;
            case R.id.animation:
                startActivity(new Intent(this, AnimationActivity.class));
                break;
            case R.id.frame:
                startActivity(new Intent(this, FrameActivity.class));
                break;
            case R.id.recycleView:
                startActivity(new Intent(this, RecycleViewActivity.class));
                break;
        }
    }
}
