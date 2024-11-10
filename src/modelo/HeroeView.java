package modelo;

public class HeroeView {
    private String nombre;
    private String nombreUsuario;
    private int puntosVida;
    private int nivelAtaque;
    private int nivelDefensa;


    public HeroeView(String nombre, int puntosVida, int nivelAtaque, int nivelDefensa, String nombreUsuario) {
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.nivelAtaque = nivelAtaque;
        this.nivelDefensa = nivelDefensa;
        this.nombreUsuario = nombreUsuario;
    }


    public String getNombre() {
        return this.nombre;
    }

    public String getNombreUsuario() {
        return this.nombreUsuario;
    }

    public int getPuntosVida() {
        return this.puntosVida;
    }

    public int getNivelAtaque() {
        return this.nivelAtaque;
    }

    public int getNivelDefensa() {
        return this.nivelDefensa;
    }
}
