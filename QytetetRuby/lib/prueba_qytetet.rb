# encoding: utf-8


# Imprescindibles para crear
# instancias clases definidas 
# en otros archivos del proyecto

require_relative "sorpresa"
require_relative "qytetet"
require_relative "tipo_sorpresa"
require_relative "tablero"
require_relative "jugador"
require_relative "dado"
require_relative "metodo_salir_carcel"
require_relative "estado_juego"

module ModeloQytetet
  
  class PruebaQytetet
    
    # Variable de clase
    
require_relative "tipo_casilla"
require_relative "casilla"
require_relative "titulo_propiedad"
    @@juego = Qytetet.instance
    
    
    # Método de instancia de clase que crea, a partir
    # de un mazo, otro mazo con sorpresas
    # de valor siempre mayor que cero
    
    def self.sorpresa_mayor_que_cero (mazo)
      a_devolver = Array.new
      
      mazo.each do |sorpresa|
        
        if sorpresa.valor > 0
          a_devolver << sorpresa
        end
      end
      
      a_devolver
    end
    
    # Método de instancia de clase que crea, a partir
    # de un mazo, otro mazo con sorpresas
    # de un tipo específico
    
    def self.es_de_tipo (mazo, tipo)
      a_devolver = Array.new
      
      mazo.each do |sorpresa|
        
        if sorpresa.tipo == tipo
          a_devolver << sorpresa
        end
      end
      
      a_devolver
    end
    
    # Método de instancia de clase que crea, a partir
    # de un mazo, otro mazo con sorpresas
    # de tipo "ir a casilla" 
    # (aprovechamos el general)
    
    def self.es_de_ir_a_casilla (mazo)
      es_de_tipo(mazo, TipoSorpresa::IRACASILLA)
    end
    
    def self.get_nombre_jugadores
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
    
    # Mueve entre varias opciones
    
    def self.probar_mover
      puts "¿A que tipo de casilla quieres moverte?\n"
      puts "1. Calle\n"
      puts "2. Impuesto\n"
      puts "3. Sorpresa\n"
      
      opcion = gets.chomp.to_i
      puts "\nCasilla antes de llamarlo: \n"
      puts @@juego.jugador_actual.casilla_actual
      
      case opcion
        when 1
        @@juego.mover(3)
        puts "\nQuieres comprarla? (y/n)\n"
        opcion2 = gets.chomp
        if opcion2 == "y"
          @@juego.comprar_titulo_propiedad
        end
      when 2
        @@juego.mover(17)
      when 3
        @@juego.mover(18)
        puts "\nCarta actual\n\n"
        puts @@juego.carta_actual
        @@juego.aplicar_sorpresa
      end
      puts "\nCasilla despues de llamarlo: \n"
      puts @@juego.jugador_actual.casilla_actual
      puts "\nJugador despues de llamarlo: "
      puts @@juego.jugador_actual
      
    end
    
    # Cambia al siguiente jugador y lo mueve en una casilla en la que se puede comprar
    # con la opción 1
    
    def self.probar_pagar_alquiler
      @@juego.siguiente_jugador
       puts "\nJugador antes de: \n"
      puts @@juego.jugador_actual
      @@juego.mover(3)
      puts "\nJugador despues de: \n"
      puts @@juego.jugador_actual
      
    end
    
    # Probar hipotecar una casilla
    
    def self.probar_hipotecar
      puts "\nAntes de hipotecar: "
      puts @@juego.tablero.obtener_casilla_numero(5)
      puts "\nHipotecamos la casilla 5\n"
      @@juego.hipotecar_propiedad(5)
      puts @@juego.tablero.obtener_casilla_numero(5)
      puts "\nLa cancelamos\n"
      @@juego.cancelar_hipoteca(5)
     puts @@juego.tablero.obtener_casilla_numero(5)
    end
    
    # Probar comprar y vender una propiedad
    
    def self.probar_vender
      puts "\nCompramos la 8 primero\n"
      @@juego.mover (8)
      @@juego.comprar_titulo_propiedad
      puts @@juego.jugador_actual
      
      puts @@juego.tablero.obtener_casilla_numero(8)
      puts "\nLa vendemos\n"
      @@juego.vender_propiedad(8)
      puts @@juego.tablero.obtener_casilla_numero(8)
      puts @@juego.jugador_actual
     
    end
    
    # Probamos a edificar
    
    def self.probar_edificar
      puts "\nVamos a comprar una propiedad (13) y a edificar un hotel y una casa\n"
      @@juego.mover (13)
      @@juego.comprar_titulo_propiedad
      puts @@juego.tablero.obtener_casilla_numero(13)
      puts "\nAhora edificamos \n"
      @@juego.edificar_casa(13)
      @@juego.edificar_hotel(13)
      puts @@juego.tablero.obtener_casilla_numero(13)
    end
    
    # Ranking
    
    def self.probar_ranking
      puts "\nPrimero sin ordenar\n"
      puts @@juego.jugadores
      puts "\nOrdenamos\n"
      @@juego.obtener_ranking
      puts @@juego.jugadores
    end
    
    
    # Método de instancia de clase Main 
    # para probar el juego
    
    def self.main
      
      @@juego.inicializar_juego (get_nombre_jugadores)
      
#      mazo_completo = @@juego.mazo
#      
#      mazo_mayor_que_cero = sorpresa_mayor_que_cero(mazo_completo)
#      puts "\n\n///////////////////////////////////////////////////"
#      puts "Prueba del método de mazo con valor mayor que cero:"
#      puts "///////////////////////////////////////////////////\n\n"
#      puts mazo_mayor_que_cero
#      
#      
#      TipoSorpresa::constants.each do |constante|
#        tipo = TipoSorpresa.const_get(constante)
#        puts "\n\n///////////////////////////////////////////////////"
#        puts "  Prueba del método de mazo con tipo #{tipo}"
#        puts "///////////////////////////////////////////////////\n\n"
#        puts es_de_tipo(mazo_completo, tipo)
#      end
#      
#      puts "\n\n///////////////////////////////////////////////////"
#      puts "  Prueba del tablero.to_s"
#      puts "///////////////////////////////////////////////////\n\n"
#      
#      tablero = @@juego.tablero
#      
#      puts tablero
#      
#      puts "\n\n///////////////////////////////////////////////////"
#      puts "  Prueba del jugadores"
#      puts "///////////////////////////////////////////////////\n\n"
#      
#      jugadores = @@juego.jugadores
#      
#      puts jugadores
      
#      puts "\n\n///////////////////////////////////////////////////"
#      puts "  Prueba de juego.to_s"
#      puts "///////////////////////////////////////////////////\n\n"
#     
#      puts @@juego.to_s
     
     loop do
      puts "Prueba Qytetet: \n"
      puts "Opción 1: Probar Mover\n"
      puts "Opción 2: Probar pagar alquiler\n"
      puts "Opción 3: Probar Hipotecar\n"
      puts "Opción 4: Probar Vender\n"
      puts "Opción 5: Probar Edificar\n"
      puts "Opción 6: Probar Ranking\n"

      opcion = gets.chomp.to_i

      case opcion
      when 1
        probar_mover()
      when 2
        probar_pagar_alquiler()
      when 3
        probar_hipotecar()
      when 4
        probar_vender()
      when 5
        probar_edificar()
      when 6
        probar_ranking()
      else
        puts "Fin del programa"
        break
      end
      
     
     end
    

   
  
  
  
    end

  end
  PruebaQytetet.main
end