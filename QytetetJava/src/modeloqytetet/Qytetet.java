package modeloqytetet;
import java.util.ArrayList;

    /* 
     Esta clase representa
     una un juego completo de 
     qytetet, con tablero
     y cartas sorpresa
    */

public class Qytetet {
    
    public static final int MAX_JUGADORES = 4;
    static final int NUM_SORPRESAS = 10;
    public static final int NUM_CASILLAS = 20;
    static final int PRECIO_LIBERTAD = 200;
    static final int SALDO_SALIDA = 1000;

// Atributos privados
    
        // Mazo con las cartas sorpresa
    private ArrayList <Sorpresa> mazo = new ArrayList <> ();
        // Tablero con las casillas del juego
    private Tablero tablero;
    
    private Dado dado;
    
    private Sorpresa cartaActual;
    
    private ArrayList<Jugador> jugadores = new ArrayList <> ();
    
    private Jugador jugadorActual;
    
    
    
    
// Constructor sin argumentos
    
    public Qytetet (String nombres){
        inicializarJuego (String nombres);
    }
    
// Consultores
    
    Tablero getTablero (){return tablero;}
    
    ArrayList <Sorpresa> getMazo () {return mazo;}
    
   public Sorpresa getCartaActual () {return cartaActual;}
    
    Dado getDado() {return dado;}
    
    Jugador getJugadorActual () {return jugadorActual;}
    
    public ArrayList <Jugador> getJugadores () {return jugadores;}
    
    
    public void inicializarJugadores (String nombres){
        for (String nombre : nombres){
            jugadores.add (new Jugador(nombre, false, 7500));
        }
    }  
        /*
        Inicializa las cartas sopresa con las
        características que hemos decidido
        */
    
    private void setCartaActual (Sorpresa carta){
        cartaActual = carta;
    }
    
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
    
    private void inicializarJuego (String nombres){
        inicializarTablero();
        inicializarCartasSorpresa();
        inicializarJugadores (nombres);
    }
    
    @Override
    public String toString(){
        
        String aDevolver;
        
        aDevolver =  "Qytetet{MAX_JUGADORES: "+ MAX_JUGADORES + 
                "\nNUM_SORPRESAS: " + NUM_SORPRESAS + 
                "\nNUM_CASILLAS: " + NUM_CASILLAS +
                "\nPRECIO_LIBERTAD: "+ PRECIO_LIBERTAD +
                "\nSALDO_SALIDA: "+ SALDO_SALIDA +
                "\nMazo: " + mazo +
                "\nTablero: " + tablero + 
                "\nDado: " + dado;
        
                if (cartaActual != null){
                    aDevolver += "\nCarta actual: " + cartaActual;
                }
                
                aDevolver += "}";
                
                return aDevolver;
    }
    
}
