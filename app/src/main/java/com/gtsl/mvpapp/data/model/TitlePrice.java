package com.gtsl.mvpapp.data.model;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import android.os.Parcelable;

@AutoValue
public abstract class TitlePrice implements Parcelable {
    public abstract String type();
    public abstract float price();

    public static TypeAdapter<TitlePrice> typeAdapter(Gson gson) {
        return new AutoValue_TitlePrice.GsonTypeAdapter(gson);
    }

}
