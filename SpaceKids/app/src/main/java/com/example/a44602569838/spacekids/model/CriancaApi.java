package com.example.a44602569838.spacekids.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 44602569838 on 03/04/2018.
 */

public class CriancaApi {

    private int criancaId;
    private String nome;
    private String idade;
    private String sexo;
    private String foto;

    public CriancaApi(int criancaId, String nome, String idade, String sexo, String foto) {
        this.criancaId = criancaId;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.foto = foto;
    }

    public CriancaApi() {
    }

    public int getCriancaId() {
        return criancaId;
    }

    public void setCriancaId(int criancaId) {
        this.criancaId = criancaId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "CriancaApi{" +
                "criancaId=" + criancaId +
                ", nome='" + nome + '\'' +
                ", idade='" + idade + '\'' +
                ", sexo='" + sexo + '\'' +
                ", foto='" + foto + '\'' +
                '}';
    }
}
