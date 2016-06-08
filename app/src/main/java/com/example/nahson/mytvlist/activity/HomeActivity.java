package com.example.nahson.mytvlist.activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import com.example.nahson.mytvlist.Fragments.SearchFragment;

/**
 * Created by Jonathan on 6/3/2016.
 */
public class HomeActivity extends AddFragment {
    @Override
    public Fragment createFragment() {
        return new SearchFragment();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
