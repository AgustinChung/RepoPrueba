package modelo;

public class Arquero extends Heroe{

	private int agilidad;
	private int punteria;
	
	public Arquero(String nombre, int puntosVida, int nivelAtaque, int nivelDefensa, int punteria, int agilidad) {
		super(nombre, puntosVida, nivelAtaque, nivelDefensa);
		this.punteria = punteria;
	    this.agilidad = agilidad;
	}

	
	//cuando luha contra dragones su punteria es 100%
	public int aplicarHabilidadesEspeciales(Criatura enemigo) {
		if (enemigo.getNombre() == "Dragon") {  //en vez de nombre "dragon" puede ser un id
			punteria = 100;
		}
		
		return punteria;
	}


	public int getAgilidad() {
		return agilidad;
	}

	public int getPunteria() {
		return punteria;
	}

	
}
