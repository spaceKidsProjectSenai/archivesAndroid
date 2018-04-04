package com.example.a44602569838.spacekids.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a44602569838.spacekids.R;
import com.roger.catloadinglibrary.CatLoadingView;

public class HomeActivity extends AppCompatActivity {

    Button jogar;
    CatLoadingView mView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        findViews();

        //dwqdq
        mView = new CatLoadingView();
        jogar.setOnClickListener(view -> {
            mView.show(getSupportFragmentManager(), "");
            Intent i = new Intent(getBaseContext(), SelecionarCriancasActivity.class);
            startActivity(i);
        });
    }

    public void findViews() {
        jogar = findViewById(R.id.jogar);

    }
}
