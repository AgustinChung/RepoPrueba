//Páramo Brumoso

package modelo;

public class ParamoBrumoso extends Ubicacion {

    private Criatura criatura;

    public ParamoBrumoso(String nombre, Heroe heroe, Criatura criatura, boolean estaActivo) {
        super(nombre, heroe, estaActivo);
        this.criatura = criatura;
    }

    public boolean ganoElHeroe() {
        return (this.getHeroe().getPuntosVida() > 0 && this.criatura.getPuntosVida() == 0);
    }

    public boolean juegoGanado() {
        // Siempre retorna falso porque no hay tesoro en esta clase
        return false;
    }

    public Recompensa reclamarRecompensa() {
        return new Recompensa("Experiencia", 0.20, 0);
    }

    @Override
    public Criatura getCriatura() {
        return this.criatura;
    }

    @Override
    public UbicacionView toView() {
        return new UbicacionView(this.getNombre(), this.getHeroe(), this.criatura);
    }
}