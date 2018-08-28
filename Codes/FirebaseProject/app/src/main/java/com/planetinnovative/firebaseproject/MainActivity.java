package com.planetinnovative.firebaseproject;


import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    String name = null;

    String NOTIFICATION_CHANNEL_ID1 = "Application Channel";
    String NOTIFICATION_CHANNEL_ID2 = "Application Channel2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnText = findViewById(R.id.btnText);
        Button btnText2 = findViewById(R.id.btnText2);

        btnText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationChannel notificationChannel = null;
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);


                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    notificationChannel = new NotificationChannel(
                            NOTIFICATION_CHANNEL_ID1,
                            "Channel 1",
                            NotificationManager.IMPORTANCE_HIGH
                    );
                    notificationManager.createNotificationChannel(notificationChannel);
                }


                Notification notify = new NotificationCompat.Builder(getApplicationContext(), NOTIFICATION_CHANNEL_ID1)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Notification 1")
                        .setContentText("TEXT IS HERE")
                        .build();
                notificationManager.notify(1, notify);


            }
        });

        btnText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationChannel notificationChannel = null;
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);


                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    notificationChannel = new NotificationChannel(
                            NOTIFICATION_CHANNEL_ID2,
                            "Channel 2",
                            NotificationManager.IMPORTANCE_HIGH
                    );
                    notificationManager.createNotificationChannel(notificationChannel);
                }


                Notification notify = new NotificationCompat.Builder(getApplicationContext(), NOTIFICATION_CHANNEL_ID2)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Notification 2")
                        .setContentText("TEXT IS HERE")
                        .build();
                notificationManager.notify(2, notify);


            }
        });
    }
}
