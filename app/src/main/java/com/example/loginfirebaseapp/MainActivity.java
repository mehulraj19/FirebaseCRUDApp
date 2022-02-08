package com.example.loginfirebaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button addButton, viewButton, viewAllButton, updateButton, deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = findViewById(R.id.addButton);
        viewButton = findViewById(R.id.viewButton);
        viewAllButton = findViewById(R.id.viewAllButton);
        updateButton = findViewById(R.id.updateButton);
        deleteButton = findViewById(R.id.deleteButton);


        // button working
        addButton.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AddDataActivity.class));
        });

        viewButton.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ReadDataActivity.class));
        });
        viewAllButton.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ReadAllDataActivity.class));
        });

        deleteButton.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, DeleteDataActivity.class));
        });
        updateButton.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, UpdateDataActivity.class));
        });

    }
}