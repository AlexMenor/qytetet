# encoding: utf-8

module ModeloQytetet
  
  # Esta clase representa una "carta sorpresa"
  # de Qytetet
  
  class Sorpresa
    attr_reader:texto
    attr_reader:valor
    attr_reader:tipo

    # Constructor que crea una carta sorpesa a partir de 3 argumentos
    
    def initialize (texto, valor, tipo)
      @texto = texto
      @valor = valor
      @tipo = tipo
    end
    
    # Método que imprime los atributos de una carta sorpresa

    def to_s()
      "Texto; #{@texto} \n Valor: #{@valor} \n Tipo: #{@tipo}"
    end 

  end
end