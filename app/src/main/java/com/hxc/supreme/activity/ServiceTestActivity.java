package com.hxc.supreme.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.hxc.supreme.R;
import com.hxc.supreme.service.MainService;


/**
 * created by huxc  on 2017/9/28.
 * func：  ServiceTestActivity
 * email: hxc242313@qq.com
 */

public class ServiceTestActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnStart;
    private Button btnStop;
    private Button btnBind;
    private Button btnUnbind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_test);
        btnStart = findViewById(R.id.btn_start);
        btnStop = findViewById(R.id.btn_stop);
        btnBind = findViewById(R.id.btn_bind);
        btnUnbind = findViewById(R.id.btn_unbind);
        btnStart.setOnClickListener(this);
        btnStart.setOnClickListener(this);
        btnBind.setOnClickListener(this);
        btnUnbind.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start:
                startService();
                break;
            case R.id.btn_stop:
                stopService();
                break;
            case R.id.btn_bind:
                bindService();
                break;
            case R.id.btn_unbind:
                unBindService();
                break;
        }
    }

    private void startService() {
        Intent it = new Intent(this, MainService.class);
        startService(it);
    }
    private void stopService() {
        Intent it = new Intent(this, MainService.class);
        stopService(it);
    }

    private void bindService() {
        Intent it = new Intent(this, MainService.class);
        bindService(it,serviceConnection,BIND_AUTO_CREATE);
    }
    private void unBindService() {
        unbindService(serviceConnection);
    }

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MainService.MyBinder myBinder = (MainService.MyBinder) iBinder;
            myBinder.showToast();
            myBinder.showList();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };


}
