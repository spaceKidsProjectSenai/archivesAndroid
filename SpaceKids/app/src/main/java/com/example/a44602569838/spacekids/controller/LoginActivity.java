package com.example.a44602569838.spacekids.controller;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import com.example.a44602569838.spacekids.R;
import com.example.a44602569838.spacekids.model.Logar;
import com.example.a44602569838.spacekids.rest.RestInterface;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
        Retrofit.Builder builder = new Retrofit.Builder().baseUrl("http://spacekids-001-site1.dtempurl.com").addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        RestInterface restInterface = retrofit.create(RestInterface.class);

        Call<ResponseBody> call = restInterface.logar(new Logar(editEmail.getEditableText().toString(), editSenha.getEditableText().toString()));
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    if (response.isSuccessful()) {

                        JSONObject jsonObject = new JSONObject(response.body().string());
                        String token = jsonObject.getString("acessToken");
                        Log.d("token", token);

                        SharedPreferences tokenShared =  getSharedPreferences("spacekids", MODE_PRIVATE);
                        SharedPreferences.Editor editor = tokenShared.edit();
                        editor.putString("token", "Bearer "+token);
                        editor.apply();


                        Intent i = new Intent(getBaseContext(), HomeActivity.class);
                        startActivity(i);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
