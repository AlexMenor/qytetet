# encoding: utf-8

class Jugador
  
  #Modificadores y consultores
  
  attr_reader:saldo,:nombre,:propiedades
  attr_accessor:carta_libertad,:casilla_actual,:encarcelado
  
  # Constructor con un parámetro
  
  def initialize (encarcelado, nombre, saldo, carta_libertad, casilla_actual, propiedades)
    @encarcelado = encarcelado
    @nombre = nombre
    @saldo = saldo
    @carta_libertad = carta_libertad
    @casilla_actual = casilla_actual
    @propiedades = propiedades
  end
  
  def self.nuevo(nombre)
    prop = Array.new
    Jugador.new(false, nombre, 7500, nil, nil, prop)
  end
  
  def self.copia(jug)
    Jugador.new(jug.encarcelado, jug.nombre, jug.saldo, jug.carta_libertad, jug.casilla_actual, jug.propiedades)
  end
  
  def convertirme (fianza)
    return Especulador.new(self, fianza)
  end
  
  # Implementado este operador para poder clasificar a los jugadores
  
  def <=> (otroJugador)
    otroJugador.obtener_capital <=> obtener_capital
  end
  
  # Método que devuelve el capital formado por el saldo y el valor
  # inmobiliario de sus propiedades
  
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
  
  # Método que cuenta las casas y hoteles del jugador
  
  def cuantas_casas_hoteles_tengo
    to_return = 0
    
    @propiedades.each do |propiedad|
      to_return += propiedad.num_casas + propiedad.num_hoteles
    end
    
    return to_return
  end
  
  # Método que "quita" al jugador la carta libertad que posee
  
  def devolver_carta_libertad
    tmp = @carta_libertad
    @carta_libertad = nil
    
    return tmp
  end
  
  # Método que resta al jugador de su saldo un impuesto a pagar
  
  def pagar_impuesto
    @saldo -= @casilla_actual.coste
  end
  
  # Método consultor para comprobar si un jugador tiene una carta libertad
  
  def tengo_carta_libertad
    return !@carta_libertad.nil?
  end
  
  # Método consultor para comprobar si un jugador tiene una propiedad dada
  
  def es_de_mi_propiedad (titulo)
    return @propiedades.include?(titulo)
  end
  
  # Método para sumarle al saldo de un jugador una cantidad
  # (puede ser negativa)
  
  def modificar_saldo (cantidad)
    @saldo += cantidad
    
    return @saldo
  end
  
  # Método que provee al jugador de una carta libertad
  
  def set_carta_libertad (carta)
    @carta_libertad = carta
  end
  
  # Método que devuelve un subarray de las propiedades
  # de un jugador, hipotecadas o no según su argumento
  
  def obtener_propiedades (estado_hipotecada)
    to_return = Array.new
    
    @propiedades.each do |propiedad|
      if (propiedad.hipotecada == estado_hipotecada)
        to_return << propiedad
      end
    end
    return to_return
  end
  
  # Consulta si un usuario puede pagar un dinero dado como argumento 
  
  def tengo_saldo (cantidad)
    return (@saldo > cantidad)
  end
  
  # Paga el alquiler, modificando su saldo
  
  def pagar_alquiler 
    coste_alquiler = @casilla_actual.pagar_alquiler
    modificar_saldo (-coste_alquiler)
    
    return true
  end
  
  # Compra un titulo propiedad, modificando su saldo
  # y sus propiedades
  
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
  
  # Devuelve true si tiene carta libertad
  
  def debo_ir_a_carcel
    return tengo_carta_libertad
  end
  
  # Cancela la hipoteca de un titulo
  
  def cancelar_hipoteca(titulo)
    titulo.cancelar_hipoteca
    return true
  end
  
  # Cambia su posición a la casilla cárcel y se activa @encarcelado
  
  def ir_a_carcel(casilla_carcel)
    @casilla_actual = casilla_carcel
    @encarcelado = true
  end
  
  # Consulta si debe pagar alquiler al caer en una casilla
  
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
  
  # Hipoteca una propiedad, pasando TituloPropiedad como argumento
  
  def hipotecar_propiedad(titulo)
    coste_hipoteca = titulo.hipotecar
    modificar_saldo(coste_hipoteca)
    
    return true
  end
  
  # Se elimina una propiedad de sus propiedades y se modifica su saldo
  
  def vender_propiedad (casilla)
    titulo = casilla.titulo
    eliminar_de_mis_propiedades (titulo)
    
    precio_venta = titulo.calcular_precio_venta
    modificar_saldo(precio_venta)
    
    return true
  end
  
  # Se elimina una propiedad dada como argumento de las propiedades del jugador
  
  def eliminar_de_mis_propiedades (titulo)
    @propiedades.delete(titulo)
    titulo.propietario = nil
  end
  
  # Se edifica una casa si se cumplen las condiciones necesarias 
  # en la propiedad pasada como argumento
  
  def edificar_casa (titulo)
    edificada = puedo_edificar_casa(titulo)
    
      if (edificada)
        titulo.edificar_casa
        modificar_saldo (coste_edificar_casa)
      end
    
    return edificada
  end
  
  # Similar a edificar_casa pero con un hotel
  
   def edificar_hotel (titulo)
    edificado = puedo_edificar_hotel(titulo)
      
      if (edificado)
        titulo.edificar_hotel
        modificar_saldo (coste_edificar_hotel)
      end
      
    return edificado
  end
  
   # Devuelve true si puede edificar una casa en una propiedad
   def puedo_edificar_casa (titulo)
    return @saldo >= titulo.precio_edificar && titulo.num_casas < 4
   end
   
    # Devuelve true si puede edificar un hotel en una propiedad
   def puedo_edificar_hotel (titulo)
     tengo_suficientes_casas = titulo.num_casas == 4
    return @saldo >= titulo.precio_edificar && titulo.num_hoteles < 4 && tengo_suficientes_casas
   end
  
   # Paga por su libertad y sale de la cárcel si tiene el saldo necesario 
  
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
  protected_class_method :copia
  protected :convertirme, :debo_ir_a_carcel, :puedo_edificar_casa, :puedo_edificar_hotel, :pagar_impuesto, :puedo_edificar_casa, :puedo_edificar_hotel, :tengo_saldo
end
