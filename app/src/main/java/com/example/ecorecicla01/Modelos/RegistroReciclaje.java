package com.example.ecorecicla01.Modelos;

public class RegistroReciclaje {

    private int cantidad, peso;

    private String mes, idUsuario;

    public RegistroReciclaje(int cantidad, int peso, String mes, String idUsuario) {
        this.cantidad = cantidad;
        this.peso = peso;
        this.mes = mes;
        this.idUsuario = idUsuario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

}
