package com.planetinnovative.example_recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        //Data
        ArrayList<YoutubeData> youtubeData = new ArrayList<>();
        youtubeData.add(new YoutubeData("Youtube Hits Vol1", R.drawable.favicon1, R.drawable.img1));
        youtubeData.add(new YoutubeData("Facebook Hits Vol1", R.drawable.favicon2, R.drawable.img2));
        youtubeData.add(new YoutubeData("Twitter Hits Vol1", R.drawable.favicon3, R.drawable.img3));
        youtubeData.add(new YoutubeData("Twitter Hits Vol1", R.drawable.favicon3, R.drawable.img3));
        youtubeData.add(new YoutubeData("Twitter Hits Vol1", R.drawable.favicon3, R.drawable.img3));
        youtubeData.add(new YoutubeData("Twitter Hits Vol1", R.drawable.favicon3, R.drawable.img3));
        youtubeData.add(new YoutubeData("Twitter Hits Vol1", R.drawable.favicon3, R.drawable.img3));
        youtubeData.add(new YoutubeData("Twitter Hits Vol1", R.drawable.favicon3, R.drawable.img3));

        //LayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        //CustomAdapter
        CustomAdapter adapter = new CustomAdapter(getApplicationContext(), youtubeData);
        recyclerView.setAdapter(adapter);


    }
}

