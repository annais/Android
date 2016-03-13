package com.example.anais.animales;

/**
 * Created by Anais on 25/01/2016.
 */
public class Animal {
    int imagen;
    int sonido;
    int color;

    public Animal(int imagen, int sonido) {
        this.imagen = imagen;
        this.sonido = sonido;
    }

    public Animal(int imagen, int sonido, int color) {
        this.imagen = imagen;
        this.sonido = sonido;
        this.color = color;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getSonido() {
        return sonido;
    }

    public void setSonido(int sonido) {
        this.sonido = sonido;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
