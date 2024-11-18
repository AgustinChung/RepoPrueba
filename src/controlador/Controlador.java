package controlador;

import modelo.*;
import vista.PantallaEstadoPersonaje;
import vista.PantallaVictoria;

import java.util.ArrayList;
import java.util.List;


//el controlador va a tener metodos estaticos (o pueden ser singleton) que se comunica con la fachada para pedirle cosas y crear cosas.
//adentro tiene metodos para la creacion 
public class Controlador {


	public static void crearGuerrero(String nombre, int puntosVida, int nivelAtaque, int nivelDefensa, String nombreUsuario) {
		Juego.getInstancia().crearGuerrero(nombre, puntosVida, nivelAtaque, nivelDefensa, nombreUsuario);
		Controlador.MostrarPantalla2();
	}

	public static void crearMago(String nombre, int puntosVida, int nivelAtaque, int nivelDefensa, String nombreUsuario) {
		Juego.getInstancia().crearMago(nombre, puntosVida, nivelAtaque, nivelDefensa, nombreUsuario);
		Controlador.MostrarPantalla2();
	}

	public static void crearArquero(String nombre, int puntosVida, int nivelAtaque, int nivelDefensa, String nombreUsuario, int punteria, int agilidad) {
		Juego.getInstancia().crearArquero(nombre, puntosVida, nivelAtaque, nivelDefensa, nombreUsuario, punteria, agilidad);
		Controlador.MostrarPantalla2();
	}

	public static void crearDragon(String nombre, int puntosVida, int nivel, int nivelAtaque, int nivelDefensa) {
		Juego.getInstancia().crearDragon(nombre, puntosVida, nivel, nivelAtaque, nivelDefensa);
	}

	public static void crearTroll(String nombre, int puntosVida, int nivel, int nivelAtaque, int nivelDefensa) {
		Juego.getInstancia().crearTroll(nombre, puntosVida, nivel, nivelAtaque, nivelDefensa);
	}

	public static void crearEspectro(String nombre, int puntosVida, int nivel, int nivelAtaque, int nivelDefensa) {
		Juego.getInstancia().crearEspectro(nombre, puntosVida, nivel, nivelAtaque, nivelDefensa);
	}

	public static HeroeView getHeroe() {
		return Juego.getInstancia().getHeroe().toView();
	}

	public static List<UbicacionView> mostrarMapa() {
		List<UbicacionView> ubicacionesView = new ArrayList<UbicacionView>();
		List<Ubicacion> ubicaciones = Juego.getInstancia().getUbicaciones();
		for (Ubicacion ubicacion : ubicaciones) {
			ubicacionesView.add(ubicacion.toView());
		}
		return ubicacionesView;
	}

	// el usuario apreta el boton de la ubicacion a donde quiere viajar. El view, llama a controlador.viajar(nombreUbicacion), el controlador devuelve
	// la ubicacion a la que el usuario quiso acceder.
	public static UbicacionView viajar(String nombreUbicacion) {
		// esto tiene que estar hecho con object View ubicacion view
		List<Ubicacion> ubicaciones = Juego.getInstancia().getUbicaciones();
		for (Ubicacion ubicacion : ubicaciones) {
			if (ubicacion.nombre() == nombreUbicacion && ubicacion.getEstaActivo()) {
				return ubicacion.toView();
			}
		}
		return null;
	}

	public static HeroeView pelear(UbicacionView ubicacion, CriaturaView criatura) {
		Juego.getInstancia().generarPelea(ubicacion.getIdUbicacion(), criatura.getIdCriatura());
		HeroeView heroe = Juego.getInstancia().getHeroe().toView();
		return heroe;
	}

	public static HeroeView curarHeroe(UbicacionView ubicacion) {
		Juego.getInstancia().curarHeroe(ubicacion.getIdUbicacion());
		return Juego.getInstancia().getHeroe().toView();
	}

	public static HeroeView reclamarRecompensaHeroe(UbicacionView ubicacion) {
		Juego.getInstancia().reclamarRecompensas(ubicacion.getIdUbicacion());
		return Juego.getInstancia().getHeroe().toView();
	}

	public static void MostrarPantalla2() {
		HeroeView heroe = Controlador.getHeroe();
		PantallaEstadoPersonaje pantallaEstadoPersonaje = new PantallaEstadoPersonaje(heroe);
		pantallaEstadoPersonaje.setVisible(true);
	}

	public static void ubicacionGanada(UbicacionView ubicacion) {
		Juego.getInstancia().ubicacionGanada(ubicacion.getIdUbicacion());
	}

	public static boolean juegoGanado(UbicacionView ubicacion) {
		return Juego.getInstancia().juegoGanado(ubicacion.getIdUbicacion());
	}
}