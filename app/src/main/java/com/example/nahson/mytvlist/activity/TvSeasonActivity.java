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

import com.example.nahson.mytvlist.Fragments.TvSeasonFragment;
import com.example.nahson.mytvlist.R;
import com.example.nahson.mytvlist.model.TV.TV;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jonathan on 6/3/2016.
 */
public class TvSeasonActivity extends AppCompatActivity{
    public static final String TV_tvlist = "MyTVList.tvlist";
    public static final String TV_CURRENT_ID= "MyTVList.ID";
    private ViewPager mViewPager;
    private List<TV> tvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_search_results);

        tvList = (ArrayList) getIntent().getSerializableExtra(TV_tvlist);
        int ID = (int) getIntent().getSerializableExtra(TV_CURRENT_ID);

        mViewPager = (ViewPager)findViewById(R.id.search_result_view_pager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                TV tv = tvList.get(position);
                Log.d("TV", tvList.get(position).getName() + " at position " + position);
                return TvSeasonFragment.newInstance(tv);
            }

            @Override
            public int getCount() {
                return tvList.size();
            }
        });

        for (int i = 0; i < tvList.size(); i++) {
            if (tvList.get(i).getId() == ID) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }

    public static Intent createIntent(Context packageContext, ArrayList<TV> tvlist, int ID){
        Intent intent = new Intent(packageContext, TvSeasonActivity.class);
        intent.putParcelableArrayListExtra(TV_tvlist, tvlist);
        intent.putExtra(TV_CURRENT_ID, ID);
        return intent;
    }
}
