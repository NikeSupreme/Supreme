package com.hxc.supreme.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.hxc.supreme.R;


/**
 * created by huxc  on 2018/6/11.
 * func：
 * email: hxc242313@qq.com
 */

public class HandlerTestActivity extends AppCompatActivity {
    private static final String TAG = "HandlerTestActivity";
    private Handler uiHandler;
    private Handler mhandler;
    private TextView tvHandler;
    private DownloadLolThread downloadThread;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_test);
        tvHandler = (TextView) findViewById(R.id.tvHandler);
    }

    @Override
    protected void onResume() {
        super.onResume();
        uiHandler = new Handler();
        mhandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                Log.i(TAG, "Thread id = " + Thread.currentThread().getId() + ",msg.what = " + msg.what);
                if (msg.what == 1) {
                    Log.i(TAG, "接收到空消息");
                } else if (msg.what == 2) {
                    Log.i(TAG, "Thread id = " + Thread.currentThread().getId());
                    Log.i(TAG, "msg = " + msg.getData().getString("data"));
                }

            }
        };
        downloadThread = new DownloadLolThread();
        downloadThread.start();


        String text = "hxc123411222222222222222222222";
        int length = text.toCharArray().length;
        String hexStr = Integer.toHexString(length);
        Log.i("hxc123","data = "+hexStr);
    }

    class DownloadLolThread extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                Thread.sleep(3000);
                Log.i(TAG, "DownloadLolThread id = " + Thread.currentThread().getId());
//                tvHandler.setText("啦啦啦啦德玛西亚,下载完成啦!"); crash:Only the original thread that created a view hierarchy can touch its views.
                uiHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        tvHandler.setText("啦啦啦啦德玛西亚,下载完成啦!");
                    }
                });
                Message msg = new Message();
                msg.what = 2;
                Bundle bundle = new Bundle();
                bundle.putString("data", "假装我是数据");
                msg.setData(bundle);
                //发送空消息
                mhandler.sendEmptyMessage(1);
                //发送消息
                mhandler.sendMessage(msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        setResult(RESULT_OK,null);
        finish();
    }


    class MyAsyncTask extends AsyncTask<String,Void,Void>{


        @Override
        protected Void doInBackground(String... strings) {
            return null;
        }
    }

}
