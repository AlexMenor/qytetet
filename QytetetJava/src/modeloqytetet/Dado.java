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
    
    public Dado (int valor) {this.valor = valor;}
    
    public int getValor () {return valor;}
    
    @Override
    public String toString (){
        return "Dado{Valor: " + valor+ "}";
    }
    
}
