package modelo;

//METER LOGS EN TODOS LADOS
public class Pelea {
	
    private Heroe heroe;
    private Criatura criatura;

    public Pelea(Heroe heroe, Criatura criatura) {
        this.heroe = heroe;
        this.criatura = criatura;
    }

    // Metodo para inicializar la pelea
    public String iniciarPelea() {
    	System.out.println("EMPEZO LA PELEA");
        boolean turnoHeroe = true;
        while (this.heroe.getPuntosVida() > 0 && this.criatura.getPuntosVida() > 0) {
            if (turnoHeroe) {
                this.realizarAtaqueHeroe();
                turnoHeroe = false;
            } else {
                this.realizarAtaqueCriatura();
                turnoHeroe = true;
            }
        }

        if (heroe.getPuntosVida() > 0) {
            return "Victoria del Héroe";
        } else {
            return "Derrota del Héroe";
        }
    }

    // Metodo para el ataque del héroe a la criatura
    public void realizarAtaqueHeroe() {
        int danio = calcularDanioHeroe();
        aplicarDanioACriatura(criatura, danio);
    }

    // Metodo para el ataque de la criatura al héroe
    public void realizarAtaqueCriatura() {
        int danio = calcularDanioCriatura();
        aplicarDanioAHeroe(heroe, danio);
    }

    
    
    
    // CORREGIR METODO DE CALCULAR DANIO. PODEMOS PREGUNTAR 2 OPCIONES. IF ATAQUEDELHEROE < DEFENSA DE LA CRIATURA ENTONCES SACARLE PUNTOS A SU NIVEL DE DEFENSA.
    // PERO SI EL ATAQUE DEL HEROE ES MAYOR A LA DEFENSA DE LA CRIATURA, ENTONCES LE SACAMOS ESA DIFERENCIA A LA VIDA DE LA CRIATURA DIRECTAMENTE.
    
    // Metodo para calcular el daño que el héroe inflige a la criatura
    public int calcularDanioHeroe() {
        int ataqueHeroe = heroe.aplicarHabilidadesEspeciales(criatura); // Polimorfismo
        int defensaCriatura = criatura.getNivelDefensa();
        return Math.max(ataqueHeroe - defensaCriatura ,0); //REVISAR EN EL CASO DE QUE EL ATAQUE SEA MAYOR A LA DEFENSA
    }

    
    public int calcularDanioHeroe2() {
        int ataqueHeroe = heroe.aplicarHabilidadesEspeciales(criatura); // Polimorfismo
        int defensaCriatura = criatura.getNivelDefensa();
    	return (ataqueHeroe > defensaCriatura) ? 0 : defensaCriatura - ataqueHeroe;
    }
    
    
    // Metodo para calcular el daño que la criatura inflige al héroe
    public int calcularDanioCriatura() {
        int ataqueCriatura = criatura.aplicarHabilidadesEspeciales(heroe); // Polimorfismo
        int defensaHeroe = heroe.getNivelDefensa();
        return Math.max(ataqueCriatura - defensaHeroe, 0); //REVISAR EN EL CASO DE QUE EL ATAQUE SEA MAYOR A LA DEFENSA
    }

    // Metodo para aplicar daño a un héroe
    public void aplicarDanioAHeroe(Heroe heroe, int danio) {
        if (heroe.getNivelDefensa() > 0) {
            heroe.setNivelDefensa(heroe.getNivelDefensa() - danio);
        } else {
            heroe.setPuntosVida(heroe.getPuntosVida() - danio); 
        }
    }

    // Metodo para aplicar daño a una criatura
    public void aplicarDanioACriatura(Criatura criatura, int danio) {
        if (criatura.getNivelDefensa() > 0) {
            criatura.setNivelDefensa(criatura.getNivelDefensa() - danio);
        } else {
            criatura.setPuntosVida(criatura.getPuntosVida() - danio);
        }
    }
}

