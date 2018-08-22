package com.planetinnovative.pi_service;

import android.app.IntentService;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.support.annotation.Nullable;

import java.util.logging.Handler;


public class AlarmManager extends IntentService {


    public AlarmManager() {
        super("AlarmManager");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

}
