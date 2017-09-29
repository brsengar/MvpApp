package com.gtsl.mvpapp.data.model;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

@AutoValue
public abstract class ComicDataWrapper {

    public abstract ComicDataContainer data();

    public static TypeAdapter<ComicDataWrapper> typeAdapter(Gson gson) {
        return new AutoValue_ComicDataWrapper.GsonTypeAdapter(gson);
    }

}
