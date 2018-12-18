# encoding: utf-8
require_relative "../ModeloQytetet/qytetet"
require_relative "../ControladorQytetet/opcion_menu"
require_relative "../ControladorQytetet/controlador_qytetet"
require_relative "../ModeloQytetet/calle"
require_relative "../ModeloQytetet/casilla"
require_relative "../ModeloQytetet/dado"
require_relative "../ModeloQytetet/especulador"
require_relative "../ModeloQytetet/estado_juego"
require_relative "../ModeloQytetet/jugador"
require_relative "../ModeloQytetet/metodo_salir_carcel"
require_relative "../ModeloQytetet/otra_casilla"
require_relative "../ModeloQytetet/sorpresa"
require_relative "../ModeloQytetet/sorpresa"
require_relative "../ModeloQytetet/tablero"
require_relative "../ModeloQytetet/tipo_casilla"
require_relative "../ModeloQytetet/tipo_sorpresa"
require_relative "../ModeloQytetet/titulo_propiedad"
module ModeloQytetet
  class Calle < Casilla
    attr_accessor :titulo
  
    def initialize (numero_casilla, titulo)
      super(numero_casilla, titulo.precio_compra)
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
  end
end