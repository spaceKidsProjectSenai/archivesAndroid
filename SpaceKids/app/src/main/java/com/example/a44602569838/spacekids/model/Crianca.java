package com.example.a44602569838.spacekids.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 41183607806 on 22/03/2018.
 */

public class Crianca  implements Parcelable{
    @SerializedName("nome")
    private String nome;
    @SerializedName("idade")
    private String idade;
    @SerializedName("sexo")
    private String sexo;
    @SerializedName("foto")
    private String foto;

    public Crianca() {
    }

    private Crianca(Parcel in) {
        nome = in.readString();
        idade = in.readString();
        sexo = in.readString();
        foto = in.readString();
    }

    public static final Creator<Crianca> CREATOR = new Creator<Crianca>() {
        @Override
        public Crianca createFromParcel(Parcel in) {
            return new Crianca(in);
        }

        @Override
        public Crianca[] newArray(int size) {
            return new Crianca[size];
        }
    };


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
        parcel.writeString(nome);
        parcel.writeString(idade);
        parcel.writeString(sexo);
        parcel.writeString(foto);
    }
}
