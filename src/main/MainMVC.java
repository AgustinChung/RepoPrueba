package main;

import controlador.Controlador;
import modelo.*;
import vista.PantallaInicio;
import vista.PantallaPelea;
import vista.PantallaUbicaciones;

import java.util.List;

public class MainMVC {

    // * MAIN *
    public static void main(String[] args) {

        PantallaInicio pantalla = new PantallaInicio();
        pantalla.setVisible(true);

        Juego.getInstancia().crearMapa();

    }
}
