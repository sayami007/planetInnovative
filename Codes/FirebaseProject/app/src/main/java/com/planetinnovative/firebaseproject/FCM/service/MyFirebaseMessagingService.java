package com.planetinnovative.firebaseproject.FCM.service;

import android.content.Intent;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.planetinnovative.firebaseproject.FCM.ToastBroadcast;

import java.util.Map;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Map<String, String> value =remoteMessage.getData();
        for(String values:value.keySet())
            System.out.println(values);
        showNotification(remoteMessage.getNotification().getBody());
    }

    void showNotification(final String body) {
        Intent intent = new Intent(getApplicationContext(),ToastBroadcast.class);
        intent.setAction("com.android.toaster");
        sendBroadcast(intent);
    }
}
