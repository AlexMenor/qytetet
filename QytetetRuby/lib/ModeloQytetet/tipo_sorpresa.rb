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
  
  # Simplemente contiene los tipos
  # que pueden tener las cartas
  # sorpresa del juego
  
  module TipoSorpresa
      PAGARCOBRAR = :Pagar_cobrar
      IRACASILLA =:Ir_A_Casilla
      PORCASAHOTEL =:Por_Casa_Hotel
      PORJUGADOR =:Por_Jugador
      SALIRCARCEL =:Salir_Carcel
      CONVERTIRME =:Convertirme
  end
end