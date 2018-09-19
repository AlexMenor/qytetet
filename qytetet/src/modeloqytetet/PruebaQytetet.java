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
        ArrayList<Sorpresa> mayoresQueCero, irACasilla, tipos;
        juego.inicializarCartasSorpresa();
        
        System.out.println(juego.getMazo().toString());
        
        mayoresQueCero = sorpresaMayorQueCero(juego.getMazo());
        irACasilla = esDeIrACasilla(juego.getMazo());
        
        
        System.out.println(mayoresQueCero.toString());
        System.out.println(irACasilla.toString());
        
        
        for (TipoSorpresa sorp : TipoSorpresa.values()){
            tipos = esDeTipo(sorp, juego.getMazo());
            
            System.out.println(tipos.toString());
        }
        
    }
    
}
