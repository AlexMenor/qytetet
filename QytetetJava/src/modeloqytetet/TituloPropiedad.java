package modeloqytetet;
import java.util.ArrayList;
    /* 
     Esta clase representa
     el conjunto de características
     que se asocian a la propiedad
     de una casilla de tipo calle
     en qytetet
    */

public class TituloPropiedad {
    
// Campos privados asociados a la propiedad
    
        // Nombre de la calle
    private String nombre;
        // ¿Está hipotecada?
    private boolean hipotecada = false;
        // Su precio
    private int precioCompra;
        // Precio base por caer en la casilla
    private int alquilerBase;
        /*
           Revalorización de la propiedad entre
           su compra y venta 
        */
    private float factorRevalorizacion;
        // Valor base de su hipoteca
    private int hipotecaBase;
        // Precio de edificación
    private int precioEdificar;
        // Número de casas edificadas
    private int numCasas = 0;
        // Número de hoteles edificados
    private int numHoteles = 0;
    
        // Propietario de del titulo
    private Jugador propietario;
    
        // Constructor
    TituloPropiedad
        (String nombre, int precioCompra, int alquilerBase,
         float factorRevalorizacion, int hipotecaBase, 
         int precioEdificar)
        {
            this.nombre = nombre;
            this.precioCompra = precioCompra;
            this.alquilerBase = alquilerBase;
            this.factorRevalorizacion = factorRevalorizacion;
            this.hipotecaBase = hipotecaBase;
            this.precioEdificar = precioEdificar;
        }
        
// Consultores

    String getNombre() {return nombre;}

    boolean getHipotecada() {return hipotecada;}

    int getPrecioCompra() {return precioCompra;}

    int getAlquilerBase() {return alquilerBase;}

    float getFactorRevalorizacion() {
        return factorRevalorizacion;
    }
    
    int getHipotecaBase() {return hipotecaBase;}

    int getPrecioEdificar() {return precioEdificar;}

    int getNumCasas() {return numCasas;}

    int getNumHoteles() {return numHoteles;}
    
    Jugador getPropietario () {return propietario;}
    
    boolean tengoPropietario (){
        return (propietario != null);
    }
    
    boolean propietarioEncarcelado (){
        return (propietario.getEncarcelado());
    }
    
        // Modificadores
    
    void setHipotecada (boolean hipotecada){
        this.hipotecada = hipotecada;
    }
    
    void setPropietario (Jugador propietario){
        this.propietario = propietario;
    }
    
    // Incrementa el número de casas del titulo propiedad
    
    void edificarCasa (){
        numCasas++;
    }
    
    int pagarAlquiler(){
        int costeAlquiler = calcularCosteAlquiler();
        
        propietario.modificarSaldo(costeAlquiler);
        
        return costeAlquiler;
    
    }
    
    int calcularCosteAlquiler(){
        return alquilerBase + (int) (numCasas * 0.5 + numHoteles * 2 );
    }
    
        // TituloPropiedad toString()

    @Override
    public String toString() {
        String toReturn = "TituloPropiedad{" 
                + "nombre=" + nombre 
                + ", hipotecada=" + hipotecada 
                + ", precioCompra=" + precioCompra 
                + ", alquilerBase=" + alquilerBase 
                + ", factorRevalorizacion=" + factorRevalorizacion 
                + ", hipotecaBase=" + hipotecaBase 
                + ", precioEdificar=" + precioEdificar 
                + ", numCasas=" + numCasas 
                + ", numHoteles=" + numHoteles;
        
        // Solución a el problema de la navegabilidad en doble sentido
        
        if (propietario != null)
                toReturn += ", propietario=" + propietario.getNombre();
        
        return toReturn + '}';
    }

    
    
}
