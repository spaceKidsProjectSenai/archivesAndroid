package com.example.a44602569838.spacekids.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by 41183607806 on 22/03/2018.
 */

public class Desempenho {

    @SerializedName("acertou")
    private boolean acertou;
    @SerializedName("horaInicial")
    private String horaInicial;
    @SerializedName("horaFinal")
    private String horaFinal;
    @SerializedName("criancaId")
    private int criancaID;
    @SerializedName("faseId")
    private int faseID;

    public Desempenho(boolean acertou, String horaInicial, String horaFinal, int criancaID, int faseID) {
        this.acertou = acertou;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
        this.criancaID = criancaID;
        this.faseID = faseID;
    }

    public Desempenho() {
    }

    public boolean isAcertou() {
        return acertou;
    }

    public void setAcertou(boolean acertou) {
        this.acertou = acertou;
    }

    public String getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(String horaInicial) {
        this.horaInicial = horaInicial;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    public int getCriancaID() {
        return criancaID;
    }

    public void setCriancaID(int criancaID) {
        this.criancaID = criancaID;
    }

    public int getFaseID() {
        return faseID;
    }

    public void setFaseID(int faseID) {
        this.faseID = faseID;
    }

    @Override
    public String toString() {
        return "Desempenho{" +
                "acertou=" + acertou +
                ", horaInicial=" + horaInicial +
                ", horaFinal=" + horaFinal +
                ", criancaID=" + criancaID +
                ", faseID=" + faseID +
                '}';
    }
}
