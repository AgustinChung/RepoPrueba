//Cañón del Crepúsculo

package modelo;

public class CanonCrepusculo extends Ubicacion {
    private Criatura criatura;


    public CanonCrepusculo(String nombre, Heroe heroe, Criatura criatura, boolean estaActivo) {
        super(nombre, heroe, estaActivo);
        this.criatura = criatura;
    }

    public boolean juegoGanado() {
        // Siempre retorna falso porque no hay tesoro en esta clase
        return false;
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