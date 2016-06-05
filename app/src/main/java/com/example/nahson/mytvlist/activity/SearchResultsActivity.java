package com.example.nahson.mytvlist.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.example.nahson.mytvlist.Fragments.SearchResultsFragment;
import com.example.nahson.mytvlist.R;
import com.example.nahson.mytvlist.model.TV.TV;
import com.example.nahson.mytvlist.model.TV.TVResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jonathan on 6/3/2016.
 */
public class SearchResultsActivity extends AddFragment{
    public static final String SEARCH_ID = "MyTVList.search_id";

    public static Intent createIntent(Context packageContext, String search) {
        Intent intent = new Intent(packageContext, SearchResultsActivity.class);
        intent.putExtra(SEARCH_ID, search);
        return intent;
    }

    @Override
    public Fragment createFragment() {
        String search = (String) getIntent().getSerializableExtra(SEARCH_ID);
        return SearchResultsFragment.newInstance(search);
    }
}
