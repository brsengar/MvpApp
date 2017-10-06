package com.gtsl.mvpapp.ui.landing;

import com.bumptech.glide.Glide;
import com.gtsl.mvpapp.R;
import com.gtsl.mvpapp.data.model.Title;
import com.gtsl.mvpapp.ui.details.DetailsActivity;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TitleAdapter extends RecyclerView.Adapter<TitleAdapter.ViewHolder> {
    private List<Title> mTitleList;

    public TitleAdapter(List<Title> titleList) {
        mTitleList = titleList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_title_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Title comic = mTitleList.get(position);
        holder.title.setText(comic.title());
        Glide.with(holder.thumbnail.getContext())
                .load(comic.thumbnail().path() + "." + comic.thumbnail().extension())
                .into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return mTitleList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.title_list_imageview_thumbnail)
        ImageView thumbnail;
        @BindView(R.id.title_list_textview_title)
        TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(view.getContext(), DetailsActivity.class);
            intent.putExtra(DetailsActivity.getEXTRA_TITLE(), mTitleList.get(getLayoutPosition()));
            view.getContext().startActivity(intent);

        }
    }
}
