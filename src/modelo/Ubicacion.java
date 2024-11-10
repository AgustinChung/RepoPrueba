package modelo;

public abstract class Ubicacion {
	//ATRIBUTOS
	private String nombre;
	protected Heroe heroe;
	protected boolean estaActivo;

	protected Ubicacion(String nombre, Heroe heroe, boolean estaActivo) {
		this.setNombre(nombre);
		this.heroe = heroe;
		this.estaActivo = estaActivo;
	}

	public abstract void reclamarRecompensa();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean getEstaActivo() { return this.estaActivo; }

	public abstract Criatura getCriatura();
}
