package com.gtsl.mvpapp.data.scheduler;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@Module
public class SchedulerModule {

    @Provides
    @RunOn(SchedulerType.IO)
    Scheduler provideIo() {
        return Schedulers.io();
    }

    @Provides
    @RunOn(SchedulerType.UI)
    Scheduler provideUi() {
        return AndroidSchedulers.mainThread();
    }
}