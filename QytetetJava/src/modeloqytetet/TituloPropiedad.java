/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

/**
 *
 * @author alex
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
    
        // Constructor
    public TituloPropiedad
        (String nombre, int precioCompra, int alquilerBase,
         int factorRevalorizacion, int hipotecaBase, 
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

    public String getNombre() {return nombre;}

    public boolean isHipotecada() {return hipotecada;}

    public int getPrecioCompra() {return precioCompra;}

    public int getAlquilerBase() {return alquilerBase;}

    public float getFactorRevalorizacion() {
        return factorRevalorizacion;
    }
    
    public int getHipotecaBase() {return hipotecaBase;}

    public int getPrecioEdificar() {return precioEdificar;}

    public int getNumCasas() {return numCasas;}

    public int getNumHoteles() {return numHoteles;}
    
        // Modificador hipotecada
    
    public void setHipotecada (boolean hipotecada){
        this.hipotecada = hipotecada;
    }
    
        // TituloPropiedad toString()

    @Override
    public String toString() {
        return "TituloPropiedad{" + "nombre=" + nombre 
                + ", hipotecada=" + hipotecada 
                + ", precioCompra=" + precioCompra 
                + ", alquilerBase=" + alquilerBase 
                + ", factorRevalorizacion=" + factorRevalorizacion 
                + ", hipotecaBase=" + hipotecaBase 
                + ", precioEdificar=" + precioEdificar 
                + ", numCasas=" + numCasas 
                + ", numHoteles=" + numHoteles + '}';
    }
    
    
    
        
    
    
    
}
