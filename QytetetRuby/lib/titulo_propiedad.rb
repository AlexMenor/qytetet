# encoding: utf-8
module ModeloQytetet
  
  # Esta clase representa los distintos títulos de propiedad
  # y sus características

  class TituloPropiedad
    
    attr_reader:nombre
    attr_accessor:hipotecada
    attr_reader:factor_revalorizacion
    attr_reader:alquiler_base
    attr_reader:precio_compra
    attr_reader:hipoteca_base
    attr_reader:precio_edificar
    attr_reader:num_hoteles
    attr_reader:num_casas
    
    # Constructor que crea un título de propiedad a partir de 5 argumentos
    
    def initialize (nombre, precio_compra, alquiler_base, factor_revalorizacion, 
          hipoteca_base,precio_edificar)
      @nombre = nombre
      @precio_compra = precio_compra
      @hipotecada = false
      @alquiler_base = alquiler_base
      @factor_revalorizacion = factor_revalorizacion
      @hipoteca_base = hipoteca_base
      @precio_edificar = precio_edificar
      @num_hoteles = 0
      @num_casas= 0
    end
    
    # Método que imprime por pantalla los atributos de un título de propiedad
    
    #pendiente modificar to_s para precio_compra
    
    def to_s()
       
      to_return = "TituloPropiedad; #{@nombre} \nhipotecada: #{@hipotecada}" 
      to_return << "\nalquiler_base: #{@alquiler_base}\nfactor_revalorizacion: " 
      to_return << "#{@factor_revalorizacion}\nhipoteca_base: #{@hipoteca_base}" 
      to_return << "\nprecio_edificar: #{@precio_edificar}\nnum_hoteles: #{@num_hoteles}"
      to_return << "\nnum_casas: #{@num_casas}"
      
      to_return
    end
    
  end
end