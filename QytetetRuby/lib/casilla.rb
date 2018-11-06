# encoding: utf-8

module ModeloQytetet
  
  # Esta clase representa cada casilla 
  # de nuestro Qytetet
  
  class Casilla
    
    # Consultores y modificadores
    
    attr_reader:numero_casilla, :coste, :tipo
    attr_accessor:titulo
    private :titulo=
    
    # Constructor con dos parámetros (en realidad es un constructor "doble")
    
    def initialize (numero_casilla, titulo_o_tipo)
      if titulo_o_tipo.instance_of?(ModeloQytetet::TituloPropiedad)
        @titulo = titulo_o_tipo
        @coste = titulo_o_tipo.precio_compra
        @tipo = TipoCasilla::CALLE
      else
        @titulo = nil
        @coste = 0
        @tipo = titulo_o_tipo
      end
      @numero_casilla = numero_casilla
    end
    
    # Devuelve true solo si la casilla es del tipo calle
    
    def soy_edificable
      return @tipo ==ModeloQytetet::TipoCasilla::CALLE
    end
    
    # Llama al método de mismo nombre de la clase TituloPropiedad
    
    def tengo_propietario
      return @titulo.tengo_propietario
    end
    
   # Llama al método de mismo nombre de la clase TituloPropiedad
    
    def propietario_encarcelado
      return @titulo.propietario_encarcelado
    end
    
    def pagar_alquiler
      coste_alquiler = @titulo.pagar_alquiler
      
      return coste_alquiler
    end
    
    # toString()
    
    def to_s
      to_return = "\nNúmero de casilla: #{@numero_casilla} \ncoste: #{@coste}\ntipo: #{@tipo}" 
      
      
      if !titulo.nil?
        to_return << ("\ntitulo: " + @titulo.to_s)
      end
      
      to_return << "\n"
    end
  end
end
