package com.gtsl.mvpapp.di.component;

import com.gtsl.mvpapp.data.network.ApiHelper;
import com.gtsl.mvpapp.di.module.ApplicationModule;
import com.gtsl.mvpapp.di.module.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class, ApplicationModule.class})
public interface NetworkComponent {
    ApiHelper apiHelper();
}
