package com.example.christian.adminsportec.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Juego {

    @SerializedName("marcador1")
    @Expose
    private String marcador1;
    @SerializedName("marcador2")
    @Expose
    private String marcador2;
    @SerializedName("resultado")
    @Expose
    private String resultado;
    @SerializedName("fecha")
    @Expose
    private String fecha;
    @SerializedName("equipo1_nombre")
    @Expose
    private String equipo1Nombre;
    @SerializedName("equipo2_nombre")
    @Expose
    private String equipo2Nombre;
    @SerializedName("deporte_id")
    @Expose
    private int deporteId;
    @SerializedName("iniciado")
    @Expose
    private int iniciado;
    @SerializedName("set_actual")
    @Expose
    private String setActual;

    public String getMarcador1() {
        return marcador1;
    }

    public void setMarcador1(String marcador1) {
        this.marcador1 = marcador1;
    }

    public String getMarcador2() {
        return marcador2;
    }

    public void setMarcador2(String marcador2) {
        this.marcador2 = marcador2;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEquipo1Nombre() {
        return equipo1Nombre;
    }

    public void setEquipo1Nombre(String equipo1Nombre) {
        this.equipo1Nombre = equipo1Nombre;
    }

    public String getEquipo2Nombre() {
        return equipo2Nombre;
    }

    public void setEquipo2Nombre(String equipo2Nombre) {
        this.equipo2Nombre = equipo2Nombre;
    }

    public Integer getDeporteId() {
        return deporteId;
    }

    public void setDeporteId(Integer deporteId) {
        this.deporteId = deporteId;
    }

    public Integer getIniciado() {
        return iniciado;
    }

    public void setIniciado(Integer iniciado) {
        this.iniciado = iniciado;
    }

    public String getSetActual() {
        return setActual;
    }

    public void setSetActual(String setActual) {
        this.setActual = setActual;

    }
}