package modeloqytetet;


public class Calle extends Casilla {
    private TituloPropiedad titulo;

    Calle (int numeroCasilla, TituloPropiedad titulo){
        super (numeroCasilla, titulo.getPrecioCompra());
        this.titulo = titulo;
    }
    
    @Override
    public void asignarPropietario (Jugador jugador){
        titulo.setPropietario(jugador);
    }

    @Override
    protected TipoCasilla getTipo() {
        return TipoCasilla.CALLE;
    }

    @Override
    protected TituloPropiedad getTitulo() {
        return titulo;
    }

    @Override
    protected boolean soyEdificable() {
       return true;
    }
    
    @Override
    public int pagarAlquiler (){
        return titulo.pagarAlquiler();
    }
    
    @Override
    void setTitulo (TituloPropiedad titulo){
        this.titulo = titulo;
    }
    
     
    @Override
    boolean tengoPropietario(){
        return titulo.tengoPropietario();
    }
    
      
    @Override
    boolean propietarioEncarcelado(){
        return titulo.propietarioEncarcelado();
    }

    @Override
    
    public String toString(){
        return "\nNúmero de Casilla: " + super.getNumeroCasilla() +
                "\nCoste: " + super.getCoste() +
                "\nTITULO: " + titulo;
    }
    
    
}
