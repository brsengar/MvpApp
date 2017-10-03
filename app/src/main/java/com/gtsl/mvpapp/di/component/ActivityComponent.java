package com.gtsl.mvpapp.di.component;


import com.gtsl.mvpapp.data.scheduler.SchedulerModule;
import com.gtsl.mvpapp.di.PerActivity;
import com.gtsl.mvpapp.di.module.ActivityModule;
import com.gtsl.mvpapp.ui.landing.HomeActivity;

import dagger.Component;

//import com.gtsl.mvpapp.ui.details.DetailsActivity;

@PerActivity
@Component(dependencies = NetworkComponent.class, modules = {ActivityModule.class, SchedulerModule.class})
public interface ActivityComponent {

    void inject(HomeActivity activity);

//    void inject(DetailsActivity activity);

}
