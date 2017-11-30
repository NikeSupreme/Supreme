package com.hxc.supreme.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.hxc.supreme.bean.PieChartBean;

import java.util.ArrayList;

/**
 * created by huxc  on 2017/9/28.
 * func：自定义饼状图
 * email: hxc242313@qq.com
 */

public class PieChartView extends View {
    private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};
    // 饼状图初始绘制角度
    private float mStartAngle = 0;
    // 数据
    private ArrayList<PieChartBean> data;
    // 宽高
    private Paint paint;//画笔

    private int width, height;//View 的宽高

    private float startAngle = 0;//开始的角度


    public PieChartView(Context context) {
        super(context);
    }

    public PieChartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initPaint();
    }

    private void initPaint() {
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.width = w;
        this.height = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float currentStartAngle = startAngle;
        canvas.translate(width / 2, height / 2);
        float r = (float) (Math.min(width, height) / 2 * 0.8);
        RectF rectF = new RectF(-r, -r, r, r);
        canvas.drawRect(rectF, paint);

        for (int i = 0; i < data.size(); i++) {
            PieChartBean pie = data.get(i);
            paint.setColor(pie.getColor());
            canvas.drawArc(rectF, currentStartAngle, pie.getAngle(), true, paint);
            currentStartAngle += pie.getAngle();
        }

    }

    // 设置起始角度
    public void setStartAngle(int mStartAngle) {
        this.mStartAngle = mStartAngle;
        invalidate();   // 刷新
    }

    // 设置数据
    public void setData(ArrayList<PieChartBean> mData) {
        this.data = mData;
        initData(mData);
        invalidate();   // 刷新
    }

    // 初始化数据
    private void initData(ArrayList<PieChartBean> mData) {
        if (null == mData || mData.size() == 0)   // 数据有问题 直接返回
            return;

        float sumValue = 0;
        for (int i = 0; i < mData.size(); i++) {
            PieChartBean pie = mData.get(i);

            sumValue += pie.getValue();       //计算数值和

            int j = i % mColors.length;       //设置颜色
            pie.setColor(mColors[j]);
        }

        float sumAngle = 0;
        for (int i = 0; i < mData.size(); i++) {
            PieChartBean pie = mData.get(i);

            float percentage = pie.getValue() / sumValue;   // 百分比
            float angle = percentage * 360;                 // 对应的角度

            pie.setPercentage(percentage);                  // 记录百分比
            pie.setAngle(angle);                            // 记录角度大小
            sumAngle += angle;

            Log.i("angle", "" + pie.getAngle());
        }
    }
}
