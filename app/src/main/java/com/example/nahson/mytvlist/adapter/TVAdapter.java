package com.example.nahson.mytvlist.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nahson.mytvlist.Fragments.SearchFragment;
import com.example.nahson.mytvlist.R;
import com.example.nahson.mytvlist.activity.TVDetail;
import com.example.nahson.mytvlist.activity.TvSeasonActivity;
import com.example.nahson.mytvlist.model.TV.TV;
import com.example.nahson.mytvlist.model.TVID.Season;
import com.example.nahson.mytvlist.model.TVID.TVID;
import com.example.nahson.mytvlist.rest.ApiClient;
import com.example.nahson.mytvlist.rest.ApiInterface;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Nah Son on 5/12/2016.
 */
public class TVAdapter extends RecyclerView.Adapter<TVAdapter.TVViewHolder> {
    private static List<Integer> progress;
    private static List<TV> tvList;
    private static int rowLayout;
    private static Context context;
    public static int ID;

    public static class TVViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private LinearLayout tvLayout;
        private TextView tvName;
        private TextView data;
        private TextView tvShowDescription;
        private TextView rating;
        private ImageView tvPoster;
        private TV tv;

        public TVViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
            tvLayout = (LinearLayout) v.findViewById(R.id.tv_layout);
            tvName = (TextView) v.findViewById(R.id.title);
            data = (TextView) v.findViewById(R.id.subtitle);
            tvShowDescription = (TextView) v.findViewById(R.id.description);
            rating = (TextView) v.findViewById(R.id.rating);
            tvPoster = (ImageView) v.findViewById(R.id.poster_image);
            tvPoster.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            tv = tvList.get(position);
            ID = tv.getId();
            Intent intent = TvSeasonActivity.createIntent(context, (ArrayList) tvList, ID);
            context.startActivity(intent);
        }
    }

    public TVAdapter(List<TV> tvList, int rowLayout, Context context) {
        TVAdapter.tvList = tvList;
        TVAdapter.rowLayout = rowLayout;
        TVAdapter.context = context;
    }

    @Override
    public TVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        final TVViewHolder viewHolder = new TVViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TVViewHolder holder, int position) {
        holder.tvName.setText(tvList.get(position).getName());
        Picasso.with(context)
                .load(tvList.get(position).getPosterPath())
                .into(holder.tvPoster);
        if (rowLayout != R.layout.card_view_tv_list) {
            Log.d("Average", tvList.get(position).getVoteAverage().toString());
            holder.rating.setText(tvList.get(position).getVoteAverage().toString());
            holder.data.setText(tvList.get(position).getFirstAirDate());
            holder.tvShowDescription.setText(tvList.get(position).getOverview());
        }
    }

    @Override
    public int getItemCount() {
        return tvList.size();
    }

}
