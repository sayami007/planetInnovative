package com.planetinnovative.firebaseproject.FCM;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.iid.FirebaseInstanceId;
import com.planetinnovative.firebaseproject.R;

public class FCMActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fcm);
        String firebaseInstanceId=FirebaseInstanceId.getInstance().getId();
        System.out.println(firebaseInstanceId);
        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                for (String value : bundle.keySet())
                    System.out.println(value);
            }
        }
    }
}
