package com.example.administrator.myapplication2;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Administrator on 2017/3/2.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
