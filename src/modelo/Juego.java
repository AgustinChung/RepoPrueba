package modelo;

import java.util.ArrayList;
import java.util.List;

//FACHADA. Quien va a recibir las cosas
public class Juego {
	//Declaracion de la instancia para el singleton
	private static Juego instancia;
	
	//Listas
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
		this.usuarioHeroe = guerrero;
		return guerrero;
	};
	
	public Mago crearMago(String nombre, int puntosVida, int nivelAtaque, int nivelDefensa, String nombreUsuario) {
		Mago mago = new Mago (nombre, puntosVida, nivelAtaque, nivelDefensa, nombreUsuario);
		this.usuarioHeroe = mago;
		return mago;
	};
	
	public Arquero crearArquero(String nombre, int puntosVida, int nivelAtaque, int nivelDefensa, String nombreUsuario, int punteria, int agilidad) {
		Arquero arquero = new Arquero (nombre, puntosVida, nivelAtaque, nivelDefensa, nombreUsuario, punteria, agilidad);
		this.usuarioHeroe = arquero;
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

	private void crearMontaniasHeladas(String nombre, Heroe heroe, Criatura criatura, boolean estaActivo, boolean tieneTesoro) {
		MontaniasHeladas montaniasHeladas = new MontaniasHeladas(nombre, this.usuarioHeroe, criatura, estaActivo, tieneTesoro);
		this.ubicaciones.add(montaniasHeladas);
	}

	private void crearUbicacionNeutral(String nombre, Heroe heroe, boolean estaActivo) {
		UbicacionNeutral ubicacionNeutral = new UbicacionNeutral(nombre, heroe, estaActivo);
		this.ubicaciones.add(ubicacionNeutral);
	}

	private void crearPantanoOscuro(String nombre, Heroe heroe, Criatura criatura, boolean estaActivo, boolean tieneTesoro) {
		PantanoOscuro pantanoOscuro = new PantanoOscuro("Pantano Oscuro", heroe, criatura, estaActivo, tieneTesoro);
		this.ubicaciones.add(pantanoOscuro);
	}

	public void crearMapa() {
		Dragon dragon = this.crearDragon("Dragon", 80, 1, 40, 20);
		Espectro espectro = this.crearEspectro("Espectro", 200, 2, 45, 150);
		this.crearMontaniasHeladas("Montanias Heladas", this.usuarioHeroe, dragon, true, false);
		this.crearUbicacionNeutral("Ubicacion Neutral", this.usuarioHeroe, true);
		this.crearPantanoOscuro("Pantano Oscuro", this.usuarioHeroe, espectro, false, false);
	}

	public List<Ubicacion> getUbicaciones() {
		return ubicaciones;
	}

	public Heroe getHeroe() {
		return this.usuarioHeroe;
	}

	public boolean generarPelea(String idUbicacion, String idCriatura) {
		Criatura criatura = this.buscarCriatura(idCriatura);
		PeleaV2 pelea = new PeleaV2(this.getHeroe(), criatura);
		boolean ganoElHeroe = pelea.iniciarPelea();
		if (ganoElHeroe) {
			Ubicacion ubicacion = buscarUbicacion(idUbicacion);
			if (ubicacion != null) {
				Recompensa recompensa = ubicacion.reclamarRecompensa();
				System.out.println("Se genero la recompensa");
				this.usuarioHeroe.guardarRecompensa(recompensa);
				System.out.println("Se guardo la recompensa");
			}
		}
		return ganoElHeroe;
	}

	private Criatura buscarCriatura(String id) {
		for (Criatura criatura : criaturas) {
			if (criatura.idCriatura == id) {
				return criatura;
			}
		}
		return null;
	}

	private Ubicacion buscarUbicacion(String id) {
		for (Ubicacion ubicacion : ubicaciones) {
			if (ubicacion.idUbicacion == id) {
				return ubicacion;
			}
		}
		return null;
	}

	public boolean esUbicacionNeutral(String idUbicacion) {
		Ubicacion ubicacion = buscarUbicacion(idUbicacion);
		return ubicacion != null && ubicacion.getNombre() == "Ubicacion Neutral";
	}

	public void curarHeroe(String idUbicacion) {
		if(esUbicacionNeutral(idUbicacion)) {
			int puntosVidaMaximo = this.usuarioHeroe.getPuntosVidaMaxima();
			this.usuarioHeroe.setPuntosVida(puntosVidaMaximo);
		}
	}
}
