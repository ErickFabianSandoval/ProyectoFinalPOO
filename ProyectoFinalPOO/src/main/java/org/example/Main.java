package org.example;

import org.example.controlador.ControladorMoto;
import org.example.vista.VentanaMoto;


public class Main {
    public static void main(String[] args) {
        VentanaMoto view = new VentanaMoto("Proyecto Final");
        ControladorMoto controller = new ControladorMoto(view);
    }

}