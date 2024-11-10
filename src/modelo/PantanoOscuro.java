package modelo;

public class PantanoOscuro extends Ubicacion {

	private Criatura criatura;
    private boolean tieneTesoro;
	
	public PantanoOscuro(String nombre, Heroe heroe, Criatura criatura, boolean estaActivo, boolean tieneTesoro) {
        super(nombre, heroe, estaActivo);
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
                ? new Recompensa("Arco de Luz", 0.25, 0)
                : null;
        if (recompensa != null) {
            this.heroe.guardarRecompensa(recompensa);
        }
    }

    public Criatura getCriatura() {
        return this.criatura;
    }
	
}
