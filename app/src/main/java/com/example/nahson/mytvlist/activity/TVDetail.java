package com.example.nahson.mytvlist.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nahson.mytvlist.R;
import com.example.nahson.mytvlist.model.TV;
import com.squareup.picasso.Picasso;

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
    private Intent sendTVListIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_detail);

        Intent intent = getIntent();
        tv = intent.getParcelableExtra(EXTRA_TV);

        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/
        CollapsingToolbarLayout toolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolbarLayout.setTitle(tv.getOriginalName());

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

        title.setText(tv.getOriginalName());

        description.setText(tv.getOverview());
        Picasso.with(this)
                .load(tv.getPosterPath())
                .into(poster);

        Picasso.with(this)
                .load(tv.getBackdropPath())
                .into(backdrop);


    }
}
