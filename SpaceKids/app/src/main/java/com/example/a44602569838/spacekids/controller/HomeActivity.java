package com.example.a44602569838.spacekids.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a44602569838.spacekids.R;

public class HomeActivity extends AppCompatActivity {

    Button jogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        findViews();

        jogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void findViews() {
        jogar = findViewById(R.id.jogar);
    }
}
