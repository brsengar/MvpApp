package com.gtsl.mvpapp.di.component;

import com.gtsl.mvpapp.di.PerService;
import com.gtsl.mvpapp.di.module.NetworkModule;

import dagger.Component;


@PerService
@Component(dependencies = ApplicationComponent.class, modules = NetworkModule.class)
public interface NetworkComponent {

}
