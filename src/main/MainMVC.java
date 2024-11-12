package main;

import controlador.Controlador;
import modelo.*;
import vista.PantallaInicio;

import java.util.List;

public class MainMVC {

    public static void mostrarInformacionHeroe(HeroeView heroe) {
        System.out.println("\nMostrando la informacion del guerrero.");
        System.out.println("Nivel de ataque: " + heroe.getNivelAtaque() + "\nNivel de defensa: " + heroe.getNivelDefensa()
                + "\nPuntos de vida: " + heroe.getPuntosVida() +
                "\nNombre de usuario: " + heroe.getNombreUsuario() + "\n");
    }

    public static void mostrarMapa(List<UbicacionView> ubicaciones) {
        System.out.println("Ubicaciones:");
        for (UbicacionView ubicacion : ubicaciones) {
            System.out.println(ubicacion.getNombre());
        }
    }

    public static void mostrarUbicacion(UbicacionView ubicacion) {
        System.out.println("Nombre ubicacion: " + ubicacion.getNombre() + "\n");
    }

    public static void mostrarInformacionCriatura(CriaturaView criatura) {
        System.out.println("Nombre critura: " + criatura.getNombre() +
                "\nPuntos de vida: " + criatura.getPuntosVida() +
                "\nNivel: " + criatura.getNivel() +
                "\nNivel de ataque: " + criatura.getNivelAtaque() +
                "\nNivel de defensa: " + criatura.getNivelDefensa()+ "\n");
    }

    // *** MAIN ***
    public static void main(String[] args) {
        // *** PASO 1 ***
        // 1) Seteamos el mapa e instanciamos el Juego

        Juego.getInstancia().crearMapa();

        // *** PASO 2 ***
        // 1) El usuario ingresa el nombre de usuario
        // 2) El usuario selecciona el personaje que quiere usar

        Controlador.crearGuerrero("Guerrero", 100, 50, 30, "manuel123");
        mostrarInformacionHeroe(Controlador.getHeroe());

        // *** PASO 3 ***
        // 1) El usuario preciona el botón mostrar mapa
        // 2) El usuario selecciona una ubicación disponible
        // 3) El usuario ve la informacion de la critatura y decide si atacar o no

        mostrarMapa((Controlador.mostrarMapa()));
        mostrarUbicacion(Controlador.viajar("Montanias Heladas"));
        CriaturaView criatura = Controlador.viajar("Montanias Heladas").getCriatura();
        mostrarInformacionCriatura(criatura);

        // *** PASO 4 ***
        // 1) El usuario decide atacar
        // 2) Comienza la pelea
        // 3) Se muestra quien gano y quien perdio

        if (!Controlador.ganoHeroe(criatura)) {
            System.out.println("EL HEROE PERDIO");
        } else {
            System.out.println("EL HEROE GANO");
            mostrarInformacionCriatura(criatura);
            mostrarInformacionHeroe(Controlador.getHeroe());
        }
    }
}
