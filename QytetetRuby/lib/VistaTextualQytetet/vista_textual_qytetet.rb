# encoding: utf-8

require_relative "opcion_menu"
require_relative "controlador_qytetet"

module VistaTextualQytetet
  class VistaTextualQytetet
    
    include ControladorQytetet::ControladorQytetet

    def initialize
      @controlador = ControladorQytetet.new
      @modelo = Qytetet.new
    end
    
    def obtener_nombre_jugadores
      
    end
    
    def elegir_casilla (opcion)
      
    end
    
    def leer_valor_correcto
      
    end
    
    def elegir_operacion
      
    end
    
    
  end
end
