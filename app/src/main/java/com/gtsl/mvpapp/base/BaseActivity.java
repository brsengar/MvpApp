package com.gtsl.mvpapp.base;

import com.gtsl.mvpapp.MvpApplication;
import com.gtsl.mvpapp.di.component.ActivityComponent;
import com.gtsl.mvpapp.di.component.DaggerActivityComponent;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    private ActivityComponent mActivityComponent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        mActivityComponent = DaggerActivityComponent.builder()
                .applicationComponent(((MvpApplication) getApplication()).applicationComponent())
                .build();
    }

    public ActivityComponent activityComponent() {
        return mActivityComponent;
    }
}
