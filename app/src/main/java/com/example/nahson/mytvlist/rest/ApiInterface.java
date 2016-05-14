package com.example.nahson.mytvlist.rest;

import com.example.nahson.mytvlist.model.SeasonNumber.SeasonNumber;
import com.example.nahson.mytvlist.model.TV.TVResponse;
import com.example.nahson.mytvlist.model.TVID.TVID;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Nah Son on 5/12/2016.
 */
public interface ApiInterface {
    @GET("tv/{id}")
    Call<TVID> getTVShowsDetails(@Path("id") int id, @Query("api_key") String apiKey);

    @GET("search/tv")
    Call<TVResponse> getTVShows(@Query("api_key") String apiKey,
                                @Query("query") String query);

    @GET("tv/{id}/season/{season_number}")
    Call<SeasonNumber> getSeasonNumberInfo(@Path("id") int id,
                                           @Path("season_number") int seasonNumber,
                                           @Query("api_key") String apiKey);
}
