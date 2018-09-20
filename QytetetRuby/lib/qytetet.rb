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
      sorpresa = Sorpresa.new ("Te encuentras un billete por la calle, cobra 500 euros", 500, TipoSorpresa::PAGARCOBRAR)
      @mazo.push(sorpresa) 
    end
  end
end
