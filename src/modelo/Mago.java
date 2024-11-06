package modelo;

public class Mago extends Heroe{

	private boolean esInmune;
	
	public Mago(String nombre, int puntosVida, int nivelAtaque, int nivelDefensa, String nombreUsuario) {
		super(nombre, puntosVida, nivelAtaque, nivelDefensa, nombreUsuario);
	}

	@Override
    public int aplicarHabilidadesEspeciales(Criatura criatura) {
        // El Mago no tiene habilidades especiales durante el ataque,
        // pero al finalizar la pelea, cura su vida al 100% (esto se maneja fuera)
        return this.nivelAtaque;
    }
	
	//es inmune contra espectros
	public boolean esInmune(Criatura criatura) {
		if (criatura.getNombre() == "espectro") {
			this.esInmune = true;
		} else {
			this.esInmune = false;
		}
		
		return esInmune;}
}
