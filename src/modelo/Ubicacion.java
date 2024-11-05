package modelo;

public abstract class Ubicacion {
	//ATRIBUTOS
	private String nombre;
	protected Heroe heroe;

	protected Ubicacion(String nombre, Heroe heroe) {
		this.nombre = nombre;
		this.heroe = heroe;
	}

	public abstract void reclamarRecompensa();
}
