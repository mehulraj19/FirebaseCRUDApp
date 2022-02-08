package com.example.loginfirebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.loginfirebaseapp.util.Util;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ReadDataActivity extends AppCompatActivity {

    EditText editUserName;
    Button showDataButton;
    TextView textShowData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_data);

        editUserName = findViewById(R.id.editReadUserName);
        showDataButton = findViewById(R.id.readDataButton);
        textShowData = findViewById(R.id.textReadData);
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference reference = db.getReference(Util.DATABASE_NAME);

        showDataButton.setOnClickListener(v -> {
            String userName = editUserName.getText().toString();
            if (!userName.isEmpty()) {
                reference.child(userName).get().addOnCompleteListener(task -> {
                    if(task.isSuccessful()) {
                        if (task.getResult().exists()) {
                            DataSnapshot snapshot = task.getResult();
                            String designation = String.valueOf(snapshot.child(Util.KEY_DESIGNATION).getValue());
                            String fullName = String.valueOf(snapshot.child(Util.KEY_NAME).getValue());
                            String data = "Username: " + userName + "\n\n" + "Fullname: " + fullName + "\n\n" + "Designation: " + designation;
                            textShowData.setText(data);

                        }
                    }
                });
            }
        });
    }
}