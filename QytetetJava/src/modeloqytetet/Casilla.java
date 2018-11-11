package modeloqytetet;

    /* 
     Esta clase representa
     una casilla de nuestro
     qytetet
    */

public class Casilla {
    
    // Atributos privados de casilla
    
        // El número de la casilla
    private int numeroCasilla;
        // El coste de la casilla
    private int coste;
        // El tipo de la casilla
    private TipoCasilla tipo;
        /* 
        Si la casilla es una calle
        tendra titulo de propiedad
        sino, este atributo será null
        */
    private TituloPropiedad titulo;
    
        // Modificador público de titulo
    
    public void setTitulo(TituloPropiedad titulo){
        this.titulo = titulo;
    }
        
    TituloPropiedad asignarPropietario (Jugador jugador){
        titulo.setPropietario(jugador);
        
        return titulo;
    }
    
        /* 
        Constructor para calles, por defecto
        inicializa el tipo de casilla a calle
        */
    
    Casilla (int numeroCasilla, TituloPropiedad titulo){
        this.numeroCasilla = numeroCasilla;
        setTitulo (titulo);
        this.coste = titulo.getPrecioCompra();
        this.tipo = TipoCasilla.CALLE;
        
    }
        
        /* 
        Constructor para el resto de tipos, 
        por defecto inicializa coste a 0
        */
    
    Casilla (int numeroCasilla, TipoCasilla tipo){
        this.numeroCasilla = numeroCasilla;
        this.coste = 0;
        this.tipo = tipo;
    }
    
        // Consultores
    
    int getNumeroCasilla(){return numeroCasilla;}
    
    int getCoste(){return coste;}
    
    TipoCasilla getTipo(){return tipo;}
    
    TituloPropiedad getTitulo(){return titulo;}
    
    boolean soyEdificable(){
        return (tipo == TipoCasilla.CALLE);
    }
    
    boolean tengoPropietario(){
        return titulo.tengoPropietario();
    }
    
    boolean propietarioEncarcelado(){
        return titulo.propietarioEncarcelado();
    }
    
    /* 
       Devuelve el dinero a pagar por el
       alquiler de una casilla
    */
    
    int pagarAlquiler (){
        return titulo.pagarAlquiler();
    }
        

    /* Por implementar
    TituloPropiedad asignarPropietario (Jugador jugador){}
    
    boolean propietarioEncarcelado(){}
    */
    
    /* 
        Casilla toString() solo devuelve las características
        de título propiedad, si la casilla es de tipo
        calle y por tanto, tiene título
        */
    
    @Override
    public String toString() {
        String toReturn = "Casilla{" 
                + "numeroCasilla=" + numeroCasilla 
                + "coste=" + coste 
                + "tipo=" + tipo;
        
        if (titulo != null)
            toReturn += ("titulo=" + titulo.toString());
        
        return toReturn + '}';
    }
    
    
    
}
