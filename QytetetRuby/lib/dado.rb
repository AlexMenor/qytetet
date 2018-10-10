#encoding: utf-8
requiere "singleton"
module ModeloQytetet
  
  class Dado
    include Singleton
    attr_reader:valor
    
    def to_s
      to_return = "Dado:\n Valor = #{@valor}"
      to_return
    end
  end
end
