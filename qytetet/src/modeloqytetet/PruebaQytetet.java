/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;
import java.util.ArrayList;

/**
 *
 * @author alex
 */
public class PruebaQytetet {

    static Qytetet juego;
    /**
     * @param args the command line arguments
     */
    
    private static ArrayList<Sorpresa> 
        sorpresaMayorQueCero (ArrayList<Sorpresa> mazo){
        
        ArrayList<Sorpresa> aDevolver = new ArrayList<>();
        
        for (Sorpresa carta :mazo){
            if (carta.getValor() > 0){
                aDevolver.add(carta);
            }
        }
        
        return aDevolver;
        
    }
    
    private static ArrayList<Sorpresa> 
        esDeIrACasilla (ArrayList<Sorpresa> mazo){
        
        
        return esDeTipo(TipoSorpresa.IRACASILLA, mazo);
        
    }
    
    private static ArrayList<Sorpresa> 
        esDeTipo (TipoSorpresa tipo, ArrayList<Sorpresa> mazo){
        
        ArrayList<Sorpresa> aDevolver = new ArrayList<>();
        
        for (Sorpresa carta :mazo){
            if (carta.getTipo() == tipo){
                aDevolver.add(carta);
            }
        }
        
        return aDevolver;
        
    }
    
    public static void main(String[] args) {
        
        juego = new Qytetet();
        ArrayList<Sorpresa> mayoresQueCero;
        juego.inicializarCartasSorpresa();
        
        System.out.println(juego.getMazo().toString());
        
        mayoresQueCero = sorpresaMayorQueCero();
    }
    
}
