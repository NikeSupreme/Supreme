package com.hxc.supreme.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

import com.hxc.supreme.R;

/**
 * created by huxc  on 2017/9/28.
 * func：属性动画
 * email: hxc242313@qq.com
 */

public class PropertyAnimationActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnTranslate;
    private Button btnRotate;
    private Button btnScale;
    private Button btnFade;
    private Button btnCombination;
    private Button btnPoint;

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
        btnPoint = (Button) findViewById(R.id.btn_ponit);
    }

    protected void initListener() {
        btnTranslate.setOnClickListener(this);
        btnScale.setOnClickListener(this);
        btnRotate.setOnClickListener(this);
        btnFade.setOnClickListener(this);
        btnCombination.setOnClickListener(this);
        btnPoint.setOnClickListener(this);
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
                float curTranslationX = btnTranslate.getTranslationX();
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(btnTranslate, "translationX", curTranslationX, -500f, curTranslationX);
                animator1.setDuration(5000);
                animator1.start();
                break;
            case R.id.btn_rotate:
                ObjectAnimator animator2 = ObjectAnimator.ofFloat(btnRotate, "rotation", 0f, 360f,50f,180f);
                animator2.setDuration(5000);
                animator2.start();
                break;
            case R.id.btn_fade:
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(btnFade, "alpha", 1f, 0f, 1f);
                objectAnimator.setDuration(2000);
                objectAnimator.start();
                break;
            case R.id.btn_scale:
                ObjectAnimator animator3 = ObjectAnimator.ofFloat(btnScale, "scaleX", 1f, 2f, 0.5f,1f);
                animator3.setDuration(5000);
                animator3.start();
                break;
            case R.id.btn_combination:
                ObjectAnimator moveIn = ObjectAnimator.ofFloat(btnCombination, "translationX", -300f, 0f);
                ObjectAnimator rotate = ObjectAnimator.ofFloat(btnCombination, "rotation", 0f, 360f);
                ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(btnCombination, "alpha", 1f, 0f, 1f);
                AnimatorSet animSet = new AnimatorSet();
                animSet.play(rotate).with(fadeInOut).after(moveIn);
                animSet.setDuration(5000);
                animSet.start();
                break;
            case R.id.btn_ponit:
                startActivity(new Intent(this,PointAnimationActivity.class));
                break;
        }
    }

}
