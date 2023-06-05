package org.example.modelo;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Motocicleta {
    private int id;
    private String marca;
    private String modelo;
    private double velocidad;
    private String pais;
    private String url;

    public Motocicleta() {
    }

    public Motocicleta(int id, String marca, String modelo, double velocidad, String pais, String url) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.velocidad = velocidad;
        this.pais = pais;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Motocicleta{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", velocidad=" + velocidad +
                ", pais='" + pais + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public ImageIcon getImagen() throws MalformedURLException {
        URL urlImage = new URL(this.url);
        return new ImageIcon(urlImage);
    }
}
