package com.gtsl.mvpapp.ui.landing;

import com.gtsl.mvpapp.data.model.ApiResponse;
import com.gtsl.mvpapp.data.network.ApiHelper;

import javax.inject.Inject;

public class HomePresenter implements HomeBasePresenter {

    private HomeEventListener mListener;
    private ApiHelper mApiHelper;

    @Inject
    public HomePresenter(ApiHelper apiHelper) {
        mApiHelper = apiHelper;
    }

    @Override
    public void onAttach(HomeEventListener listener) {
        mListener = listener;
    }

    @Override
    public void populate(ApiResponse wrapper) {
        mListener.onPopulate(wrapper.data().results());
    }

    @Override
    public void init() {
        mApiHelper.getTitles(this);
    }

    @Override
    public void showError() {

    }

    @Override
    public void showProgress() {

    }
}
