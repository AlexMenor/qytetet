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
require_relative "../ModeloQytetet/tablero"
require_relative "../ModeloQytetet/tipo_casilla"
require_relative "../ModeloQytetet/tipo_sorpresa"
require_relative "../ModeloQytetet/titulo_propiedad"

module ModeloQytetet
  class Casilla
  end
  class OtraCasilla < Casilla
    attr_accessor :tipo
    def initialize (numero_casilla, tipo)
      coste = tipo == ModeloQytetet::TipoCasilla::IMPUESTO ? ModeloQytetet::Qytetet.coste_impuesto : 0 
      super(numero_casilla, coste)
      @tipo = tipo
    end
  
    # Consultor del titulo, devuelve nil ya que solo las calles tienen titulo
  
    def titulo
      return nil
    end
  
    #Comprueba si la casilla es edificable, devuelve false porque solo las calles lo son
  
    def soy_edificable
      return false
    end
    
    def tengo_propietario
      return false
    end
  
    def to_s
      to_return = super
      to_return += "Tipo: #{@tipo}"
      
      return to_return
    end
  end
end
