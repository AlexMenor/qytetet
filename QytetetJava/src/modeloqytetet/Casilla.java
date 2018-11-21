package modeloqytetet;

    /* 
     Esta clase representa
     una casilla de nuestro
     qytetet
    */

public abstract class Casilla {
    
    // Atributos privados de casilla
    
        // El número de la casilla
    private int numeroCasilla;
        // El coste de la casilla
    private int coste;
        
    
    // Constructor
    
    Casilla (int numeroCasilla, int coste){
        this.numeroCasilla = numeroCasilla;
        this.coste = coste;
    }
    
        // Consultores
    
    int getNumeroCasilla(){return numeroCasilla;}
    
    int getCoste(){return coste;}
    
    abstract protected TipoCasilla getTipo();
    
    public void setCoste (int coste){
        this.coste = coste;
    }
    
    protected abstract boolean soyEdificable();
    
     /* Declarados abstractos aquí para evitar errores de compilación*/
    
    abstract boolean tengoPropietario();
    
    abstract protected TituloPropiedad getTitulo();
    
    abstract void asignarPropietario (Jugador jugador);
    
    abstract public int pagarAlquiler();
    
    abstract boolean propietarioEncarcelado();
    
    abstract void setTitulo (TituloPropiedad titulo);
     
}
