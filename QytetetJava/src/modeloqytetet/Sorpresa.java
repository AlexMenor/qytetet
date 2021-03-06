package modeloqytetet;

    /* 
     Esta clase cada una de
     las cartas sorpresa de
     qytetet
    */

public class Sorpresa {
    
 // Atributos privados
    
        // Mensaje de la carta
    private String texto;
        // Tipo de sopresa
    private TipoSorpresa tipo;
        // Valor (puede ser 0)
    private int valor;
    
        
        // Constructor 
    
    Sorpresa (String texto, int valor, TipoSorpresa tipo){
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
        return texto + 
                "\nValor: " + Integer.toString(valor) + 
                "\nTipo=" + tipo;
    }
}
