package modelo;

public class Recompensa {
	private String nombre;
	private double porcentajeAumentoAtaque;
	private double porcentajeAumentoDefensa;

	public Recompensa(String nombre, double porcentajeAumentoAtaque, double porcentajeAumentoDefensa) {
		this.nombre = nombre;
		this.porcentajeAumentoAtaque = porcentajeAumentoAtaque;
		this.porcentajeAumentoDefensa = porcentajeAumentoDefensa;
	}

	public String nombre() {
		return this.nombre;
	}
	
	public double getPorcentajeAumentoAtaque() { 
		return this.porcentajeAumentoAtaque; 
	}
	
	public double getPorcentajeAumentoDefensa() { 
		return this.porcentajeAumentoDefensa; 
	}

	public RecompensaView toView() {
		return new RecompensaView(this.nombre, this.porcentajeAumentoAtaque, this.porcentajeAumentoDefensa);
	}
	
}
