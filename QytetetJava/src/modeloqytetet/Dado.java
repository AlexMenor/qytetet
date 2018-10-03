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
class Dado {
    private int valor;
    
    private static final Dado instance = new Dado ();
    
    private Dado () {valor = 1;} // Valor 1 por defecto
    
    public static Dado getInstance () {return instance;}
    
    public int getValor () {return valor;}
    
    @Override
    public String toString (){
        return "Dado{Valor: " + valor+ "}";
    }
    
}
