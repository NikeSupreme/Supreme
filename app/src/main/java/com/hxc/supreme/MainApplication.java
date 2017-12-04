package com.hxc.supreme;

import android.app.Application;
import android.content.res.Configuration;

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

    }


    @Override
    public void onTerminate() {
        super.onTerminate();
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
}
