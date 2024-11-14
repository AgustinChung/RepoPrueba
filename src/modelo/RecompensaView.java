package modelo;

public class RecompensaView {
    private String nombre;
    private double porcentajeAumentoAtaque;
    private double porcentajeAumentoDefensa;

    public RecompensaView(String nombre, double porcentajeAumentoAtaque, double porcentajeAumentoDefensa) {
        this.nombre = nombre;
        this.porcentajeAumentoAtaque = porcentajeAumentoAtaque;
        this.porcentajeAumentoDefensa = porcentajeAumentoDefensa;
    }

    public String getNombre() {
        return this.nombre;
    }

    public double getPorcentajeAumentoAtaque() {
        return this.porcentajeAumentoAtaque;
    }

    public double getPorcentajeAumentoDefensa() {
        return this.porcentajeAumentoDefensa;
    }
}
