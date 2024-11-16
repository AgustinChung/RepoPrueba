//Páramo Brumoso

package modelo;

import java.util.List;

public class ParamoBrumoso extends Ubicacion {

    private Criatura criatura;
    private List<Ubicacion> nombresUbiDesbloquea;

    public ParamoBrumoso(String nombre, Heroe heroe, Criatura criatura, boolean estaActivo, List<Ubicacion> nombresUbiDesbloquea) {
        super(nombre, heroe, estaActivo);
        this.criatura = criatura;
        this.nombresUbiDesbloquea = nombresUbiDesbloquea;
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
        for (Ubicacion ubicacion : this.nombresUbiDesbloquea) {
            ubicacion.activarMapa();
        }
    }

    @Override
    public UbicacionView toView() {
        return new UbicacionView(this.getIdUbicacion(), this.getNombre(), this.getHeroe(), this.criatura, this.getEstaActivo());
    }
}