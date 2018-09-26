# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module ModeloQytetet

  class TituloPropiedad
    
    attr_accessor:nombre
    attr_accessor:hipotecada
    attr_accessor:alquiler_base
    attr_accessor:factor_revalorizacion
    attr_accessor:hipoteca_base
    attr_accessor:precio_edificar
    attr_accessor:num_casas
    attr_accessor:num_hoteles
    
    def initialize (nombre, alquiler_base, factor_revalorizacion, hipoteca_base,
                    precio_edificar)
      @nombre = nombre
      @hipotecada = false
      @alquilerBase = alquiler_base
      @factorRevalorizacion = factor_revalorizacion
      @hipotecaBase = hipoteca_base
      @precioEdificar = precio_edificar
      @num_hoteles = 0
      @num_casas= 0
    end
    
  end
end