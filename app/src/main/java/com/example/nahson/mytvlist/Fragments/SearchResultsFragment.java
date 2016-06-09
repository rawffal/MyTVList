package com.example.nahson.mytvlist.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import android.widget.Toast;

import com.example.nahson.mytvlist.R;
import com.example.nahson.mytvlist.activity.HomeActivity;
import com.example.nahson.mytvlist.activity.MainActivity;
import com.example.nahson.mytvlist.activity.SearchResultsActivity;
import com.example.nahson.mytvlist.adapter.TVAdapter;
import com.example.nahson.mytvlist.model.TV.TV;
import com.example.nahson.mytvlist.model.TV.TVResponse;
import com.example.nahson.mytvlist.rest.ApiClient;
import com.example.nahson.mytvlist.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jonathan on 6/3/2016.
 */
public class SearchResultsFragment extends Fragment {
    private static final String TAG = HomeActivity.class.getSimpleName();
    private final static String API_KEY = "56ad544b1b49a341e09a472c21bfcf9e";
    private static final String SEARCH_QUERY = "search_q";
    RecyclerView recyclerView;
    private String query;

    public static SearchResultsFragment newInstance(String searchQuery){
        Bundle args = new Bundle();
        args.putString(SEARCH_QUERY, searchQuery);
        SearchResultsFragment fragment = new SearchResultsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        query = getArguments().getString(SEARCH_QUERY);
        searchTvOrMovie(query);
        setHasOptionsMenu(true);
    }

    private void searchTvOrMovie(String query) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<TVResponse> call = apiService.getTVShows(API_KEY, query);
        call.enqueue(new Callback<TVResponse>() {
            @Override
            public void onResponse(Call<TVResponse> call, Response<TVResponse> response) {
                List<TV> tvList = response.body().getResults();
                recyclerView.setAdapter(new TVAdapter(tvList, R.layout.list_item_tv, getActivity()));
                if(tvList.size() == 0) Toast.makeText(getActivity(), "No results found", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<TVResponse> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
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
                searchTvOrMovie(s);
                return true;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
    }
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_search_results, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.tvs_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }
}
