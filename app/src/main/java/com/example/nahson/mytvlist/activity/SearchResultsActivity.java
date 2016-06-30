package com.example.nahson.mytvlist.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.nahson.mytvlist.Fragments.SearchFragment;
import com.example.nahson.mytvlist.Fragments.SearchResultsFragment;
import com.example.nahson.mytvlist.R;


/**
 * Created by Jonathan on 6/3/2016.
 */
public class SearchResultsActivity extends /*AddFragment*/ AppCompatActivity{
    public static final String SEARCH_ID = "MyTVList.search_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_holder);

        if(fragment == null){
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_holder, fragment)
                    .commit();
        }
    }

    public static Intent createIntent(Context packageContext, String search) {
        Intent intent = new Intent(packageContext, SearchResultsActivity.class);
        intent.putExtra(SEARCH_ID, search);
        return intent;
    }

    //@Override
    public Fragment createFragment() {
        String search = (String) getIntent().getSerializableExtra(SEARCH_ID);
        return SearchResultsFragment.newInstance(search);
    }
}
