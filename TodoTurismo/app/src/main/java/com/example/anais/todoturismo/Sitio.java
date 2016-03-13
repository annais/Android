package com.example.anais.todoturismo;


/**
 * Created by Anais on 29/02/2016.
 */
public class Sitio {

    int id;
    String nombre;
    String descripcion;
    String direcion;
    String horario;
    String tlf;
    String precio;
    String otrosDatos;
    String imagen;
    double cord1;
    double cord2;

    public Sitio(){

    }

    public Sitio(String nombre, String descripcion, String imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public Sitio(String nombre, double cord1, double cord2) {
        this.nombre = nombre;
        this.cord1 = cord1;
        this.cord2 = cord2;
    }

    public Sitio(int id, String imagen, String otrosDatos, String precio, String horario, String direcion, String descripcion, String nombre, String tlf) {
        this.id = id;
        this.imagen = imagen;
        this.otrosDatos = otrosDatos;
        this.precio = precio;
        this.horario = horario;
        this.direcion = direcion;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.tlf = tlf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getOtrosDatos() {
        return otrosDatos;
    }

    public void setOtrosDatos(String otrosDatos) {
        this.otrosDatos = otrosDatos;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getDirecion() {
        return direcion;
    }

    public void setDirecion(String direcion) {
        this.direcion = direcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getBreveDescripción() {
        return descripcion.substring(0,100)+"...";
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCord1() {
        return cord1;
    }

    public void setCord1(double cord1) {
        this.cord1 = cord1;
    }

    public double getCord2() {
        return cord2;
    }

    public void setCord2(double cord2) {
        this.cord2 = cord2;
    }
}
