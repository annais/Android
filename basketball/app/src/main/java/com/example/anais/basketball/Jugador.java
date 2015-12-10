package com.example.anais.basketball;

/**
 * Created by Anais on 07/12/2015.
 */
public class Jugador {
    String camiseta;
    int puntos;

    Jugador(String camiseta, int puntos){
        this.camiseta = camiseta;
        this.puntos = puntos;
    }

    public String getCamiseta() {
        return camiseta;
    }

    public void setCamiseta(String camiseta) {
        this.camiseta = camiseta;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
}
