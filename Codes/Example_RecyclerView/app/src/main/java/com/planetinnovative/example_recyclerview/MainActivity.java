package com.planetinnovative.example_recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Data
        ArrayList<MyApplication> myApp = new ArrayList<>();
        myApp.add(new MyApplication(R.drawable.im1, "Youtube"));
        myApp.add(new MyApplication(R.drawable.im2, "Facebook"));
        myApp.add(new MyApplication(R.drawable.im3, "Instagram"));
        //



        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(new CustomAdapter(getApplicationContext(), myApp));

    }
}



