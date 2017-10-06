package com.gtsl.mvpapp.data.network;

import com.gtsl.mvpapp.data.model.ApiResponse;
import com.gtsl.mvpapp.di.RunOn;
import com.gtsl.mvpapp.di.SchedulerType;
import com.gtsl.mvpapp.ui.landing.HomeBasePresenter;
import com.gtsl.mvpapp.utils.Hash;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class RetrofitApiHelper implements ApiHelper {
    private static final String TIMESTAMP = "0";
    private static final String API_PUBLIC_KEY = "d87869f3d87c47c4d93b592c80c77a92";
    private static final String API_PRIVATE_KEY = "4b54e46a3ee95bcb9b7f45f8aea081987ee55ff5";
    private static final String HASH = Hash.md5(TIMESTAMP + API_PRIVATE_KEY + API_PUBLIC_KEY);

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
    public void getTitles(final HomeBasePresenter presenter) {
        mApiService.getTitles(TIMESTAMP, API_PUBLIC_KEY, HASH).subscribeOn(mIoScheduler).observeOn(mUiScheduler).subscribe(
                new SingleObserver<ApiResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        presenter.showProgress();
                    }

                    @Override
                    public void onSuccess(ApiResponse apiResponse) {
                        presenter.populate(apiResponse);
                    }

                    @Override
                    public void onError(Throwable e) {
                        presenter.showError();
                    }
                });
    }
}
