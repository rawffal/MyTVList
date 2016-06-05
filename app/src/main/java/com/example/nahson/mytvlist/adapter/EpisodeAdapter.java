package com.example.nahson.mytvlist.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nahson.mytvlist.R;
import com.example.nahson.mytvlist.model.SeasonNumber.Episode;

import java.util.List;

/**
 * Created by Nah Son on 5/13/2016.
 */
public class EpisodeAdapter extends RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder> {

    private static List<Episode> episodeList;
    private static int rowLayout;
    private static Context context;

    public static class EpisodeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        LinearLayout linearLayout;
        TextView episodeTitle;
        TextView episodeAirDate;
        TextView episodeOverview;
        TextView episodeNumber;
        ImageView episodeImage;

        public EpisodeViewHolder(View v) {
            super(v);
            linearLayout = (LinearLayout) v.findViewById(R.id.episode_layout);
            episodeTitle = (TextView) v.findViewById(R.id.episode_name);
            episodeAirDate = (TextView) v.findViewById(R.id.episode_air_date);
            episodeOverview = (TextView) v.findViewById(R.id.episode_overview);
            episodeNumber = (TextView) v.findViewById(R.id.episode_number);
            /*episodeImage = (ImageView) v.findViewById(R.id.episode_image);*/
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }

    public EpisodeAdapter(List<Episode> episodeList, int rowLayout, Context context) {
        EpisodeAdapter.episodeList = episodeList;
        EpisodeAdapter.rowLayout = rowLayout;
        EpisodeAdapter.context = context;
    }

    @Override
    public EpisodeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        final EpisodeViewHolder viewHolder = new EpisodeViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final EpisodeViewHolder holder, int position) {
        holder.episodeNumber.setText(episodeList.get(position).getEpisodeNumber() + ".");
        holder.episodeTitle.setText(episodeList.get(position).getName());
        holder.episodeAirDate.setText(episodeList.get(position).getAirDate());
        holder.episodeOverview.setText(episodeList.get(position).getOverview());
    }

    @Override
    public int getItemCount() {
        return episodeList.size();
    }
}

