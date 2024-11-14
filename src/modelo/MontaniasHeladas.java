package modelo;

public class MontaniasHeladas extends Ubicacion{
    private Criatura criatura;
    private boolean tieneTesoro;

    public MontaniasHeladas(String nombre, Heroe heroe, Criatura criatura, boolean estaActivo, boolean tieneTesoro) {
        super(nombre, heroe, estaActivo);
        this.criatura = criatura;
        this.tieneTesoro = tieneTesoro;
    }

    public boolean juegoGanado() {
        return this.tieneTesoro;
    }

    public Recompensa reclamarRecompensa() {
        return new Recompensa("Espada de Fuego", 0.20, 0);
    }

    public Criatura getCriatura() {
        return this.criatura;
    }

    public UbicacionView toView() {
        return new UbicacionView(this.getIdUbicacion(), this.getNombre(), this.getHeroe(), this.criatura);
    }
}
