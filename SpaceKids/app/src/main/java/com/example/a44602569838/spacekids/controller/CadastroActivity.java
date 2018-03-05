package com.example.a44602569838.spacekids.controller;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.a44602569838.spacekids.R;

public class CadastroActivity extends AppCompatActivity {

    EditText editNome, editEmail, editSenha, editConfirmacao;
    Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        findView();
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editNome.getEditableText().toString().trim().isEmpty()) {
                    editNome.setError("Campo não preenchido");
                } else if (editEmail.getEditableText().toString().trim().isEmpty()) {
                    editEmail.setError("Campo não preenchido");
                } else if (editSenha.getEditableText().toString().trim().isEmpty()) {
                    editSenha.setError("Campo não preenchido");
                } else if (editConfirmacao.getEditableText().toString().trim().isEmpty()) {
                    editConfirmacao.setError("Campo não preenchido");
                } else if (!editConfirmacao.getEditableText().toString().trim().equals(editSenha.getEditableText().toString())) {
                    editConfirmacao.setError("Esse campo deve ser igual ao campo senha");
                } else {
                    Snackbar snackbar = Snackbar.make(view, "Cadstrado com Sucesso", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            }
        });

        Button btnVoltar = findViewById(R.id.btnVoltar);

        //Chama a tela de cadastro quando clicado no botão
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent voltar = new Intent(CadastroActivity.this, InicioActivity.class);
                startActivity(voltar);
            }
        });
    }

    public void findView() {
        editNome = findViewById(R.id.nome_input);
        editEmail = findViewById(R.id.email_input);
        editSenha = findViewById(R.id.senha_input);
        editConfirmacao = findViewById(R.id.confirmacao_input);
        btnCadastrar = findViewById(R.id.btnCadastrar);
    }
}
