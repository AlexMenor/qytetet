# encoding: utf-8
module ModeloQytetet
  
  # Esta clase representa los distintos títulos de propiedad
  # y sus características

  class TituloPropiedad
    
    attr_reader:nombre
    attr_accessor:hipotecada
    attr_reader:factor_revalorizacion
    attr_reader:hipoteca_base
    attr_reader:precio_edificar
    
    # Constructor que crea un título de propiedad a partir de 5 argumentos
    
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
    
    # Método que imprime por pantalla los atributos de un título de propiedad
    
    def to_s()
      "TituloPropiedad; #{@nombre} \n hipotecada: #{@hipotecada} 
      \n alquiler_base: #{@alquiler_base} \n factor_revalorizacion: 
      #{@factor_revalorizacion} \n hipoteca_base: #{@hipoteca_base} 
      \n precio_edificar: #{@precio_edificar} \n num_hoteles: #{@num_hoteles}
      \n num_casas: #{@num_casas}"
    end
    
  end
end