
package controladorqytetet;

import java.util.ArrayList;
import modeloqytetet.MetodoSalirCarcel;
import modeloqytetet.EstadoJuego;
import modeloqytetet.Casilla;

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
            validas.add(OpcionMenu.OBTENERRANKING.ordinal());
            switch(modelo.getEstadoJuego()){
                case JA_CONSORPRESA:
                    validas.add(OpcionMenu.APLICARSORPRESA.ordinal());
                    break;
                case JA_ENCARCELADO:
                    validas.add(OpcionMenu.PASARTURNO.ordinal());
                    break;
                case JA_ENCARCELADOCONOPCIONDELIBERTAD:
                    validas.add(OpcionMenu.INTENTARSALIRCARCELTIRANDODADO.ordinal());
                    validas.add(OpcionMenu.INTENTARSALIRCARCELPAGANDOLIBERTAD.ordinal());
                    break;
                case JA_PREPARADO:
                    validas.add(OpcionMenu.JUGAR.ordinal());
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
    
    public String realizarOperacion(int opcionElegida, int casillaElegida){
        opcion = OpcionMenu.values()[opcionElegida];
        String mensajeInformativo = "";
        String nombreJugador = modelo.getJugadorActual().getNombre();
        Casilla casillaActual = modelo.getJugadorActual().getCasillaActual();
        Casilla casillaSeleccionada = modelo.getTablero().obtenerCasillaNumero(casillaElegida);
        
        switch (opcion){
            case INICIARJUEGO:
                modelo.inicializarJuego (nombreJugadores);
                mensajeInformativo = "¡Ha empezado el juego!";
                break;
            case JUGAR:
                modelo.jugar();
                mensajeInformativo = "Valor del dado: " + modelo.getValorDado()
                        + "\nEl jugador " + nombreJugador 
                        + " ha caído en la casilla: " + casillaActual;
                break;
            case APLICARSORPRESA:
                mensajeInformativo = "Sorpresa: " + modelo.getCartaActual();
                modelo.aplicarSorpresa();
                break;
            case INTENTARSALIRCARCELPAGANDOLIBERTAD:
                if (modelo.intentarSalirCarcel(MetodoSalirCarcel.PAGANDOLIBERTAD))
                    mensajeInformativo = nombreJugador + " ha conseguido salir de la cárcel!";
                else
                    mensajeInformativo = nombreJugador + " no ha podido pagar su libertad...";
                
                break;
            case INTENTARSALIRCARCELTIRANDODADO:
                if (modelo.intentarSalirCarcel(MetodoSalirCarcel.TIRANDODADO))
                    mensajeInformativo = nombreJugador + " ha conseguido salir de la cárcel!";
                else
                    mensajeInformativo = nombreJugador + " ha tenido mala suerte con el dado...";
                
                break;
            case COMPRARTITULOPROPIEDAD:
                if (modelo.comprarTituloPropiedad())
                    mensajeInformativo = nombreJugador + " ha comprado " + casillaActual;
                else
                    mensajeInformativo = "No se ha podido efectuar la compra...";
                
                break;
            case VENDERPROPIEDAD:
                modelo.venderPropiedad(casillaElegida);
                mensajeInformativo = nombreJugador + " ha vendido " + 
                        casillaSeleccionada;
                break;
            case HIPOTECARPROPIEDAD:
                modelo.hipotecarPropiedad(casillaElegida);
                mensajeInformativo = nombreJugador + " ha hipotecado " +
                        casillaSeleccionada;
                break;
           case CANCELARHIPOTECA:
                modelo.hipotecarPropiedad(casillaElegida);
                mensajeInformativo = nombreJugador + " ha cancelado la hipoteca de: " +
                        casillaSeleccionada;
                break;
           case EDIFICARCASA:
               if (modelo.edificarCasa(casillaElegida))
                   mensajeInformativo = nombreJugador + " ha edificado una casa en: " +
                           casillaSeleccionada;
               else
                   mensajeInformativo = "No se ha podido edificar la casa ";
                           
               break;
            case EDIFICARHOTEL:
            if (modelo.edificarHotel(casillaElegida))
                mensajeInformativo = nombreJugador + " ha edificado un hotel en: " +
                        casillaSeleccionada;
            else
                mensajeInformativo = "No se ha podido edificar el hotel ";

                break;
            case PASARTURNO:
                modelo.siguienteJugador();
                mensajeInformativo = nombreJugador + " ha preferido pasar turno";
                break;
            case OBTENERRANKING:
                modelo.obtenerRanking();
                mensajeInformativo = "Ranking: " + modelo.getJugadores();
                break;
            case TERMINARJUEGO:
                modelo.obtenerRanking();
                mensajeInformativo = "Se ha terminado el juego\n Ranking: " + 
                        modelo.getJugadores();
                break;
            case MOSTRARJUGADORACTUAL:
                mensajeInformativo = "Jugador actual:\n" + modelo.getJugadorActual();
                break;
            case MOSTRARJUGADORES:
                mensajeInformativo = "Jugadores :\n" + modelo.getJugadores();
                break;
            case MOSTRARTABLERO:
                mensajeInformativo = "Tablero:\n" + modelo.getTablero();
                break;
        }
    
        return mensajeInformativo;
    }
}
