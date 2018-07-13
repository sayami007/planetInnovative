package com.planetinnovative.example_recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import static android.content.res.Configuration.ORIENTATION_PORTRAIT;

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
        myApp.add(new MyApplication(R.drawable.im1, "Instagram"));
        myApp.add(new MyApplication(R.drawable.im2, "App Instagram"));
        myApp.add(new MyApplication(R.drawable.im3, "Instagram"));
        myApp.add(new MyApplication(R.drawable.im1, "Mock App"));
        myApp.add(new MyApplication(R.drawable.im3, "Hello World"));
        myApp.add(new MyApplication(R.drawable.im2, "Instagram"));
        myApp.add(new MyApplication(R.drawable.im1, "Instagram"));
        myApp.add(new MyApplication(R.drawable.im2, "Instagram"));
        myApp.add(new MyApplication(R.drawable.im3, "Instagram"));
        myApp.add(new MyApplication(R.drawable.im2, "Instagram"));
        //
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        if(getResources().getConfiguration().orientation == ORIENTATION_PORTRAIT )
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        else
            recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        recyclerView.setAdapter(new CustomAdapter(getApplicationContext(), myApp));
        //
        DividerItemDecoration decoration = new DividerItemDecoration(getApplicationContext(),DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(decoration);

    }
}



