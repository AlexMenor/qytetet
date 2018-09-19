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
    private String texto;
    private TipoSorpresa tipo;
    private int valor;
    
    public Sorpresa (String text, int val, TipoSorpresa tip){
        texto = text;
        tipo = tip;
        valor = val;
    }
    
    String getTexto (){
        return (texto);
    }
    
    TipoSorpresa getTipo (){
        return (tipo);
    }
    
    int getValor (){
        return (valor);
    }
    
    @Override
    public String toString (){
        return "Sorpresa{" + "texto=" + texto + ", valor= " +
                Integer.toString(valor) + ", tipo=" + tipo + "}";
    }
    
    
    
}
