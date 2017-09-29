package com.gtsl.mvpapp.data.model;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import android.os.Parcelable;

import java.util.List;

@AutoValue
public abstract class CreatorList implements Parcelable {
    public abstract List<CreatorSummary> items();

    public static TypeAdapter<CreatorList> typeAdapter(Gson gson) {
        return new AutoValue_CreatorList.GsonTypeAdapter(gson);
    }

}
