package com.example.rongcloud.rongimdemo;

import android.app.Application;

import io.rong.imlib.RongIMClient;

/**
 * Created by rongcloud on 2017/8/22.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RongIMClient.init(this, "8luwapkv8s2ql");
    }
}
