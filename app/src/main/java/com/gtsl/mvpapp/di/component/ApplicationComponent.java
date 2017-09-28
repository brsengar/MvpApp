package com.gtsl.mvpapp.di.component;

import com.gtsl.mvpapp.di.ApplicationContext;
import com.gtsl.mvpapp.di.module.ApplicationModule;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    @ApplicationContext
    Context context();

    Application application();
}