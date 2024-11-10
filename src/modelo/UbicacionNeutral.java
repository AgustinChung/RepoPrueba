package modelo;

import java.util.List;

public class UbicacionNeutral extends Ubicacion{

	public UbicacionNeutral(String nombre, Heroe heroe) {
		super(nombre, heroe);
	}

	//setea al maximo los puntos de vida del heroe
	public void descansar(Heroe heroe) {
		heroe.setPuntosVida(heroe.getPuntosVidaMaxima());
		heroe.setNivelDefensa(heroe.getNivelDeDefensaMaximo());
	}
	

	//agarra los datos de la recompensa y setea nuevos valores en el ataque y defensa del heroe.
	//VER SI RECIBE UNA SOLA RECOMPENSA O UNA LISTA DE RECOMPENSAS.
	@Override
	public void reclamarRecompensa() {
		List<Recompensa> recompensas = this.heroe.getRecompensas();
		for (Recompensa recompensa : recompensas) {
			if (recompensa.getPorcentajeAumentoAtaque() != 0) {
				double nuevoNivelAtaque = this.heroe.getNivelAtaque() + this.heroe.getNivelAtaque() * recompensa.getPorcentajeAumentoAtaque();
				this.heroe.setNivelAtaque((int) nuevoNivelAtaque);
			}
			if (recompensa.getPorcentajeAumentoDefensa() != 0) {
				double nuevoNivelDefensa = this.heroe.getNivelDeDefensaMaximo() + this.heroe.getNivelDeDefensaMaximo() * recompensa.getPorcentajeAumentoDefensa();
				this.heroe.setNivelDefensa((int) nuevoNivelDefensa);
			}
		}

	}
}
