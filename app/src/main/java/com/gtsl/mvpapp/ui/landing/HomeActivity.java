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
    HomePresenter mPresenter;

    @BindView(R.id.home_recyclerview_title_list)
    RecyclerView mTitleRecyclerView;
    @BindView(R.id.home_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.home_button_filter)
    FloatingActionButton mFilterButton;
    @BindView(R.id.home_swipe_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.home_button_retry)
    Button mRetryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        mToolbar.setTitle(getTitle());

        activityComponent().inject(this);
        mPresenter.onAttach(this);
        mPresenter.init();
    }

    @Override
    public void onPopulate(List<Title> titleList) {
        mTitleRecyclerView.setAdapter(new TitleAdapter(titleList));
    }
}
