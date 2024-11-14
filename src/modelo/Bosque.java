package modelo;

public class Bosque extends Ubicacion {

    private Criatura criatura;
    private boolean tieneTesoro;
	
	public Bosque(String nombre, Heroe heroe, Criatura criatura, boolean estaActivo ,boolean tieneTesoro) {
        super(nombre, heroe, estaActivo);
        this.criatura = criatura;
        this.tieneTesoro = tieneTesoro;
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
        return new Recompensa("Amuleto perdido", 0, 0.15);
    }

    public Criatura getCriatura() {
        return this.criatura;
    }

    public UbicacionView toView() {
        return new UbicacionView(this.getIdUbicacion(), this.getNombre(), this.getHeroe(), this.criatura);
    }

}
