package com.example.nahson.mytvlist;


import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Nah Son on 5/11/2016.
 */
public interface TVApiService {

    @GET("/tv/popular")
    void getPopularTVShows(Callback<TV.TVResult> callback);

}
