package com.example.a44602569838.spacekids.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 44602569838 on 29/03/2018.
 */

public class Logar {
    @SerializedName("email")
    private String email;
    @SerializedName("senha")
    private String senha;

    public Logar(String email, String senha) {
        this.email = email;
        this.senha = senha;
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

    @Override
    public String toString() {
        return "Logar{" +
                "email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
