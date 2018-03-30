package com.example.a44602569838.spacekids.rest;

import com.example.a44602569838.spacekids.model.Cricanca;
import com.example.a44602569838.spacekids.model.Desempenho;
import com.example.a44602569838.spacekids.model.Fase;
import com.example.a44602569838.spacekids.model.Logar;
import com.example.a44602569838.spacekids.model.Login;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface RestInterface {

    /* API's Relacionadas ao Login */

    @POST("/api/Login/cadastrar")
    Call<ResponseBody> cadastrarlogin(@Body Login login);

    @POST("/api/Login/autenticar")
    Call<ResponseBody> logar(@Body Logar logar);

    /* Fim API's Relacionadas ao Login */

    /*API's Relacionadas a criança*/

    @POST("api/Cricanca/cadastrar")
    Call<ResponseBody> cadastrarCrianca(@Body Cricanca cricanca);

    @GET("/api/Cricanca/listar")
    Call<ResponseBody> listarCricancas();

    /*Fim API's Relacionadas a criança*/

    /* API's Relacionadas ao Desempenho*/

    @POST("/api/Desempenho/cadastrar")
    Call<ResponseBody> cadastrarDesempenho(@Body Desempenho desempenho);

    /* Fim API's Relacionadas ao Desempenho*/

    /* API's Relacionadas a Fase */

    @POST("/api/Fase/cadastrar")
    Call<ResponseBody> cadastrarFase(@Body Fase fase);

    /* Fim API's Relacionadas a Fase*/

}
