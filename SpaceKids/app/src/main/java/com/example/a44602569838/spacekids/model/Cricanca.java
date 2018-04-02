package com.example.a44602569838.spacekids.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by 41183607806 on 22/03/2018.
 */

public class Cricanca  implements Parcelable{
    private String criancaId;
    private String nome;
    private String idade;
    private String sexo;
    private String foto;

    public Cricanca() {
    }

    private Cricanca(Parcel in) {
        criancaId = in.readString();
        nome = in.readString();
        idade = in.readString();
        sexo = in.readString();
        foto = in.readString();
    }

    public static final Creator<Cricanca> CREATOR = new Creator<Cricanca>() {
        @Override
        public Cricanca createFromParcel(Parcel in) {
            return new Cricanca(in);
        }

        @Override
        public Cricanca[] newArray(int size) {
            return new Cricanca[size];
        }
    };

    public String getCriancaId() {
        return criancaId;
    }

    public void setCriancaId(String criancaId) {
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
        return "Cricanca{" +
                "criancaId='" + criancaId + '\'' +
                ", nome='" + nome + '\'' +
                ", idade='" + idade + '\'' +
                ", sexo='" + sexo + '\'' +
                ", foto='" + foto + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(criancaId);
        parcel.writeString(nome);
        parcel.writeString(idade);
        parcel.writeString(sexo);
        parcel.writeString(foto);
    }
}
