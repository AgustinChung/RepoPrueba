package modelo;

public abstract class Ubicacion {
	//ATRIBUTOS
	private static int contador = 0;

	protected String idUbicacion;
	private String nombre;
	private Heroe heroe;
	private boolean estaActivo;
	private boolean ubicacionGanada;

	protected Ubicacion(String nombre, Heroe heroe, boolean estaActivo) {
		contador++;
		this.idUbicacion = String.valueOf(contador);
		this.setNombre(nombre);
		this.heroe = heroe;
		this.estaActivo = estaActivo;
		this.ubicacionGanada = false;
	}

	public abstract void reclamarRecompensa(Heroe heroe);
	public abstract void activarSiguientesUbicaciones();
	public abstract boolean juegoGanado();

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

	protected void activarMapa() {
		this.estaActivo = true;
	}

	protected void desactivarMapa() {
		this.estaActivo = false;
	}

	public void ubicacionGanada() {
		this.ubicacionGanada = true;
	}

	public boolean getUbicacionGanada() {
		return this.ubicacionGanada;
	}
}
