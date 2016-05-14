package com.example.nahson.mytvlist.adapter;

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

import com.example.nahson.mytvlist.R;
import com.example.nahson.mytvlist.activity.TVDetail;
import com.example.nahson.mytvlist.model.TV.TV;
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

    private static List<TV> tvList;

    private static int rowLayout;
    private static Context context;

    private final static String API_KEY = "56ad544b1b49a341e09a472c21bfcf9e";
    private final static String TAG = "TAG";
    private static List<Integer> progress;

    public static int ID;

    public static class TVViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        LinearLayout tvLayout;
        TextView tvName;
        TextView data;
        TextView tvShowDescription;
        TextView rating;
        ImageView tvPoster;
        TVID tvid;
        Intent intent;

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
            final int position = getAdapterPosition();

            ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
            final TV tv = tvList.get(position);
            ID = tv.getId();

            Call<TVID> call = apiInterface.getTVShowsDetails(ID, API_KEY);
            call.enqueue(new Callback<TVID>() {
                @Override
                public void onResponse(Call<TVID> call, Response<TVID> response) {
                    tvid = response.body();
                    intent = new Intent(context, TVDetail.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putParcelableArrayListExtra("Season", (ArrayList) tvid.getSeasons());
                    intent.putExtra("Poster", tvid.getPosterPath());
                    intent.putExtra("Backdrop", tvid.getBackdropPath());
                    intent.putExtra("Name", tvid.getName());
                    intent.putExtra("Overview", tvid.getOverview());
                    intent.putExtra("TV", tv);
                    context.startActivity(intent);
                }

                @Override
                public void onFailure(Call<TVID> call, Throwable t) {
                    Log.e("TVAdapter: ", "Error occured");
                }
            });
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
        if (rowLayout != R.layout.favorite_list) {
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
