# encoding: utf-8
require_relative "metodo_salir_carcel"
require_relative "estado_juego"
require_relative "qytetet"
require "singleton"

module ControladorQytetet
  class ControladorQytetet
    include Singleton
    include ModeloQytetet::MetodoSalirCarcel
    include ModeloQytetet::EstadoJuego
    include ModeloQytetet::Qytetet
    attr_writer:nombre_jugadores
    
    def initialize
      @modelo = Qytetet.new
      @nombre_jugadores = Array.new
    end
    def obtener_casillas_validas (opcion)
    
    end
    
    def necesita_elegir_casilla (opcion)
    
    end
    
    def obtener_operaciones_juego_validas
      
    end
    
    def realizar_operacion(opcion, casilla)
      
    end
  end
end
