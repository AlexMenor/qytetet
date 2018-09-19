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
    
    private static ArrayList<Sorpresa> Metodo1 (){
        
        ArrayList<Sorpresa> cartas = juego.getMazo();
        
        ArrayList<Sorpresa> aDevolver = new ArrayList<>();
        
        for (Sorpresa carta :cartas){
            if (carta.getValor() > 0){
                aDevolver.add(carta);
            }
        }
        
        return aDevolver;
        
    }
    
    private static ArrayList<Sorpresa> Metodo2 (){
        
        ArrayList<Sorpresa> cartas = juego.getMazo();
        
        ArrayList<Sorpresa> aDevolver = new ArrayList<>();
        
        for (Sorpresa carta :cartas){
            if (carta.getTipo() == TipoSorpresa.IRACASILLA){
                aDevolver.add(carta);
            }
        }
        
        return aDevolver;
        
    }
    
    private static ArrayList<Sorpresa> Metodo3 (TipoSorpresa tipo){
        
        ArrayList<Sorpresa> cartas = juego.getMazo();
        
        ArrayList<Sorpresa> aDevolver = new ArrayList<>();
        
        for (Sorpresa carta :cartas){
            if (carta.getTipo() == tipo){
                aDevolver.add(carta);
            }
        }
        
        return aDevolver;
        
    }
    
    public static void main(String[] args) {
        
        juego = new Qytetet();
        juego.inicializarCartasSorpresa();
        
        System.out.println(juego.getMazo().toString());
        
        
    }
    
}
