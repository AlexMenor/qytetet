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
    
    private static ArrayList<Sorpresa> 
        sorpresaMayorQueCero (ArrayList<Sorpresa> mazo){
        
        ArrayList<Sorpresa> aDevolver = new ArrayList<>();
        
        for (Sorpresa carta : mazo){
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
        
        for (Sorpresa carta : mazo){
            if (carta.getTipo() == tipo){
                aDevolver.add(carta);
            }
        }
        
        return aDevolver;
        
    }
    
    public static void main(String[] args) {
        
        juego = new Qytetet();
        
        
            // Declarados para probar los métodos de esta clase
        
        ArrayList<Sorpresa> mayoresQueCero, irACasilla, 
                tipos, mazoCompleto;
        
        mazoCompleto = juego.getMazo();
        
            /* 
            * El método println automáticamente
            * hace uso de toString() en ArrayList 
            */
        System.out.println("Mazo completo: ");
        System.out.println(mazoCompleto);
        
        mayoresQueCero = sorpresaMayorQueCero(mazoCompleto);
        System.out.println("Mazo mayores de cero: ");
        System.out.println(mayoresQueCero);
        
        irACasilla = esDeIrACasilla(mazoCompleto);
        System.out.println("Mazo de ir a casilla: ");
        System.out.println(irACasilla);
        
        System.out.println("Mazos de cada tipo: ");
        for (TipoSorpresa sorp : TipoSorpresa.values()){
            tipos = esDeTipo(sorp, mazoCompleto);
            
            System.out.println(tipos.toString());
        }
        
        System.out.println(juego.getTablero().toString());
        
    }
    
}
