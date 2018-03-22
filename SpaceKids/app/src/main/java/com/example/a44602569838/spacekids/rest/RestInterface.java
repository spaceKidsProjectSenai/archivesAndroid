package com.example.a44602569838.spacekids.rest;

import com.example.a44602569838.spacekids.model.Login;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.POST;

/**
 * Created by 44602569838 on 13/03/2018.
 */

public interface RestInterface {

    @POST("/api/Login/cadastrar")
    Call<ResponseBody> LoginCadastro(@Body Login login);
}
