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
    attr_accessor:carta_actual
    
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
    
    # Los 3 métodos inicializadores son privados y se llaman desde
    # inicializarJuego() que sí es público
    
    private :carta_actual=, :inicializar_jugadores, :inicializar_cartas_sorpresa, :inicializar_tablero
  end
end
