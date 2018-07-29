package com.planetinnovative.example_recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    ArrayList<YoutubeData> data;
    LayoutInflater inflater;

    public CustomAdapter(Context ctx, ArrayList<YoutubeData> data) {
        this.data = data;
        inflater = LayoutInflater.from(ctx);
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
        holder.tvTitle.setText( data.get(position).getTitle());
        holder.ivMain.setImageResource( data.get(position).getMainImage());
        holder.ivFavicon.setImageResource( data.get(position).getFavImage());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
