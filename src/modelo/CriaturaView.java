package modelo;

public class CriaturaView {
    private String idCriatura;
    private String nombre;
    private int puntosVida;
    private int nivel;
    private int nivelAtaque;
    private int nivelDefensa;

    public CriaturaView(String idCriatura, String nombre, int puntosVida, int nivel, int nivelAtaque, int nivelDefensa) {
        this.idCriatura = idCriatura;
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.nivel = nivel;
        this.nivelAtaque = nivelAtaque;
        this.nivelDefensa = nivelDefensa;
    }

    public String getIdCriatura() { return this.idCriatura; }
    public String getNombre() { return this.nombre; }
    public int getPuntosVida() { return this.puntosVida; }
    public int getNivel() { return this.nivel; }
    public int getNivelAtaque() { return this.nivelAtaque; }
    public int getNivelDefensa() { return this.nivelDefensa; }

}
