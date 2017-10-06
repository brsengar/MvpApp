package com.gtsl.mvpapp.di.module;

import com.gtsl.mvpapp.data.network.ApiHelper;
import com.gtsl.mvpapp.ui.landing.HomePresenter;

import android.support.v7.app.AppCompatActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Singleton
    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    HomePresenter providePresenter(ApiHelper apiHelper) {
        return new HomePresenter(apiHelper);
    }

}
