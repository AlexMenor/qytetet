
package modeloqytetet;


public class Especulador extends Jugador {
    private int fianza;
    
    // Método para pagar impuesto 
    
    protected void pagarImpuesto (int cantidad){
    }
    
    // Método para obtener el factor de especulador
//    @Override
//    protected int getFactorEspeculador(){}
    
    // Constructor de especulador
    
    protected Especulador (Jugador jugador, int fianza){
        super (jugador);
        this.fianza = fianza;
    }
    
    // Método para convertirse
    @Override
    protected Especulador convertirme (int fianza){
        return this;
    }
    
//    // Método para consultar si el especulador debe ir a la cárcel
//    
//    @Override
//    protected boolean deboIrACarcel(){}
//    
//    // Método privado para pagar la fianza
//    
//    private boolean pagarFianza(){}
//    
//    // Método que sobreescribe el de jugador y devuelve si puede edificar una casa
//    
//    @Override
//    protected boolean puedoEdificarCasa(){}
//    
//    // Método que sobreescribe el de jugador y devuelve si puede edificar una casa
//    
//    @Override
//    protected boolean puedoEdificarHotel(){}
    
}
