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
    private static final Scanner in2 = new Scanner (System.in);
        
    private static ArrayList<String> getNombreJugadores (){
        int n_jugadores = in2.nextInt();
        
        ArrayList<String> nombres = new ArrayList <> (); 
        
        for (int i = 1; i <= n_jugadores; i++){
            System.out.println("Introduce el jugador " + i);
            String s = in.nextLine ();
            nombres.add(s);
        }
        
        return nombres;
    }
    
    public static void main(String[] args) {
        
            // Declarados para probar los métodos de esta clase
        
        juego = Qytetet.getInstance();
        juego.inicializarJuego(getNombreJugadores());
        
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
            
            System.out.println(tipos);
        }
        
        System.out.println(juego.getTablero());
        
        System.out.println("Jugadores: ");
        
        for (Jugador jugador : juego.getJugadores()){
            System.out.println(jugador.toString());
        }
               
        System.out.println("Juego: ");
        System.out.println(juego);
        
    }
    
}
