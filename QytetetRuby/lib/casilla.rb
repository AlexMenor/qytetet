# encoding: utf-8

module ModeloQytetet
  
  # Esta clase representa cada casilla 
  # de nuestro Qytetet
  
  class Casilla
    attr_reader:numero_casilla, :coste, :tipo
    attr_accessor:titulo
    private :titulo=
    
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
    
    def to_s
      to_return = "\nNúmero de casilla: #{@numero_casilla} \ncoste: #{@coste}\ntipo: #{@tipo}" 
      
      
      if !titulo.nil?
        to_return << ("\ntitulo: " + @titulo.to_s)
      end
      
      to_return << "\n"
    end
  end
end
