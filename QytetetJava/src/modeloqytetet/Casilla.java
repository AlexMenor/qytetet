/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

/**
 *
 * @author escaleranm
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
    
        // Modificador privado de titulo
    
    private void setTitulo(TituloPropiedad titulo){
        this.titulo = titulo;
    }
        
        /* 
        Constructor para calles, por defecto
        inicializa el tipo de casilla a calle
        */
    
    public Casilla (int numeroCasilla, TituloPropiedad titulo){
        this.numeroCasilla = numeroCasilla;
        setTitulo (titulo);
        this.coste = titulo.getPrecioCompra();
        this.tipo = TipoCasilla.CALLE;
        
    }
        
        /* 
        Constructor para el resto de tipos, 
        por defecto inicializa coste a 0
        */
    
    public Casilla (int numeroCasilla, TipoCasilla tipo){
        this.numeroCasilla = numeroCasilla;
        this.coste = 0;
        this.tipo = tipo;
    }
    
        // Consultores
    
    public int getNumeroCasilla(){return numeroCasilla;}
    
    public int getCoste(){return coste;}
    
    public TipoCasilla getTipo(){return tipo;}
    
    public TituloPropiedad getTitulo(){return titulo;}
    
        /* 
        Casilla toString() solo devuelve las características
        de título propiedad, si la casilla es de tipo
        calle y por tanto, tiene título
        */

    @Override
    public String toString() {
        String toReturn = "Casilla{" 
                + "numeroCasilla=" + numeroCasilla 
                + ", coste=" + coste 
                + ", tipo=" + tipo + "\n";
        
        if (titulo != null)
            toReturn += titulo.toString();
        
        return toReturn + '}';
    }
    
    
    
}
