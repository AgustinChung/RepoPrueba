package modelo;

public class MontaniasHeladas extends Ubicacion{
    private Criatura criatura;
    private boolean tieneTesoro;

    public MontaniasHeladas(String nombre, Heroe heroe, Criatura criatura, boolean tieneTesoro) {
        super(nombre, heroe);
        this.criatura = criatura;
        this.tieneTesoro = tieneTesoro;
    }

    public void inicializarPelea() {
        Pelea pelea = new Pelea(this.heroe, this.criatura);
        pelea.iniciarPelea();
    }

    public boolean juegoGanado() {
        // si gano el heroe gano la pelea y el mapa tiene el tesoro -> gano el juego
        return (this.heroe.getPuntosVida() > 0 && this.criatura.getPuntosVida() == 0 && this.tieneTesoro);
    }

    public void reclamarRecompensa() {
        Recompensa recompensa = (this.heroe.getPuntosVida() > 0 && this.criatura.getPuntosVida() == 0)
                ? new Recompensa("Espada de Fuego", 0.20, 0)
                : null;
        if (recompensa != null) {
            this.heroe.guardarRecompensa(recompensa);
        }
    }
}
