# encoding: utf-8
require_relative "metodo_salir_carcel"
require_relative "estado_juego"
require_relative "qytetet"
require "singleton"

module ControladorQytetet
  class ControladorQytetet
    include Singleton
    include ModeloQytetet::MetodoSalirCarcel
    include ModeloQytetet::EstadoJuego
    include ModeloQytetet::Qytetet
    attr_writer:nombre_jugadores
    
    def initialize
      @modelo = Qytetet.new
      @nombre_jugadores = Array.new
    end
    def obtener_casillas_validas ()
      array_de_opciones = Array.new
      
      if @modelo.jugadores.empty?
        array_de_opciones.push(OpcionMenu.index(INICIARJUEGO))
        return array_de_opciones
      end
      
      array_de_opciones.push(OpcionMenu.index(TERMINARJUEGO))
      array_de_opciones.push(OpcionMenu.index(MOSTRARJUGADORACTUAL))
      array_de_opciones.push(OpcionMenu.index(MOSTRARJUGADORES))
      array_de_opciones.push(OpcionMenu.index(MOSTRARTABLERO))
      
      estado = @modelo.estado_juego
      
      case estado
      when ModeloQytetet::EstadoJuego::JA_PREPARADO
        array_de_opciones.push(OpcionMenu.index(JUGAR))
      when ModeloQytetet::EstadoJuego::JA_PUEDECOMPRAROGESTIONAR
        array_de_opciones.push(OpcionMenu.index(PASARTURNO))
        array_de_opciones.push(OpcionMenu.index(COMPRARTITULOPROPIEDAD))
        array_de_opciones.push(OpcionMenu.index(VENDERPROPIEDAD))
        array_de_opciones.push(OpcionMenu.index(HIPOTECARPROPIEDAD))
        array_de_opciones.push(OpcionMenu.index(CANCELARHIPOTECA))
        array_de_opciones.push(OpcionMenu.index(EDIFICARCASA))
        array_de_opciones.push(OpcionMenu.index(EDIFICARHOTEL))
       when ModeloQytetet::EstadoJuego::JA_PUEDEGESTIONAR
        array_de_opciones.push(OpcionMenu.index(PASARTURNO))
        array_de_opciones.push(OpcionMenu.index(VENDERPROPIEDAD))
        array_de_opciones.push(OpcionMenu.index(HIPOTECARPROPIEDAD))
        array_de_opciones.push(OpcionMenu.index(CANCELARHIPOTECA))
        array_de_opciones.push(OpcionMenu.index(EDIFICARCASA))
        array_de_opciones.push(OpcionMenu.index(EDIFICARHOTEL))
      when ModeloQytetet::EstadoJuego::JA_CONSORPRESA
        array_de_opciones.push(OpcionMenu.index(APLICARSORPRESA))
      when ModeloQytetet::EstadoJuego::ALGUNJUGADORENBANCARROTA
        array_de_opciones.push(OpcionMenu.index(OBTENERRANKING))
      when ModeloQytetet::EstadoJuego::JA_ENCARCELADO
        array_de_opciones.push(OpcionMenu.index(PASARTURNO))
      when ModeloQytetet::EstadoJuego::JA_ENCARCELADOCONOPCIONDELIBERTAD
        array_de_opciones.push(OpcionMenu.index(INTENTARSALIRCARCELTIRANDODADO))
        array_de_opciones.push(OpcionMenu.index(INTENTARSALIRCARCELPAGANDOLIBERTAD))
      end
      
      return array_de_opciones
    
    end 
    
    def necesita_elegir_casilla (opcion)
    
    end
    
    def obtener_operaciones_juego_validas
      
    end
    
    def realizar_operacion(opcion, casilla)
      
    end
  end
end
