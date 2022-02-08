package com.example.loginfirebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loginfirebaseapp.model.Employee;
import com.example.loginfirebaseapp.util.Util;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddDataActivity extends AppCompatActivity {

    EditText editUsername, editName, editDesignation, editExperience;
    Button addDataButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        // ENTRIES
        editUsername = findViewById(R.id.editUserName);
        editName = findViewById(R.id.editFullName);
        editDesignation = findViewById(R.id.editDesignation);
        addDataButton = findViewById(R.id.addDataButton);

        // DATABASE
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference reference = db.getReference(Util.DATABASE_NAME);

        addDataButton.setOnClickListener(v -> {
            String username = editUsername.getText().toString();
            String name = editName.getText().toString();
            String designation = editDesignation.getText().toString();

            if (!username.isEmpty() && !name.isEmpty() && !designation.isEmpty()) {
                Employee employee = new Employee(username, designation, name);
                reference.child(username).setValue(employee)
                        .addOnSuccessListener(unused -> {
                            Toast.makeText(this, "User Added!!", Toast.LENGTH_SHORT).show();
                            finish();
                        })
                        .addOnFailureListener(e -> {
                            Toast.makeText(this, "User Not Added!!", Toast.LENGTH_SHORT).show();
                        });
            }

        });
    }
}