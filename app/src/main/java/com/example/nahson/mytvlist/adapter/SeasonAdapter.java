package com.example.nahson.mytvlist.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nahson.mytvlist.R;
import com.example.nahson.mytvlist.activity.SeasonActivity;
import com.example.nahson.mytvlist.activity.TvEpisodeActivity;
import com.example.nahson.mytvlist.model.SeasonNumber.Episode;
import com.example.nahson.mytvlist.model.SeasonNumber.SeasonNumber;
import com.example.nahson.mytvlist.model.TV.TV;
import com.example.nahson.mytvlist.model.TVID.Season;
import com.example.nahson.mytvlist.rest.ApiClient;
import com.example.nahson.mytvlist.rest.ApiInterface;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Nah Son on 5/13/2016.
 */
public class SeasonAdapter extends RecyclerView.Adapter<SeasonAdapter.SeasonViewHolder> {
    private static final String SEASON = "Season ";
    private static List<Season> seasonList;
    private static int rowLayout;
    private static Context context;
    private static int position;
    private static Hashtable<Integer, Integer> table;
    private static TV tv;

    public static class SeasonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private LinearLayout linearLayout;
        private TextView seasonTitle;
        private ImageView posterPath;
        private EditText episodeCounter;
        private TextView totalEpisodes;
        private ImageButton incrementEpisode;

        public SeasonViewHolder(View v) {
            super(v);
            table = new Hashtable<>();
            linearLayout = (LinearLayout) v.findViewById(R.id.season_tv_layout);
            seasonTitle = (TextView) v.findViewById(R.id.season_title);
            posterPath = (ImageView) v.findViewById(R.id.season_poster_image);
            episodeCounter = (EditText) v.findViewById(R.id.episode_counter);
            totalEpisodes = (TextView) v.findViewById(R.id.total_episodes);
            incrementEpisode = (ImageButton) v.findViewById(R.id.increment_episode);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            position = getAdapterPosition();
            Season season = seasonList.get(position);
            Log.d("TV Series", tv.getName());
            Log.d("Season Number", "" + season.getSeasonNumber());
            Log.d("Season ID", "" + season.getId());
            Intent intent = TvEpisodeActivity.createIntent(context, tv, seasonList, season.getId());
            context.startActivity(intent);
        }
    }

    public SeasonAdapter(TV tv, List<Season> seasonList, int rowLayout, Context context) {
        SeasonAdapter.seasonList = seasonList;
        SeasonAdapter.rowLayout = rowLayout;
        SeasonAdapter.context = context;
        SeasonAdapter.tv = tv;
    }

    @Override
    public SeasonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        final SeasonViewHolder viewHolder = new SeasonViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SeasonViewHolder holder, int position) {
        Log.d("BindViewHolder", "" + seasonList.get(position).getId());
        holder.seasonTitle.setText(SEASON + seasonList.get(position).getSeasonNumber());
        Picasso.with(context)
                .load(seasonList.get(position).getPosterPath())
                .into(holder.posterPath);
        /*holder.incrementEpisode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int counter = 1;
                int seasonNumber = seasonList.get(position).getSeasonNumber();
                if (table.containsKey(seasonNumber)) {
                    if (table.get(seasonNumber) < seasonList.get(position).getEpisodeCount()) {
                        counter = table.get(seasonNumber);
                        table.put(seasonNumber, ++counter);
                    }
                } else {
                    table.put(seasonNumber, counter);
                }
                holder.episodeCounter.setText("" + table.get(seasonNumber));
            }
        });
        holder.totalEpisodes.setText("" + seasonList.get(position).getEpisodeCount());*/

    }

    @Override
    public int getItemCount() {
        return seasonList.size();
    }
}
