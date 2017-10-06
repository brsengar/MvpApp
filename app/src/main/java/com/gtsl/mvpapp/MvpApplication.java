package com.gtsl.mvpapp;

import com.gtsl.mvpapp.di.component.ApplicationComponent;
import com.gtsl.mvpapp.di.component.DaggerApplicationComponent;
import com.gtsl.mvpapp.di.component.DaggerNetworkComponent;
import com.gtsl.mvpapp.di.component.NetworkComponent;
import com.gtsl.mvpapp.di.module.ApplicationModule;
import com.gtsl.mvpapp.di.module.NetworkModule;

import android.app.Application;

public class MvpApplication extends Application {
    private ApplicationComponent mApplicationComponent;
    private NetworkComponent mNetworkComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        mNetworkComponent = DaggerNetworkComponent.builder().applicationModule(new ApplicationModule(this))
                .networkModule(new NetworkModule("http://gateway.marvel.com/")).build();
    }

    public ApplicationComponent applicationComponent() {
        return mApplicationComponent;
    }

    public NetworkComponent networkComponent() {
        return mNetworkComponent;
    }
}
