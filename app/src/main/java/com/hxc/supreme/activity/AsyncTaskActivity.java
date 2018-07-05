package com.hxc.supreme.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.hxc.supreme.R;
import com.hxc.supreme.fragment.QuickControlFragment;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * created by huxc  on 2017/9/28.
 * func：
 * email: hxc242313@qq.com
 */

public class AsyncTaskActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnDownload;
    private ImageView ivImage;
    private TextView tvProgress;
    private final String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1530768567689&di=c482b903234896b9a551079259e10101&imgtype=0&src=http%3A%2F%2Fmvimg11.meitudata.com%2F598678971f3932409.jpg";
//    private final String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1530768520670&di=b77ba83872c7f2d1c1d5b10398ceaf2d&imgtype=0&src=http%3A%2F%2Fi10.hoopchina.com.cn%2Fhupuapp%2Fbbs%2F720%2F31253720%2Fthread_120_31253720_20180608155609_62946.gif";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asynctask);
        initView();
        initListener();
        initData();
    }

    protected void initView() {
        btnDownload = (Button) findViewById(R.id.btn_download);
        ivImage = (ImageView) findViewById(R.id.iv_image);
        tvProgress = (TextView) findViewById(R.id.tv_progress);
    }

    protected void initListener() {
        btnDownload.setOnClickListener(this);
    }

    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        if (view == btnDownload) {
            MyAsyncTask asyncTask = new MyAsyncTask();
            asyncTask.execute(url);
        }
    }


    class MyAsyncTask extends AsyncTask<String, String, Bitmap> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            tvProgress.setText("下载开始");
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            publishProgress("正在下载中...");
            return getBitmapFromUrl(strings[0]);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            tvProgress.setText("正在下载中...");
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            ivImage.setImageBitmap(bitmap);
            tvProgress.setText("下载结束");
        }
    }

    public Bitmap getBitmapFromUrl(String urlString) {
        Bitmap bitmap;
        InputStream is = null;

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            is = new BufferedInputStream(connection.getInputStream());
            bitmap = BitmapFactory.decodeStream(is);
            connection.disconnect();
            return bitmap;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


}
