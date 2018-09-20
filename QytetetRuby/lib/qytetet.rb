# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
#encoding: utf8

module ModeloQytetet
  
  class Qytetet
    attr_accessor:mazo
    
    def initialize
      @mazo = Array.new
    end
    
    def inicializarCartasSorpresa
      @mazo << Sorpresa.new("Te encuentras un billete por la calle, cobra 500 euros", 
        500, TipoSorpresa::PAGARCOBRAR)
      @mazo << Sorpresa.new("Te han pillado superando el límite de velocidad", 
       -200, TipoSorpresa::PAGARCOBRAR) 
      @mazo << Sorpresa.new("Ve a la cárcel", 
        9, TipoSorpresa::IRACASILLA) 
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
  end
end
