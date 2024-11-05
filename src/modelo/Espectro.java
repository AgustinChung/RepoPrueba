package modelo;

public class Espectro extends Criatura{

	public Espectro(String nombre, int puntosVida, int nivel, int nivelAtaque, int nivelDefensa) {
		super(nombre, puntosVida, nivel, nivelAtaque, nivelDefensa);
	}

	
	public int aplicarHabilidadesEspeciales(Heroe enemigo) {
	    if (enemigo.getNombre() == "Aquero") {
	    	nivelAtaque += nivelAtaque * 0.20;
	    }
	    return nivelAtaque;
	}
}
