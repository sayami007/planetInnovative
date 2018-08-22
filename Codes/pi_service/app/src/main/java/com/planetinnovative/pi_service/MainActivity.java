package com.planetinnovative.pi_service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button clickMe = findViewById(R.id.clickMe);
        clickMe.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        System.out.println("SERVICE");
        Intent intent = new Intent(getApplicationContext(), AlarmManager.class);
        startService(intent);
    }
}
