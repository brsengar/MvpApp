package com.gtsl.mvpapp.ui.landing;

import com.gtsl.mvpapp.R;
import com.gtsl.mvpapp.ui.base.BaseActivity;
import com.gtsl.mvpapp.data.model.Title;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity implements HomeEventListener {
    @Inject
    HomePresenter presenter;

    @BindView(R.id.home_recyclerview_title_list)
    RecyclerView comicList;
    @BindView(R.id.home_toolbar)
    Toolbar toolbar;
    @BindView(R.id.home_button_filter)
    FloatingActionButton filterButton;
    @BindView(R.id.home_swipe_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.home_button_retry)
    Button retryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        activityComponent().inject(this);
        presenter.onAttach(this);
        presenter.init();
    }

    @Override
    public void onPopulate(List<Title> titleList) {
        comicList.setAdapter(new TitleAdapter(titleList));
    }
}
