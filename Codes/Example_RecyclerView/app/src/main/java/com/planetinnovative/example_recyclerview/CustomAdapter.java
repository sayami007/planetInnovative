package com.planetinnovative.example_recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {


    ArrayList<YoutubeData> youtubeData;
    LayoutInflater inflater;

    CustomAdapter(Context context, ArrayList<YoutubeData> youtubeData) {
        this.youtubeData = youtubeData;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_view, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.tvTitle.setText(youtubeData.get(position).getTitle());
        holder.ivFavicon.setImageResource(youtubeData.get(position).getFavImage());
        holder.ivMain.setImageResource(youtubeData.get(position).getMainImage());
    }

    @Override
    public int getItemCount() {
        return youtubeData.size();
    }
}
