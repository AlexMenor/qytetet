
package modeloqytetet;


public class Especulador extends Jugador {
    private int fianza;
    
    
    // Constructor de especulador
    protected Especulador (Jugador jugador, int fianza){
        super (jugador);
        this.fianza = fianza;
    }
    
    // Método para pagar impuesto 
    @Override
    protected void pagarImpuesto (){
        modificarSaldo (-(getCasillaActual().getCoste()/2));
    }
    
    // Método para consultar si el especulador debe ir a la cárcel
    
    @Override
    protected boolean deboIrACarcel(){
        boolean debe_ir = false;
        debe_ir = super.deboIrACarcel();
        if (!debe_ir)
            debe_ir = !pagarFianza();
        return debe_ir;
    }
    
    // Método privado para pagar la fianza
    
    private boolean pagarFianza(){
        boolean pagada = false;
        
        if (getSaldo() > fianza){
            modificarSaldo(-fianza);
            pagada = true;
        }
        return pagada;
    }
    
    // Método para obtener el factor de especulador
//    @Override
//    protected int getFactorEspeculador(){}
    
    // Método para convertirse
    @Override
    protected Especulador convertirme (int fianza){
        return this;
    }

    // Método que sobreescribe el de jugador y devuelve si puede edificar una casa
    
    @Override
    protected boolean puedoEdificarCasa(TituloPropiedad titulo){
        return tengoSaldo(titulo.getPrecioEdificar()) && titulo.getNumCasas() < 8 && titulo.getNumHoteles() == 0;
    }
    
    // Método que sobreescribe el de jugador y devuelve si puede edificar una casa
    
    @Override
    protected boolean puedoEdificarHotel(TituloPropiedad titulo){
        boolean tengo_suficientes_casas = titulo.getNumCasas() == 8;
        return tengoSaldo(titulo.getPrecioEdificar()) && ((titulo.getNumHoteles() == 0 && tengo_suficientes_casas)
                || (titulo.getNumHoteles() < 8 && titulo.getNumHoteles() > 0));
    }
    
    @Override
    public String toString(){
        String aDevolver = super.toString().substring(0, super.toString().length()-1);
        aDevolver += ", Fianza= ";
        aDevolver += fianza;
        
        return aDevolver + '}';
    }
    
}
