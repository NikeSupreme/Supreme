package com.hxc.supreme.utils;

import android.content.Context;
import android.support.annotation.StringRes;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by zbl on 2017/6/15.
 * 统一弹Toast
 */

public class ToastUtil {
    private static Toast toast;

    public static void show(Context context,String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

    public static void show(Context context,@StringRes int resId) {
        Toast.makeText(context, resId, Toast.LENGTH_SHORT).show();
    }

    /**
     * 弹出多个toast时, 不会一个一个的弹, 后面一个要显示的内容直接显示在当前的toast上
     */
    public static void single(Context context,String msg) {
        if (toast == null) {
            toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        } else {
            toast.setText(msg);
        }
        toast.show();
    }

    /**
     * 多行居中显示
     */
    public static void singleCenter(Context context,@StringRes int msg) {
        if (toast == null) {
            toast = Toast.makeText( context, msg, Toast.LENGTH_SHORT);
        } else {
            toast.setText(msg);
        }
        ((TextView) toast.getView().findViewById(android.R.id.message)).setGravity(Gravity.CENTER);
        toast.show();
    }

    /**
     * 多行居中显示
     */
    public static void singleCenter(Context context,String msg) {
        if (toast == null) {
            toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        } else {
            toast.setText(msg);
        }
        ((TextView) toast.getView().findViewById(android.R.id.message)).setGravity(Gravity.CENTER);
        toast.show();
    }

    /**
     * 弹出多个toast时, 不会一个一个的弹, 后面一个要显示的内容直接显示在当前的toast上
     */
    public static void single(Context context,@StringRes int msg) {
        if (toast == null) {
            toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        } else {
            toast.setText(msg);
        }
        toast.show();
    }
}
