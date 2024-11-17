package modelo;

import java.util.List;

public class HeroeView {
    private String nombre;
    private String nombreUsuario;
    private int puntosVida;
    private int nivelAtaque;
    private int nivelDefensa;
    private List<RecompensaView> recompensas;
    private int experienciaAcumulada;
    private int nivelDefensaMaximo;
    private int puntosVidaMaximo;

    public HeroeView(String nombre, int puntosVida, int nivelAtaque, int nivelDefensa, String nombreUsuario, List<RecompensaView> recompensas, int experienciaAcumulada, int nivelDefensaMaximo, int puntosVidaMaximo) {
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.nivelAtaque = nivelAtaque;
        this.nivelDefensa = nivelDefensa;
        this.nombreUsuario = nombreUsuario;
        this.recompensas = recompensas;
        this.experienciaAcumulada = experienciaAcumulada;
        this.nivelDefensaMaximo = nivelDefensaMaximo;
        this.puntosVidaMaximo = puntosVidaMaximo;
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

    public List<RecompensaView> getRecompensas() {
        return this.recompensas;
    }

    public int getExperienciaAcumulada() {
        return this.experienciaAcumulada;
    }

    public int getNivelDefensaMaximo() {
        return this.nivelDefensaMaximo;
    }

    public int getPuntosVidaMaximo() {
        return this.puntosVidaMaximo;
    }
}
