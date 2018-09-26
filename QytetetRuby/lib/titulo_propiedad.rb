# encoding: utf-8
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
      @alquiler_base = alquiler_base
      @factor_revalorizacion = factor_revalorizacion
      @hipoteca_base = hipoteca_base
      @precio_edificar = precio_edificar
      @num_hoteles = 0
      @num_casas= 0
    end
    
    def to_s()
      "TituloPropiedad; #{@nombre} \n hipotecada: #{@hipotecada} 
      \n alquiler_base: #{@alquiler_base} \n factor_revalorizacion: 
      #{@factor_revalorizacion} \n hipoteca_base: #{@hipoteca_base} 
      \n precio_edificar: #{@precio_edificar} \n num_hoteles: #{@num_hoteles}
      \n num_casas: #{@num_casas}"
    end
    
  end
end