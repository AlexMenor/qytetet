#encoding: utf-8
require "singleton"
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
  
  class Dado
    
    # Clase singleton
    
    include Singleton
    attr_reader:valor
    
    # Método que genera un número entre 1-6
    
    def tirar
      random = Random.new
      @valor = random.rand(6) + 1
      return @valor
    end
    
    # toString()
    
    def to_s
      to_return = "Dado:\n Valor = #{@valor}"
      to_return
    end
  end
end
