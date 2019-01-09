package com.hxc.supreme;

import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;

import com.hxc.supreme.utils.ToastUtil;
import com.hxc.supreme.utils.XCrashHandlerUtils;

/**
 * Created by Administrator on 2017/2/10 0010.
 */

public class MainApplication extends Application {

    private static MainApplication mInstance = null;


    public synchronized static MainApplication getApplication() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        XCrashHandlerUtils.getInstance().init(getApplicationContext());

    }


    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.i("MainApplication","logout");
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        System.gc();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }
}
