package com.example.whiteboardnew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Main_menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Button checkAvailableFriends = findViewById(R.id.checkAvailableFriends);
        checkAvailableFriends.setOnClickListener(v -> {
            Intent i = new Intent(this, CheckAvailableFriendActivity.class);
            startActivity(i);
        });
        Button checkDeadlines = findViewById(R.id.checkDeadlines);
        checkDeadlines.setOnClickListener(v -> {
            Intent i = new Intent(this, CheckDeadlinesActivity.class);
            startActivity(i);
        });
        Button checkParking = findViewById(R.id.checkParking);
        checkParking.setOnClickListener(v -> {
            Intent i = new Intent(Main_menu.this, CheckParkingActivity.class);
            startActivity(i);
        });
    }
}
