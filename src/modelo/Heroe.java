package modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Heroe {
	public static int contador = 0;
    protected int idHeroe;
    protected String nombre;
	protected String nombreUsuario;
    protected int puntosVida;
    private int puntosVidaMaxima; // Para restaurar al máximo
	private int nivelDeDefensaMaximo; // Para restaurar al maximo
    protected int nivelAtaque;
    protected int nivelDefensa;
    protected int nivel;
    protected int experiencia;
    protected List<Recompensa> recompensas;
    

    public Heroe(String nombre,int puntosVida, int nivelAtaque, int nivelDefensa, String nombreUsuario) {
        this.idHeroe = contador;
        contador ++;
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.setPuntosVidaMaxima(puntosVida); // La vida máxima es igual a la vida inicial
        this.nivelAtaque = nivelAtaque;
        this.nivelDefensa = nivelDefensa;
		this.nombreUsuario = nombreUsuario;
        this.nivel = 1;
        this.experiencia = 0;
        this.recompensas =  new ArrayList<>();
    }


	public int getIdHeroe() {
		return idHeroe;
	}
	public void setIdHeroe(int idHeroe) {
		this.idHeroe = idHeroe;
	}


	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getPuntosVida() {
		return puntosVida;
	}
	public void setPuntosVida(int puntosVida) {
		this.puntosVida = puntosVida;
	}


	public void setNivelAtaque(int nivelAtaque) {
		this.nivelAtaque = nivelAtaque;
	}


	public int getNivelDefensa() {
		return nivelDefensa;
	}
	public void setNivelDefensa(int nivelDefensa) {
		this.nivelDeDefensaMaximo = nivelDefensa;
	}


	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}


	public int getExperiencia() {
		return experiencia;
	}
	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	public int getNivelAtaque() { return this.nivelAtaque; }
	public abstract int aplicarHabilidadesEspeciales(Criatura criatura);
	public int nuevoNivelAtaque(Criatura criatura) {
		return aplicarHabilidadesEspeciales(criatura);
	}

	public void guardarRecompensa(Recompensa recompensa) {
		recompensas.add(recompensa);
	}

	public List<Recompensa> getRecompensas() { return recompensas; }


	public int getPuntosVidaMaxima() {
		return this.puntosVidaMaxima;
	}
	public int getNivelDeDefensaMaximo() { return this.nivelDeDefensaMaximo; }


	public void setPuntosVidaMaxima(int puntosVidaMaxima) {
		this.puntosVidaMaxima = puntosVidaMaxima;
	}

	public HeroeView toView() {
		return new HeroeView(this.nombre, this.puntosVida, this.nivelAtaque, this.nivelDefensa, this.nombreUsuario);
	}
}

