package com.hxc.supreme.widget;

import android.animation.TypeEvaluator;

import com.hxc.supreme.bean.Point;

/**
 * created by huxc  on 2017/10/19.
 * func：
 * email: hxc242313@qq.com
 */

public class PointEvaluator implements TypeEvaluator {
    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        Point startPoint = (Point) startValue;
        Point endPoint = (Point) endValue;
        float x = startPoint.getX() + fraction * (endPoint.getX() - startPoint.getX());
        float y = startPoint.getY() + fraction * (endPoint.getY() - startPoint.getY());
        Point point = new Point(x, y);
        return point;
    }
}
