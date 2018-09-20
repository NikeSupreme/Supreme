package com.hxc.supreme.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hxc.supreme.R;

import uk.co.senab.photoview.PhotoView;


/**
 * created by huxc  on 2018/6/11.
 * func：GlideTestActivity
 * email: hxc242313@qq.com
 */

public class GlideTestActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "GlideTestActivity";
    private Button btnGlideShowg;
    private PhotoView ivImg;
    private String jpgUrl = "https://img4.duitang.com/uploads/item/201609/23/20160923073516_rL3UG.jpeg";
//    private String gifUrl = "http://p0.qhimgs4.com/t0129ddb6e5427431b0.gif";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide_test);
        btnGlideShowg = findViewById(R.id.btn_glide);
        ivImg = findViewById(R.id.iv_image);
        btnGlideShowg.setOnClickListener(this);
    }


    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_glide:
                Glide.with(this)
                        .load(jpgUrl)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
//                        .placeholder(R.drawable.guide_1)
                        .into(ivImg);
                break;
        }
    }
}
