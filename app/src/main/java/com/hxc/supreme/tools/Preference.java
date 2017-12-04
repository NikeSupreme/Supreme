package com.hxc.supreme.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.hxc.supreme.MainApplication;

/**
 * 系统参数
 */
public class Preference {

    private final Context mContext;
    private final SharedPreferences mPreferences;
    private final Editor mEditor;

    private static Preference mInstance;

    public static Preference getPreferences() {
        if (mInstance == null)
            mInstance = new Preference();
        return mInstance;
    }

    private Preference() {
        mContext = MainApplication.getApplication();
        mPreferences = mContext.getSharedPreferences(
                IPreferenceKey.P_KEY_PREFERENCE, Context.MODE_PRIVATE);
        mEditor = mPreferences.edit();
    }

    public boolean setIsFirstLogin(boolean flag){
        return mEditor.putBoolean(IPreferenceKey.P_KEY_FIRST_LOGIN,flag).commit();
    }

    public boolean getIsFirstLogin(){
        return mPreferences.getBoolean(IPreferenceKey.P_KEY_FIRST_LOGIN,true);
    }

}