package com.gtsl.mvpapp.di.module;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.gtsl.mvpapp.data.model.GsonFactory;
import com.gtsl.mvpapp.data.network.ApiService;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {
    private String mBaseUrl;

    public NetworkModule(String baseUrl) {
        mBaseUrl = baseUrl;
    }

    @Provides
    @Singleton
    Cache provideHttpCache(Application app) {
        Cache cache = new Cache(app.getCacheDir(), 10 * 1024 * 1024);
        return cache;
    }

    @Provides
    @Singleton
    OkHttpClient provideOkhttpClient(Cache cache) {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.cache(cache);
        return client.build();
    }

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create(
                new GsonBuilder().registerTypeAdapterFactory(GsonFactory.create())
                        .create());

        return new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    ApiService provideApi(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

}
