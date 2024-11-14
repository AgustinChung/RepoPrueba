package main;

import controlador.Controlador;
import modelo.*;
import vista.PantallaEstadoPersonaje;
import vista.PantallaInicio2;

import java.util.List;

public class MainMVC {

    public static void mostrarInformacionHeroe(HeroeView heroe) {
        System.out.println("\nMostrando la informacion del guerrero.");
        System.out.println("Nivel de ataque: " + heroe.getNivelAtaque() + "\nNivel de defensa: " + heroe.getNivelDefensa()
                + "\nPuntos de vida: " + heroe.getPuntosVida() +
                "\nNombre de usuario: " + heroe.getNombreUsuario() + "\nLista de recompensas: ");
        for(RecompensaView recompensa : heroe.getRecompensas()) {
            System.out.print(recompensa.getNombre() + " - ");
        }
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
        /*
        PantallaInicio2 pantalla = new PantallaInicio2();
        pantalla.setVisible(true);
        PantallaEstadoPersonaje pantallaEstadoPersonaje = new PantallaEstadoPersonaje();
        pantallaEstadoPersonaje.setVisible(true);
        */
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
        UbicacionView montaniasHeladas = Controlador.viajar("Montanias Heladas");
        mostrarUbicacion(montaniasHeladas);
        CriaturaView criatura = Controlador.viajar("Montanias Heladas").getCriatura();
        mostrarInformacionCriatura(criatura);

        // *** PASO 4 ***
        // 1) El usuario decide atacar
        // 2) Comienza la pelea
        // 3) Se muestra quien gano y quien perdio

        HeroeView heroe = Controlador.pelear(montaniasHeladas, criatura);
        String resultado = (heroe.getPuntosVida() > 0)
                ? "GANO HEROE"
                : "PERDIO EL HEROE";
        System.out.println(resultado);
        mostrarInformacionHeroe(Controlador.getHeroe());

        // *** PASO 5 ***
        // 1) El heroe pide ver el mapa
        // 2) El heroe decide viajar a una ubicacion neutral
        // 3) El heroe recupera su vida
        // 4) El heroe reclama su recompensa ganada

        mostrarMapa((Controlador.mostrarMapa()));
        UbicacionView ubicacionNeutral = Controlador.viajar("Ubicacion Neutral");
        mostrarUbicacion(ubicacionNeutral);
        heroe = Controlador.curarHeroe(ubicacionNeutral);
        mostrarInformacionHeroe(heroe);
    }
}
