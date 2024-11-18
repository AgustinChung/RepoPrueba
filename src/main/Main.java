package main;

import modelo.*;
import vista.PantallaInicio;

public class Main {

    // * MAIN *
    public static void main(String[] args) {

        PantallaInicio pantalla = new PantallaInicio();
        pantalla.setVisible(true);

        Juego.getInstancia().crearMapa();

    }
}
