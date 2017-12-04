package com.hxc.supreme.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.hxc.supreme.R;

/**
 * created by huxc  on 2017/11/30.
 * func： 音乐播放界面
 * email: hxc242313@qq.com
 */

public class PlayMusicActivity extends BaseActivity {
    private Button btnPullView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
        btnPullView = (Button) findViewById(R.id.btn_pull_view);
        btnPullView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.side_bottom_in, R.anim.side_bottom_out);
    }
}
