package com.gtsl.mvpapp.ui.landing;

import com.gtsl.mvpapp.data.model.ApiResponse;
import com.gtsl.mvpapp.di.PerActivity;
import com.gtsl.mvpapp.ui.base.BasePresenter;

@PerActivity
public interface HomeBasePresenter extends BasePresenter {
    void onAttach(HomeEventListener listener);
    void populate(ApiResponse wrapper);
    void init();
    void showError();
    void showProgress();
}
