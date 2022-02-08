package com.example.loginfirebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loginfirebaseapp.model.Employee;
import com.example.loginfirebaseapp.util.Util;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class UpdateDataActivity extends AppCompatActivity {

    EditText updateUsername, updateFullname, updateDesignation;
    Button updateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        updateUsername = findViewById(R.id.editUpdateUserName);
        updateFullname = findViewById(R.id.editUpdateFullName);
        updateDesignation = findViewById(R.id.editUpdateDesignation);
        updateButton = findViewById(R.id.updateDataButton);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference(Util.DATABASE_NAME);

        updateButton.setOnClickListener(v -> {
            HashMap employee = new HashMap();
            employee.put(Util.KEY_DESIGNATION, updateDesignation.getText().toString());
            employee.put(Util.KEY_NAME, updateFullname.getText().toString());
            employee.put(Util.KEY_USERNAME, updateUsername.getText().toString());
            reference.child(updateUsername.getText().toString()).updateChildren(employee)
                    .addOnSuccessListener(o -> {
                        Toast.makeText(this, "Employee Details Updated!!", Toast.LENGTH_SHORT).show();
                    })
                    .addOnFailureListener(e -> {
                        Toast.makeText(this, "Unable to Update!!", Toast.LENGTH_SHORT).show();
                    });
        });
    }
}