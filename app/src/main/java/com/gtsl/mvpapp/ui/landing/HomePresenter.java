package com.gtsl.mvpapp.ui.landing;

import com.gtsl.mvpapp.data.model.ComicDataWrapper;
import com.gtsl.mvpapp.data.network.ApiHelper;

import javax.inject.Inject;

public class HomePresenter implements HomeBasePresenter {

    private HomeEventListener mListener;
    public ApiHelper mApiHelper;


    @Inject
    public HomePresenter(ApiHelper apiHelper) {
        mApiHelper = apiHelper;
    }

    @Override
    public void onAttach(HomeEventListener listener) {
        mListener = listener;
    }

    @Override
    public void populate(ComicDataWrapper wrapper) {
        mListener.onPopulate(wrapper.data().results());
    }

    @Override
    public void init() {
        mApiHelper.getComics(this);
    }

    @Override
    public void showError() {

    }

    @Override
    public void showProgress() {

    }
}
