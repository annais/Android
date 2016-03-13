package com.example.anais.puntosturisticos;

/**
 * Created by Anais on 25/01/2016.
 */
public class Sitio {
    String nombre;
    int imagen;
    String descripción;


    public Sitio(String nombre, String descripción, int imagen) {
        this.nombre = nombre;
        this.descripción = descripción;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripción() {
        return descripción;
    }

    public String getBreveDescripción() {
        return descripción.substring(0,100)+"...";
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Sitio{" +
                "nombre='" + nombre + '\'' +
                ", imagen=" + imagen +
                ", descripción='" + descripción + '\'' +
                '}';
    }
}
