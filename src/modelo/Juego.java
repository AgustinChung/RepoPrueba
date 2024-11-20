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
	
	
	// *** Metodos de creación *** //
	// Heroes
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

	// Criaturas
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

	// Ubicaciones
	private Ubicacion crearUbicacionNeutral(String nombre, Heroe heroe, boolean estaActivo) {
		UbicacionNeutral ubicacionNeutral = new UbicacionNeutral(nombre, heroe, estaActivo);
		this.ubicaciones.add(ubicacionNeutral);
		return (Ubicacion) ubicacionNeutral;
	}
	private Ubicacion crearMontaniasHeladas(String nombre, Heroe heroe, Criatura criatura, boolean estaActivo, boolean tieneTesoro, List<Ubicacion> nombresUbiDesbloquea) {
		MontaniasHeladas montaniasHeladas = new MontaniasHeladas(nombre, this.usuarioHeroe, criatura, estaActivo, tieneTesoro, nombresUbiDesbloquea);
		this.ubicaciones.add(montaniasHeladas);
		return (Ubicacion) montaniasHeladas;
	}
	private Ubicacion crearPantanoOscuro(String nombre, Heroe heroe, Criatura criatura, boolean estaActivo, boolean tieneTesoro, List<Ubicacion> nombresUbiDesbloquea) {
		PantanoOscuro pantanoOscuro = new PantanoOscuro(nombre, heroe, criatura, estaActivo, tieneTesoro, nombresUbiDesbloquea);
		this.ubicaciones.add(pantanoOscuro);
		return (Ubicacion) pantanoOscuro;
	}
	private Ubicacion crearAldea(String nombre, Heroe heroe, Criatura criatura, boolean estaActivo, boolean tieneTesoro) {
		Aldea aldea = new Aldea(nombre, heroe, criatura, estaActivo, tieneTesoro);
		this.ubicaciones.add(aldea);
		return (Ubicacion) aldea;
	}
	private Ubicacion crearBosque(String nombre, Heroe heroe, Criatura criatura, boolean estaActivo, boolean tieneTesoro, List<Ubicacion> nombresUbiDesbloquea) {
		Bosque bosque = new Bosque(nombre, heroe, criatura, estaActivo, tieneTesoro, nombresUbiDesbloquea);
		this.ubicaciones.add(bosque);
		return (Ubicacion) bosque;
	}
	private Ubicacion crearParamoBrumoso(String nombre, Heroe heroe, Criatura criatura, boolean estaActivo, List<Ubicacion> nombresUbiDesbloquea) {
		ParamoBrumoso paramoBrumoso = new ParamoBrumoso(nombre, heroe, criatura, estaActivo, nombresUbiDesbloquea);
		this.ubicaciones.add(paramoBrumoso);
		return (Ubicacion) paramoBrumoso;
	}
	private Ubicacion crearRuinasLyrath(String nombre, Heroe heroe, Criatura criatura, boolean estaActivo) {
		RuinasLyrath ruinasLyrath = new RuinasLyrath(nombre, heroe, criatura, estaActivo);
		this.ubicaciones.add(ruinasLyrath);
		return (Ubicacion) ruinasLyrath;
	}

	// Mapa hardcodeado
	public void crearMapa() {
		Dragon dragonMontanias = this.crearDragon("Dragon", 200, 5, 50, 75);
		Espectro espectroPantano = this.crearEspectro("Espectro", 400, 5, 250, 150);
		Dragon dragonAldea = this.crearDragon("Troll", 800, 1, 40, 300);
		Espectro espectroRuinas = this.crearEspectro("Espectro", 600, 2, 150, 400);
		Troll trollBosque = this.crearTroll("Troll", 100, 1, 40, 20);
		Troll trollParamo = this.crearTroll("Troll", 450, 2, 80, 100);
		List<Ubicacion> nombresUbiDesbloqueaMH = new ArrayList<>();
		List<Ubicacion> nombresUbiDesbloqueaPB = new ArrayList<>();
		List<Ubicacion> nombresUbiDesbloqueaPO = new ArrayList<>();
		List<Ubicacion> nombresUbiDesbloqueaB = new ArrayList<>();
		Ubicacion aldea = this.crearAldea("Aldea", this.usuarioHeroe, dragonAldea, false, true);
		Ubicacion ruinas = this.crearRuinasLyrath("Ruinas", this.usuarioHeroe, espectroRuinas, false);
		nombresUbiDesbloqueaPO.add(aldea);
		nombresUbiDesbloqueaPO.add(ruinas);
		nombresUbiDesbloqueaB.add(aldea);
		nombresUbiDesbloqueaB.add(ruinas);
		Ubicacion pantanoOscuro = this.crearPantanoOscuro("Pantano Oscuro", this.usuarioHeroe, espectroPantano, false, false, nombresUbiDesbloqueaPO);
		Ubicacion bosque = this.crearBosque("Bosque", this.usuarioHeroe, trollBosque, false, false, nombresUbiDesbloqueaB);
		nombresUbiDesbloqueaPB.add(pantanoOscuro);
		nombresUbiDesbloqueaPB.add(bosque);
		Ubicacion paramoBrumoso = this.crearParamoBrumoso("Paramo Brumoso", this.usuarioHeroe, trollParamo, false, nombresUbiDesbloqueaPB);
		nombresUbiDesbloqueaMH.add(paramoBrumoso);
		this.crearMontaniasHeladas("Montanias Heladas", this.usuarioHeroe, dragonMontanias, true, false, nombresUbiDesbloqueaMH);
		this.crearUbicacionNeutral("Ubicacion Neutral", this.usuarioHeroe, true);
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
				ubicacion.reclamarRecompensa(this.usuarioHeroe);
				ubicacion.activarSiguientesUbicaciones();
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

	public boolean esUbicacionNeutral(Ubicacion ubicacion) {
		return ubicacion != null && ubicacion.getNombre() == "Ubicacion Neutral";
	}

	public void curarHeroe(String idUbicacion) {
		Ubicacion ubicacion = buscarUbicacion(idUbicacion);
		if (esUbicacionNeutral(ubicacion) && ubicacion != null) {
			UbicacionNeutral ubicacionNeutral = (UbicacionNeutral) ubicacion;
			ubicacionNeutral.descansar(this.usuarioHeroe);
		}
	}

	public void reclamarRecompensas(String idUbicacion) {
		Ubicacion ubicacion = buscarUbicacion(idUbicacion);
		if (esUbicacionNeutral(ubicacion) && ubicacion != null) {
			UbicacionNeutral ubicacionNeutral = (UbicacionNeutral) ubicacion;
			ubicacionNeutral.reclamarRecompensa(this.usuarioHeroe);
		}
	}

	public void ubicacionGanada(String idUbicacion) {
		Ubicacion ubicacion = buscarUbicacion(idUbicacion);
		if (!esUbicacionNeutral(ubicacion) && ubicacion != null) {
			ubicacion.ubicacionGanada();
		}
	}

	public boolean juegoGanado(String idUbicacion) {
		Ubicacion ubicacion = buscarUbicacion(idUbicacion);
		boolean juegoGanado = false;
		if (!this.esUbicacionNeutral(ubicacion) && ubicacion != null) {
			juegoGanado = ubicacion.juegoGanado();
		}
		return juegoGanado;
	}
}
