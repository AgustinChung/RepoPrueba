package modelo;

public class PeleaV2 {
    private Heroe heroe;
    private Criatura criatura;

    public PeleaV2(Heroe heroe, Criatura criatura) {
        this.heroe = heroe;
        this.criatura = criatura;
    }

    public boolean iniciarPelea() {
        boolean turnoHeroe = true;
        while(this.heroe.getPuntosVida() > 0 && this.criatura.getPuntosVida() > 0) {
            if (turnoHeroe) {
                this.heroeRealizaAtaque();
                System.out.println("El heroe ataco.");
                turnoHeroe = false;
            } else {
                this.criaturaRealizaAtaque();
                System.out.println("La criatura ataco");
                turnoHeroe = true;
            }
        }
        // Termino la pelea
        if (this.esUnGuerrero()) { // si es un guerrero reseteo los golpes
            Guerrero guerrero = (Guerrero) heroe;
            guerrero.resetContadorGolpes();
        }
        return (this.heroe.getPuntosVida() > 0);
    }

    public void heroeRealizaAtaque() {
        int danio = this.heroe.nuevoNivelAtaque(this.criatura);
        if(this.criatura.getNivelDefensa() > 0) {
            int nivelDefensa = (danio > this.criatura.getNivelDefensa())
                    ? 0 // Rompe la defensa, pero no baja la vida
                    : this.criatura.getNivelDefensa() - danio;
            this.criatura.setNivelDefensa(nivelDefensa);
        } else { // ya no tiene defensa
            int puntosVida = (danio > this.criatura.getPuntosVida())
                    ? 0 // murio
                    : this.criatura.getPuntosVida() - danio;
            this.criatura.setPuntosVida(puntosVida);
        }
    }

    public void criaturaRealizaAtaque() {
        int danio = this.criatura.nuevoNivelAtaque(this.heroe);
        if (this.heroe.getNivelDefensa() > 0) {
            int nivelDefensa = (danio > this.heroe.getNivelDefensa())
                    ? 0
                    : this.heroe.getNivelDefensa() - danio;
            this.heroe.setNivelDefensa(nivelDefensa);
        } else { // ya no tiene defensa
            int puntosVida = (danio > this.heroe.getPuntosVida())
                    ? 0 // murio
                    : this.heroe.getPuntosVida() - danio;
            this.heroe.setPuntosVida(puntosVida);
        }
    }

    public boolean esUnGuerrero() {
        return heroe.getNombre() == "Guerrero";
    }
}
