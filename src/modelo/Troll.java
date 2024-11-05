package modelo;

public class Troll extends Criatura{

	public Troll(String nombre,int puntosVida, int nivel, int nivelAtaque, int nivelDefensa) {
		super(nombre,puntosVida, nivel, nivelAtaque, nivelDefensa);
	}

	
	
	public int aplicarHabilidadesEspeciales(Heroe enemigo) {
	    if (enemigo.getNombre() == "Mago") {
	        nivelDefensa += nivelDefensa * 0.15;
	    }
	    return nivelDefensa;
	}
	
}
