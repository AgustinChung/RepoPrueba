package modelo;

public class PeleaV2View {
    private Heroe heroe;
    private Criatura criatura;

    public PeleaV2View(Heroe heroe,Criatura criatura) {
        this.heroe = heroe;
        this.criatura = criatura;
    }

    public Heroe getHeroe() {
        return this.heroe;
    }
    public Criatura getCriatura() {
        return this.criatura;
    }

}
