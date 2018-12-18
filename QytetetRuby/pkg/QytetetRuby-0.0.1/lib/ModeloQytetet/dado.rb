#encoding: utf-8
require "singleton"
module ModeloQytetet
  
  class Dado
    
    # Clase singleton
    
    include Singleton
    attr_reader:valor
    
    # Método que genera un número entre 1-6
    
    def tirar
      random = Random.new
      @valor = random.rand(6) + 1
      return @valor
    end
    
    # toString()
    
    def to_s
      to_return = "Dado:\n Valor = #{@valor}"
      to_return
    end
  end
end
