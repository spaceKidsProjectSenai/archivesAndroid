package com.example.a44602569838.spacekids.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.a44602569838.spacekids.R;
import com.example.a44602569838.spacekids.adapters.RVAdapterCriancas;
import com.example.a44602569838.spacekids.model.Crianca;
import com.example.a44602569838.spacekids.rest.RestInterface;
import com.roger.catloadinglibrary.CatLoadingView;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SelecionarCriancasActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RVAdapterCriancas adapter;
    Crianca crianca;
    ArrayList<Crianca> criancas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecionar_criancas);
        findViews();
        listarCriancas();
    }

    public void findViews() {
        recyclerView = findViewById(R.id.rvCriancas);
    }

    public void listarCriancas() {
        Retrofit.Builder builder = new Retrofit.Builder().baseUrl("http://spacekids-001-site1.dtempurl.com").addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        RestInterface restInterface = retrofit.create(RestInterface.class);
        Call<ResponseBody> call = restInterface.listarCricancas();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    if (response.isSuccessful()) {
                        String resposta = response.body().string();
                        JSONArray jsonArray = new JSONArray(resposta);

                        for (int i = 0; i < jsonArray.length(); i++) {
                            crianca = new Crianca();
                            crianca.setNome(jsonArray.getJSONObject(i).getString("nome"));
                            crianca.setIdade(jsonArray.getJSONObject(i).getString("idade"));
                            crianca.setSexo(jsonArray.getJSONObject(i).getString("sexo"));

                            criancas.add(crianca);
                        }
                        adapter = new RVAdapterCriancas(criancas);
                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(SelecionarCriancasActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void cadastrarCriancasOnClick(View view) {
        Intent i = new Intent(getBaseContext(), CadastrarCricancaActivity.class);
        startActivity(i);
    }
}
