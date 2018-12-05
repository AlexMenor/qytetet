
package controladorqytetet;

import java.util.ArrayList;
import modeloqytetet.MetodoSalirCarcel;
import modeloqytetet.EstadoJuego;

public class ControladorQytetet {
    // Atributos
    private OpcionMenu opcion;
    private modeloqytetet.Qytetet modelo;
    private ArrayList<String> nombreJugadores = new ArrayList<>();
    
    //Métodos públicos
    
    public void setNombreJugadores(ArrayList<String> nombres){
        nombreJugadores = nombres;
    }
    
    //public ArrayList<int> obtenerOperacionesJuegoValidas(){}
    
    //public boolean necesitaElegirCasilla (int opcionMenu){}
    
    //public ArrayList<int> obtenerCasillasValidas(int opcionMenu){}
    
    //public String realizarOperacion(int opcionElegida, int casillaElegida){}
    
}
