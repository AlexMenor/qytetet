package modeloqytetet;


public class OtraCasilla extends Casilla{
    private TipoCasilla tipo;
    
    OtraCasilla (int numeroCasilla, TipoCasilla tipo){
        super (numeroCasilla, tipo == TipoCasilla.IMPUESTO ? Qytetet.COSTE_IMPUESTO : 0);
        this.tipo = tipo;
    }

    @Override
    protected TipoCasilla getTipo() {
        return tipo;
    }

    @Override
    protected TituloPropiedad getTitulo() {
        return null;
    }

    @Override
    protected boolean soyEdificable() {
        return false;
    }

    @Override
    public String toString() {
        return "\nNúmero de casilla: " + super.getNumeroCasilla() +
                "\nCoste: " + super.getCoste() +
                "\nTipo: " + tipo;
    }
    
    /* Implementados para evitar errores de compilación */
    
    @Override
    boolean tengoPropietario() {
        return false;
    }

    @Override
    void asignarPropietario(Jugador jugador) {}

    @Override
    public int pagarAlquiler() {
        return 0;
    }

    @Override
    boolean propietarioEncarcelado() {
        return false;
    }

    @Override
    void setTitulo(TituloPropiedad titulo) {}
    
    
}
