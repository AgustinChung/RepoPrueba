package modelo;

public class HeroeView {
    public String nombre;
    public String nombreUsuario;
    public int puntosVida;
    public int nivelAtaque;
    public int nivelDefensa;

    public HeroeView(String nombre, int puntosVida, int nivelAtaque, int nivelDefensa, String nombreUsuario) {
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.nivelAtaque = nivelAtaque;
        this.nivelDefensa = nivelDefensa;
        this.nombreUsuario = nombreUsuario;
    }
}
