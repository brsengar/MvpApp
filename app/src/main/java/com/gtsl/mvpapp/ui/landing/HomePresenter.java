package com.gtsl.mvpapp.ui.landing;

import com.gtsl.mvpapp.data.model.ComicDataWrapper;
import com.gtsl.mvpapp.data.network.ApiService;
import com.gtsl.mvpapp.data.scheduler.RunOn;
import com.gtsl.mvpapp.data.scheduler.SchedulerType;

import javax.inject.Inject;

import io.reactivex.Scheduler;

public class HomePresenter implements HomeBasePresenter {

//    public ApiHelper mApiHelper;
    private ApiService marvelApi;
    private Scheduler ioScheduler;
    private Scheduler uiScheduler;

    @Inject
    HomePresenter(ApiService marvelApi,
            @RunOn(SchedulerType.IO) Scheduler ioScheduler,
            @RunOn(SchedulerType.UI) Scheduler uiScheduler) {
        this.marvelApi = marvelApi;
        this.ioScheduler = ioScheduler;
        this.uiScheduler = uiScheduler;
    }

//    @Inject
//    public HomePresenter() {
////        mApiHelper = apiHelper;
//    }

    @Override
    public void populate(ComicDataWrapper wrapper) {

    }

    @Override
    public void init() {
//        mApiHelper.getComics(this);
    }

    @Override
    public void showError() {

    }

    @Override
    public void showProgress() {

    }
}
