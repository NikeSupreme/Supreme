package com.hxc.supreme.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.hxc.supreme.R;
import com.hxc.supreme.activity.MainActivity;

/**
 * created by huxc  on 2018/10/18.
 * func：
 * email: hxc242313@qq.com
 */

public class MainService extends Service {
    private static final String NOTIFICATION_ALARM_CHANNEL_ID = "alarm";
    private static final String NOTIFICATION_ALARM_CHANNEL_NAME = "alarm_message";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("MainService", "onBind: ");
        return new MyBinder();
    }

    @Override
    public void onCreate() {
        Log.i("MainService", "onCreate: ");
        showNotification();
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("MainService", "onStartCommand: ");
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(2000);
                        Log.i("MainService", "doSomething: ");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }

   public  class MyBinder extends Binder {
        public void showToast(){
            Log.i("MainService", "showToast: ");
        }
        public void showList(){
            Log.i("MainService", "showList: ");
        }
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("MainService", "onUnbind: ");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.i("MainService", "onDestroy: ");
        super.onDestroy();
    }


    private void showNotification(){
        setApi26Notification();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, NOTIFICATION_ALARM_CHANNEL_ID);
        PendingIntent contentIntent = PendingIntent.getActivities(this, 0,
                new Intent[]{new Intent(this, MainActivity.class)}, PendingIntent.FLAG_CANCEL_CURRENT);
        builder.setContentIntent(contentIntent)
                .setSmallIcon(R.drawable.app_logo)         //设置状态栏里面的图标（小图标）
                .setWhen(System.currentTimeMillis())        //设置时间发生时间
                .setAutoCancel(false)                        //设置可以清除
                .setContentTitle("一二三四五")    //设置下拉列表里的标题
                .setContentText("上山打老虎");     //设置上下文内容
        Notification notification = builder.build();
        startForeground(1, notification);
    }


    /**
     * Android8.0通知适配
     */
    private void setApi26Notification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelId = NOTIFICATION_ALARM_CHANNEL_ID;
            String channelName = NOTIFICATION_ALARM_CHANNEL_NAME;
            int importance = NotificationManager.IMPORTANCE_LOW;
            createNotificationChannel(channelId, channelName, importance);
        }
    }
    @TargetApi(Build.VERSION_CODES.O)
    private void createNotificationChannel(String channelId, String channelName, int importance) {
        NotificationChannel channel = new NotificationChannel(channelId, channelName, importance);
        channel.enableVibration(false);
        channel.setVibrationPattern(new long[]{0});
        NotificationManager notificationManager = (NotificationManager) getSystemService(
                NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(channel);
    }

}
