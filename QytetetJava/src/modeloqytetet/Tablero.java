/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;
import java.util.ArrayList;
/**
 *
 * @author escaleranm
 */
public class Tablero {
    private ArrayList<Casilla> casillas;
    private Casilla carcel;
    
    private void inicializar(){
        casillas = new ArrayList<>();
        
        casillas.add (new Casilla (1, 300, new TituloPropiedad ("Huerto de "
                + "Calixto y Melibea", 300, 50, (float)1.2, 150, 250)));
    }

    
    public Tablero(){
        carcel = new Casilla(9, TipoCasilla.CARCEL);
    }
    
    public ArrayList<Casilla> getCasillas(){
        return casillas;
    }
    
    public Casilla getCarcel(){
        return carcel;
    }
    
    public String toString(){
        return "Casillas";
    }
    
}
