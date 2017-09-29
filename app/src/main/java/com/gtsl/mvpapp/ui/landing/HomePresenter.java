package com.gtsl.mvpapp.ui.landing;

import com.gtsl.mvpapp.data.model.ComicDataWrapper;
import com.gtsl.mvpapp.data.network.ApiHelper;

import javax.inject.Inject;

public class HomePresenter implements HomeBasePresenter {
    private ApiHelper mApiHelper;

    @Inject
    public HomePresenter(ApiHelper apiHelper) {
        mApiHelper = apiHelper;
    }

    @Override
    public void populate(ComicDataWrapper wrapper) {

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
