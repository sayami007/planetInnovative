package com.planetinnovative.firebaseproject.Database;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.planetinnovative.firebaseproject.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DatabaseActivity extends AppCompatActivity {
    Button btnUpdate, btnShow, btnDelete, btnAdd;
    ListView listView;
    ArrayList<String> notesTitle;
    FirebaseDatabase database;
    String token;
    public static String databaseName ="NewDatabase";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        database = FirebaseDatabase.getInstance();

        listView = findViewById(R.id.listView);
        btnShow = findViewById(R.id.btnShow);
        btnAdd = findViewById(R.id.btnAdd);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        notesTitle = new ArrayList<>();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database = FirebaseDatabase.getInstance();
                DatabaseReference ref = database.getReference(databaseName);
                NotesDetailModel mod = new NotesDetailModel(
                        "1",
                        "Title 1",
                        "Main Details",
                        "H");
                ref.child(ref.push().getKey()).setValue(mod);
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DatabaseReference myRef = database.getReference(databaseName);
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        notesTitle.clear();
                        for (DataSnapshot child : dataSnapshot.getChildren()) {
                            DataSnapshot allData = dataSnapshot.child(child.getKey());
                            NotesDetailModel value = allData.getValue(NotesDetailModel.class);
                            notesTitle.add(value.title);
                        }
                        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, notesTitle);
                        listView.setAdapter(listViewAdapter);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference myRef = database.getReference();
                NotesDetailModel model = new NotesDetailModel(
                        "1",
                        "SHRETHA",
                        "DETAIL",
                        "H"
                );
                Map<String, Object> objectMap = new HashMap<>();
                objectMap.put("5", model);//5 is the id of the data to be updated
                myRef.updateChildren(objectMap);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference myRef = database.getReference("notes_table");
                Query query = myRef.child("5");
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot reference : dataSnapshot.getChildren()) {
                            reference.getRef().removeValue();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
