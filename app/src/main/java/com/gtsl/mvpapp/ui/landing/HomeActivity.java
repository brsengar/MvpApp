package com.gtsl.mvpapp.ui.landing;

import com.gtsl.mvpapp.MvpApplication;
import com.gtsl.mvpapp.R;
import com.gtsl.mvpapp.di.component.ActivityComponent;
import com.gtsl.mvpapp.di.component.DaggerActivityComponent;
import com.gtsl.mvpapp.di.module.ActivityModule;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements HomeView {
    @Inject
    HomePresenter presenter;

    @BindView(R.id.comic_list)
    RecyclerView comicList;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.filter_button)
    FloatingActionButton filterButton;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.retry_button)
    Button retryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        ActivityComponent activityComponent = DaggerActivityComponent.builder()
                .networkComponent(((MvpApplication) getApplication()).networkComponent())
                .build();

        activityComponent.inject(this);
        presenter.init();

    }

    @Override
    public void onPopulate() {

    }
}
