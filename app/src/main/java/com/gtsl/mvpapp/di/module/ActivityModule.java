package com.gtsl.mvpapp.di.module;

import com.gtsl.mvpapp.base.BasePresenter;
import com.gtsl.mvpapp.ui.landing.HomeBasePresenter;
import com.gtsl.mvpapp.ui.landing.HomePresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    @Provides
    HomeBasePresenter providePresenter() {
        return new HomePresenter();
    }
}
