package modelo;

public abstract class Ubicacion {
	//ATRIBUTOS
	private String nombre;
	private Heroe heroe;
	private boolean estaActivo;

	protected Ubicacion(String nombre, Heroe heroe, boolean estaActivo) {
		this.setNombre(nombre);
		this.heroe = heroe;
		this.estaActivo = estaActivo;
	}

	public abstract void reclamarRecompensa();


	protected String getNombre() {
		return this.nombre;
	}
	public String nombre() { return this.nombre; }

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean getEstaActivo() { return this.estaActivo; }

	public abstract Criatura getCriatura();

	protected Heroe getHeroe() { return this.heroe; }

	public abstract UbicacionView toView();
}
