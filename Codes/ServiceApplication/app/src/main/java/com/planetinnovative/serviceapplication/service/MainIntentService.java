package com.planetinnovative.serviceapplication.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

public class MainIntentService extends IntentService {

    boolean isServiceRunning = false;

    public MainIntentService() {
        super("MainIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        try {
            isServiceRunning = true;
            while (isServiceRunning) {
                Thread.sleep(500);
                intent.getStringExtra("Name");
                System.out.println("hello, " + intent.getStringExtra("Name"));
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        return START_REDELIVER_INTENT;
    }
}
