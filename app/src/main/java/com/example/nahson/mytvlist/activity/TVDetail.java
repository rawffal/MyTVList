package com.example.nahson.mytvlist.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nahson.mytvlist.R;
import com.example.nahson.mytvlist.adapter.SeasonAdapter;
import com.example.nahson.mytvlist.model.TV.TV;
import com.example.nahson.mytvlist.model.TVID.Season;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Nah Son on 5/12/2016.
 */
public class TVDetail extends AppCompatActivity {
    public static final String EXTRA_TV = "tv";

    private TV tv;
    ImageView backdrop;
    ImageView poster;
    TextView title;
    TextView description;
    SeasonAdapter seasonAdapter;
    ArrayList<Season> sSeasons;
    RecyclerView recyclerView;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_detail);

        intent = getIntent();
        String sPoster = intent.getStringExtra("Poster");
        String sBackdrop = intent.getStringExtra("Backdrop");
        sSeasons = intent.getParcelableArrayListExtra("Season");
        String sName = intent.getStringExtra("Name");
        String sOverview = intent.getStringExtra("Overview");
        tv = intent.getParcelableExtra("TV");

        CollapsingToolbarLayout toolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolbarLayout.setTitle(sName);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.tvShowList.add(tv);
                Snackbar.make(view, "TV Show added to your list!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        backdrop = (ImageView) findViewById(R.id.backdrop);
        title = (TextView) findViewById(R.id.tv_title);
        description = (TextView) findViewById(R.id.tv_description);
        poster = (ImageView) findViewById(R.id.tv_poster);

        title.setText(sName);

        description.setText(sOverview);
        Picasso.with(this)
                .load(sPoster)
                .into(poster);

        recyclerView = (RecyclerView) findViewById(R.id.tv_detail_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //updateUI();

        Picasso.with(this)
                .load(sBackdrop)
                .into(backdrop);
    }

    /*public void updateUI() {
        if (seasonAdapter == null) {
            seasonAdapter = new SeasonAdapter(sSeasons, R.layout.list_tv_seasons, getApplicationContext());
            recyclerView.setAdapter(seasonAdapter);
        } else {
            seasonAdapter.notifyDataSetChanged();
            recyclerView.setAdapter(seasonAdapter);
        }
    }*/
}
