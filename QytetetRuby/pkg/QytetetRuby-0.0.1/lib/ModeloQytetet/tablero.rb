# encoding: utf-8

module ModeloQytetet
  class Tablero
    
    # Consultores
    
    attr_reader:casillas, :carcel
    
    # Constructor sin parámetros que a la vez inicializa 
    # las casillas del tablero
    
    def initialize
      @casillas = Array.new
      self.inicializar
    end
    
    # Método de ayuda para inicializar las casillas
    
    def inicializar
      @casillas = Array.new
      
      @casillas << OtraCasilla.new(0, TipoCasilla::SALIDA)
      @casillas << Calle.new(1,
        TituloPropiedad.new("Huerto de Calixto y Melibea", 200, 50, 1.2, 150, 250))
      @casillas << Calle.new(2,
        TituloPropiedad.new("Avda de los cipreses ", 350, 55, 1.3, 200, 255))
      @casillas << Calle.new(3,
        TituloPropiedad.new("Avda Carmen Martín Gaite ", 400, 60, 1.4, 300, 300))
      @casillas << OtraCasilla.new(4, TipoCasilla::PARKING)
      @casillas << Calle.new(5,
        TituloPropiedad.new("Calle Cuarta ", 425, 62, 1.4, 400, 325))
      @casillas << Calle.new(6,
        TituloPropiedad.new("Avda Vicente del Bosque ", 460, 67, 1.43, 450, 350))
      @casillas << OtraCasilla.new(7, TipoCasilla::SORPRESA)
      @casillas << Calle.new(8,
        TituloPropiedad.new("Rana de la Universidad ", 500, 70, 1.5, 475, 400))
      @carcel = OtraCasilla.new(9, TipoCasilla::CARCEL)
      @casillas << @carcel
      @casillas << Calle.new(10,
        TituloPropiedad.new("Palacio de Monterrey ", 600, 75, 1.6, 500, 450))
      @casillas << Calle.new(11,
        TituloPropiedad.new("Plaza de Barcelona ", 750, 80, 1.65, 600, 475))
      @casillas << OtraCasilla.new(12, TipoCasilla::JUEZ)
      @casillas << Calle.new(13,
        TituloPropiedad.new("Ieronimus ", 800, 85, 1.7, 700, 500))
      @casillas << OtraCasilla.new(14, TipoCasilla::SORPRESA)
      @casillas << Calle.new(15,
        TituloPropiedad.new("Puente romano ", 900, 90, 1.75, 850, 550))
      @casillas << Calle.new(16,
        TituloPropiedad.new("Catedral de Salamanca ", 1000, 95, 1.9, 900, 600))
      @casillas << OtraCasilla.new(17, TipoCasilla::IMPUESTO)
      @casillas << OtraCasilla.new(18, TipoCasilla::SORPRESA)
      @casillas << Calle.new(19,
        TituloPropiedad.new("Gran vía", 1500, 100, 1.95, 1000, 700)) 
    end
    
    # Consulta si el número de la casilla pasada como parámetro es el de la cárcel
    
    def es_casilla_carcel (numero_casilla)
      return numero_casilla == @carcel.numero_casilla
    end
    
    # Consultor de una casilla del tablero cuyo número se pasa como parámetro
    
    def obtener_casilla_numero (numero_casilla)
      return @casillas.at(numero_casilla)
    end
    
    # Consultor de una casilla que se obtiene como la suma de una casilla base
    # y un desplazamiento, teniendo un tablero "circular"
    
    def obtener_casilla_final (casilla, desplazamiento)
      casilla_final = (casilla.numero_casilla + desplazamiento) % @casillas.size
      
      return obtener_casilla_numero (casilla_final)
    end
    
    # toString ()
    
    def to_s
      
      to_return = "\nCasillas: \n" 

      @casillas.each do |casilla|
        to_return << casilla.to_s
      end

      to_return 
    end
  end
end

