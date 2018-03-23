package com.example.a44602569838.spacekids.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import com.example.a44602569838.spacekids.R;

public class LoginActivity extends BaseActivity {

    EditText editEmail, editSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        inicializarComponentes();
    }

    @Override
    public void inicializarComponentes() {
        findViews();
    }

    public void findViews() {
        editEmail = findViewById(R.id.email_input);
        editSenha = findViewById(R.id.senha_input);
    }

    public void logarOnClick(View view) {
        if (editEmail.getEditableText().toString().trim().equals("")) {
            editEmail.setError("Campo Obrigatório");
        } else if (editSenha.getEditableText().toString().trim().equals("")) {
            editSenha.setError("Campo Obrigatório");
        } else {
            logar();
        }
    }

    public void logar() {

    }
}
