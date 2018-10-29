package modeloqytetet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

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
    
    private void setEstadoJuego (EstadoJuego estado){
        this.estado = estado;
    }
    
    
        // Métodos de inicialización
    
    public void inicializarJuego (ArrayList<String> nombres){
        inicializarTablero();
        inicializarCartasSorpresa();
        inicializarJugadores (nombres);
        salidaJugadores();
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
        
            // Barajamos
        
        Collections.shuffle(mazo);
        
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
        
        numJugadorActual = new Random().nextInt(jugadores.size());
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
        Casilla casillaDestino = tablero.obtenerCasillaFinal(jugadorActual.getCasillaActual(), valor_dado);
        mover (casillaDestino.getNumeroCasilla());
    }
    
    public void obtenerRanking (){
        Collections.sort(jugadores);
    }
    
    public int obtenerSaldoJugadorActual (){
         return jugadorActual.getSaldo();
    }
    
    public Casilla obtenerCasillaJugadorActual(){
        return jugadorActual.getCasillaActual();
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
    
    void actuarSiEnCasillaEdificable (){
        if (jugadorActual.deboPagarAlquiler()){
            jugadorActual.pagarAlquiler();
        }
        
        Casilla casilla = obtenerCasillaJugadorActual();
        
        if (casilla.tengoPropietario()){
            setEstadoJuego (EstadoJuego.JA_PUEDEGESTIONAR);
        }
        else{
            setEstadoJuego (EstadoJuego.JA_PUEDECOMPRAROGESTIONAR);
        }
    }
    
    void actuarSiEnCasillaNoEdificable (){
        setEstadoJuego (EstadoJuego.JA_PUEDEGESTIONAR);
        
        Casilla casillaActual = jugadorActual.getCasillaActual();
        
        if (casillaActual.getTipo() == TipoCasilla.IMPUESTO){
            jugadorActual.pagarImpuesto();
        }
        else{
            if (casillaActual.getTipo() == TipoCasilla.JUEZ){
                encarcelarJugador();
            }
            else if (casillaActual.getTipo() == TipoCasilla.SORPRESA){
                cartaActual = mazo.remove(0);
                setEstadoJuego (EstadoJuego.JA_CONSORPRESA);
            }
        }
        
    }
    
    
    private void encarcelarJugador (){
        if (!jugadorActual.tengoCartaLibertad()){
            Casilla casillaCarcel = tablero.getCarcel();
            jugadorActual.irACarcel(casillaCarcel);
            setEstadoJuego (EstadoJuego.JA_ENCARCELADO);
        }
        else{
            Sorpresa carta = jugadorActual.getCartaLibertad();
            mazo.add (carta);
            setEstadoJuego (EstadoJuego.JA_PUEDEGESTIONAR);
        }
    }
    
    public boolean comprarTituloPropiedad (int numeroCasilla){
        boolean comprado = jugadorActual.comprarTituloPropiedad();
        
        if (comprado){
            setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
        }
        
        return comprado;
    }
    
    public void aplicarSorpresa (){
        setEstadoJuego (EstadoJuego.JA_PUEDEGESTIONAR);
        
        if (cartaActual.getTipo() == TipoSorpresa.SALIRCARCEL)
            jugadorActual.setCartaLibertad(cartaActual);
        else{
            mazo.add(cartaActual);
            switch (cartaActual.getTipo()){

                case PAGARCOBRAR:
                    jugadorActual.modificarSaldo(cartaActual.getValor());
                    if (jugadorActual.getSaldo() < 0)
                        setEstadoJuego (EstadoJuego.ALGUNJUGADORENBANCARROTA);
                    break;
                case IRACASILLA:
                    int valor = cartaActual.getValor();
                    if (tablero.esCasillaCarcel(valor))
                        encarcelarJugador();
                    else
                        mover(valor);
                    break;
                case PORCASAHOTEL:
                    int cantidad = cartaActual.getValor();
                    int numeroTotal = jugadorActual.cuantasCasasHotelesTengo();
                    jugadorActual.modificarSaldo(numeroTotal*cantidad);
                    
                    if (jugadorActual.getSaldo() < 0)
                        setEstadoJuego (EstadoJuego.ALGUNJUGADORENBANCARROTA);
                    break;
                case PORJUGADOR:
                    for (Jugador jugador : jugadores){
                        if (jugador != jugadorActual){
                            
                            jugador.modificarSaldo (cartaActual.getValor());
                            
                            if (jugador.getSaldo() < 0)
                                setEstadoJuego (EstadoJuego.ALGUNJUGADORENBANCARROTA);
 
                            jugadorActual.modificarSaldo(-cartaActual.getValor());
                        
                            if (jugadorActual.getSaldo() < 0)
                                setEstadoJuego(EstadoJuego.ALGUNJUGADORENBANCARROTA);
                        
                        }
                    }
                    break;
            }
        }
    }
    
    public boolean edificarCasa (int numeroCasilla){
        boolean edificada = false;
        
        Casilla casilla = tablero.obtenerCasillaNumero(numeroCasilla);
        TituloPropiedad titulo = casilla.getTitulo();
        
        edificada = jugadorActual.edificarCasa (titulo);
        
        if (edificada)
            setEstadoJuego (EstadoJuego.JA_PUEDEGESTIONAR);
        
        return edificada;
    
    }
    
    public boolean intentarSalirCarcel (MetodoSalirCarcel metodo){
        if (metodo == MetodoSalirCarcel.TIRANDODADO){
            int resultado = tirarDado();
            
            if (resultado >= 5)
                jugadorActual.setEncarcelado(false);
        }
        else if (metodo == MetodoSalirCarcel.PAGANDOLIBERTAD)
            jugadorActual.pagarLibertad (PRECIO_LIBERTAD);
        
        boolean encarcelado = jugadorActual.getEncarcelado();
        
        if (encarcelado)
            setEstadoJuego(EstadoJuego.JA_ENCARCELADO);
        else
            setEstadoJuego(EstadoJuego.JA_PREPARADO);
        
        return !encarcelado;
    }
    
    void mover (int numCasillaDestino){
         Casilla casillaInicial = jugadorActual.getCasillaActual();
         Casilla casillaFinal = tablero.obtenerCasillaNumero(numCasillaDestino);
         
         jugadorActual.setCasillaActual(casillaFinal);
         
         if (numCasillaDestino < casillaInicial.getNumeroCasilla()){
             jugadorActual.modificarSaldo(SALDO_SALIDA);
         }
         
         if (casillaFinal.soyEdificable()){
             actuarSiEnCasillaEdificable();
         }
         else{
             actuarSiEnCasillaNoEdificable();
         }
     }
     
     public void hipotecarPropiedad (int numeroCasilla){
         Casilla casilla = tablero.obtenerCasillaNumero(numeroCasilla);
         TituloPropiedad titulo = casilla.getTitulo();
         
         jugadorActual.hipotecarPropiedad (titulo);
         
         setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
     }
     
     public boolean venderPropiedad (int numeroCasilla){
         Casilla casilla = tablero.obtenerCasillaNumero(numeroCasilla);
         jugadorActual.venderPropiedad (casilla);
         setEstadoJuego(EstadoJuego.JA_PUEDEGESTIONAR);
                 
        return true;
     }
     
     
    /* MÉTODOS A IMPLEMENTAR EN EL FUTURO:
    public boolean cancelarHipoteca (int numeroCasilla);
    public boolean edificarHotel (int numeroCasilla);
    public ArrayList<Casilla> obtenerCasillasTablero ();
    */

    
    
}
