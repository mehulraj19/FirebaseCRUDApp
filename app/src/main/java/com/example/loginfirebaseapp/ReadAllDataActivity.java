package com.example.loginfirebaseapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginfirebaseapp.model.Employee;
import com.example.loginfirebaseapp.util.Util;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;

public class ReadAllDataActivity extends AppCompatActivity {

    TextView textData;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_all_data);

        listView = findViewById(R.id.label);
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference(Util.DATABASE_NAME);

        ArrayList<String> arr = new ArrayList<>();
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.list_item, arr);
        listView.setAdapter(adapter);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                arr.clear();
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    Employee employee = dataSnapshot.getValue(Employee.class);
                    arr.add("Username:  " + employee.getUsername() + "\n\n" + "Fullname:  " + employee.getFullName() + "\n\n" + "Designation: " + employee.getDesignation() + "\n\n");
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}