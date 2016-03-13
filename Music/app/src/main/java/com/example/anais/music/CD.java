package com.example.anais.music;

import android.widget.ImageView;

/**
 * Created by Anais on 13/01/2016.
 */
public class CD {

    String nombre;
    String disco;
    int ano;
    int imagen;

    public CD(String nombre,  String disco, int ano, int imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.ano = ano;
        this.disco = disco;
    }

    public CD(String nombre, int ano, String disco) {
        this.nombre = nombre;
        this.ano = ano;
        this.disco = disco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getDisco() {
        return disco;
    }

    public void setDisco(String disco) {
        this.disco = disco;
    }

    @Override
    public String toString() {
        return "CD{" +
                "nombre='" + nombre + '\'' +
                ", disco='" + disco + '\'' +
                ", ano=" + ano +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
