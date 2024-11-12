package modelo;

import java.util.List;

public class UbicacionNeutral extends Ubicacion{

	public UbicacionNeutral(String nombre, Heroe heroe, boolean estaActivo) {
		super(nombre, heroe, estaActivo);
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
		List<Recompensa> recompensas = this.getHeroe().getRecompensas();
		for (Recompensa recompensa : recompensas) {
			if (recompensa.getPorcentajeAumentoAtaque() != 0) {
				double nuevoNivelAtaque = this.getHeroe().getNivelAtaque() + this.getHeroe().getNivelAtaque() * recompensa.getPorcentajeAumentoAtaque();
				this.getHeroe().setNivelAtaque((int) nuevoNivelAtaque);
			}
			if (recompensa.getPorcentajeAumentoDefensa() != 0) {
				double nuevoNivelDefensa = this.getHeroe().getNivelDeDefensaMaximo() + this.getHeroe().getNivelDeDefensaMaximo() * recompensa.getPorcentajeAumentoDefensa();
				this.getHeroe().setNivelDefensa((int) nuevoNivelDefensa);
			}
		}
	}

	public Criatura getCriatura() {
		return null;
	}

	public UbicacionView toView() {
		return new UbicacionView(this.getNombre(), this.getHeroe(), null);
	}
}
