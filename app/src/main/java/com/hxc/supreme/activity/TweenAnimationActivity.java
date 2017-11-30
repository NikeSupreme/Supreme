package com.hxc.supreme.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.hxc.supreme.R;

/**
 * created by huxc  on 2017/9/28.
 * func：补间动画
 * email: hxc242313@qq.com
 */

public class TweenAnimationActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnTranslate;
    private Button btnRotate;
    private Button btnScale;
    private Button btnFade;
    private Button btnCombination;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_test);
        initView();
        initListener();
    }


    protected void initView() {
        btnTranslate = (Button) findViewById(R.id.btn_translate);
        btnFade = (Button) findViewById(R.id.btn_fade);
        btnRotate = (Button) findViewById(R.id.btn_rotate);
        btnScale = (Button) findViewById(R.id.btn_scale);
        btnCombination = (Button) findViewById(R.id.btn_combination);
    }

    protected void initListener() {
        btnTranslate.setOnClickListener(this);
        btnScale.setOnClickListener(this);
        btnRotate.setOnClickListener(this);
        btnFade.setOnClickListener(this);
        btnCombination.setOnClickListener(this);
    }

    protected void initData() {
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_translate:
                TranslateAnimation animation = new TranslateAnimation(0, 300, 0, 0);
                animation.setDuration(1000);
                animation.setFillAfter(true);
//                animation.setInterpolator(new AccelerateInterpolator());//先慢后快
                btnTranslate.startAnimation(animation);
                break;
            case R.id.btn_rotate:
                RotateAnimation rotateAnimation = new RotateAnimation(0, 90, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rotateAnimation.setDuration(1000);
                rotateAnimation.setFillAfter(true);
                btnRotate.startAnimation(rotateAnimation);
                break;
            case R.id.btn_fade:
                AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0.3f);//起始透明度
                alphaAnimation.setDuration(1000);
//                scaleAnimation.setFillAfter(true);
                alphaAnimation.setRepeatCount(2);
                btnFade.startAnimation(alphaAnimation);
                break;
            case R.id.btn_scale:
                ScaleAnimation scaleAnimation = new ScaleAnimation(1, 2, 1, 2);
                scaleAnimation.setDuration(1000);
                btnScale.startAnimation(scaleAnimation);
                break;
            case R.id.btn_combination:
                TranslateAnimation animation1 = new TranslateAnimation(0, 300, 0, 0);
                animation1.setDuration(1000);
                animation1.setFillAfter(true);
                AlphaAnimation animation2 = new AlphaAnimation(1, 0.3f);//起始透明度
                animation2.setDuration(1000);
//                scaleAnimation.setFillAfter(true);
                animation2.setRepeatCount(2);

                AnimationSet animationSet = new AnimationSet(false);
                animationSet.addAnimation(animation1);
                animationSet.addAnimation(animation2);
                btnCombination.startAnimation(animationSet);
                break;
        }
    }

}
