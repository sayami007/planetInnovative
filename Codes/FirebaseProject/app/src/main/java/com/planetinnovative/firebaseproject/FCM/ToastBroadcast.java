package com.planetinnovative.firebaseproject.FCM;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ToastBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "New Message Received", Toast.LENGTH_SHORT).show();
    }
}
