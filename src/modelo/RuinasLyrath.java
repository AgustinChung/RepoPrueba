//Ruinas de Lyrath

package modelo;

import java.util.List;

public class RuinasLyrath extends Ubicacion {

    private Criatura criatura;

    public RuinasLyrath(String nombre, Heroe heroe, Criatura criatura, boolean estaActivo) {
        super(nombre, heroe, estaActivo);
        this.criatura = criatura;
    }

    public boolean juegoGanado() {
        // Siempre retorna falso porque no hay tesoro en esta clase
        return false;
    }

    public void reclamarRecompensa(Heroe heroe) {
        heroe.aumentarExperienciaAcumulada(this.criatura.getNivel());
    }

    @Override
    public Criatura getCriatura() {
        return this.criatura;
    }

    public void activarSiguientesUbicaciones() {
        this.desactivarMapa();
    }

    @Override
    public UbicacionView toView() {
        return new UbicacionView(this.getIdUbicacion(), this.getNombre(), this.getHeroe(), this.criatura, this.getEstaActivo());
    }
}