# encoding: utf-8

require "singleton"

module ModeloQytetet
  
  class Qytetet
    
    # Clase singleton
    
    include Singleton
    
    
    # Parámetros del juego
    
    @@MAX_JUGADORES = 4
    @@NUM_SORPRESAS = 10
    @@NUM_CASILLAS = 20
    @@PRECIO_LIBERTAD = 200
    @@SALDO_SALIDA = 1000
    
    # Consultores y modificadores
    
    attr_reader:mazo,:tablero, :dado, :jugadores, :jugador_actual
    attr_accessor:carta_actual, :estado_juego
    
    # Métodos para inicializar el juego
    
    def inicializar_jugadores (nombres)
      @jugadores = Array.new
      nombres.each do |nombre|
        jugadores << Jugador.new(nombre)
      end
    end
    
    def inicializar_cartas_sorpresa
      @mazo = Array.new
      @mazo << Sorpresa.new("Te encuentras un billete por la calle, cobra 500 euros", 
        500, TipoSorpresa::PAGARCOBRAR)
      @mazo << Sorpresa.new("Te han pillado superando el límite de velocidad", 
       -200, TipoSorpresa::PAGARCOBRAR) 
      @mazo << Sorpresa.new("Ve a la cárcel", 
        @tablero.carcel.numero_casilla, TipoSorpresa::IRACASILLA) 
      @mazo << Sorpresa.new("Parking gratuito", 
        4, TipoSorpresa::IRACASILLA) 
      @mazo << Sorpresa.new("Ve a la casilla número 10", 
        10, TipoSorpresa::IRACASILLA) 
      @mazo << Sorpresa.new("Concurso de decoración. Cobras 100 euros por cada casa y hotel", 
        100, TipoSorpresa::PORCASAHOTEL)
      @mazo << Sorpresa.new("Reformas: Paga 300 euros por cada casa y hotel", 
       -300, TipoSorpresa::PORCASAHOTEL) 
      @mazo << Sorpresa.new("Ganas una apuesta, recibe 50 euros de cada", 
        50, TipoSorpresa::PORJUGADOR) 
      @mazo << Sorpresa.new("Hoy invitas tú, paga 45 euros a cada jugador", 
       -45, TipoSorpresa::PORJUGADOR)  
      @mazo << Sorpresa.new("Quedas libres de la cárcel, puedes guardar esto para luego", 
        0, TipoSorpresa::SALIRCARCEL) 
    end
    
    def inicializar_tablero
      @tablero = Tablero.new
    end
    
    def inicializar_juego(nombres)
      inicializar_tablero()
      inicializar_cartas_sorpresa()
      inicializar_jugadores(nombres)
    end
    
    # toString()
    
    def to_s
      to_return = "Qytetet:\n" 
      to_return += "mazo=#{@mazo}\n"
      to_return += "tablero=#{@tablero}\n"
      to_return += "dado=#{@dado}\n"
      to_return += "carta_acutal=#{@carta_actual}\n"
      to_return += "jugadores=#{@jugadores}\n"
      to_return += "jugador_actual=#{@jugador_actual}\n"
      
      to_return
    end
    
    # Asigna jugador actual al siguiente de la lista de jugadores
    # si está encarcelado lo refleja en estado_juego
    
    def siguiente_jugador
      num_jugador_actual = @jugadores.find_index(@jugador_actual)
      
      num_jugador_siguiente = (num_jugador_actual + 1) % @jugadores.size
      
      @jugador_actual = @jugadores.at(num_jugador_siguiente)
      
      
        @estado_juego = @jugador_actual.encarcelado ? 
          ModeloQytetet::EstadoJuego.const_get(JA_ENCARCELADOCONOPCIONDELIBERTAD) :
          ModeloQytetet::EstadoJuego.const_get(JA_PREPARADO)
    end
    
    # Posiciona todos los jugadores en la casilla de salida
    
    def salida_jugadores
      jugadores.each do |jugador|
        jugador.casilla_actual = 0
      end
      
      random = Random.new
      
      primero_en_salir = random.rand(@jugadores.size + 1)
      
      @jugador_actual = @jugadores.at(primero_en_salir)
      
      @estado_juego = ModeloQytetet::EstadoJuego.const_get(JA_PREPARADO);
    end
    
    # Devuelve los números de las casillas de las propiedades
    # del jugador actual
    
    def obtener_propiedades_jugador
      return obtener_propiedades_jugador_segun_estado_hipoteca(true)+
        obtener_propiedades_jugador_segun_estado_hipoteca(false)
    end
    
    # Devuelve los números de las casillas de las propiedades 
    # del jugador actual que están o no, hipotecadas
    
    def obtener_propiedades_jugador_segun_estado_hipoteca(estado_hipoteca)
      to_return = Array.new
      
      propiedades = @jugador_actual.obtener_propiedades(estado_hipoteca)
      
      casillas = @tablero.casillas
      
      casillas.each do |casilla|
        if !casilla.titulo.nil?
          if propiedades.include?(casilla.titulo)
            to_return << casilla.numero_casilla
          end
        end
      end
      
      return to_return
    end
    
    # Devuelve si la calle en la que se encuentra el usuario es edificable
    
    def jugador_actual_en_calle_libre
      casilla_actual = @jugador_actual.casilla_actual
      
      return casilla_actual.soy_edificable && !casilla_actual.titulo.tengo_propietario
    end
    
    # Devuelve true si el jugador actual está encarcelado
    
    def jugador_actual_encarcelado
      return @jugador_actual.encarcelado
    end
    
    # Método llama a tira el dado y mueve el jugador a la casilla que le ha tocado
    
    def jugar
      casilla_destino = @tablero.obtener_casilla_final(@jugador_actual.casilla_actual,
      tirar_dado())
    
      mover(casilla_destino)
    end
    
    # Método que ordena el array de jugadores por su posicion en el ranking de capital
    
    def obtener_ranking
      @jugadores = @jugadores.sort
    end
    
    # Método que devuelve el saldo del jugador actual
    
    def obtener_saldo_jugador_actual
      return @jugador_actual.saldo
    end
    
    # Método que que llama al metodo de jugador situado_en_calle_libre
    
    def jugador_actual_en_calle_libre
      return @jugador_actual.estoy_en_calle_libre
    end
    
    # Método que llama a tirar de la clase dado
    
    def tirar_dado
      return @dado.tirar
    end
    
    # Devuelve el valor que salió la última vez que se tiró el dado
   
    def get_valor_dado
      return @dado.valor
    end
    
    
    # Los 3 métodos inicializadores son privados y se llaman desde
    # inicializarJuego() que sí es público
    
    private :carta_actual=, :inicializar_jugadores, :inicializar_cartas_sorpresa, :inicializar_tablero, :salida_jugadores
  end
end
