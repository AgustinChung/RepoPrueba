package main;

import modelo.*;

public class Main {

	public static void mostrarInformacionHeroe(Guerrero guerrero) {
		System.out.println("\nMostrando la informacion del guerrero.");
		System.out.println("Nivel de ataque: " + guerrero.getNivelAtaque() + "\nNivel de defensa: " + guerrero.getNivelDefensa()
				+ "\nPuntos de vida: " + guerrero.getPuntosVida() + "\nExperiencia: " + guerrero.getExperiencia());
	}

	public static void mostrarInformacionCriatura(Dragon dragon) {
		System.out.println("\nMostrando la informacion de la criatura: ");
		System.out.println("Nivel de ataque: " + dragon.getNivelAtaque() + "\nNivel de defensa: " + dragon.getNivelDefensa()
				+ "\nPuntos de vida: " + dragon.getPuntosVida());
	}

	public static void main(String[] args) {
		/* Juego juego = new Juego();
		System.out.println("Inicia el juego\n");

		Guerrero guerrero = juego.crearGuerrero("Guerrero", 100, 50, 30, "manuel123");
		System.out.println("El jugador elegiio jugar con un Guerrero.");
		mostrarInformacionHeroe(guerrero);

		System.out.println("Ver mapa: ");
		System.out.println("El jugador por cercania solo puede ir a Montanias Heladas.");

		Dragon dragon = new Dragon("Dragon", 130, 1, 30, 30);
		System.out.println("Creamos al Dragon la criatura para montania helada.");
		MontaniasHeladas montaniaHelada = new MontaniasHeladas("Montania Helada", guerrero, dragon, false);
		System.out.println("Creamos a la montania helada.");
		mostrarInformacionCriatura(dragon);

		System.out.println("Vamos a presionar boton atacar.");
		montaniaHelada.inicializarPelea();
		
		if (montaniaHelada.ganoElHeroe()) {
			System.out.println("El guerrero le gano al dragon.");
			montaniaHelada.reclamarRecompensa();
			System.out.println("El guerrero guarda el item de recompensa.");
			if (guerrero.getRecompensas().size() > 0) {
				System.out.println("Se agrego la recompensa a la lista.");
			}
		} else {
			System.out.println("El guerrero perdio contra el dragon.\nJuego terminado.");
			// aca tendriamos que hacer algo para que se termine la ejecucion del juego.
		}
		mostrarInformacionHeroe(guerrero);
		mostrarInformacionCriatura(dragon);

		UbicacionNeutral ubicacionNeutral = new UbicacionNeutral("Ubicacion neutral", guerrero);
		System.out.println("Se creo la ubicacion neutral");
		System.out.println("Ahora el heroe se dirige a la ubicación de descanso.");
		ubicacionNeutral.descansar(guerrero);
		System.out.println("El heroe descanso");
		mostrarInformacionHeroe(guerrero);
		ubicacionNeutral.reclamarRecompensa();
		System.out.println("El heroe reclamo su recompensa.");
		ubicacionNeutral.descansar(guerrero);
		System.out.println("El hereoe descanso para resetear su nivel de defensa.");
		mostrarInformacionHeroe(guerrero);

		 */
	}

}
