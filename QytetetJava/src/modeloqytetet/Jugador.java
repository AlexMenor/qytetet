
package modeloqytetet;
import java.util.ArrayList;

/*
Esta clase representa a cada jugador de qytetet
*/

public class Jugador implements Comparable{
    
    // Atributos privados de jugador

    private boolean encarcelado = false;
    private String nombre;
    private int saldo = 7500;
    private Sorpresa cartaLibertad;
    private Casilla casillaActual;
    private ArrayList <TituloPropiedad> propiedades;
    
        // Posiblemente declaremos por defecto casillaActual a la de salida

    Jugador(String nombre) {
        this.nombre = nombre;
    }
    
    // Modificadores 
    
    void setCartaLibertad (Sorpresa carta){
        cartaLibertad = carta;
    }
    
    void setCasillaActual (Casilla casilla){
        casillaActual = casilla;
    }
    
    void setEncarcelado (boolean encarcelado){
        this.encarcelado = encarcelado;
    }
    
    // Consultores 
     Sorpresa getCartaLibertad (){
        return cartaLibertad;
    }
    
    Casilla getCasillaActual (){
        return casillaActual;
    }
    
    boolean getEncarcelado (){
        return encarcelado;
    }
    
    String getNombre(){
        return nombre;
    }
    
    ArrayList <TituloPropiedad> getPropiedades(){
        return propiedades;
    }
    
    public int getSaldo (){
        return saldo;
    }
    
     
    boolean edificarCasa (TituloPropiedad titulo){
        boolean edificada = false;
        
        int numCasas = titulo.getNumCasas();
        
        if (numCasas < 4){
            int costeEdificarCasa = titulo.getPrecioEdificar();
            if (tengoSaldo(costeEdificarCasa)){
                titulo.edificarCasa();
                modificarSaldo(-costeEdificarCasa);
                edificada = true;
            }
        }
        
        return edificada;
    }
    
    void pagarLibertad (int cantidad){
        if (tengoSaldo(cantidad)){
            setEncarcelado(false);
            modificarSaldo(-cantidad);
        }
    }
    
        
    
    void pagarAlquiler (){
        int costeAlquiler = casillaActual.pagarAlquiler();
        
        modificarSaldo(-costeAlquiler);
    }
 

    /* Por implementar
    boolean cancelarHipoteca (TituloPropiedad titulo){
    
        return true;
    }
    
    
    boolean deboPagarAlquiler (){
        return true;
    }
    
   
    
    boolean edificarHotel (TituloPropiedad titulo){
        return true;
    }
    
    private void eliminarDeMisPropiedades (TituloPropiedad titulo){
    
    }
    
    boolean estoyEnCalleLibre (){
        return true;
    }
    boolean hipotecarPropiedad (TituloPropiedad titulo){
        return true;
    }
    
    void irACarcel (Casilla casilla){
        
    }
    
   
    
    
    

    
    
    
    
    
   
    
    boolean venderPropiedad (Casilla casilla){
        return true;
    }
    */
    
    // Devuelve true si el usuario tiene más que la cantidad pasada como parámetro
    
     private boolean tengoSaldo (int cantidad){
        return saldo > cantidad;
    }
    
    // Devuelve los titulos de propiedad que estén o no hipotecados (dependiendo
    // del parametro booleano)
    
    ArrayList <TituloPropiedad> obtenerPropiedades (boolean hipotecada){
        ArrayList <TituloPropiedad> toReturn = new ArrayList <> ();
        
        for (TituloPropiedad cadaPropiedad : propiedades){
            if (cadaPropiedad.getHipotecada() == hipotecada)
                toReturn.add(cadaPropiedad);
        }
        
        return toReturn;    
    }
    
    // Modifica el saldo del usuario y lo devuelve
     int modificarSaldo (int cantidad){
         saldo += cantidad;
         
        return saldo;
    }
    
    
    // Método para consultar si un jugador tiene una propiedad que 
    // se pasa por argumento
    
    boolean esDeMiPropiedad (TituloPropiedad titulo){
        return propiedades.contains(titulo);
    }
    
    // Método para consultar si un jugador tiene una carta libertad
    
    boolean tengoCartaLibertad(){
        return cartaLibertad != null;
    }
    
    // Se paga el impuesto de la casilla actual
    
    void pagarImpuesto (){
        saldo -= casillaActual.getCoste();
    }
    
    // Devuelve el capital total, compuesto del saldo y el valor de todas sus
    // propiedades
    
    int obtenerCapital (){
        int toReturn = getSaldo();
        
        if (propiedades != null){
            for (TituloPropiedad cadaPropiedad : propiedades){
                int valorDeLaPropiedad = cadaPropiedad.getPrecioCompra();

                int numTotalDeEdificaciones = 
                        cadaPropiedad.getNumCasas() + cadaPropiedad.getNumHoteles();

                valorDeLaPropiedad += (numTotalDeEdificaciones * cadaPropiedad.getPrecioEdificar());

                if (cadaPropiedad.getHipotecada())
                    valorDeLaPropiedad -= cadaPropiedad.getHipotecaBase();

                toReturn += valorDeLaPropiedad;
            }
        }
        
        return toReturn;
    }
    
    // Devuelve la carta de libertad del jugador (se la quita)
    
    Sorpresa devolverCartaLibertad () {
    Sorpresa tmp = cartaLibertad;
    cartaLibertad = null;
    
    return tmp;
    }
    
    // Devuelve el número total de casas y hoteles pertenecientes al jugador
    int cuantasCasasHotelesTengo (){
        int toReturn = 0;
        
        for (TituloPropiedad cadaPropiedad : propiedades)
            toReturn += (cadaPropiedad.getNumCasas() + cadaPropiedad.getNumHoteles());
        
        return toReturn;
    }
    
    public boolean situadoEnCalleLibre (){
        return (casillaActual.soyEdificable() && 
                casillaActual.tengoPropietario());
    }
    
    void irACarcel (Casilla casilla){
        setCasillaActual (casilla);
        setEncarcelado (true);
    }
    
    boolean comprarTituloPropiedad(){
        boolean comprado = false;
        
        int costeCompra = casillaActual.getCoste();
        
        if (costeCompra < saldo){
            TituloPropiedad titulo = casillaActual.asignarPropietario (this);
            comprado = true;
            propiedades.add (titulo);
            modificarSaldo (saldo-costeCompra);
        }
        
        return comprado;
    }
    
    // Implementación de la interfaz Comparable
    
    @Override
    public int compareTo(Object t) {
       return ((Jugador) t).obtenerCapital() - this.obtenerCapital();
    }
    
    @Override
    public String toString() {
        return "Jugador{" 
                + "encarcelado=" + encarcelado 
                + ", nombre=" + nombre 
                + ", saldo=" + saldo 
                + ", capital=" + obtenerCapital()
                + ", cartaLibertad=" + cartaLibertad 
                + ", casillaActual=" + casillaActual 
                + ", propiedades=" + propiedades + '}';
    }  
}
