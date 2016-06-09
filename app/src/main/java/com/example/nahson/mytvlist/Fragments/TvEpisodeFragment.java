package com.example.nahson.mytvlist.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nahson.mytvlist.R;
import com.example.nahson.mytvlist.activity.SearchResultsActivity;
import com.example.nahson.mytvlist.adapter.EpisodeAdapter;
import com.example.nahson.mytvlist.model.SeasonNumber.Episode;
import com.example.nahson.mytvlist.model.SeasonNumber.SeasonNumber;
import com.example.nahson.mytvlist.model.TV.TV;
import com.example.nahson.mytvlist.model.TVID.Season;
import com.example.nahson.mytvlist.rest.ApiClient;
import com.example.nahson.mytvlist.rest.ApiInterface;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jonathan on 6/4/2016.
 */
public class TvEpisodeFragment extends Fragment {
    private final static String API_KEY = "56ad544b1b49a341e09a472c21bfcf9e";
    private static final String SEASON = "Season ";
    public static final String SEASON_TV = "MyTVList.season";
    public static final String TV = "MyTVList.tv";

    RecyclerView recyclerView;
    private TV tv;
    private ArrayList<Episode> episodeList;
    private Season season;
    private SeasonNumber seasonNumber;

    private TextView seasonTitle;
    private TextView seasonDescription;
    private ImageView backdrop;

    public static TvEpisodeFragment newInstance(TV tv, Season season){
        Bundle args = new Bundle();
        args.putParcelable(TV, tv);
        args.putParcelable(SEASON_TV, season);
        TvEpisodeFragment fragment = new TvEpisodeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if(bundle != null){
            season = bundle.getParcelable(SEASON_TV);
            tv = bundle.getParcelable(TV);
        }
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_search, menu);

        MenuItem searchItem = menu.findItem(R.id.search_tv);
        final SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Intent intent = SearchResultsActivity.createIntent(getActivity(), s);
                startActivity(intent);
                getActivity().finish();
                return true;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_season,container,false);

        seasonTitle = (TextView) view.findViewById(R.id.season_tv_title);
        seasonDescription = (TextView) view.findViewById(R.id.season_tv_description);
        backdrop = (ImageView) view.findViewById(R.id.season_backdrop);

        Picasso.with(getActivity())
                .load(season.getPosterPath())
                .into(backdrop);

        recyclerView = (RecyclerView) view.findViewById(R.id.episode_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisible) {
        super.setUserVisibleHint(isVisible);
        if (isVisible) {
            ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
            Call<SeasonNumber> call = apiInterface.getSeasonNumberInfo(tv.getId(),
                    season.getSeasonNumber(), API_KEY);
            call.enqueue(new Callback<SeasonNumber>() {
                @Override
                public void onResponse(Call<SeasonNumber> call, Response<SeasonNumber> response) {
                    seasonNumber = response.body();
                    episodeList = (ArrayList)seasonNumber.getEpisodes();
                    seasonTitle.setText(seasonNumber.getName());
                    seasonDescription.setText(seasonNumber.getOverview());
                    recyclerView.setAdapter(new EpisodeAdapter(episodeList, R.layout.list_episodes, getActivity()));
                }

                @Override
                public void onFailure(Call<SeasonNumber> call, Throwable t) {
                    Log.e("SeasonAdapter: ", t.getMessage());
                }
            });
        }
    }
}
