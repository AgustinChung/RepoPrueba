package modelo;

public class Dragon extends Criatura{

	public Dragon(String nombre,int puntosVida, int nivel, int nivelAtaque, int nivelDefensa) {
		super(nombre,puntosVida, nivel, nivelAtaque, nivelDefensa);
	}

	
	public int aplicarHabilidadesEspeciales(Heroe enemigo) {
	    if (enemigo.getNombre() == "Guerrero") {
	        nivelAtaque += nivelAtaque * 0.3;
	    }
	    return nivelAtaque;
	}

}
