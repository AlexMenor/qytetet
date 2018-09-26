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
    private int numeroCasilla;
    private int coste;
    private TipoCasilla tipo;
    private TituloPropiedad titulo;
    
    private void setTitulo(TituloPropiedad titulo){
        this.titulo = titulo;
    }
    
    public Casilla (int numeroCasilla, int coste, TituloPropiedad titulo){
        this.numeroCasilla = numeroCasilla;
        this.coste = coste;
        this.tipo = TipoCasilla.CALLE;
        setTitulo (titulo);
    }
    
    public Casilla (int numeroCasilla, TipoCasilla tipo){
        this.numeroCasilla = numeroCasilla;
        this.coste = 0;
        this.tipo = tipo;
    }
    
    public int getNumeroCasilla(){
        return numeroCasilla;
    }
    
    public int getCoste(){
        return coste;
    }
    
    public TipoCasilla getTipo(){
        return tipo;
    }
    
    public TituloPropiedad getTitulo(){
        return titulo;
    }
    
    public String toString(){
        return "Número: " + Integer.toString (numeroCasilla) + " \nCoste: " + 
                Integer.toBinaryString(coste) + "\nTipo: " + tipo + "\nTitulo: " 
                + titulo;
    }
    
}
