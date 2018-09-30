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
public class Qytetet {

// Atributos privados
    
        // Mazo con las cartas sorpresa
    private ArrayList <Sorpresa> mazo = new ArrayList <> ();
        // Tablero con las casillas del juego
    private Tablero tablero;
    
// Constructor sin argumentos
    
    public Qytetet (){
        inicializarTablero ();
        inicializarCartasSorpresa ();
    }
    
// Consultores
    
    Tablero getTablero (){return tablero;}
    
    ArrayList <Sorpresa> getMazo () {return mazo;}
    
        /*
        Inicializa las cartas sopresa con las
        características que hemos decidido
        */
    
    void inicializarCartasSorpresa (){
        
        mazo.add (new Sorpresa ("Te encuentras un billete por la calle, cobra"
                + " 500 euros", 500, TipoSorpresa.PAGARCOBRAR));
        
        mazo.add (new Sorpresa ("Te han pillado superando el límite de velocidad"
                , -200, TipoSorpresa.PAGARCOBRAR));
        
        mazo.add (new Sorpresa ("Ve a la cárcel", 
                  tablero.getCarcel().getNumeroCasilla(), TipoSorpresa.IRACASILLA));
        
        mazo.add (new Sorpresa ("Parking gratuito", 4, TipoSorpresa.IRACASILLA));
        
        mazo.add (new Sorpresa ("Ve a la casilla número 10", 10, 
                TipoSorpresa.IRACASILLA));
        
        mazo.add (new Sorpresa ("Concurso de decoración. Cobras 100 euros "
                + "por cada casa y hotel", 100, TipoSorpresa.PORCASAHOTEL));
        
        mazo.add (new Sorpresa ("Reformas: Paga 300 euros por cada casa y hotel"
                , -300, TipoSorpresa.PORCASAHOTEL));
                
        mazo.add (new Sorpresa ("Ganas una apuesta, recibe 50 euros de cada"
                + " jugador", 50, TipoSorpresa.PORJUGADOR));
        
        mazo.add (new Sorpresa ("Hoy invitas tú, paga 45 euros a cada jugador", 
                -45, TipoSorpresa.PORJUGADOR));
        
        mazo.add (new Sorpresa ("Quedas libres de la cárcel, puedes guardar "
        + " esto para luego", 0, TipoSorpresa.SALIRCARCEL));
        
    }
    
        // Inicialización del atributo tablero
    
    private void inicializarTablero (){tablero = new Tablero ();}
    
}
