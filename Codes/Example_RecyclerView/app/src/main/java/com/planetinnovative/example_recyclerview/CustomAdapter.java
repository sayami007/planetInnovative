package com.planetinnovative.example_recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    ArrayList<MyApplication> myApp;
    LayoutInflater inflater;


    public CustomAdapter(Context context, ArrayList<MyApplication> myApp) {
        this.myApp = myApp;
        inflater = inflater.from(context);
    }


    @NonNull
    @Override
    public CustomAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.single_design, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.CustomViewHolder holder, int position) {
        holder.textView.setText(myApp.get(position).getAppTitle());
        holder.imageView.setImageResource(myApp.get(position).getAppImage());
    }

    @Override
    public int getItemCount() {
        return myApp.size();
    }


    class CustomViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public CustomViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ivMainImage);
            textView = itemView.findViewById(R.id.ivMainText);
        }
    }
}

