package com.example.nahson.mytvlist.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.nahson.mytvlist.R;
import com.example.nahson.mytvlist.activity.HomeActivity;
import com.example.nahson.mytvlist.activity.Result;
import com.example.nahson.mytvlist.activity.SearchResultsActivity;
import com.example.nahson.mytvlist.activity.TVShowList;
import com.example.nahson.mytvlist.model.TV.TV;

import java.util.ArrayList;

/**
 * Created by Jonathan on 6/3/2016.
 */
public class SearchFragment extends Fragment {
    private EditText searchBarText;
    private Button searchButton;
    private Button tvListButton;
    private Intent tvIntent;

    public static ArrayList<TV> tvShowList;

    public static final String TV_LIST_TAB = "TV List";
    private static final int SEARCH_FOR_LIST = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_search, menu);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_search, container, false);
        tvShowList = new ArrayList<>();

        searchBarText = (EditText) view.findViewById(R.id.search_bar);
        searchBarText.setText("");
        searchButton = (Button) view.findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (searchBarText.getText() != null) {
                    String input = searchBarText.getText().toString();
                    Intent intent = SearchResultsActivity.createIntent(getActivity(), input);
                    startActivityForResult(intent, SEARCH_FOR_LIST);
                }
            }
        });

        tvListButton = (Button) view.findViewById(R.id.tv_list_button);
        tvListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvIntent = new Intent(getActivity(), TVShowList.class);
                tvIntent.putParcelableArrayListExtra(TVShowList.TAG, tvShowList);
                startActivity(tvIntent);
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SEARCH_FOR_LIST) {
            //tvShowList = data.getStringArrayListExtra();
        }
    }
}
