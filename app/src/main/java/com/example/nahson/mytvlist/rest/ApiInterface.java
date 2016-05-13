package com.example.nahson.mytvlist.rest;

import com.example.nahson.mytvlist.model.TVResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Nah Son on 5/12/2016.
 */
public interface ApiInterface {
    @GET("tv/top_rated")
    Call<TVResponse> getTopRatedTV(@Query("api_key") String apiKey);

    @GET("tv/{id}")
    Call<TVResponse> getTVShowsDetails(@Path("id") int id, @Query("api_key") String apiKey);

    @GET("search/tv")
    Call<TVResponse> getTVShows(@Query("api_key") String apiKey,
                                @Query("query") String query);

}
