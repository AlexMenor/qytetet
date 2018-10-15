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
    
    to_return
  end
  
end
