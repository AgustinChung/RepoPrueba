package modelo;

import java.util.ArrayList;
import java.util.List;

//FACHADA. Quien va a recibir las cosas
public class Juego {
	//Declaracion de la instancia para el singleton
	private static Juego instancia;
	
	//Listas 
	private Guerrero usuarioGuerrero;
	private Mago usuarioMago;
	private Arquero usuarioArquero;
	private Heroe usuarioHeroe;
	private List<Criatura> criaturas;
	private List<Ubicacion> ubicaciones;
	
	//Constructor
	private Juego() {
		criaturas = new ArrayList<>();
		ubicaciones = new ArrayList<>();
	}

	//Singleton
	public static Juego getInstancia() {
		if (instancia == null) {
			instancia = new Juego();
		}
		return instancia;
	}
	
	
	//METODOS DE CREACION. Crea y agrega a la lista. Agregar excepciones
	public Guerrero crearGuerrero(String nombre ,int puntosVida, int nivelAtaque, int nivelDefensa, String nombreUsuario) {
		Guerrero guerrero = new Guerrero(nombre, puntosVida, nivelAtaque, nivelDefensa, nombreUsuario);
		this.usuarioGuerrero = guerrero;
		this.usuarioHeroe = guerrero;
		return guerrero;
	};
	
	public Mago crearMago(String nombre, int puntosVida, int nivelAtaque, int nivelDefensa, String nombreUsuario) {
		Mago mago = new Mago (nombre, puntosVida, nivelAtaque, nivelDefensa, nombreUsuario);
		this.usuarioMago = mago;
		return mago;
	};
	
	public Arquero crearArquero(String nombre, int puntosVida, int nivelAtaque, int nivelDefensa, String nombreUsuario, int punteria, int agilidad) {
		Arquero arquero = new Arquero (nombre, puntosVida, nivelAtaque, nivelDefensa, nombreUsuario, punteria, agilidad);
		this.usuarioArquero = arquero;
		return arquero;
	};
	
	public Dragon crearDragon(String nombre, int puntosVida, int nivel, int nivelAtaque, int nivelDefensa) {
		Dragon dragon = new Dragon (nombre, puntosVida, nivel, nivelAtaque, nivelDefensa);
		this.criaturas.add(dragon);
		return dragon;
	};
	
	public Troll crearTroll(String nombre, int puntosVida, int nivel, int nivelAtaque, int nivelDefensa) {
		Troll troll = new Troll (nombre, puntosVida, nivel, nivelAtaque, nivelDefensa);
		this.criaturas.add(troll);
		return troll;
	};
	
	public Espectro crearEspectro(String nombre, int puntosVida, int nivel, int nivelAtaque, int nivelDefensa) {
		Espectro espectro = new Espectro (nombre, puntosVida, nivel, nivelAtaque, nivelDefensa);
		this.criaturas.add(espectro);
		return espectro;
	};

	public void crearMontaniasHeladas(String nombre, Heroe heroe, Criatura criatura, boolean estaActivo, boolean tieneTesoro) {
		MontaniasHeladas montaniasHeladas = new MontaniasHeladas(nombre, this.usuarioHeroe, criatura, estaActivo, tieneTesoro);
		this.ubicaciones.add(montaniasHeladas);
	}

	public void crearMapa() {
		Dragon dragon = this.crearDragon("Dragon", 80, 1, 40, 20);
		this.crearMontaniasHeladas("Montanias Heladas", this.usuarioHeroe, dragon, true, false);
		// tenemos que agregar todas las ubicaciones aca
	}

	public List<Ubicacion> getUbicaciones() {
		return ubicaciones;
	}

	public Heroe getHeroe() { return this.usuarioHeroe; }
	
	public boolean generarPelea(String idCriatura) {
		Criatura criatura = this.buscarCriatura(idCriatura);
		PeleaV2 pelea = new PeleaV2(this.usuarioHeroe, criatura);
		return pelea.iniciarPelea();
	}

	private Criatura buscarCriatura(String id) {
		for (Criatura criatura : criaturas) {
			if (criatura.idCriatura == id) {
				return criatura;
			}
		}
		return null;
	}
}
