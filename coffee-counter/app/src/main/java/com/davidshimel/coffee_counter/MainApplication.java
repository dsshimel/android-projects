package com.davidshimel.coffee_counter;

import android.app.Application;

import net.danlew.android.joda.JodaTimeAndroid;

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        JodaTimeAndroid.init(this);
    }
}
