package com.hxc.supreme.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.hxc.supreme.MainActivity;
import com.hxc.supreme.R;
import com.hxc.supreme.widget.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * created by huxc  on 2017/11/28.
 * func：引导页
 * email: hxc242313@qq.com
 */
public class GuideActivity extends AppCompatActivity {
    private final List<View> guideViews = new ArrayList<>();

    private ViewPager guideViewPager;
    private CirclePageIndicator guideIndecator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        initGuideViews();
        guideViewPager = (ViewPager) this
                .findViewById(R.id.home_viewPager);
        guideIndecator = (CirclePageIndicator) findViewById(R.id.home_indicator);
        guideViewPager.setAdapter(new GuidePagerAdapter(guideViews));
        guideIndecator.setViewPager(guideViewPager);
    }

    private void initGuideViews() {
        LayoutInflater inflater = getLayoutInflater();
        FrameLayout guideOne = (FrameLayout) inflater.inflate(R.layout.guide_viewpage_one, null);
        FrameLayout guideTwo = (FrameLayout) inflater.inflate(R.layout.guide_viewpage_one, null);
        FrameLayout guideThree = (FrameLayout) inflater.inflate(R.layout.guide_viewpage_one, null);
        FrameLayout guideFour = (FrameLayout) inflater.inflate(R.layout.guide_viewpage_two, null);
        TextView skip = (TextView) guideFour.findViewById(R.id.guide_tv);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GuideActivity.this, MainActivity.class));
                finish();
            }
        });

        guideOne.setBackgroundResource(R.drawable.guide_1);
        guideTwo.setBackgroundResource(R.drawable.guide_2);
        guideThree.setBackgroundResource(R.drawable.guide_3);
        guideFour.setBackgroundResource(R.drawable.guide_4);
//            skip.setBackgroundResource(R.drawable.guide_ver3_zh_open);
        //其他语言图片待添加
        guideViews.add(guideOne);
        guideViews.add(guideTwo);
        guideViews.add(guideThree);
        guideViews.add(guideFour);
    }

    private class GuidePagerAdapter extends PagerAdapter {

        private final List<View> viewList;

        public GuidePagerAdapter(List<View> list) {
            this.viewList = list;
        }

        @Override
        public int getCount() {

            return viewList != null ? viewList.size() : 0;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(viewList.get(position), 0);
            return viewList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(viewList.get(position));
        }

    }
}
