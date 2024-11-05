package modelo;

public class Guerrero extends Heroe {
	
	int contadorGolpes;
	
    public Guerrero(String nombre, int puntosVida, int nivelAtaque, int nivelDefensa) {
		super(nombre, puntosVida, nivelAtaque, nivelDefensa);
		this.contadorGolpes = 0;
	}

    public void incrementarContadorGolpes() {
    	this.contadorGolpes++;
    }
    
    @Override
    public int aplicarHabilidadesEspeciales(Criatura criatura) {
        // El Guerrero duplica su ataque a partir del tercer golpe
        incrementarContadorGolpes();
        if (contadorGolpes >= 3) {
            this.nivelAtaque *= 2; // Duplica el ataque
        }
        return this.nivelAtaque;
    }
}

