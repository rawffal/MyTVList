package com.example.nahson.mytvlist.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.nahson.mytvlist.R;
import com.example.nahson.mytvlist.adapter.TVAdapter;
import com.example.nahson.mytvlist.model.TV;

import java.util.List;

/**
 * Created by Nah Son on 5/12/2016.
 */
public class TVShowList extends AppCompatActivity {

    public static final String TAG = "TAG";

    private Intent intent;
    private List<TV> tvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_tv_show_list_activity);

        intent = getIntent();
        tvList = intent.getParcelableArrayListExtra(TAG);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.tv_list_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(new TVAdapter(tvList, R.layout.list_item_tv, getApplicationContext()));
    }
}
