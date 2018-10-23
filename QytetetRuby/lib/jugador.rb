# encoding: utf-8

class Jugador
  
  #Modificadores y consultores
  
  attr_reader:saldo,:nombre,:propiedades
  attr_accessor:carta_libertad,:casilla_actual,:encarcelado
  
  # Constructor con un parámetro
  
  def initialize (nombre)
    @encarcelado = false
    @nombre = nombre
    @saldo = 7500
    @carta_libertad
    @casilla_actual
    @propiedades = Array.new
  end
  
  def <=> (otroJugador)
    otroJugador.obtener_capital <=> obtener_capital
  end
  
  def obtener_capital
    to_return = @saldo
    
    @propiedades.each do |propiedad|
      precio_propiedad = propiedad.precio_compra
      
      numero_edificios = propiedad.num_casas + propiedad.num_hoteles
      
      precio_propiedad += numero_edificios * propiedad.precio_edificar
      
      if (propiedad.hipotecada)
        precio_propiedad -= propiedad.hipoteca_base
      end
      
      to_return += precio_propiedad
    end
    return to_return
  end
  
  def cuantas_casa_hoteles_tengo
    to_return = 0
    
    @propiedades.each do |propiedad|
      to_return += propiedad.num_casas + propiedad.num_hoteles
    end
    
    return to_return
  end
  
  def devolver_carta_libertad
    tmp = @carta_libertad
    @carta_libertad = nil
    
    return tmp
  end
  
  def pagar_impuesto
    @saldo -= @casilla_actual.coste
  end
  
  def tengo_carta_libertad
    return !@carta_libertad.nil?
  end
  
  def es_de_mi_propiedad (titulo)
    return @propiedades.include?(titulo)
  end
  
  def modificar_saldo (cantidad)
    @saldo += cantidad
    
    return @saldo
  end
  
  def obtener_propiedades (estado_hipotecada)
    to_return = Array.new
    
    @propiedades.each do |propiedad|
      if (propiedad.hipotecada == estado_hipotecada)
        to_return << propiedad
      end
    end
    return to_return
  end
  
  def tengo_saldo (cantidad)
    return (@saldo > cantidad)
  end
  
  # toString()
  
  def to_s
    to_return = "\nEncarcelado: #{@encarcelado} \nNombre: #{@nombre} \nSaldo: #{@saldo}"
    
    if (!carta_libertad.nil?)
      to_return << ("\nCarta Libertad: #{@carta_libertad.to_s}")
    end
    
    if (!casilla_actual.nil?)
      to_return << ("\nCasilla Actual: #{@casilla_actual.to_s}")
    end
    
    if (!propiedades.nil?)
      to_return << ("\nPropiedades: #{@propiedades.to_s}")
    end
    
    to_return += "\nCapital: "
    to_return += obtener_capital.to_s
    
    to_return
  end
  
end
