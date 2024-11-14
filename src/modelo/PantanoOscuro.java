package modelo;

public class PantanoOscuro extends Ubicacion {

    private boolean tieneTesoro;
    private Criatura criatura;

	public PantanoOscuro(String nombre, Heroe heroe, Criatura criatura, boolean estaActivo, boolean tieneTesoro) {
        super(nombre, heroe, estaActivo);
        this.criatura = criatura;
        this.tieneTesoro = tieneTesoro;
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
            this.getHeroe().guardarRecompensa(recompensa);
        }
    }

    public Criatura getCriatura() {
        return this.criatura;
    }

    public UbicacionView toView() {
        return new UbicacionView(this.getNombre(), this.getHeroe(), this.criatura);
    }
	
}
