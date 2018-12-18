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
  
  module EstadoJuego
    
    JA_CONSORPRESA = :ja_consorpresa 
    ALGUNJUGADORENBANCARROTA = :algunjugadorenbancarrota 
    JA_PUEDECOMPRAROGESTIONAR = :ja_puedecomprargestionar
    JA_PUEDEGESTIONAR = :ja_puedegestionar 
    JA_PREPARADO = :ja_preparado 
    JA_ENCARCELADO = :ja_encarcelado 
    JA_ENCARCELADOCONOPCIONDELIBERTAD = :ja_encarceladoconopciondelibertad
   
  end
end
