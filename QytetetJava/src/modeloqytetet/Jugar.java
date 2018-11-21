package modeloqytetet;
import java.util.ArrayList;
import java.util.Scanner;

public class Jugar {
    static Qytetet juego;
    private static final Scanner in = new Scanner (System.in);
        
    private static ArrayList<String> getNombreJugadores (){
        
        System.out.println("Introduzca el número de jugadores: ");
        String line = in.nextLine();
        int n_jugadores = Integer.parseInt(line);
        
        ArrayList<String> nombres = new ArrayList <> (); 
        
        for (int i = 1; i <= n_jugadores; i++){
            System.out.println("Introduce el jugador " + i);
            String s = in.nextLine ();
            nombres.add(s);
        }
        
        return nombres;
    }
    
 
//    public static void main (String [] args){
//        
//        juego = Qytetet.getInstance();
//        juego.inicializarJuego(getNombreJugadores());
//        boolean juegoFinalizado = false;
//        
//        while (!juegoFinalizado){
//            Jugador jugadorActual = juego.getJugadorActual();
//            System.out.println("Es el turno de: " + jugadorActual.getNombre());
//            
//            if (juego.getEstadoJuego() == EstadoJuego.JA_PREPARADO){
//                juego.jugar();
//                System.out.println("Se tira el dado y sale: " + juego.getValorDado());
//                System.out.println("Ha caido en la casilla: " + jugadorActual.getCasillaActual().getNumeroCasilla());
//                if (jugadorActual.getCasillaActual().soyEdificable())
//                    juego.actuarSiEnCasillaEdificable();
//                else
//                    juego.actuarSiEnCasillaNoEdificable();
//                
//                EstadoJuego estadoActual = juego.getEstadoJuego();
//                boolean siguienteTurno = false;
//                while (!siguienteTurno){
//                    switch (estadoActual){
//                        case ALGUNJUGADORENBANCARROTA:
//                            System.out.println("El jugador: " + jugadorActual.getNombre() + " ha caído en bancarrota");
//                            juego.obtenerRanking();
//                            juegoFinalizado = true;
//                            break;
//                        case JA_CONSORPRESA:
//                            System.out.println("Se ha caído en la casilla sorpresa");
//                            System.out.println(juego.getCartaActual().getTexto());
//                            juego.aplicarSorpresa();
//                            break;
//                        /*case JA_ENCARCELADO:
//                            System.out.println("El jugador: " + jugadorActual.getNombre() + " ha sido encarcelado");
//                            siguienteTurno = true;
//                            break;
//                        case JA_ENCARCELADOCONOPCIONDELIBERTAD*/
//                        case JA_PUEDEGESTIONAR:
//                    }
//                }
//            
//            }
//        
//        
//        
//        }
//        
//    }
}
