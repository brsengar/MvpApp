package com.gtsl.mvpapp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
//    private ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        mActivityComponent = DaggerActivityComponent.builder()
//                .activityModule(new ActivityModule(this))
////                .applicationComponent(((MvpApplication) getApplication()).applicationComponent())
//                .build();
    }

//    public ActivityComponent activityComponent() {
//        return mActivityComponent;
//    }
}
