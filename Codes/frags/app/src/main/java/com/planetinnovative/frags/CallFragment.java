package com.planetinnovative.frags;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class CallFragment extends Fragment {
    RecyclerView callRecycler;
    int[] images = {android.R.drawable.star_off, android.R.drawable.star_off, android.R.drawable.star_off};
    String[] name = {"RAME", "CHS", "SDF"};
    String[] date = {"2012/12/12", "2012/12/12", "2012/12/12"};


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View callPage = inflater.inflate(R.layout.call_fragment, container, false);
        callRecycler = callPage.findViewById(R.id.callRecycler);
        callRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        callRecycler.setAdapter(new CustomAdapter(getContext(), name, date, images));
        return callPage;
    }
}

class CustomViewHolder extends RecyclerView.ViewHolder {
    TextView tvCallName, tvCallDate;
    ImageView ivCall;

    public CustomViewHolder(View itemView) {
        super(itemView);
        ivCall = itemView.findViewById(R.id.ivCall);
        tvCallName = itemView.findViewById(R.id.tvCallName);
        tvCallDate = itemView.findViewById(R.id.tvCallDate);
    }
}

class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    LayoutInflater inflater;
    String[] name;
    String[] date;
    int[] image;

    public CustomAdapter(Context inflater, String[] name, String[] date, int[] image) {
        this.name = name;
        this.date = date;
        this.image = image;
        this.inflater = LayoutInflater.from(inflater);
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.call_custom_view, parent, false);
        CustomViewHolder hol = new CustomViewHolder(view);
        return hol;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.tvCallDate.setText(date[position]);
        holder.tvCallName.setText(name[position]);
        holder.ivCall.setImageResource(image[position]);
    }

    @Override
    public int getItemCount() {
        return date.length;
    }
}
