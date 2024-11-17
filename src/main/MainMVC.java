package main;

import controlador.Controlador;
import modelo.*;
import vista.PantallaInicio;
import vista.PantallaPelea;
import vista.PantallaUbicaciones;

import java.util.List;

public class MainMVC {

    public static void mostrarInformacionHeroe(HeroeView heroe) {
        System.out.println("\nMostrando la informacion del guerrero.");
        System.out.println("Nivel de ataque: " + heroe.getNivelAtaque() + "\nNivel de defensa: " + heroe.getNivelDefensa()
                + "\nPuntos de vida: " + heroe.getPuntosVida() +
                "\nNombre de usuario: " + heroe.getNombreUsuario() + "\nLista de recompensas: ");
        for(RecompensaView recompensa : heroe.getRecompensas()) {
            System.out.println(recompensa.getNombre() + " - ");
        }
    }

    public static void mostrarMapa(List<UbicacionView> ubicaciones) {
        System.out.println("\nUbicaciones:");
        for (UbicacionView ubicacion : ubicaciones) {
            if(ubicacion.getEstaActivo()) {
                System.out.println(ubicacion.getNombre() + " esta ACTIVA.");
            } else {
                System.out.println(ubicacion.getNombre() + " no esta activa.");
            }
        }
    }

    public static void mostrarUbicacion(UbicacionView ubicacion) {
        System.out.println("\nNombre ubicacion seleccionada: " + ubicacion.getNombre() + "\n");
    }

    public static void mostrarInformacionCriatura(CriaturaView criatura) {
        System.out.println("\nCritura en la ubicacion seleccionada: " + criatura.getNombre() +
                "\nPuntos de vida: " + criatura.getPuntosVida() +
                "\nNivel: " + criatura.getNivel() +
                "\nNivel de ataque: " + criatura.getNivelAtaque() +
                "\nNivel de defensa: " + criatura.getNivelDefensa()+ "\n");
    }

    // * MAIN *
    public static void main(String[] args) {

        PantallaInicio pantalla = new PantallaInicio();
        pantalla.setVisible(true);



    	//PantallaPelea pantalla = new PantallaPelea();
        //pantalla.setVisible(true);


        // * PASO 1 *
        // 1) Seteamos el mapa e instanciamos el Juego

        Juego.getInstancia().crearMapa();

        // * PASO 2 *
        // 1) El usuario ingresa el nombre de usuario
        // 2) El usuario selecciona el personaje que quiere usar


        // * PASO 3 *
        // 1) El usuario preciona el botón mostrar mapa
        // 2) El usuario selecciona una ubicación disponible
        // 3) El usuario ve la informacion de la critatura y decide si atacar o no

        mostrarMapa((Controlador.mostrarMapa()));
        UbicacionView ubicacion = Controlador.viajar("Montanias Heladas");
        mostrarUbicacion(ubicacion);
        CriaturaView criatura = Controlador.viajar("Montanias Heladas").getCriatura();
        mostrarInformacionCriatura(criatura);

        // * PASO 4 *
        // 1) El usuario decide atacar
        // 2) Comienza la pelea
        // 3) Se muestra quien gano y quien perdio

        HeroeView heroe1 = Controlador.pelear(ubicacion, criatura);
        String resultado = (heroe1.getPuntosVida() > 0)
                ? "GANO HEROE"
                : "PERDIO EL HEROE";
        System.out.println(resultado);
        mostrarInformacionHeroe(Controlador.getHeroe());

        // * PASO 5 *
        // 1) El heroe pide ver el mapa
        // 2) El heroe decide viajar a una ubicacion neutral
        // 3) El heroe recupera su vida
        // 4) El heroe reclama su recompensa ganada

        mostrarMapa((Controlador.mostrarMapa()));
        ubicacion = Controlador.viajar("Ubicacion Neutral");
        mostrarUbicacion(ubicacion);
        Controlador.curarHeroe(ubicacion);
        System.out.println("El heroe se esta curando.");
        System.out.println("El heroe reclamo su recompensa.");
        heroe1 = Controlador.reclamarRecompensaHeroe(ubicacion);
        mostrarInformacionHeroe(heroe1);

        // * PASO 6 *
        // 1) El heroe viaja a la siguiente ubicacion disponible
        // 2) El heroe selecciona atacar
        ubicacion = Controlador.viajar("Paramo Brumoso");
        mostrarUbicacion(ubicacion);
        criatura = Controlador.viajar("Paramo Brumoso").getCriatura();
        mostrarInformacionCriatura(criatura);

        heroe1 = Controlador.pelear(ubicacion, criatura);
        resultado = (heroe1.getPuntosVida() > 0)
                ? "GANO HEROE"
                : "PERDIO EL HEROE";
        System.out.println(resultado);
        mostrarInformacionHeroe(Controlador.getHeroe());
        mostrarMapa((Controlador.mostrarMapa()));
    }
}