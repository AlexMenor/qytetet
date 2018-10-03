
package modeloqytetet;
import java.util.ArrayList;


public class Jugador {

    private boolean encarcelado = false;
    private String nombre;
    private int saldo = 7500;
    private Sorpresa cartaLibertad;
    private Casilla casillaActual;
    private ArrayList <TituloPropiedad> propiedades;
    
    boolean cancelarHipoteca (TituloPropiedad titulo){
    
        return true;
    }
    
    int cuantasCasasHotelesTengo (){
        return 0;
    }
    
    boolean deboPagarAlquiler (){
        return true;
    }
    
    Sorpresa devolverCartaLibertad(){
        return null;
    }
    
    boolean edificarCasa (TituloPropiedad titulo){
        return true;
    }
    
    boolean edificarHotel (TituloPropiedad titulo){
        return true;
    }
    
    private void eliminarDeMisPropiedades (TituloPropiedad titulo){
    
    }
    
    private boolean esDeMiPropiedad (TituloPropiedad titulo){
        return true;
    }
    
    boolean estoyEnCalleLibre (){
        return true;
    }
    
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
    
    boolean hipotecarPropiedad (TituloPropiedad titulo){
        return true;
    }
    
    void irACarcel (Casilla casilla){
        
    }
    
    int modificarSaldo (int cantidad){
        return 0;
    }
    
    int obtenerCapital (){
        return 0;
    }
    
    ArrayList <TituloPropiedad> obtenerPropiedades (boolean hipotecada){
        return null;
    }
    
    void pagarAlquiler (){
    }
    
    void pagarImpuesto (){
    
    }
    
    void pagarLibertad (int cantidad){
    
    }
    
    void setCartaLibertad (Sorpresa carta){
        cartaLibertad = carta;
    }
    
    void setCasillaActual (Casilla casilla){
        casillaActual = casilla;
    }
    
    void setEncarcelado (boolean encarcelado){
        this.encarcelado = encarcelado;
    }
    
    void setSaldo (int saldo){
        this.saldo = saldo;
    }
    
    boolean tengoCartaLibertad (){
        return true;
    }
    
    private boolean tengoSaldo (int cantidad){
        return true;
    }
    
    boolean venderPropiedad (Casilla casilla){
        return true;
    }
    
    
    
    
    
}
