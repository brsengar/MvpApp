package com.gtsl.mvpapp.ui.base;

import com.gtsl.mvpapp.MvpApplication;
import com.gtsl.mvpapp.di.component.ActivityComponent;
import com.gtsl.mvpapp.di.component.DaggerActivityComponent;
import com.gtsl.mvpapp.di.module.ActivityModule;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    private ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .networkComponent(((MvpApplication) getApplication()).networkComponent())
                .build();
    }

    public ActivityComponent activityComponent() {
        return mActivityComponent;
    }
}
