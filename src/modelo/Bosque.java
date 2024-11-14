package modelo;

public class Bosque extends Ubicacion {

    private boolean tieneTesoro;
    private Criatura criatura;

	
	public Bosque(String nombre, Heroe heroe, Criatura criatura, boolean estaActivo ,boolean tieneTesoro) {
        super(nombre, heroe, estaActivo);
        this.criatura = criatura;
        this.tieneTesoro = tieneTesoro;
    }

    public boolean juegoGanado() {
        return this.tieneTesoro;
    }

    public void reclamarRecompensa(Heroe heroe) {
        Recompensa recompensa =  new Recompensa("Amuleto perdido", 0, 0.15);
        heroe.guardarRecompensa(recompensa);
    }

    public Criatura getCriatura() {
        return this.criatura;
    }

    public UbicacionView toView() {
        return new UbicacionView(this.getIdUbicacion(), this.getNombre(), this.getHeroe(), this.criatura);
    }

}
