package modelo;

public class Arquero extends Heroe{

	private int agilidad;
	private int punteria;
	private int punteriaMaxima;
	
	public Arquero(String nombre, int puntosVida, int nivelAtaque, int nivelDefensa, String nombreUsuario, int punteria, int agilidad) {
		super(nombre, puntosVida, nivelAtaque, nivelDefensa, nombreUsuario);
		this.punteria = punteria;
	    this.agilidad = agilidad;
		this.punteriaMaxima = punteria;
	}

	public int aplicarHabilidadesEspeciales(Criatura enemigo) {
		if (enemigo.getNombre() == "Dragon") {
			this.punteria = 100;
		}
		return punteria;
	}

	public void resetPunteria() {
		this.punteria = this.punteriaMaxima;
	}

	public int getAgilidad() {
		return agilidad;
	}

	public int getPunteria() {
		return punteria;
	}

	
}
