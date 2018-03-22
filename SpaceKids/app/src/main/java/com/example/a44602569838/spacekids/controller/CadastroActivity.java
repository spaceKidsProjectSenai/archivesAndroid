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
import android.widget.Toast;

import com.example.a44602569838.spacekids.R;
import com.example.a44602569838.spacekids.model.Login;
import com.example.a44602569838.spacekids.rest.RestInterface;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
                   cadastrarPai(new Login(editEmail.getEditableText().toString(), editSenha.getEditableText().toString(), editNome.getText().toString()));
                    Toast.makeText(CadastroActivity.this, "Cadastrado com Sucesso", Toast.LENGTH_SHORT).show();
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

    public void cadastrarPai(Login l) {
        Retrofit.Builder builder = new Retrofit.Builder().baseUrl("http://spacekids-001-site1.dtempurl.com").addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();
        RestInterface restInterface = retrofit.create(RestInterface.class);

        Call<ResponseBody> call = restInterface.LoginCadastro(l);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    Toast.makeText(CadastroActivity.this, String.valueOf(response.code()), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
