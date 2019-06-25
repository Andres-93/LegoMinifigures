package com.example.pccom.legominifigures.data;

import java.io.Serializable;

public class Figura implements Serializable {

    private long id;
    private String nombre;
    private String urlImg;
    private int enPosesion;
    private String serie;
    private int anio;
    private String accesorios;

    public Figura(long id, String nombre, String urlImg, int enPosesion, String serie, int anio, String accesorios) {
        this.id = id;
        this.nombre = nombre;
        this.urlImg = urlImg;
        this.enPosesion = enPosesion;
        this.serie = serie;
        this.anio = anio;
        this.accesorios = accesorios;
    }

    public Figura(String nombre, String urlImg, int enPosesion, String serie, int anio, String accesorios) {
        this.nombre = nombre;
        this.urlImg = urlImg;
        this.enPosesion = enPosesion;
        this.serie = serie;
        this.anio = anio;
        this.accesorios = accesorios;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public int getEnPosesion() {
        return enPosesion;
    }

    public void setEnPosesion(int enPosesion) {
        this.enPosesion = enPosesion;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getAccesorios() {
        return accesorios;
    }

    public void setAccesorios(String accesorios) {
        this.accesorios = accesorios;
    }

    @Override
    public String toString() {
        return "Figura{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", urlImg='" + urlImg + '\'' +
                ", enPosesion=" + enPosesion +
                ", serie='" + serie + '\'' +
                ", anio=" + anio +
                ", accesorios='" + accesorios + '\'' +
                '}';
    }


}
