package com.example.a44602569838.spacekids.controller;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.a44602569838.spacekids.R;
import com.example.a44602569838.spacekids.adapters.RVAdapterCriancas;
import com.example.a44602569838.spacekids.model.Cricanca;
import com.example.a44602569838.spacekids.rest.RestInterface;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CadastrarCricancaActivity extends AppCompatActivity {

    Cricanca crianca;
    //
    EditText nome;
    EditText idade;
    //
    String sexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_cricanca);

        //Cria o fb dos inputs
        nome = findViewById(R.id.nome_crianca);
        idade = findViewById(R.id.idade_crianca);

        //Chama o método que recupera as informações
        informacoesCriancas();
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.radio_masculino:
                if (checked)
                    sexo = ("masculino");
                    break;
            case R.id.radio_feminino:
                    sexo = ("feminino");
                if (checked)
                    break;
        }
    }


    public void informacoesCriancas() {
        //Cria criança
        crianca = new Cricanca();

        //Da o sexo da criança
        crianca.setSexo(sexo);
        //Recupera o nome da criança
        crianca.setNome(nome.getEditableText().toString());
        //Recupera a idade da criança
        crianca.setIdade(idade.getEditableText().toString());
    }

    public void cadastrarCrianca() {

        SharedPreferences preferences = getSharedPreferences("spacekids", MODE_PRIVATE);
        final String tokenAuth = preferences.getString("token", "");

       OkHttpClient defaultHttpClient = new OkHttpClient.Builder().addInterceptor((chain)->{
           Request request = chain.request().newBuilder()
                   .addHeader("Authorization", tokenAuth).build();
           return chain.proceed(request);
       }).build();

        Retrofit.Builder builder = new Retrofit.Builder().client(defaultHttpClient).baseUrl("").addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        RestInterface restInterface = retrofit.create(RestInterface.class);

        Call<ResponseBody> call = restInterface.cadastrarCrianca(crianca);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    Log.d("Response code", String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

}
