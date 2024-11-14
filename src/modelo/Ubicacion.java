package modelo;

public abstract class Ubicacion {
	//ATRIBUTOS
	private static int contador = 0;

	protected String idUbicacion;
	private String nombre;
	private Heroe heroe;
	private boolean estaActivo;

	protected Ubicacion(String nombre, Heroe heroe, boolean estaActivo) {
		contador++;
		this.idUbicacion = String.valueOf(contador);
		this.setNombre(nombre);
		this.heroe = heroe;
		this.estaActivo = estaActivo;
	}

	public abstract Recompensa reclamarRecompensa();

	protected String getIdUbicacion() { return this.idUbicacion; }
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
