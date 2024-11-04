// Clase base para personajes
abstract class Personaje {
    protected String nombre;
    protected int puntosVida;
    protected int nivelAtaque;
    protected int nivelDefensa;
    protected int experiencia;

    public abstract int atacar(Criatura criatura);
    
    public void recibirDaño(int daño) {
        this.puntosVida -= daño;
        if (this.puntosVida < 0) this.puntosVida = 0;
    }
    
    public void mejorar() {
        this.nivelAtaque += 1;
        this.nivelDefensa += 1;
    }
}

class Guerrero extends Personaje {
    private int contadorGolpes;

    @Override
    public int atacar(Criatura criatura) {
        contadorGolpes++;
        int daño = this.nivelAtaque;
        if (contadorGolpes >= 3) {
            daño *= 2;
        }
        criatura.recibirDaño(daño);
        return daño;
    }
}

class Mago extends Personaje {
    @Override
    public int atacar(Criatura criatura) {
        int daño = this.nivelAtaque;
        criatura.recibirDaño(daño);
        return daño;
    }

    public void curarVida() {
        // Implementación de curación
    }
}

class Arquero extends Personaje {
    private int nivelPunteria;
    private int nivelAgilidad;

    @Override
    public int atacar(Criatura criatura) {
        int daño = this.nivelAtaque;
        if (Math.random() < this.nivelPunteria / 100.0) {
            daño *= 2;  // Golpe crítico
        }
        criatura.recibirDaño(daño);
        return daño;
    }

    public boolean esquivarAtaque() {
        return Math.random() < this.nivelAgilidad / 100.0;
    }
}

abstract class Criatura {
    protected String nombre;
    protected int puntosVida;
    protected int nivelAtaque;
    protected int nivelDefensa;

    public abstract int atacar(Personaje personaje);

    public void recibirDaño(int daño) {
        this.puntosVida -= daño;
        if (this.puntosVida < 0) this.puntosVida = 0;
    }
}

class Dragon extends Criatura {
    @Override
    public int atacar(Personaje personaje) {
        int daño = this.nivelAtaque;
        if (personaje instanceof Guerrero) {
            daño *= 1.3;  // 30% más de daño contra Guerreros
        }
        personaje.recibirDaño(daño);
        return daño;
    }
}

class Ubicacion {
    private String nombre;
    private Criatura criatura;
    private boolean esTesoro;

    public Criatura getCriatura() {
        return this.criatura;
    }

    public boolean revelarTesoro() {
        return this.esTesoro;
    }
}

class Mapa {
    private List<Ubicacion> ubicaciones;

    public List<Ubicacion> obtenerUbicacionesCercanas(Ubicacion ubicacionActual) {
        // Lógica para obtener ubicaciones cercanas
        return new ArrayList<>();
    }
}

class MisionSecundaria {
    private String nombre;
    private String objetivo;
    private String recompensa;

    public boolean verificarComplecion(Personaje personaje) {
        // Lógica para verificar si la misión está completa
        return false;
    }

    public void otorgarRecompensa(Personaje personaje) {
        personaje.mejorar();
    }
}

class Juego {
    private Personaje personaje;
    private Mapa mapa;
    private List<MisionSecundaria> misiones;

    public void iniciarJuego() {
        // Lógica de inicialización del juego
    }

    public void realizarTurno() {
        // Lógica principal del juego
        // Aquí se implementaría la lógica de los diagramas de secuencia
    }

    public boolean verificarVictoria() {
        // Lógica para verificar si el jugador ha ganado
        return false;
    }
}
