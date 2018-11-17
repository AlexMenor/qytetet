package modeloqytetet;
import java.util.ArrayList;
import java.util.Scanner;
    
    /* 
     Esta clase la usamos
     para probar nuestro 
     qytetet
    */

public class PruebaQytetet {

    static Qytetet juego;
    
    // Métodos para probar el mazo
    
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
    
    /*
        Mueve al jugador a la casilla de la clase que se elija
    */
    
    private static void probarMover(){
        System.out.println("A qué casilla quieres moverte: ");
        System.out.println("1. Calle");
        System.out.println("2. Impuesto");
        System.out.println("3. Sorpresa");
        
        String opcion = in.nextLine();
        System.out.println("Casilla antes de llamarlo: ");
        System.out.println(juego.getJugadorActual().getCasillaActual());
        
        switch (opcion){
            case "1":
                juego.mover(3);
                System.out.println("Compramos la propiedad");
                juego.comprarTituloPropiedad();
                System.out.println("Comprada");
                break;
            case "2":
                juego.mover(17);
                break;
            case "3":
                juego.mover(18);
                System.out.println("Carta actual: ");
                System.out.println(juego.getCartaActual());
                juego.aplicarSorpresa();
                break;
        }
        
        System.out.println("Casilla después de llamarlo: ");
        System.out.println(juego.getJugadorActual().getCasillaActual());
        System.out.println("Jugador después de llamarlo: ");
        System.out.println(juego.getJugadorActual());
    }
    
    /*
        Cambia al siguiente jugador y lo mueve a una casilla que se puede
        comprar
    */
    
    private static void probarPagarAlquiler(){
        juego.siguienteJugador();
        System.out.println("Jugador antes de: ");
        System.out.println(juego.getJugadorActual());
        juego.mover(3);
        System.out.println("Jugador después de: ");
        System.out.println(juego.getJugadorActual());
    }
    
    /*
        Prueba de hipotecar una casilla
    */
    
    private static void probarHipotecar(){
        System.out.println("Antes de hipotecar: ");
        System.out.println(juego.getTablero().obtenerCasillaNumero(5));
        System.out.println("Hipotecamos la casilla 5");
        juego.hipotecarPropiedad(5);
        System.out.println(juego.getTablero().obtenerCasillaNumero(5));
        System.out.println("La cancelamos");
        juego.cancelarHipoteca(5);
        System.out.println(juego.getTablero().obtenerCasillaNumero(5));
    }
    
    /*
        Prueba de comprar y vender una propiedad
    */
    
    private static void probarVender(){
        System.out.println("Compramos la 8 primero");
        juego.mover(8);
        juego.comprarTituloPropiedad();
        System.out.println(juego.getJugadorActual());
        
        System.out.println(juego.getTablero().obtenerCasillaNumero(8));
        System.out.println("La vendemos");
        juego.venderPropiedad(8);
        System.out.println(juego.getJugadorActual());
        System.out.println(juego.getTablero().obtenerCasillaNumero(8));
    }
    
    /*
        Prueba de edificar
    */
    
    private static void probarEdificar(){
        System.out.println("Vamos a comprar una propiedad (13) y a edificar un hotel y una casa");
        juego.mover(13);
        juego.comprarTituloPropiedad();
        System.out.println(juego.getTablero().obtenerCasillaNumero(13));
        System.out.println("Ahora edificamos");
        juego.edificarCasa(13);
        juego.edificarHotel(13);
        System.out.println(juego.getTablero().obtenerCasillaNumero(13));
    }
    
    /*
        Prueba del ranking
    */
    
    private static void probarRanking(){
        System.out.println("Primero sin ordenar");
        System.out.println(juego.getJugadores());
        System.out.println("Ahora ordenados");
        juego.obtenerRanking();
        System.out.println(juego.getJugadores());
    }
    
//    public static void main(String[] args) {
//        
//            // Declarados para probar los métodos de esta clase
//        
//        juego = Qytetet.getInstance();
//        juego.inicializarJuego(getNombreJugadores());
//       
//        /*
//        ArrayList<Sorpresa> mayoresQueCero, irACasilla, 
//                tipos, mazoCompleto;
//        
//        mazoCompleto = juego.getMazo();
//        
//          
//        System.out.println("Mazo completo: ");
//        System.out.println(mazoCompleto);
//        
//        mayoresQueCero = sorpresaMayorQueCero(mazoCompleto);
//        System.out.println("Mazo mayores de cero: ");
//        System.out.println(mayoresQueCero);
//        
//        irACasilla = esDeIrACasilla(mazoCompleto);
//        System.out.println("Mazo de ir a casilla: ");
//        System.out.println(irACasilla);
//        
//        System.out.println("Mazos de cada tipo: ");
//        for (TipoSorpresa sorp : TipoSorpresa.values()){
//            tipos = esDeTipo(sorp, mazoCompleto);
//            
//            System.out.println(tipos);
//        }
//        
//        System.out.println(juego.getTablero());
//        
//        System.out.println("Jugadores: ");
//        
//        for (Jugador jugador : juego.getJugadores()){
//            System.out.println(jugador.toString());
//        }
//               
//        System.out.println("Juego: ");
//        System.out.println(juego);
//        */
//       
//        boolean sigue = true;
//        while (sigue){
//            System.out.println("Prueba Qytetet: ");
//            System.out.println("Opción 1: Probar Mover");
//            System.out.println("Opción 2: Probar pagar alquiler");
//            System.out.println("Opción 3: Probar Hipotecar");
//            System.out.println("Opción 4: Probar Vender");
//            System.out.println("Opción 5: Probar Edificar");
//            System.out.println("Opción 6: Probar Ranking");
//            
//            String opcion = in.nextLine();
//            
//            switch (opcion){
//                case "1":
//                    probarMover();
//                    break;
//                case "2":
//                    probarPagarAlquiler();
//                    break;
//                case "3":
//                    probarHipotecar();
//                    break;
//                case "4":
//                    probarVender();
//                    break;
//                case "5":
//                    probarEdificar();
//                    break;
//                case "6":
//                    probarRanking();
//                    break;
//                default:
//                    System.out.println("Número incorrecto");
//                    sigue = false;
//                    break;
//            }
//        }
//    }
    
}
