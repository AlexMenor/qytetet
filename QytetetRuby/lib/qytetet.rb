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
    
    attr_reader:mazo, :dado, :jugadores, :jugador_actual
    attr_accessor:carta_actual, :estado_juego, :tablero
    
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
      
      @mazo.shuffle!
    end
    
    def inicializar_tablero
      @tablero = Tablero.new
    end
    
    def inicializar_juego(nombres)
      inicializar_jugadores(nombres)
      inicializar_tablero
      inicializar_cartas_sorpresa
      salida_jugadores
    end
    
    
    
    # Asigna jugador actual al siguiente de la lista de jugadores
    # si está encarcelado lo refleja en estado_juego
    
    def siguiente_jugador
      num_jugador_actual = @jugadores.find_index(@jugador_actual)
      
      num_jugador_siguiente = (num_jugador_actual + 1) % @jugadores.size
      
      @jugador_actual = @jugadores.at(num_jugador_siguiente)
      
      
        @estado_juego = @jugador_actual.encarcelado ? 
          ModeloQytetet::EstadoJuego::JA_ENCARCELADOCONOPCIONDELIBERTAD :
          ModeloQytetet::EstadoJuego::JA_PREPARADO
    end
    
    # Posiciona todos los jugadores en la casilla de salida
    
    def salida_jugadores
      @jugadores.each do |jugador|
        jugador.casilla_actual = @tablero.casillas.at(0)
      end
      random = Random.new
      
      primero_en_salir = random.rand(@jugadores.size)
      
      @jugador_actual = @jugadores.at(primero_en_salir)

      
      @estado_juego = ModeloQytetet::EstadoJuego::JA_PREPARADO;
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
    
    def obtener_casilla_jugador_actual
      casilla = @jugador_actual.casilla_actual
      
      return casilla
    end
    
    # Devuelve el valor que salió la última vez que se tiró el dado
   
    def get_valor_dado
      return @dado.valor
    end
    
    # Al caer en una casilla edificable se llama a este método para ajustar
    # todos los parámetros del juego afectados por dicho suceso
    
    def actuar_si_en_casilla_edificable
      debo_pagar = @jugador_actual.debo_pagar_alquiler
      
      if debo_pagar
        @jugador_actual.pagar_alquiler
      end
      
      casilla = obtener_casilla_jugador_actual
      
      tengo_propietario = @jugador_actual.casilla_actual.tengo_propietario
      
      if tengo_propietario
        @estado_juego = ModeloQytetet::EstadoJuego::JA_PUEDEGESTIONAR
      else
        @estado_juego = ModeloQytetet::EstadoJuego::JA_PUEDECOMPRAROGESTIONAR
      end 
    end
    
    # Si se ha caído en una casilla de carta sorpresa, se aplica la misma
    # en función del tipo, recogidos en tipo_sorpresa.rb
    
    def aplicar_sorpresa
      @estado_juego = ModeloQytetet::EstadoJuego::JA_PUEDEGESTIONAR
      
      if (@carta_actual.tipo == ModeloQytetet::TipoSorpresa::SALIRCARCEL)
        @jugador_actual.set_carta_libertad(@carta_actual)
      else
        @mazo << @carta_actual
      end
      
      if (@carta_actual.tipo == ModeloQytetet::TipoSorpresa::PAGARCOBRAR)
          @jugador_actual.modificar_saldo(@carta_actual.valor)
          
        if (@jugador_actual.saldo < 0)
          @estado_juego = ModeloQytetet::EstadoJuego::ALGUNJUGADORENBANCARROTA
        end
      elsif (@carta_actual.tipo == ModeloQytetet::TipoSorpresa::IRACASILLA)
        valor = @carta_actual.valor
        casilla_carcel = @tablero.es_casilla_carcel(valor)
        
        if (casilla_carcel)
          encarcelar_jugador
        else
          mover(valor)
        end
      elsif (@carta_actual.tipo == ModeloQytetet::TipoSorpresa::PORCASAHOTEL)
        cantidad = @carta_actual.valor
        numero_total = @jugador_actual.cuantas_casas_hoteles_tengo
        @jugador_actual.modificar_saldo(cantidad*numero_total)
        
        if (@jugador_actual.saldo < 0)
          @estado_juego = ModeloQytetet::EstadoJuego::ALGUNJUGADORENBANCARROTA
        end
      elsif (@carta_actual.tipo == ModeloQytetet::TipoSorpresa::PORJUGADOR)
        @jugadores.each do |jugador|
          if jugador != @jugador_actual
            jugador.modificarSaldo(@carta_actual.valor)
            
            if jugador.saldo < 0
              @estado_juego = ModeloQytetet::EstadoJuego::ALGUNJUGADORENBANCARROTA
            end
            @jugador_actual.modificarSaldo(-@carta_actual.valor)
            
            if @jugador_actual.saldo < 0
              @estado_juego = ModeloQytetet::EstadoJuego::ALGUNJUGADORENBANCARROTA
            end
          end
        end
      end
    end
    
    # Hace uso del método de mismo nombre definido en la clase Jugador
    # para edificar una casa en un número de casilla dado
    
    def edificar_casa (numero_casilla)
      edificada = false
      
      casilla = @tablero.obtener_casilla_numero(numero_casilla)
      
      titulo = casilla.titulo
      
      edificada = @jugador_actual.edificar_casa(titulo)
      
      if (edificada)
        @estado_juego = ModeloQytetet::EstadoJuego::JA_PUEDEGESTIONAR
      end
      
      return edificada
    end
    
    # El jugador prueba suerte para salir de la cárcel con este método
    
    def intentar_salir_carcel (metodo)
      if (metodo == ModeloQytetet::MetodoSalirCarcel::TIRANDODADO)
        resultado = tirar_dado()
        
        if (resultado >= 5)
          @jugador_actual.encarcelado = false
        end
      
      elsif (metodo == ModeloQytetet::MetodoSalirCarcel::PAGANDOLIBERTAD)
        @jugador_actual.pagar_libertad(@@PRECIO_LIBERTAD)
      end
      
      libre = @jugador_actual.encarcelado
      
      if (libre)
        @estado_juego = ModeloQytetet::EstadoJuego::JA_ENCARCELADO
      else
        @estado_juego = ModeloQytetet::EstadoJuego::JA_PREPARADO
      end
      
      return libre
    end
    
    # Al caer en una casilla no edificable se llama a este método
    # para tomar las medidas necesarias dependiendo del contexto actual
    
    def actuar_si_en_casilla_no_edificable
      @estado_juego = ModeloQytetet::EstadoJuego::JA_PUEDEGESTIONAR
      casilla_actual = @jugador_actual.casilla_actual
      
      if (casilla_actual.tipo == ModeloQytetet::TipoCasilla::IMPUESTO)
        @jugador_actual.pagar_impuesto
      else 
        if (casilla_actual.tipo == ModeloQytetet::TipoCasilla::JUEZ)
          encarcelar_jugador()
        elsif casilla_actual.tipo == ModeloQytetet::TipoCasilla::SORPRESA
          @carta_actual = @mazo.shift
          @estado_juego = ModeloQytetet::EstadoJuego::JA_CONSORPRESA
        end
      end
    end
    
    # Método para hacer la compra de un título propiedad
    
    def comprar_titulo_propiedad
   
      comprado = @jugador_actual.comprar_titulo_propiedad
      
      if comprado
        @estado_juego = ModeloQytetet::EstadoJuego::JA_PUEDEGESTIONAR
      end
      
      return comprado
    end
    
    # Método para encarcelar al jugador actual si se dan las condiciones 
    
    def encarcelar_jugador
      if !@jugador_actual.tengo_carta_libertad
        casilla_carcel = @tablero.carcel 
        @jugador_actual.ir_a_carcel(casilla_carcel)
        @estado_juego = ModeloQytetet::EstadoJuego::JA_ENCARCELADO
      else
        carta = @jugador_actual.devolver_carta_libertad
        @mazo << carta
        @estado_juego = ModeloQytetet::EstadoJuego::JA_PUEDEGESTIONAR
      end
    end
    
    # El jugador actual se mueve de casilla a la casilla dada 
    # y se llaman a los métodos de actuación edificable o no edificable
    
    def mover (num_casilla_destino)
      casilla_inicial = @jugador_actual.casilla_actual
      casilla_final = @tablero.casillas.at(num_casilla_destino)
      @jugador_actual.casilla_actual = casilla_final
      
      if num_casilla_destino < casilla_inicial.numero_casilla
        @jugador_actual.modificar_saldo(@@SALDO_SALIDA)
      end
      
      if @jugador_actual.casilla_actual.soy_edificable
        actuar_si_en_casilla_edificable
      else
        actuar_si_en_casilla_no_edificable
      end
    end
    
    # Se hipoteca la propiedad de la casilla pasada como parámetro
    
    def hipotecar_propiedad(numero_casilla)
      casilla = @tablero.obtener_casilla_numero(numero_casilla)
      titulo = casilla.titulo
      
      @jugador_actual.hipotecar_propiedad(titulo)
      
      @estado_juego = ModeloQytetet::EstadoJuego::JA_PUEDEGESTIONAR
    end
    
    # Se vende la propiedad de la casilla pasada como parámetro
    
    def vender_propiedad (numero_casilla)
      casilla = @tablero.obtener_casilla_numero(numero_casilla)
      
      @jugador_actual.vender_propiedad(casilla)
      
      @estado_juego = ModeloQytetet::EstadoJuego::JA_PUEDEGESTIONAR
      
      return true
    end
    
    # Llama al método del mismo nombre de la clase Jugador para edificar
    # un hotel en la casilla del número pasado como parámetro
    
    def edificar_hotel (numero_casilla)
      edificado = false
      
      casilla = @tablero.obtener_casilla_numero(numero_casilla)
      
      titulo = casilla.titulo
      
      edificado = @jugador_actual.edificar_hotel(titulo)
      
      if (edificado)
        @estado_juego = ModeloQytetet::EstadoJuego::JA_PUEDEGESTIONAR
      end
      
      return edificado
    end
    
    # Cancela la hipoteca de la propiedad de la casilla pasada como parámetro
    
    def cancelar_hipoteca (numero_casilla)
      cancelada = false
      
      casilla = tablero.obtener_casilla_numero(numero_casilla)
      titulo = casilla.titulo
      cancelada = @jugador_actual.cancelar_hipoteca(titulo)
      
     if cancelada
       @estado_juego = ModeloQytetet::EstadoJuego::JA_PUEDEGESTIONAR
     end
     
      return cancelada
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
    
    private :carta_actual=, :inicializar_jugadores, :inicializar_cartas_sorpresa, :inicializar_tablero, :salida_jugadores
  end
end
