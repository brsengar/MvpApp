package com.gtsl.mvpapp.data.network;

import com.gtsl.mvpapp.data.model.ComicDataWrapper;
import com.gtsl.mvpapp.data.scheduler.RunOn;
import com.gtsl.mvpapp.data.scheduler.SchedulerType;
import com.gtsl.mvpapp.ui.landing.HomeBasePresenter;
import com.gtsl.mvpapp.utils.Hash;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class RetrofitApiHelper implements ApiHelper {
    private static final String TIMESTAMP = "0";
    private static final String API_KEY = "54306733de0f5cd1418aa05a85fa062a";
    private static final String HASH = Hash.md5(TIMESTAMP + "5de1fabcda2ea08912bd8b09bca4321f50563655" + API_KEY);

    private ApiService mApiService;
    private Scheduler mIoScheduler;
    private Scheduler mUiScheduler;

    @Inject
    public RetrofitApiHelper(ApiService apiService, @RunOn(SchedulerType.IO) Scheduler ioScheduler,
            @RunOn(SchedulerType.UI) Scheduler uiScheduler) {
        mApiService = apiService;
        mIoScheduler = ioScheduler;
        mUiScheduler = uiScheduler;
    }

    @Override
    public void getComics(final HomeBasePresenter presenter) {
        mApiService.getComics(TIMESTAMP, API_KEY, HASH).subscribeOn(mIoScheduler).observeOn(mUiScheduler).subscribe(
                new SingleObserver<ComicDataWrapper>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        presenter.showProgress();
                    }

                    @Override
                    public void onSuccess(ComicDataWrapper comicDataWrapper) {
                        presenter.populate(comicDataWrapper);
                    }

                    @Override
                    public void onError(Throwable e) {
                        presenter.showError();
                    }
                });
    }
}
