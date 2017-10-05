package com.gtsl.mvpapp.ui.details;

import com.bumptech.glide.Glide;
import com.gtsl.mvpapp.R;
import com.gtsl.mvpapp.data.model.CreatorSummary;
import com.gtsl.mvpapp.data.model.Title;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ComicDetailActivity extends AppCompatActivity {
    public static final String EXTRA_COMIC = "comic";

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.comic_detail_title)
    TextView title;
    @BindView(R.id.comic_detail_creators)
    TextView creators;
    @BindView(R.id.comic_detail_price)
    TextView price;
    @BindView(R.id.comic_detail_description)
    TextView description;
    @BindView(R.id.comic_image)
    ImageView comicImage;

    private Title mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic_detail);

        ButterKnife.bind(this);

        mTitle = getIntent().getParcelableExtra(EXTRA_COMIC);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setTitle(getTitle());

        initViews();
    }

    public void initViews() {
        title.setText((mTitle.title()));
        creators.setText(getCreators());
        description.setText(Html.fromHtml(mTitle.description() != null ?
                mTitle.description() : getString(R.string.message_no_content)));
        price.setText(mTitle.prices().size() > 0 ?
                new DecimalFormat("£#.##").format(mTitle.prices().get(0).price()) : getString(R.string.message_free));
        Glide.with(this)
                .load(mTitle.thumbnail().path() + "." + mTitle.thumbnail().extension())
                .into(comicImage);
    }

    private String getCreators() {
        StringBuilder creators = new StringBuilder();
        for (CreatorSummary creatorSummary : mTitle.creators().items()) {
            creators.append(creatorSummary.name()).append(", ");
        }
        if (creators.length() > 0) {
            creators.delete(creators.length() - 2, creators.length());
        }
        return creators.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
