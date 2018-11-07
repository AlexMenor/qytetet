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
  
  def set_carta_libertad (carta)
    @carta_libertad = carta
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
  
  def pagar_alquiler 
    coste_alquiler = @casilla_actual.pagar_alquiler
    modificar_saldo (-coste_alquiler)
    
    return true
  end
  
  def comprar_titulo_propiedad
    comprado = false
    
    coste_compra = @casilla_actual.coste
      
    if coste_compra < @saldo
       
      @casilla_actual.titulo.propietario = self
     
      comprado = true
      @propiedades << @casilla_actual.titulo
     
      modificar_saldo (-coste_compra)
    
    end
    
    return comprado
  end
  
  def cancelar_hipoteca(titulo)
    titulo.cancelar_hipoteca
    return true
  end
  
  def ir_a_carcel(casilla_carcel)
    @casilla_actual = casilla_carcel
    @encarcelado = true
  end
  
  def debo_pagar_alquiler
    p_encarcelado = false
    esta_hipotecada = false
    es_de_mi_propiedad = es_de_mi_propiedad(@casilla_actual.titulo)
    tiene_propietario = @casilla_actual.tengo_propietario
    
    if tiene_propietario
      p_encarcelado = @casilla_actual.propietario_encarcelado
      esta_hipotecada = @casilla_actual.titulo.hipotecada
    end
    
    debo_pagar = !es_de_mi_propiedad & tiene_propietario & !p_encarcelado & !esta_hipotecada
    
    return debo_pagar
  end
  
  def hipotecar_propiedad(titulo)
    coste_hipoteca = titulo.hipotecar
    modificar_saldo(coste_hipoteca)
    
    return true
  end
  
  def vender_propiedad (casilla)
    titulo = casilla.titulo
    eliminar_de_mis_propiedades (titulo)
    
    precio_venta = titulo.calcular_precio_venta
    modificar_saldo(precio_venta)
    casilla.titulo = nil
    
    return true
  end
  
  def eliminar_de_mis_propiedades (titulo)
    @propieades.delete(titulo)
    titulo.propietario = nil
  end
  
  def edificar_casa (titulo)
    edificada = false
    num_casas = titulo.num_casas
    
    if (num_casas < 4)
      coste_edificar_casa = titulo.precio_edificar
      tengo_saldo = tengo_saldo (coste_edificar_casa)
      
      if (tengo_saldo)
        titulo.edificar_casa
        modificar_saldo (coste_edificar_casa)
        edificada = true
      end
    end
    return edificada
  end
  
   def edificar_hotel (titulo)
     edificado = false
    num_hoteles = titulo.num_hoteles
    
    if (num_hoteles < 4)
      coste_edificar_hotel = titulo.precio_edificar
      tengo_saldo = tengo_saldo (coste_edificar_hotel)
      
      if (tengo_saldo)
        titulo.edificar_hotel
        modificar_saldo (coste_edificar_hotel)
        edificado = true
      end
    end
    return edificado
  end
  
  def pagar_libertad (cantidad)
    tengo_saldo = tengo_saldo (cantidad)
    
    if (tengo_saldo)
      encarcelado = false
      modificar_saldo (-cantidad)
    end
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
