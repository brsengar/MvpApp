package com.gtsl.mvpapp.ui.landing;

import com.gtsl.mvpapp.data.model.ComicDataWrapper;
import com.gtsl.mvpapp.di.PerActivity;

@PerActivity
public interface HomeBasePresenter {
    void populate(ComicDataWrapper wrapper);
    void init();
    void showError();
    void showProgress();
}
