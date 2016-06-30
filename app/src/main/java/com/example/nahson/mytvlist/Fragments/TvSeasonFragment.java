package com.example.nahson.mytvlist.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
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
import com.example.nahson.mytvlist.activity.MainActivity;
import com.example.nahson.mytvlist.activity.SearchResultsActivity;
import com.example.nahson.mytvlist.activity.TvSeasonActivity;
import com.example.nahson.mytvlist.adapter.SeasonAdapter;
import com.example.nahson.mytvlist.model.TV.TV;
import com.example.nahson.mytvlist.model.TVID.Season;
import com.example.nahson.mytvlist.model.TVID.TVID;
import com.example.nahson.mytvlist.rest.ApiClient;
import com.example.nahson.mytvlist.rest.ApiInterface;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jonathan on 6/3/2016.
 */
public class TvSeasonFragment extends Fragment{
    private final static String API_KEY = "56ad544b1b49a341e09a472c21bfcf9e";
    private final static String TAG = "TAG";
    public static final String TV_tv = "MyTVList.tv";

    private TVID tvid;
    private TV tv;
    private ArrayList<Season> sSeasons;

    ImageView backdrop;
    ImageView poster;
    TextView title;
    TextView description;

    RecyclerView recyclerView;
    SeasonAdapter seasonAdapter;

    public static TvSeasonFragment newInstance(TV tv){
        Bundle args = new Bundle();
        args.putParcelable(TV_tv, tv);
        TvSeasonFragment fragment = new TvSeasonFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            tv = bundle.getParcelable(TV_tv);
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
        View view = inflater.inflate(R.layout.activity_tv_detail,container,false);
        backdrop = (ImageView) view.findViewById(R.id.backdrop);
        title = (TextView) view.findViewById(R.id.tv_title);
        description = (TextView) view.findViewById(R.id.tv_description);
        poster = (ImageView) view.findViewById(R.id.tv_poster);
        title.setText(tv.getName());
        description.setText(tv.getOverview());

        CollapsingToolbarLayout toolbarLayout = (CollapsingToolbarLayout) view.findViewById(R.id.toolbar_layout);
        toolbarLayout.setTitle(tv.getName());

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PersonalTvListFragment.tvPersonalList.add(tv);
                Snackbar.make(view, tv.getName() + " added to your list!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Picasso.with(getActivity())
                .load(tv.getPosterPath())
                .into(poster);

        Picasso.with(getActivity())
                .load(tv.getBackdropPath())
                .into(backdrop);

        recyclerView = (RecyclerView) view.findViewById(R.id.tv_detail_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    public void updateSeasonAdapter() {
        seasonAdapter = new SeasonAdapter(tv, sSeasons, R.layout.list_tv_seasons, getActivity());
        recyclerView.setAdapter(seasonAdapter);
        /*if (seasonAdapter == null) {
            seasonAdapter = new SeasonAdapter(tv, sSeasons, R.layout.list_tv_seasons, getActivity());
            recyclerView.setAdapter(seasonAdapter);
        } else {
            seasonAdapter.notifyDataSetChanged();
            recyclerView.setAdapter(seasonAdapter);
        }*/
    }

    @Override
    public void setUserVisibleHint(boolean isVisible) {
        super.setUserVisibleHint(isVisible);
        if (isVisible) {
            ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
            Call<TVID> call = apiInterface.getTVShowsDetails(tv.getId(), API_KEY);
            call.enqueue(new Callback<TVID>() {
                @Override
                public void onResponse(Call<TVID> call, Response<TVID> response) {
                    tvid = response.body();
                    sSeasons = (ArrayList)tvid.getSeasons();
                    for(Season s: sSeasons) Log.d("Season #", "" + s.getSeasonNumber());
                    updateSeasonAdapter();
                }

                @Override
                public void onFailure(Call<TVID> call, Throwable t) {
                    Log.e("TVAdapter: ", "Error occured");
                }
            });
        }
    }
}