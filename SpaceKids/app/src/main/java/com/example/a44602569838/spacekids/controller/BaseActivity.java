package com.example.a44602569838.spacekids.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by 41183607806 on 22/03/2018.
 */

public abstract class BaseActivity extends AppCompatActivity{
    public abstract void inicializarComponentes();

    public void mudaTela(Class<?> tClass){
        Intent intent = new Intent(getBaseContext(), tClass);
        startActivity(intent);
    }
}
