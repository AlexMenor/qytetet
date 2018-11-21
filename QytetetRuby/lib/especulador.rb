# encoding: utf-8

module ModeloQytetet
  class Especulador < Jugador
    def self.copia (jug, fianza)
      super(jug)
      @fianza = fianza
    end
 
    def convertirme (fianza)
      return self
    end
    # Preguntar a Nuria, pero creo que el protected en Ruby es distinto
    # y hay que ponerlo todo público
  
    # Un especulador paga la mitad de impuestos que un jugador normal
    def pagar_impuesto
      @saldo -= (@casilla_actual.coste / 2)
    end 
  
    # Devuelve false si no tiene saldo suficiente para pagar la fianza
    # devuelve true si la paga
  
    def pagar_fianza
      if @saldo >= @fianza
        @saldo -= @fianza
        return true
      end
  
      return false
    end
  
    # Devuelve true si no tiene carta libertad y no puede pagar la fianza
  
    def debo_ir_a_carcel
      if (super)
        return !pagar_fianza
      else
        return true 
        # Lo hemos hecho así, porque pensamos que si tiene carta y llama a 
        # pagar fianza y tiene el saldo suficiente, se restaría dinero
        # del saldo aún teniendo la carta libertad
      end
    end
  
    # Devuelve true si puede edificar una casa en una propiedad
    def puedo_edificar_casa (titulo)
      return @saldo >= titulo.precio_edificar && titulo.num_casas < 8
    end
   
    # Devuelve true si puede edificar un hotel en una propiedad
    def puedo_edificar_hotel (titulo)
      tengo_suficientes_casas = titulo.num_casas == 4
      return @saldo >= titulo.precio_edificar && titulo.num_hoteles < 8 && tengo_suficientes_casas
    end
 
    protected_class_method :copia
    protected :pagar_impuesto, :puedo_edificar_casa, :puedo_edificar_hotel
    private :pagar_fianza
   
    # Añade al to_s de la superclase el campo fianza
  
    def to_s
      to_return = super
    
      to_return += "\nFianza: #{@fianza}"
    
      return to_return
    end
  end
end