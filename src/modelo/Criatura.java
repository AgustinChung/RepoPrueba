package modelo;

public abstract class Criatura {
	//ATRIBUTOS
	private static int contador = 0;

	protected String idCriatura;
	protected String nombre;
	protected int puntosVida;
	protected int nivel;
	protected int nivelAtaque;
	protected int nivelDefensa;
	
	//Constructor
	public Criatura(String nombre,int puntosVida, int nivel, int nivelAtaque, int nivelDefensa) {
		contador++;
		this.idCriatura = String.valueOf(contador);
		this.nombre = nombre;
		this.puntosVida = puntosVida;
		this.nivel = nivel;
		this.nivelAtaque = nivelAtaque;
		this.nivelDefensa = nivelDefensa;
	}
	public String getIdCriatura() {
		return idCriatura;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getPuntosVida() {
		return puntosVida;
	}
	
	public int getNivel() {
		return nivel;
	}
	

	public int getNivelDefensa() {
		return nivelDefensa;
	}
	
	public abstract int aplicarHabilidadesEspeciales(Heroe heroe);
	
	public int getNivelAtaque() { 
		return this.nivelAtaque; 
	}
	
	public int nuevoNivelAtaque(Heroe heroe) {
		return aplicarHabilidadesEspeciales(heroe);
	}
	
	public void setNivelDefensa(int nivelDefensa) {
		this.nivelDefensa = nivelDefensa;
	}
	public void setPuntosVida(int puntosVida) {
		this.puntosVida = puntosVida;
	}

	public CriaturaView toView() {
		return new CriaturaView(this.idCriatura, this.nombre, this.puntosVida, this.nivel, this.nivelAtaque, this.nivelDefensa);
	}
}
