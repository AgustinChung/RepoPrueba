package modelo;

public class UbicacionView {
    private String nombre;
    private Heroe heroe;
    private Criatura criatura;

    public UbicacionView(String nombre, Heroe heroe, Criatura criatura) {
        this.nombre = nombre;
        this.heroe = heroe;
        this.criatura = criatura;
    }

    public String getNombre() {
        return this.nombre;
    }
    public HeroeView getHeroe() {
        return this.heroe.toView();
    }
    public CriaturaView getCriatura() { return this.criatura.toView();}
}
