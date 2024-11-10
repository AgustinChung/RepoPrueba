package controlador;

import modelo.Criatura;
import modelo.HeroeView;
import modelo.Juego;
import modelo.Ubicacion;

import java.util.List;
import java.util.Objects;


//el controlador va a tener metodos estaticos (o pueden ser singleton) que se comunica con la fachada para pedirle cosas y crear cosas.
//adentro tiene metodos para la creacion 
public class Controlador {

	
	public static void crearGuerrero(String nombre, int puntosVida, int nivelAtaque, int nivelDefensa, String nombreUsuario) {
		Juego.getInstancia().crearGuerrero(nombre, puntosVida, nivelAtaque, nivelDefensa, nombreUsuario );
	}
	public static void crearMago(String nombre, int puntosVida, int nivelAtaque, int nivelDefensa, String nombreUsuario) {
		Juego.getInstancia().crearMago(nombre, puntosVida,nivelAtaque,nivelDefensa, nombreUsuario);
	}
	public static void crearArquero(String nombre, int puntosVida, int nivelAtaque, int nivelDefensa, String nombreUsuario, int punteria, int agilidad) {
		Juego.getInstancia().crearArquero(nombre, puntosVida, nivelAtaque, nivelDefensa, nombreUsuario, punteria, agilidad);
	}
	public static void crearDragon(String nombre, int puntosVida, int nivel, int nivelAtaque, int nivelDefensa) {
		Juego.getInstancia().crearDragon(nombre, puntosVida, nivel, nivelAtaque, nivelDefensa );
	}
	public static void crearTroll(String nombre, int puntosVida, int nivel, int nivelAtaque, int nivelDefensa) {
		Juego.getInstancia().crearTroll(nombre, puntosVida, nivel, nivelAtaque, nivelDefensa );
	}
	public static void crearEspectro(String nombre, int puntosVida, int nivel, int nivelAtaque, int nivelDefensa) {
		Juego.getInstancia().crearEspectro(nombre, puntosVida, nivel, nivelAtaque, nivelDefensa);
	}

	public static HeroeView getHeroe() {
		return Juego.getInstancia().HeroeToView();
	}

	public static List<Ubicacion> mostrarMapa() {
		return Juego.getInstancia().getUbicaciones();
	}

	// el usuario apreta el boton de la ubicacion a donde quiere viajar. El view, llama a controlador.viajar(nombreUbicacion), el controlador devuelve
	// la ubicacion a la que el usuario quiso acceder.
	public static Ubicacion viajar(String nombreUbicacion) {
		// esto tiene que estar hecho con object View ubicacion view
		List<Ubicacion> ubicaciones = Juego.getInstancia().getUbicaciones();
		for (Ubicacion ubicacion : ubicaciones) {
			if (ubicacion.getNombre() == nombreUbicacion && ubicacion.getEstaActivo()) {
				return ubicacion; // ubicacion.toView() -> dentro debe tener el nombre de la ubicacion y una criatura view.
			}
		}
		return null;
	}

	public static boolean ganoHeroe(Criatura criatura) { // preguntarle al profe si esta bien arrancar la secuencia con este metodo
		return Juego.getInstancia().generarPelea(criatura);
	}

}
