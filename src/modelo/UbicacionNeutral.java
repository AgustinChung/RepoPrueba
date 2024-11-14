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
	public void reclamarRecompensa(Heroe heroe) {
		List<Recompensa> recompensas = heroe.getRecompensas();
		for (Recompensa recompensa : recompensas) {
			if (recompensa.getPorcentajeAumentoAtaque() != 0) {
				double nuevoNivelAtaque = heroe.getNivelAtaque() + heroe.getNivelAtaque() * recompensa.getPorcentajeAumentoAtaque();
				heroe.setNivelAtaque((int) nuevoNivelAtaque);
			}
			if (recompensa.getPorcentajeAumentoDefensa() != 0) {
				int nuevoNivelDefensa = (int) (heroe.getNivelDeDefensaMaximo() + heroe.getNivelDeDefensaMaximo() * recompensa.getPorcentajeAumentoDefensa());
				heroe.setNivelDefensa(nuevoNivelDefensa);
				heroe.setnivelDefensaMaximo(nuevoNivelDefensa);
			}
		}
		heroe.borrarRecompensas();
	}

	public Criatura getCriatura() {
		return null;
	}

	public void activarSiguientesUbicaciones() {}
	public boolean juegoGanado() {
		return false;
	}

	public UbicacionView toView() {
		return new UbicacionView(this.getIdUbicacion(), this.getNombre(), this.getHeroe(), null, this.getEstaActivo());
	}
}
