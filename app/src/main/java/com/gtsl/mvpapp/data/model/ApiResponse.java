package com.gtsl.mvpapp.data.model;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class ApiResponse {

    public abstract TitleData data();

    public static TypeAdapter<ApiResponse> typeAdapter(Gson gson) {
        return new AutoValue_ApiResponse.GsonTypeAdapter(gson);
    }

}
