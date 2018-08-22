package com.planetinnovative.serviceapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

import com.planetinnovative.serviceapplication.service.MainIntentService;
import com.planetinnovative.serviceapplication.service.MainService;

public class MainActivity extends AppCompatActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ToggleButton toggle = findViewById(R.id.toggle);
        toggle.


        Button btnStartService = findViewById(R.id.btnStartService);
        Button btnStopService = findViewById(R.id.btnStopService);
        Button btnStartIntentService = findViewById(R.id.btnStartIntentService);

        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Activity THREAD: " + Thread.currentThread().getId());
                intent = new Intent(getApplicationContext(), MainService.class);
                intent.putExtra("Name", "Ram");
                startService(intent);
            }
        });

        btnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(intent);
            }
        });

        btnStartIntentService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("ACTIVITY THREAD:"+Thread.currentThread().getId());
                Intent intent2 = new Intent(getApplicationContext(), MainIntentService.class);
                startService(intent2);
            }
        });
    }
}
