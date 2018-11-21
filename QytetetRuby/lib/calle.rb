# encoding: utf-8

module ModeloQytetet
  class Calle < Casilla
    attr_reader :titulo
  
    def initialize (numero_casilla, titulo)
      super(numero_casilla, titulo.coste)
      @titulo = titulo
    end
  
    # Asigna un propietario a la calle
  
    def asignar_propietario (jug)
      @titulo.propietario = jug
    end
  
    # Llama al método de mismo nombre de la clase TituloPropiedad
  
    def pagar_alquiler
      coste_alquiler = @titulo.pagar_alquiler
      
      return coste_alquiler
    end
  
    # Llama al método de mismo nombre de la clase TituloPropiedad
    
    def tengo_propietario
      return @titulo.tengo_propietario
    end
  
    # Llama al método de mismo nombre de la clase TituloPropiedad
    
    def propietario_encarcelado
      return @titulo.propietario_encarcelado
    end
  
    # Consultor del tipo de casilla, siempre devuelve calle
  
    def tipo
      return ModeloQytetet::TipoCasilla::CALLE
    end
  
    # Comprueba si una casilla es edificable, devuelve true, ya que las calles son edificables
  
    def soy_edificable
      return true
    end
  
    def to_s
      to_return = super
      to_return += "\nTitulo: #{@titulo}"
      
      return to_return
    end
    
    protected :soy_edificable, :titulo
    private :titulo=
  end
end