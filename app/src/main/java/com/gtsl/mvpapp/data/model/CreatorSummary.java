package com.gtsl.mvpapp.data.model;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import android.os.Parcelable;

@AutoValue
public abstract class CreatorSummary implements Parcelable {
    public abstract String name();

    public static TypeAdapter<CreatorSummary> typeAdapter(Gson gson) {
        return new AutoValue_CreatorSummary.GsonTypeAdapter(gson);
    }
}
