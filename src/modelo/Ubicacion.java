package modelo;

public abstract class Ubicacion {
	//ATRIBUTOS
	private String nombre;
	protected Heroe heroe;

	protected Ubicacion(String nombre, Heroe heroe) {
		this.setNombre(nombre);
		this.heroe = heroe;
	}

	public abstract void reclamarRecompensa();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
