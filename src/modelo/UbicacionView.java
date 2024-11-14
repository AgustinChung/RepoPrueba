package modelo;

public class UbicacionView {
    private String id;
    private String nombre;
    private Heroe heroe;
    private Criatura criatura;
    private boolean estaActivo;

    public UbicacionView(String id, String nombre, Heroe heroe, Criatura criatura, boolean estaActivo) {
        this.id = id;
        this.nombre = nombre;
        this.heroe = heroe;
        this.criatura = criatura;
        this.estaActivo = estaActivo;
    }

    public String getIdUbicacion() { return this.id; }
    public String getNombre() {
        return this.nombre;
    }
    public boolean getEstaActivo() { return this.estaActivo; }
    public HeroeView getHeroe() {
        return this.heroe.toView();
    }
    public CriaturaView getCriatura() { return this.criatura.toView();}
}
