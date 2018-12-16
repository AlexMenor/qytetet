# encoding: utf-8

module ModeloQytetet

  class TituloPropiedad
    
    # Consultores y modificadores
    
    attr_reader:nombre
    attr_accessor:hipotecada,:propietario
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
      @propietario
    end
    
    # Devuelve true solo si tiene propietario
    
    def tengo_propietario
      return !@propietario.nil?
    end
    
    # Devuelve true solo si el propietario está encarcelado
    
    def propietario_encarcelado
      return @propietario.encarcelado
    end
    
    # Paga el alquiler al jugador propietario de la propiedad
    
    def pagar_alquiler
      coste_alquiler = calcular_importe_alquiler
      @propietario.modificar_saldo(coste_alquiler)
      
      return coste_alquiler
    end
    
    # Método auxiliar para calcular el coste del alquiler de la propiedad 
    
    def calcular_importe_alquiler
      coste_alquiler = @alquiler_base + (@num_casas * 0.5 + @num_hoteles * 2).to_i
      
      return coste_alquiler
    end
    
    # Hipoteca la propiedad
    
    def hipotecar
      @hipotecada = true
      return calcular_coste_hipotecar
    end
    
    # Método auxiliar para calcular el coste de hipotecar la propiedad
    
    def calcular_coste_hipotecar
      return (@hipoteca_base + @num_casas * 0.5 * @hipoteca_base + @num_hoteles * @hipoteca_base).to_i
    end
    
    # Método auxiliar para calcular el coste de venta de la propiedad
    
    def calcular_precio_venta
      return (@precio_compra + (@num_casas + @num_hoteles) * @precio_edificar * @factor_revalorizacion).to_i
    end
    
    # Incrementa el número de casas edificadas
    
    def edificar_casa
      @num_casas += 1
    end
    
    # Incrementa el número de hoteles edificados
    
    def edificar_hotel
      @num_hoteles += 1
      @num_casas -= 4
    end
    
    # Cancela la hipoteca de la propiedad
    
    def cancelar_hipoteca
      @hipotecada = false
    end
    
    # toString()
    
    def to_s()
       
      to_return = "TituloPropiedad; #{@nombre} \nhipotecada: #{@hipotecada}" 
      to_return << "\nalquiler_base: #{@alquiler_base}\nfactor_revalorizacion: " 
      to_return << "#{@factor_revalorizacion}\nhipoteca_base: #{@hipoteca_base}" 
      to_return << "\nprecio_edificar: #{@precio_edificar}\nnum_hoteles: #{@num_hoteles}"
      to_return << "\nnum_casas: #{@num_casas}\nprecio_compra: #{@precio_compra}"
      
      if (!propietario.nil?)
        to_return << "\nPropietario: #{@propietario.nombre}"
      end
      
      to_return
    end
    
  end
end