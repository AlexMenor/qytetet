# encoding: utf-8

module ModeloQytetet
  class OtraCasilla < Casilla
    attr_reader :tipo
    def initialize (numero_casilla, tipo)
      coste = tipo == ModeloQytetet::TipoCasilla::IMPUESTO ? ModeloQytetet::Qytetet.coste_impuesto : 0 
      super(numero_casilla, coste)
      @tipo = tipo
    end
  
    # Consultor del titulo, devuelve nil ya que solo las calles tienen titulo
  
    def titulo
      return nil
    end
  
    #Comprueba si la casilla es edificable, devuelve false porque solo las calles lo son
  
    def soy_edificable
      return false
    end
    
    def tengo_propietario
      return false
    end
  
    def to_s
      to_return = super
      to_return += "Tipo: #{@tipo}"
      
      return to_return
    end
  end
end
