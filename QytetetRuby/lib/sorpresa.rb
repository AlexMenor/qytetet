# encoding: utf-8

module ModeloQytetet
  
  # Esta clase representa una "carta sorpresa"
  # de Qytetet
  
  class Sorpresa
    attr_accessor:texto
    attr_accessor:valor
    attr_accessor:tipo

    def initialize (texto, valor, tipo)
      @texto = texto
      @valor = valor
      @tipo = tipo
    end

    def to_s()
      "Texto; #{@texto} \n Valor: #{@valor} \n Tipo: #{@tipo}"
    end 

  end
end