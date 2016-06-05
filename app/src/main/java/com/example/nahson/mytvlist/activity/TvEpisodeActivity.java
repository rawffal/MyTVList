package com.example.nahson.mytvlist.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.nahson.mytvlist.Fragments.TvEpisodeFragment;
import com.example.nahson.mytvlist.Fragments.TvSeasonFragment;
import com.example.nahson.mytvlist.R;
import com.example.nahson.mytvlist.model.SeasonNumber.Episode;
import com.example.nahson.mytvlist.model.SeasonNumber.SeasonNumber;
import com.example.nahson.mytvlist.model.TV.TV;
import com.example.nahson.mytvlist.model.TVID.Season;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jonathan on 6/4/2016.
 */
public class TvEpisodeActivity extends AppCompatActivity {
    public static final String EPISODE_POSTER = "MyTVList.episode_poster";
    public static final String EPISODE_NAME = "MyTVList.episode_name";
    public static final String EPISODE_OVERVIEW = "MyTVList.episode_overview";
    public static final String EPISODE_LIST = "MyTVList.episode_list";
    public static final String SEASON_LIST = "MyTVList.season_list";
    public static final String SEASON_ID = "MyTVList.season_id";
    public static final String TV = "MyTVList.tv";

    private ViewPager mViewPager;
    private TV tv;
    private List<Season> seasonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_search_results);

        seasonList = (ArrayList) getIntent().getSerializableExtra(SEASON_LIST);
        tv = getIntent().getParcelableExtra(TV);
        Log.d("TVNAME", tv.getName());
        int ID = (int) getIntent().getSerializableExtra(SEASON_ID);

        mViewPager = (ViewPager)findViewById(R.id.search_result_view_pager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Season season = seasonList.get(position);
                Log.d("TV", seasonList.get(position).getId() + " at position " + position);
                return TvEpisodeFragment.newInstance(tv, season);
            }

            @Override
            public void notifyDataSetChanged() {
                super.notifyDataSetChanged();
            }

            @Override
            public int getCount() {
                return seasonList.size();
            }
        });

        for (int i = 0; i < seasonList.size(); i++) {
            if (seasonList.get(i).getId() == ID) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }

    public static Intent createIntent(Context packageContext, TV tv, List<Season> seasonList, int id){
        Intent intent = new Intent(packageContext, TvEpisodeActivity.class);
        intent.putExtra(TV, tv);
        intent.putParcelableArrayListExtra(SEASON_LIST, (ArrayList) seasonList);
        intent.putExtra(SEASON_ID, id);
        return intent;
    }
}
