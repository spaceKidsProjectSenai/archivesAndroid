package com.example.a44602569838.spacekids.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.a44602569838.spacekids.R;

public class SelecionarCriancasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecionar_criancas);
    }

    public void cadastrarCriancasOnClick(View view) {
        Intent i = new Intent(getBaseContext(), CadastrarCricancaActivity.class);
        startActivity(i);
    }
}
