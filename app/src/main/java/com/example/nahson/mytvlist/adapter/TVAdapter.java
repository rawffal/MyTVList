package com.example.nahson.mytvlist.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nahson.mytvlist.R;
import com.example.nahson.mytvlist.activity.TVDetail;
import com.example.nahson.mytvlist.model.TV;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Nah Son on 5/12/2016.
 */
public class TVAdapter extends RecyclerView.Adapter<TVAdapter.TVViewHolder> {

    private static List<TV> tvList;
    private static int rowLayout;
    private static Context context;

    public static class TVViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        LinearLayout tvLayout;
        TextView tvName;
        TextView data;
        TextView tvShowDescription;
        TextView rating;
        ImageView tvPoster;

        public TVViewHolder(View v) {
            super(v);
            tvLayout = (LinearLayout) v.findViewById(R.id.tv_layout);
            tvName = (TextView) v.findViewById(R.id.title);
            data = (TextView) v.findViewById(R.id.subtitle);
            tvShowDescription = (TextView) v.findViewById(R.id.description);
            rating = (TextView) v.findViewById(R.id.rating);
            tvPoster = (ImageView) v.findViewById(R.id.poster_image);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Intent intent = new Intent(context, TVDetail.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra(TVDetail.EXTRA_TV, tvList.get(position));
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
        holder.tvName.setText(tvList.get(position).getOriginalName());
        holder.data.setText(tvList.get(position).getFirstAirDate());
        holder.tvShowDescription.setText(tvList.get(position).getOverview());
        Picasso.with(context)
                .load(tvList.get(position).getPosterPath())
                .into(holder.tvPoster);
        holder.rating.setText(tvList.get(position).getVoteAverage().toString());
    }

    @Override
    public int getItemCount() {
        return tvList.size();
    }

}
