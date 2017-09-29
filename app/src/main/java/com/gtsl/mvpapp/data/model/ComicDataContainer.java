package com.gtsl.mvpapp.data.model;


import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.util.List;

@AutoValue
public abstract class ComicDataContainer {

    public abstract List<Title> results();

    public static TypeAdapter<ComicDataContainer> typeAdapter(Gson gson) {
        return new AutoValue_ComicDataContainer.GsonTypeAdapter(gson);
    }

}
