package modelo;

public class Aldea extends Ubicacion {
	private Criatura criatura;
    private boolean tieneTesoro;

    public Aldea(String nombre, Heroe heroe, Criatura criatura, boolean estaActivo, boolean tieneTesoro) {
        super(nombre, heroe, estaActivo);
        this.tieneTesoro = tieneTesoro;
        this.criatura = criatura;
    }

    public void inicializarPelea() {
        PeleaV2 pelea = new PeleaV2(this.getHeroe(), this.criatura);
        pelea.iniciarPelea();
    }

    public boolean ganoElHeroe() {
        return (this.getHeroe().getPuntosVida() > 0 && this.criatura.getPuntosVida() == 0);
    }

    public boolean juegoGanado() {
        return this.tieneTesoro;
    }

    public Recompensa reclamarRecompensa() {
        return new Recompensa("Escudo de Titanio", 0, 0.3);
    }

    public Criatura getCriatura() {
        return this.criatura;
    }

    public UbicacionView toView() {
        return new UbicacionView(this.getIdUbicacion(), this.getNombre(), this.getHeroe(), this.criatura);
    }
}
