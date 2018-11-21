# encoding: utf-8

module ModeloQytetet
  
  # Esta clase representa cada casilla 
  # de nuestro Qytetet
  
  class Casilla
    
    # Consultores y modificadores
    
    attr_reader:numero_casilla 
    attr_accessor:coste
    
    # Constructor con dos parámetros (en realidad es un constructor "doble")
    
    def initialize (numero_casilla, coste)
      @numero_casilla = numero_casilla
      @coste = coste
    end
    
    # Métodos que deberían ser abstractos, pero en ruby no hay abstacto, así
    # que lanzamos un NotImplementedError
    
    def soy_edificable
      raise NotImplementedError
    end
    
    def tipo
      raise NotImplementedError
    end
    
    def titulo
      raise NotImplementedError
    end
    
    def tengo_propietario
      raise NotImplementedError
    end
    
    # toString()
    
    def to_s
      return "\nNúmero de casilla: #{@numero_casilla} \ncoste: #{@coste}\n"
    end
    
    protected :soy_edificable
  end
end
