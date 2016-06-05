package com.example.nahson.mytvlist.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nahson.mytvlist.R;
import com.example.nahson.mytvlist.adapter.EpisodeAdapter;
import com.example.nahson.mytvlist.model.SeasonNumber.Episode;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Nah Son on 5/13/2016.
 */
public class SeasonActivity extends AppCompatActivity {

    private Intent intent;
    private TextView seasonTitle;
    private TextView seasonDescription;
    private ImageView backdrop;
    private List<Episode> episodeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_season);

        intent = getIntent();
        seasonTitle = (TextView) findViewById(R.id.season_tv_title);
        seasonDescription = (TextView) findViewById(R.id.season_tv_description);
        backdrop = (ImageView) findViewById(R.id.season_backdrop);

        episodeList = intent.getParcelableArrayListExtra("Episodes");

        seasonTitle.setText(intent.getStringExtra("Name"));
        seasonDescription.setText(intent.getStringExtra("Overview"));
        Picasso.with(this)
                .load(intent.getStringExtra("Poster"))
                .into(backdrop);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.episode_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new EpisodeAdapter(episodeList, R.layout.list_episodes, getApplicationContext()));

    }
}
