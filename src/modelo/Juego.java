package modelo;

import java.util.ArrayList;
import java.util.List;

//FACHADA. Quien va a recibir las cosas
public class Juego {
	//Declaracion de la instancia para el singleton
	// private static Juego instancia;
	
	//Listas 
	private List<Guerrero> guerreros;
	private List<Mago> magos;
	private List<Arquero> arqueros;
	private List<Dragon> dragones;
	private List<Troll> trolls;
	private List<Espectro> espectros;
	private List<Ubicacion> ubicaciones;
	
	//Constructor
	public Juego() {
		guerreros = new ArrayList<>();
		magos = new ArrayList<>();
		arqueros = new ArrayList<>();
		dragones = new ArrayList<>();
		trolls = new ArrayList<>();
		espectros = new ArrayList<>();
		ubicaciones = new ArrayList<>();
	}

	//Singleton
	//public static Juego getInstancia() {
	//	if (instancia == null) {
	//		instancia = new Juego();
	//	}
	//	return instancia;
	//}
	
	
	//METODOS DE CREACION. Crea y agrega a la lista. Agregar excepciones
	public void crearGuerrero(String nombre ,int puntosVida, int nivelAtaque, int nivelDefensa) {
		Guerrero guerrero = new Guerrero(nombre, puntosVida, nivelAtaque, nivelDefensa);
		this.guerreros.add(guerrero);
	};
	
	public void crearMago(String nombre, int puntosVida, int nivelAtaque, int nivelDefensa) {
		Mago mago = new Mago (nombre, puntosVida, nivelAtaque, nivelDefensa);
		this.magos.add(mago);
	};
	
	public void crearArquero(String nombre, int puntosVida, int nivelAtaque, int nivelDefensa, int punteria, int agilidad) {
		Arquero arquero = new Arquero (nombre, puntosVida, nivelAtaque, nivelDefensa, punteria, agilidad);
		this.arqueros.add(arquero);
	};
	
	public void crearDragon(String nombre, int puntosVida, int nivel, int nivelAtaque, int nivelDefensa) {
		Dragon dragon = new Dragon (nombre, puntosVida, nivel, nivelAtaque, nivelDefensa);
		this.dragones.add(dragon);
	};
	
	public void crearTroll(String nombre, int puntosVida, int nivel, int nivelAtaque, int nivelDefensa) {
		Troll troll = new Troll (nombre, puntosVida, nivel, nivelAtaque, nivelDefensa);
		this.trolls.add(troll);
	};
	
	public void crearEspectro(String nombre, int puntosVida, int nivel, int nivelAtaque, int nivelDefensa) {
		Espectro espectro = new Espectro (nombre, puntosVida, nivel, nivelAtaque, nivelDefensa);
		this.espectros.add(espectro);
	};
	
	public void crearUbicacion() {};
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
