package controlador;

import modelo.Guerrero;
import modelo.HeroeView;
import modelo.Juego;


//el controlador va a tener metodos estaticos (o pueden ser singleton) que se comunica con la fachada para pedirle cosas y crear cosas.
//adentro tiene metodos para la creacion 
public class Controlador {

	
	public static HeroeView crearGuerrero(String nombre, int puntosVida, int nivelAtaque, int nivelDefensa, String nombreUsuario) {
		Guerrero guerrero = Juego.getInstancia().crearGuerrero(nombre, puntosVida, nivelAtaque, nivelDefensa, nombreUsuario );
		return guerrero.toView();
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


}
