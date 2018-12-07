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
      puts "Introduce el número de jugadores"
      numero = gets.chomp.to_i
      
      nombres = Array.new
      
      for i in(1..numero)
        
        puts "Introduce el nombre del jugador #{i}"
        cadena = gets.chomp
        nombres << cadena
        
      end
      nombres
    end
    
    def elegir_casilla (opcion)
      casillas_validas = Array.new
      casillas_validas = @controlador.obtener_casillas_validas(opcion)
      
      if (casillas_validas.empty?)
        return -1
      else
        puts casillas_validas
        valor_correcto = leer_valor_correcto (casillas_validas)
        return valor_correcto.to_i
      end
    end
    
    def leer_valor_correcto (valores_correctos)
      begin
        opcion = gets.chomp
      end while(!valores_correctos.include(opcion))
      
      return opcion
    end
    
    def elegir_operacion
      lista = Array.new
      ops = Array.new
      lista = @controlador.obtener_operaciones_juego_validas
      
      lista.each do |operacion|
        ops << operacion.to_s
      end
      
      valor_correcto = leer_valor_correcto(ops)
      
      return valor_correcto.to_i
    end
    
    def self.main
      ui = VistaTextualQytetet.new
      @controlador.nombre_jugadores = ui.obtener_nombre_jugadores
      operacion_elegida = 0
      casilla_elegida = 0
      
      loop do
        operacion_elegida = ui.elegir_operacion
        necesita_elegir_casilla = @controlador.necesita_elegir_casilla(operacion_elegida)
        if(necesita_elegir_casilla)
          casilla_elegida = ui.elegir_casilla(operacion_elegida)
        end
        if(!necesita_elegir_casilla || casilla_elegida>=0)
          puts @controlador.realizar_operacion(operacion_elegida,casilla_elegida)
        end
      end
    end
    
  end
end
