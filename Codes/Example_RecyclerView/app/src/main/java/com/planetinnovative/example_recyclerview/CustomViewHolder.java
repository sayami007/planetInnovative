package com.planetinnovative.example_recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomViewHolder extends RecyclerView.ViewHolder {
    TextView tvTitle;
    ImageView ivMain, ivFavicon;

    public CustomViewHolder(View itemView) {
        super(itemView);
        tvTitle = itemView.findViewById(R.id.tvTitle);
        ivMain = itemView.findViewById(R.id.ivMain);
        ivFavicon = itemView.findViewById(R.id.ivFavicon);
    }
}
