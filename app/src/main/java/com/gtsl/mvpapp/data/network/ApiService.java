package com.gtsl.mvpapp.data.network;

import com.gtsl.mvpapp.data.model.ComicDataWrapper;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("v1/public/comics?limit=100")
    Single<ComicDataWrapper> getComics(@Query("ts") String timestamp, @Query("apikey") String apiKey, @Query("hash") String hash);

}
