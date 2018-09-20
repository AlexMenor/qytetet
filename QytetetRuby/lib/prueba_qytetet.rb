# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
#encoding: utf8

module ModeloQytetet
  
  class PruebaQytetet
    attr_accessor:juego
    
    def initialize
      @juego = Qytetet.new
      @juego.inicializarCartasSorpresa
    end  
  end
end
