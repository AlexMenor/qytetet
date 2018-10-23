package modeloqytetet;
import java.util.ArrayList;

    /* 
     Esta clase representa
     una un juego completo de 
     qytetet, con tablero
     y cartas sorpresa
    */

public class Qytetet {
    
        // Parametros del juego constantes
    
    public static final int MAX_JUGADORES = 4;
    static final int NUM_SORPRESAS = 10;
    public static final int NUM_CASILLAS = 20;
    static final int PRECIO_LIBERTAD = 200;
    static final int SALDO_SALIDA = 1000;

// Atributos privados
    
        // Mazo con las cartas sorpresa
    private ArrayList <Sorpresa> mazo;
        // Tablero con las casillas del juego
    private Tablero tablero;
        // Dado del juego
    private Dado dado;
        // Carta sorpresa actual
    private Sorpresa cartaActual;
        // Vector con los jugadores actuales
    private ArrayList<Jugador> jugadores;
        // Jugador cuyo turno está en curso
    private Jugador jugadorActual;
        // Estado del juego
    private EstadoJuego estado;
        // Número del jugador actual
    private int numJugadorActual;
    
    
    // Singleton
    
    private static final Qytetet instance = new Qytetet ();
    
    private Qytetet (){}
    
    public static Qytetet getInstance () {return instance;}
    
// Consultores
    
    Tablero getTablero (){return tablero;}
    
    ArrayList <Sorpresa> getMazo () {return mazo;}
    
    public Sorpresa getCartaActual () {return cartaActual;}
    
    Dado getDado() {return dado;}
    
    Jugador getJugadorActual () {return jugadorActual;}
    
    public ArrayList <Jugador> getJugadores () {return jugadores;}
        
    /*
        Método modificador de la
        carta sorpresa actual
    */
    
    private void setCartaActual (Sorpresa carta){
        cartaActual = carta;
    }
    
    
        // Métodos de inicialización
    
    public void inicializarJuego (ArrayList<String> nombres){
        inicializarTablero();
        inicializarCartasSorpresa();
        inicializarJugadores (nombres);
    }
    
     private void inicializarTablero (){tablero = new Tablero ();}
    
    /*
        Inicializa las cartas sopresa con las
        características que hemos decidido
    */
    
    private void inicializarCartasSorpresa (){
        mazo = new ArrayList <> ();
        
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
    
    /*
        Inicializa los jugadores
        según un array de nombres
    */
    
    private void inicializarJugadores (ArrayList<String> nombres){
        jugadores = new ArrayList <> ();
        
        for (String nombre : nombres){
            jugadores.add (new Jugador(nombre));
        }
    }  
    
    // Método toString de la clase
    @Override
    public String toString() {
        return "Qytetet{" 
                + "mazo=" + mazo 
                + ", tablero=" + tablero 
                + ", dado=" + dado 
                + ", cartaActual=" + cartaActual 
                + ", jugadores=" + jugadores 
                + ", jugadorActual=" + jugadorActual + "}";
                
    }
    
    public void siguienteJugador (){
        numJugadorActual = (jugadores.indexOf(jugadorActual)+1) % jugadores.size();
        jugadorActual = jugadores.get(numJugadorActual);
                
        if (jugadorActual.getEncarcelado())
           estado = EstadoJuego.JA_ENCARCELADOCONOPCIONDELIBERTAD;
        else
           estado = EstadoJuego.JA_PREPARADO;
    }
    
    private void salidaJugadores (){
        for (Jugador jug : jugadores){
            jug.setCasillaActual(tablero.getCasillas().get(0));
        }
        
        numJugadorActual = (int) Math.floor(Math.random() * (jugadores.size()+1));
        jugadorActual = jugadores.get(numJugadorActual);
        
        estado = EstadoJuego.JA_PREPARADO;
    }
    
    public ArrayList<Integer> obtenerPropiedadesJugador (){
        ArrayList<Integer> aDevolver = new ArrayList<>();
        
        aDevolver = obtenerPropiedadesJugadorSegunEstadoHipoteca (true);
        
        for (int numero : obtenerPropiedadesJugadorSegunEstadoHipoteca (false)){
            aDevolver.add(numero);
        }
        
        return aDevolver;
    }
    
    public ArrayList<Integer> obtenerPropiedadesJugadorSegunEstadoHipoteca (boolean estadoHipoteca){
        ArrayList<Integer> aDevolver = new ArrayList <> ();
        ArrayList<TituloPropiedad> propiedades = new ArrayList <> ();
        
        propiedades = jugadorActual.obtenerPropiedades(estadoHipoteca);
        
        for (Casilla casilla : tablero.getCasillas()){
            if (casilla.getTitulo() != null){
                if (propiedades.contains(casilla.getTitulo())){
                    aDevolver.add(casilla.getNumeroCasilla());
                }
            }
        }
        
        return aDevolver;
    }
    
    public boolean jugadorActualEncarcelado (){
        return (jugadorActual.getEncarcelado());
    }
    
    public void jugar (){
        int valor_dado = tirarDado();
        tablero.obtenerCasillaFinal(jugadorActual.getCasillaActual(), valor_dado);
        // mover ();
    }
    
    public void obtenerRanking (){
        
    }
    
    public int obtenerSaldoJugadorActual (){
         return jugadorActual.getSaldo();
    }
    
    boolean jugadorActualEnCalleLibre (){
        return jugadorActual.situadoEnCalleLibre();
    }
    
    int tirarDado (){
        return dado.tirar();
    }
    
    int getValorDado (){
        return dado.getValor();
    }
    
    /* MÉTODOS A IMPLEMENTAR EN EL FUTURO:
    void actuarSiEnCasillaEdificable ();
    void actuarSiEnCasillaNoEdificable ();
    public void aplicarSorpresa ();
    public boolean cancelarHipoteca (int numeroCasilla);
    public boolean comprarTituloPropiedad (int numeroCasilla);
    public boolean edificarCasa (int numeroCasilla);
    public boolean edificarHotel (int numeroCasilla);
    private void encarcelarJugador ();
    public int getValorDado ();
    public void hipotecarPropiedad (int numeroCasilla);
    public boolean intentarSalirCarcel (MetodoSalirCArcel metodo);
    
    void mover (int numCasillaDestino);
    
    public ArrayList<Casilla> obtenerCasillasTablero ();
    
    
   
    
    
    public boolean venderPropiedad (int numeroCasilla);
    */

    
    
}
