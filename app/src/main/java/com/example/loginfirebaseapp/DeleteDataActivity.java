package com.example.loginfirebaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loginfirebaseapp.util.Util;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DeleteDataActivity extends AppCompatActivity {

    EditText editUsername;
    Button deleteDataButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_data);

        editUsername = findViewById(R.id.editDeleteDataUsername);
        deleteDataButton = findViewById(R.id.deleteDataButton);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference(Util.DATABASE_NAME);

        deleteDataButton.setOnClickListener(v -> {
            String username = editUsername.getText().toString();
            if (!username.isEmpty()) {
                reference.child(username).removeValue()
                        .addOnSuccessListener(unused -> {
                            Toast.makeText(this, "Employee Details Deleted!!", Toast.LENGTH_SHORT).show();
                            finish();
                        })
                        .addOnFailureListener(e -> {
                            Toast.makeText(this, "Unable to Delete Employee Details", Toast.LENGTH_SHORT).show();
                        });
            }
        });
    }
}