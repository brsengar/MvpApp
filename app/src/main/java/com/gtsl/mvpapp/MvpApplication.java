package com.gtsl.mvpapp;

import com.gtsl.mvpapp.di.component.ApplicationComponent;
import com.gtsl.mvpapp.di.component.DaggerApplicationComponent;
import com.gtsl.mvpapp.di.module.ApplicationModule;

import android.app.Application;

public class MvpApplication extends Application {
    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent applicationComponent() {
        return mApplicationComponent;
    }
}
