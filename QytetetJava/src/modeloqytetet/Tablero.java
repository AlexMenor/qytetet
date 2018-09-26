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
    
    // Atributos privados
    
    private ArrayList<Casilla> casillas; // Vector de casillas del tablero
    private Casilla carcel; // Casilla que contiene la cárcel
    
    /* 
        Método privado que inicializa el tablero con las características 
        que hemos decidido
    */
    
    private void inicializar(){
        casillas = new ArrayList<>();
        
        casillas.add (new Casilla (0, TipoCasilla.SALIDA));
        casillas.add (new Casilla (1, new TituloPropiedad ("Huerto de "
                + "Calixto y Melibea", 200, 50, (float)1.2, 150, 250)));
        casillas.add (new Casilla (2, new TituloPropiedad ("Avda de los"
                + " cipreses", 350, 55, (float)1.3, 200, 255)));
        casillas.add (new Casilla (3, new TituloPropiedad ("Avda Carmen"
                + " Martín Gaite", 400, 60, (float)1.4, 300, 300)));
        casillas.add (new Casilla (4, TipoCasilla.PARKING));
        casillas.add (new Casilla (5, new TituloPropiedad ("Calle Cuarta", 
                425, 62, (float)1.4, 400, 325)));
        casillas.add (new Casilla (6, new TituloPropiedad ("Avda Vicente del"
                + "bosque", 460, 67, (float)1.43, 450, 350)));
        casillas.add (new Casilla (7, TipoCasilla.SORPRESA));
        casillas.add (new Casilla (8, new TituloPropiedad ("Rana de la "
                + "Universidad", 500, 70, (float)1.5, 475, 400)));
        carcel = new Casilla(9, TipoCasilla.CARCEL);
        casillas.add (carcel);
        casillas.add (new Casilla (10, new TituloPropiedad ("Palacio de "
                + "Monterrey", 600, 75, (float)1.6, 500, 450)));
        casillas.add (new Casilla (11, new TituloPropiedad ("Plaza de "
                + "Barcelona", 750, 80, (float)1.65, 600, 475)));
        casillas.add (new Casilla (12, TipoCasilla.JUEZ));
        casillas.add (new Casilla (13, new TituloPropiedad ("Ieronimus", 800,
                85, (float)1.7, 700, 500)));
        casillas.add (new Casilla (14, TipoCasilla.SORPRESA));
        casillas.add (new Casilla (15, new TituloPropiedad ("Puente romano",
                900, 90, (float)1.75, 850, 550)));
        casillas.add (new Casilla (16, new TituloPropiedad ("Catedral de "
                + "Salamanca", 1000, 95, (float)1.9, 900, 600)));
        casillas.add (new Casilla (17, TipoCasilla.IMPUESTO));
        casillas.add (new Casilla (18, TipoCasilla.SORPRESA));
        casillas.add (new Casilla (19, new TituloPropiedad ("Gran Vía", 1500,
                100, (float)1.95, 1000, 700)));
    }

    // Constructor sin argumentos
    
    public Tablero(){
        inicializar();
    }
    
    // Consultores públicos
    
    public ArrayList<Casilla> getCasillas(){
        return casillas;
    }
    
    public Casilla getCarcel(){
        return carcel;
    }
    
    // Método toString, que muestra las casillas de un tablero
    
    @Override
    public String toString(){
        return "Casillas: " + casillas.toString();
    }
    
}
