package com.example.a44602569838.spacekids.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 44602569838 on 01/03/2018.
 */

public class Login {
    @SerializedName("email")
    private String email;
    @SerializedName("senha")
    private String senha;
    @SerializedName("nome")
    private String nome;

    public Login() {
    }

    public Login(String email, String senha, String nome) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Login{" +
                "email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
