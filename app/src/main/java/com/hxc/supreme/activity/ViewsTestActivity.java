package com.hxc.supreme.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hxc.supreme.R;
import com.hxc.supreme.service.MainService;


/**
 * created by huxc  on 2017/9/28.
 * func：  ViewsTestActivity
 * email: hxc242313@qq.com
 */

public class ViewsTestActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout mainLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_views_test);
        mainLayout = findViewById(R.id.layout_main);

        View view = LayoutInflater.from(this).inflate(R.layout.button_view, null);
        TextView textView = new TextView(this);
        textView.setText("add View Dynamic");
        textView.setGravity(Gravity.CENTER);
        textView.setAllCaps(false);
        textView.setTextColor(Color.RED);
        mainLayout.addView(textView,new LinearLayout.LayoutParams(300, 200));
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
        }
    }

}
