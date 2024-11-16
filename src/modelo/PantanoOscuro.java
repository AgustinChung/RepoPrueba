package modelo;

import java.util.List;

public class PantanoOscuro extends Ubicacion {

    private boolean tieneTesoro;
    private Criatura criatura;
    private List<Ubicacion> nombresUbiDesbloquea;

	public PantanoOscuro(String nombre, Heroe heroe, Criatura criatura, boolean estaActivo, boolean tieneTesoro, List<Ubicacion> nombresUbiDesbloquea) {
        super(nombre, heroe, estaActivo);
        this.criatura = criatura;
        this.tieneTesoro = tieneTesoro;
        this.nombresUbiDesbloquea = nombresUbiDesbloquea;
    }

    public boolean juegoGanado() {
        return this.tieneTesoro;
    }

    public void reclamarRecompensa(Heroe heroe) {
        Recompensa recompensa = new Recompensa("Arco de Luz", 0.25, 0);
        heroe.guardarRecompensa(recompensa);
        heroe.aumentarExperienciaAcumulada(this.criatura.getNivel());
    }

    public Criatura getCriatura() {
        return this.criatura;
    }

    public void activarSiguientesUbicaciones() {
        this.desactivarMapa();
        for (Ubicacion ubicacion : this.nombresUbiDesbloquea) {
            ubicacion.activarMapa();
        }
    }

    public UbicacionView toView() {
        return new UbicacionView(this.getIdUbicacion(), this.getNombre(), this.getHeroe(), this.criatura, this.getEstaActivo());
    }
	
}
