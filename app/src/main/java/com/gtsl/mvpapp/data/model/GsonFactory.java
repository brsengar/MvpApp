package com.gtsl.mvpapp.data.model;

import com.google.gson.TypeAdapterFactory;

import com.ryanharter.auto.value.gson.GsonTypeAdapterFactory;

@GsonTypeAdapterFactory
public abstract class GsonFactory implements TypeAdapterFactory {

    public static TypeAdapterFactory create() {
        return new AutoValueGson_GsonFactory();
    }
}