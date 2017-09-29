package com.gtsl.mvpapp.di.module;

import com.gtsl.mvpapp.data.network.ApiHelper;
import com.gtsl.mvpapp.data.network.ApiService;
import com.gtsl.mvpapp.data.network.RetrofitApiHelper;
import com.gtsl.mvpapp.ui.landing.HomeBasePresenter;
import com.gtsl.mvpapp.ui.landing.HomePresenter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;

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

    @Singleton
    @Provides
    HomeBasePresenter providePresenter(ApiHelper apiHelper) {
        return new HomePresenter(apiHelper);
    }
}
