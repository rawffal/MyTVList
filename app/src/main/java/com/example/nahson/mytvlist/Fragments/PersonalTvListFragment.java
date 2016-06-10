package com.example.nahson.mytvlist.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.nahson.mytvlist.R;
import com.example.nahson.mytvlist.activity.SearchResultsActivity;
import com.example.nahson.mytvlist.adapter.TVAdapter;
import com.example.nahson.mytvlist.model.TV.TV;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jonathan on 6/9/2016.
 */
public class PersonalTvListFragment extends Fragment {

    public static List<TV> tvPersonalList = new ArrayList<>();
    private TVAdapter tvAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        if(tvAdapter == null){
            new TVAdapter(tvPersonalList, R.layout.card_view_tv_list, getActivity());
        }
        else{
            tvAdapter.notifyDataSetChanged();
        }
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
        View view = inflater.inflate(R.layout.content_tv_show_list_activity, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.tv_list_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new TVAdapter(tvPersonalList, R.layout.card_view_tv_list, getActivity()));
        return view;
    }
}
