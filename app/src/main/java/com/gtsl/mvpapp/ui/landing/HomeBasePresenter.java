package com.gtsl.mvpapp.ui.landing;

import com.gtsl.mvpapp.di.PerActivity;

@PerActivity
public interface HomeBasePresenter {
    void populate();
    void init();
}
