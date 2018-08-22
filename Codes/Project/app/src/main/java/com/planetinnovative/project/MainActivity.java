package com.planetinnovative.project;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.provider.Telephony;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Activity act;
    ListView lvItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.act = this;
        setContentView(R.layout.activity_main);
        Button btnGetMessage = findViewById(R.id.btnGetMessage);
        lvItem = findViewById(R.id.lvItem);

        btnGetMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(act, new String[]{Manifest.permission.READ_SMS}, 100);
                } else {
                    Uri allMessages = Uri.parse("content://sms/");
                    String[] columnName = new String[]{"date", "person", "body"};
                    Cursor cursor = getContentResolver().query(allMessages, null, null, null, null);
                    for(String values : cursor.getColumnNames()){
                        System.out.println(values);
                    }
                    /*ArrayList<String> list = new ArrayList<>();
                    while (cursor.moveToNext()) {
                        list.add(cursor.getString(2));
                        System.out.println(cursor.getString(2));
                    }
                    ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_dropdown_item_1line, list);
                    lvItem.setAdapter(arrayAdapter);*/
                }
            }
        });
    }

}