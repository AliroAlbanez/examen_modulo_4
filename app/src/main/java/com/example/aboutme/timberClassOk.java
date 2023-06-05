package com.example.aboutme;

import android.app.Application;

import timber.log.Timber;

public class timberClassOk extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());
    }
}
