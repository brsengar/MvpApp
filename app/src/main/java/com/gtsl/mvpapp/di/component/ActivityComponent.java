package com.gtsl.mvpapp.di.component;

import com.gtsl.mvpapp.di.PerActivity;
import com.gtsl.mvpapp.di.module.ActivityModule;
import com.gtsl.mvpapp.di.module.NetworkModule;
import com.gtsl.mvpapp.ui.details.DetailsActivity;
import com.gtsl.mvpapp.ui.landing.HomeActivity;
import com.gtsl.mvpapp.ui.landing.HomePresenter;

import dagger.Component;

@PerActivity
@Component(dependencies = NetworkComponent.class, modules = {ActivityModule.class})
public interface ActivityComponent {
    void inject(HomeActivity activity);
    void inject(DetailsActivity activity);
}
