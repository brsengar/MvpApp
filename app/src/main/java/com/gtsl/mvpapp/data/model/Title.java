package com.gtsl.mvpapp.data.model;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import java.util.List;

@AutoValue
public abstract class Title implements Parcelable {

    public abstract int id();
    public abstract String title();
    @Nullable
    public abstract String description();
    public abstract Image thumbnail();
    public abstract List<Image> images();
    public abstract int pageCount();
    public abstract List<TitlePrice> prices();
    @Nullable public abstract CreatorList creators();

    public static TypeAdapter<Title> typeAdapter(Gson gson) {
        return new AutoValue_Title.GsonTypeAdapter(gson);
    }

}
