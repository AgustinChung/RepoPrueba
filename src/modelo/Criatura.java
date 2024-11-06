package modelo;

public abstract class Criatura {
	//ATRIBUTOS
	protected String idCriatura;
	protected String nombre;
	protected int puntosVida;
	protected int nivel;
	protected int nivelAtaque;
	protected int nivelDefensa;
	
	//Constructor
	public Criatura(String nombre,int puntosVida, int nivel, int nivelAtaque, int nivelDefensa) {
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
}
