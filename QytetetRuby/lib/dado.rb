#encoding: utf-8
require "singleton"
module ModeloQytetet
  
  class Dado
    
    # Clase singleton
    
    include Singleton
    attr_reader:valor
    
    # toString()
    
    def to_s
      to_return = "Dado:\n Valor = #{@valor}"
      to_return
    end
  end
end
