package com.hxc.supreme.fragment;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.hxc.supreme.R;
import com.hxc.supreme.activity.PlayMusicActivity;
import com.hxc.supreme.utils.ToastUtil;

/**
 * created by huxc  on 2017/11/30.
 * func：音乐播放器底部快速播放按钮
 * email: hxc242313@qq.com
 */

public class QuickControlFragment extends Fragment {

    private View rootView;

    private ImageView ivPlay;
    private ImageView ivplayNext;

    public static QuickControlFragment newInstance() {
        return new QuickControlFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.bottom_nav, container, false);
        this.rootView = rootView;

        ivPlay = (ImageView) rootView.findViewById(R.id.iv_play);
        ivplayNext = (ImageView) rootView.findViewById(R.id.iv_play_next);

        ivPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ivPlay.getTag().equals("start")){
                    ivPlay.setTag("stop");
                    ivPlay.setBackgroundResource(R.drawable.playbar_btn_pause);
                }else{
                    ivPlay.setTag("start");
                    ivPlay.setBackgroundResource(R.drawable.playbar_btn_play);
                }

            }
        });

        ivplayNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtil.show(getActivity(),"下一首");
            }
        });

        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            startActivity(new Intent(view.getContext(), PlayMusicActivity.class));
            }
        });



        return rootView;
    }


    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        getActivity().overridePendingTransition(R.anim.side_bottom_in, R.anim.side_bottom_out);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode, Bundle options) {
        super.startActivityForResult(intent, requestCode, options);
        getActivity().overridePendingTransition(R.anim.side_bottom_in, R.anim.side_bottom_out);
    }

}
