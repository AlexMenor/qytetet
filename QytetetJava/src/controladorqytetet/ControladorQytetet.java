
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
    
    public ArrayList<Integer> obtenerOperacionesJuegoValidas(){
        ArrayList<Integer> validas = new ArrayList<>();
        
        if(modelo.getJugadores().isEmpty()){
            validas.add(OpcionMenu.INICIARJUEGO.ordinal());
        }
        else{
            validas.add(OpcionMenu.TERMINARJUEGO.ordinal());
            validas.add(OpcionMenu.MOSTRARJUGADORACTUAL.ordinal());
            validas.add(OpcionMenu.MOSTRARJUGADORES.ordinal());
            validas.add(OpcionMenu.MOSTRARTABLERO.ordinal());
            switch(modelo.getEstadoJuego()){
                case JA_CONSORPRESA:
                    validas.add(OpcionMenu.APLICARSORPRESA.ordinal());
                    break;
                case JA_ENCARCELADO:
                    validas.add(OpcionMenu.PASARTURNO.ordinal());
                    break;
                case JA_ENCARCELADOCONOPCIONDELIBERTAD:
                    validas.add(OpcionMenu.INTENTARSALICARCELTIRANDODADO.ordinal());
                    validas.add(OpcionMenu.INTENTARSALIRCARCELPAGANDOLIBERTAD.ordinal());
                    break;
                case JA_PREPARADO:
                    validas.add(OpcionMenu.JUGAR.ordinal());
                    break;
                case ALGUNJUGADORENBANCARROTA:
                    validas.add(OpcionMenu.OBTENERRANKING.ordinal());
                    break;
                case JA_PUEDEGESTIONAR:
                    validas.add(OpcionMenu.PASARTURNO.ordinal());
                    validas.add(OpcionMenu.VENDERPROPIEDAD.ordinal());
                    validas.add(OpcionMenu.HIPOTECARPROPIEDAD.ordinal());
                    validas.add(OpcionMenu.CANCELARHIPOTECA.ordinal());
                    validas.add(OpcionMenu.EDIFICARCASA.ordinal());
                    validas.add(OpcionMenu.EDIFICARHOTEL.ordinal());
                    break;
                case JA_PUEDECOMPRAROGESTIONAR:
                    validas.add(OpcionMenu.PASARTURNO.ordinal());
                    validas.add(OpcionMenu.COMPRARTITULOPROPIEDAD.ordinal());
                     validas.add(OpcionMenu.VENDERPROPIEDAD.ordinal());
                    validas.add(OpcionMenu.HIPOTECARPROPIEDAD.ordinal());
                    validas.add(OpcionMenu.CANCELARHIPOTECA.ordinal());
                    validas.add(OpcionMenu.EDIFICARCASA.ordinal());
                    validas.add(OpcionMenu.EDIFICARHOTEL.ordinal());
                    break;
            }
        }
        
        return validas;
    }
    
    //public boolean necesitaElegirCasilla (int opcionMenu){}
    
    //public ArrayList<int> obtenerCasillasValidas(int opcionMenu){}
    
    //public String realizarOperacion(int opcionElegida, int casillaElegida){}
    
}
