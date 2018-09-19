/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

/**
 *
 * @author alex
 */
public class PruebaQytetet {

    static Qytetet juego;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        juego = new Qytetet();
        juego.inicializarCartasSorpresa();
        
        System.out.println(juego.getMazo().toString());
        
        
    }
    
}
