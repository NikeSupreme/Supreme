package com.hxc.supreme.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.hxc.supreme.R;


/**
 * created by huxc  on 2017/9/28.
 * email: hxc242313@qq.com
 */

public class BLifeCycleActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnTest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_life_cycle);
        Log.e("BLifeCycleActivity", "onCreate");
        btnTest = findViewById(R.id.btn_test);
        btnTest.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("BLifeCycleActivity", "onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("BLifeCycleActivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("BLifeCycleActivity", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("BLifeCycleActivity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("BLifeCycleActivity", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("BLifeCycleActivity", "onDestroy");
    }


}
