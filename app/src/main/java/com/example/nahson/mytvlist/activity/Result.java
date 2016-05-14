package com.example.nahson.mytvlist.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.nahson.mytvlist.R;
import com.example.nahson.mytvlist.adapter.TVAdapter;
import com.example.nahson.mytvlist.model.TV.TV;
import com.example.nahson.mytvlist.model.TV.TVResponse;
import com.example.nahson.mytvlist.rest.ApiClient;
import com.example.nahson.mytvlist.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Nah Son on 5/12/2016.
 */
public class Result extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private final static String API_KEY = "56ad544b1b49a341e09a472c21bfcf9e";

    private Intent intent;
    private String query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_result_page);

        intent = getIntent();
        query = intent.getStringExtra("Input");

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.tvs_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<TVResponse> call = apiService.getTVShows(API_KEY, query);
        call.enqueue(new Callback<TVResponse>() {
            @Override
            public void onResponse(Call<TVResponse> call, Response<TVResponse> response) {
                List<TV> tvList = response.body().getResults();
                recyclerView.setAdapter(new TVAdapter(tvList, R.layout.list_item_tv, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<TVResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }
}
