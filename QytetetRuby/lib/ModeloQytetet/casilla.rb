# encoding: utf-8
require_relative "../ModeloQytetet/qytetet"
require_relative "../ControladorQytetet/opcion_menu"
require_relative "../ControladorQytetet/controlador_qytetet"
require_relative "../ModeloQytetet/calle"
require_relative "../ModeloQytetet/casilla"
require_relative "../ModeloQytetet/dado"
require_relative "../ModeloQytetet/especulador"
require_relative "../ModeloQytetet/estado_juego"
require_relative "../ModeloQytetet/jugador"
require_relative "../ModeloQytetet/metodo_salir_carcel"
require_relative "../ModeloQytetet/otra_casilla"
require_relative "../ModeloQytetet/sorpresa"
require_relative "../ModeloQytetet/sorpresa"
require_relative "../ModeloQytetet/tablero"
require_relative "../ModeloQytetet/tipo_casilla"
require_relative "../ModeloQytetet/tipo_sorpresa"
require_relative "../ModeloQytetet/titulo_propiedad"
module ModeloQytetet
  
  # Esta clase representa cada casilla 
  # de nuestro Qytetet
  
  class Casilla
    
    # Consultores y modificadores
    
    attr_reader:numero_casilla 
    attr_accessor:coste
    
    # Constructor con dos parámetros (en realidad es un constructor "doble")
    
    def initialize (numero_casilla, coste)
      @numero_casilla = numero_casilla
      @coste = coste
    end
    
    # Métodos que deberían ser abstractos, pero en ruby no hay abstacto, así
    # que lanzamos un NotImplementedError
    
    def soy_edificable
      raise NotImplementedError
    end
    
    def tipo
      raise NotImplementedError
    end
    
    def titulo
      raise NotImplementedError
    end
    
    def tengo_propietario
      raise NotImplementedError
    end
    
    # toString()
    
    def to_s
      return "\nNúmero de casilla: #{@numero_casilla} \ncoste: #{@coste}\n"
    end
  end
end
