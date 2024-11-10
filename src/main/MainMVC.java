package main;

import controlador.Controlador;
import modelo.Dragon;
import modelo.Guerrero;
import modelo.HeroeView;
import modelo.Juego;

public class MainMVC {

    public static void mostrarInformacionHeroe(HeroeView heroe) {
        System.out.println("\nMostrando la informacion del guerrero.");
        System.out.println("Nivel de ataque: " + heroe.nivelAtaque + "\nNivel de defensa: " + heroe.nivelDefensa
                + "\nPuntos de vida: " + heroe.puntosVida +
                "\nNombre de usuario: " + heroe.nombreUsuario);
    }

    public static void main(String[] args) {
        Juego juego = Juego.getInstancia();

        mostrarInformacionHeroe(Controlador.crearGuerrero("Guerrero", 100, 30, 50, "manuel123"));
    }
}
