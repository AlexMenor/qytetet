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
class Sorpresa {
    
 // Atributos privados
    
        // Mensaje de la carta
    private String texto;
        // Tipo de sopresa
    private TipoSorpresa tipo;
        // Valor (puede ser 0)
    private int valor;
    
        
        // Constructor 
    
    public Sorpresa (String texto, int valor, TipoSorpresa tipo){
        this.texto = texto;
        this.tipo = tipo;
        this.valor = valor;
    }
    
// Consultores
    
    String getTexto (){return (texto);} 
    
    TipoSorpresa getTipo (){return (tipo);}
    
    int getValor (){return (valor);}
    
        // Sorpresa toString()
    
    @Override
    public String toString (){
        return "Sorpresa{" + "texto=" + texto + ", valor= " +
                Integer.toString(valor) + ", tipo=" + tipo + "}";
    }
}
