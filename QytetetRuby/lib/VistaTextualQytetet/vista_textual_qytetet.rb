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

module VistaTextualQytetet
  class VistaTextualQytetet
    attr_reader:controlador, :modelo, :sigue_el_juego
    
    include ControladorQytetet
    include ModeloQytetet
    
    def initialize
      @controlador = ControladorQytetet.instance
      @controlador.inicializar_modelo(obtener_nombre_jugadores)
      @modelo = Qytetet.instance
      @sigue_el_juego = true
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
      casillas = ["0. Salida", "1. Huerto de Calixto y Melibea",
        "2. Avda de los cipreses", "3. Avda Carmen Martín Gaite", "4. Parking",
        "5. Calle Cuarta", "6. Avda Vicente del Bosque", "7. Sorpresa",
        "8. Rana de la universidad", "9. Cárcel", "10. Palacio de Monterrey",
        "11. Plaza de Barcelona", "12. Juez", "13. Ieronimus", "14. Sorpresa",
        "15. Puente Romano", "16. Catedral de Salamanca", "17. Impuesto",
        "18. Sorpresa", "19. Gran vía"]
      casillas_validas = Array.new
      casillas_validas = @controlador.obtener_casillas_validas(opcion)
      casillas_validas_string = Array.new
      
      if (casillas_validas.empty?)
        return -1
      else
        casillas_validas.each do |cas|
          casillas_validas_string << casillas[cas.to_i]
        end
        valor_correcto = leer_valor_correcto (casillas_validas_string)
        return casillas.index(valor_correcto)
      end
    end
    
    def leer_valor_correcto (valores_correctos)
      puts "********* Seleccione una opción: *********\n"
      valores_correctos.each {|v| puts v}
      
      first_try = true
      begin
        if (!first_try)
          puts "Prueba otra vez..."
        end
        opcion = gets.chomp
        first_try = false
      end while(!valores_correctos.include?(opcion))
      
      return opcion
    end
    
    def elegir_operacion
      opciones = ["Iniciar Juego", "Jugar", "Aplicar sorpresa",
            "Intentar salir de la cárcel pagando precio de libertad",
            "Intentar salir de la cárcel tirando un dado",
            "Comprar titulo de propiedad",
            "Hipotecar propiedad",
            "Cancelar hipoteca",
            "Edificar casa",
            "Edificar hotel",
            "Vender Propiedad",
            "Pasar turno",
            "Obtener ranking",
            "Terminar el juego",
            "Mostrar jugador actual",
            "Mostrar jugadores",
            "Mostrar tablero"]
      lista = Array.new
      ops = Array.new
      lista = @controlador.obtener_operaciones_juego_validas
      
      lista.each do |op|
        ops << opciones[op.to_i]
      end
      
      valor_correcto = leer_valor_correcto(ops)
      @sigue_el_juego = valor_correcto != "Terminar el juego"
      
      
      return opciones.index(valor_correcto)
    end
    
    def self.main
      ui = VistaTextualQytetet.new
      controlador = ui.controlador
      operacion_elegida = 0
      casilla_elegida = 0
      
      while ui.sigue_el_juego
        operacion_elegida = ui.elegir_operacion
        necesita_elegir_casilla = controlador.necesita_elegir_casilla(operacion_elegida)
        
        if(necesita_elegir_casilla)
          casilla_elegida = ui.elegir_casilla(operacion_elegida)
        end
        if(!necesita_elegir_casilla || casilla_elegida>=0)
          puts controlador.realizar_operacion(operacion_elegida,casilla_elegida)
          
        # Esto sirve para no tener que hacer scroll para ver la opción aplicada
        # y que de tiempo a examinar lo que ha pasado
        puts "Pulse cualquier tecla para continuar..."
        gets
        end
      end
    end
  main
  end
end
