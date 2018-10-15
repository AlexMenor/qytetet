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
      
      @casillas << Casilla.new(0, TipoCasilla::SALIDA)
      @casillas << Casilla.new(1,
        TituloPropiedad.new("Huerto de Calixto y Melibea", 200, 50, 1.2, 150, 250))
      @casillas << Casilla.new(2,
        TituloPropiedad.new("Avda de los cipreses ", 350, 55, 1.3, 200, 255))
      @casillas << Casilla.new(3,
        TituloPropiedad.new("Avda Carmen Martín Gaite ", 400, 60, 1.4, 300, 300))
      @casillas << Casilla.new(4, TipoCasilla::PARKING)
      @casillas << Casilla.new(5,
        TituloPropiedad.new("Calle Cuarta ", 425, 62, 1.4, 400, 325))
      @casillas << Casilla.new(6,
        TituloPropiedad.new("Avda Vicente del Bosque ", 460, 67, 1.43, 450, 350))
      @casillas << Casilla.new(7, TipoCasilla::SORPRESA)
      @casillas << Casilla.new(8,
        TituloPropiedad.new("Rana de la Universidad ", 500, 70, 1.5, 475, 400))
      @carcel = Casilla.new(9, TipoCasilla::CARCEL)
      @casillas << @carcel
      @casillas << Casilla.new(10,
        TituloPropiedad.new("Palacio de Monterrey ", 600, 75, 1.6, 500, 450))
      @casillas << Casilla.new(11,
        TituloPropiedad.new("Plaza de Barcelona ", 750, 80, 1.65, 600, 475))
      @casillas << Casilla.new(12, TipoCasilla::JUEZ)
      @casillas << Casilla.new(13,
        TituloPropiedad.new("Ieronimus ", 800, 85, 1.7, 700, 500))
      @casillas << Casilla.new(14, TipoCasilla::SORPRESA)
      @casillas << Casilla.new(15,
        TituloPropiedad.new("Puente romano ", 900, 90, 1.75, 850, 550))
      @casillas << Casilla.new(16,
        TituloPropiedad.new("Catedral de Salamanca ", 1000, 95, 1.9, 900, 600))
      @casillas << Casilla.new(17, TipoCasilla::IMPUESTO)
      @casillas << Casilla.new(18, TipoCasilla::SORPRESA)
      @casillas << Casilla.new(19,
        TituloPropiedad.new("Gran vía", 1500, 100, 1.95, 1000, 700)) 
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

