package com.example.a44602569838.spacekids;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastroActivity extends AppCompatActivity {

    EditText editNome, editEmail, editSenha, editConfirmacao;
    Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        findView();
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editNome.getEditableText().toString().isEmpty()) {
                    editNome.setError("Campo não preenchido");
                } else if (editEmail.getEditableText().toString().isEmpty()) {
                    editEmail.setError("Campo não preenchido");
                } else if (editSenha.getEditableText().toString().isEmpty()) {
                    editSenha.setError("Campo não preenchido");
                } else if (editConfirmacao.getEditableText().toString().isEmpty()) {
                    editConfirmacao.setError("Campo não preenchido");
                } else if (!editConfirmacao.getEditableText().toString().equals(editSenha.getEditableText().toString())) {
                    editConfirmacao.setError("Esse campo deve ser igual ao campo senha");
                } else {
                    Snackbar snackbar = Snackbar.make(view, "Cadstrado com Sucesso", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
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
