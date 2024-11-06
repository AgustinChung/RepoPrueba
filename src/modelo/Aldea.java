package modelo;

public class Aldea extends Ubicacion {
	private Criatura criatura;
    private boolean tieneTesoro;

    public Aldea(String nombre, Heroe heroe, Criatura criatura, boolean tieneTesoro) {
        super(nombre, heroe);
        this.criatura = criatura;
        this.tieneTesoro = tieneTesoro;
    }

    public void inicializarPelea() {
        PeleaV2 pelea = new PeleaV2(this.heroe, this.criatura);
        pelea.iniciarPelea();
    }

    public boolean ganoElHeroe() {
        return (this.heroe.getPuntosVida() > 0 && this.criatura.getPuntosVida() == 0);
    }

    public boolean juegoGanado() {
        // si gano el heroe gano la pelea y el mapa tiene el tesoro -> gano el juego
        return (this.ganoElHeroe() && this.tieneTesoro);
    }

    public void reclamarRecompensa() {
        Recompensa recompensa = (this.ganoElHeroe())
                ? new Recompensa("Escudo de Titanio", 0, 0.3)
                : null;
        if (recompensa != null) {
            this.heroe.guardarRecompensa(recompensa);
        }
    }
}
