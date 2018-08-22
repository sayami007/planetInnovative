package com.planetinnovative.serviceapplication.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class MainService extends Service {
    boolean isServiceRunning = false;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
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
        }).start();
        return START_REDELIVER_INTENT;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        isServiceRunning=false;
    }
}
