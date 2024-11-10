package main;

import controlador.Controlador;
import modelo.*;

import java.util.List;

public class MainMVC {

    public static void mostrarInformacionHeroe(HeroeView heroe) {
        System.out.println("\nMostrando la informacion del guerrero.");
        System.out.println("Nivel de ataque: " + heroe.getNivelAtaque() + "\nNivel de defensa: " + heroe.getNivelDefensa()
                + "\nPuntos de vida: " + heroe.getPuntosVida() +
                "\nNombre de usuario: " + heroe.getNombreUsuario() + "\n");
    }

    public static void mostrarMapa(List<Ubicacion> ubicaciones) {
        for (Ubicacion ubicacion : ubicaciones) {
            System.out.println(ubicacion.getNombre());
        }
    }

    public static void mostrarUbicacion(Ubicacion ubicacion) {
        System.out.println("Nombre ubicacion: " + ubicacion.getNombre() +
                "\nCriatura: " + ubicacion.getCriatura().getNombre());
    }

    public static void main(String[] args) {
        Juego.getInstancia().crearMapa();
        Controlador.crearGuerrero("Guerrero", 100, 50, 30, "manuel123");
        mostrarInformacionHeroe(Controlador.getHeroe());
        mostrarMapa((Controlador.mostrarMapa()));
        mostrarUbicacion(Controlador.viajar("Montanias Heladas"));
        System.out.println(Controlador.ganoHeroe(Controlador.viajar("Montanias Heladas").getCriatura()));
        mostrarInformacionHeroe(Controlador.getHeroe());
    }
}
