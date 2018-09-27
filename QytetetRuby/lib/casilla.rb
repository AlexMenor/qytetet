# encoding = utf-8

module ModeloQytetet
  
  class Casilla
    attr_reader:numero_casilla, :coste, :tipo
    attr_accessor:titulo
    private :titulo=
    
    def initialize (numero_casilla, titulo_o_tipo)
      if titulo_o_tipo.instance_of?(ModeloQytetet::TituloPropiedad)
        self.titulo = titulo_o_tipo
        @coste = titulo_o_tipo.precio_compra
        @tipo = TipoCasilla::CALLE
      else
        @titulo = nil
        @coste = 0
        @tipo = titulo_o_tipo
      end
      @numero_casilla = numero_casilla
    end
    
    def to_s()
      to_return = "Número de casilla: #{@numero_casilla} \n coste: #{@coste} 
      \n tipo: #{@tipo}"
      
      if !titulo.nil?
        to_return += ("\n titulo: " + titulo.to_s)
      end
      
      to_return += '}'
    end
  end
end
