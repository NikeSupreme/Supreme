package com.hxc.supreme.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.hxc.supreme.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * created by huxc  on 2017/11/24.
 * func：
 * email: hxc242313@qq.com
 */

public class OkhttpTestActivity extends Activity implements View.OnClickListener {
    private OkHttpClient okHttpClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp_test);
        initView();
        initListener();
        initData();
    }

    private void initView() {
    }

    private void initListener() {
    }

    private void initData() {
        okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url("http://www.baidu.com").build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i("onResponse",response.body().toString());
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
        }
    }
}
