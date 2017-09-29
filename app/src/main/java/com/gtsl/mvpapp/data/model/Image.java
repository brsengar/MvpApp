package com.gtsl.mvpapp.data.model;


import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import android.os.Parcelable;

@AutoValue
public abstract class Image implements Parcelable {
    public abstract String path();
    public abstract String extension();

    public static TypeAdapter<Image> typeAdapter(Gson gson) {
        return new AutoValue_Image.GsonTypeAdapter(gson);
    }
}
