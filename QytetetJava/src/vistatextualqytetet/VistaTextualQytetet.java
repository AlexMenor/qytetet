package vistatextualqytetet;

import java.util.ArrayList;
import controladorqytetet.*;
import java.util.Scanner;

public class VistaTextualQytetet {
    
    static String [] opciones = {"Iniciar Juego", "Jugar", "Aplicar sorpresa",
            "Intentar salir de la cárcel pagando precio de libertad",
            "Intentar salir de la cárcel tirando un dado",
            "Comprar titulo de propiedad",
            "Hipotecar propiedad",
            "Cancelar hipoteca",
            "Edificar casa",
            "Edificar hotel",
            "Vender Propiedad",
            "Pasar turno",
            "Obtener ranking",
            "Terminar el juego",
            "Mostrar jugador actual",
            "Mostrar jugadores",
            "Mostrar tablero"};
    static String [] casillas = {"0. Salida", "1. Huerto de Calixto y Melibea",
        "2. Avda de los cipreses", "3. Avda Carmen Martín Gaite", "4. Parking",
        "5. Calle Cuarta", "6. Avda Vicente del Bosque", "7. Sorpresa",
        "8. Rana de la universidad", "9. Cárcel", "10. Palacio de Monterrey",
        "11. Plaza de Barcelona", "12. Juez", "13. Ieronimus", "14. Sorpresa",
        "15. Puente Romano", "16. Catedral de Salamanca", "17. Impuesto",
        "18. Sorpresa", "19. Gran vía"};
    
    static Scanner in = new Scanner (System.in);
    
    // Atributos privados
    private  ControladorQytetet controlador;
    private  modeloqytetet.Qytetet modelo;
    boolean sigueElJuego;

    public VistaTextualQytetet(){

            /* Puesto que controlador es el que debería comunicarse con el modelo
            y no la vista, hemos incluido en el "constructor" de controlador un 
            parámetro para los nombres y que sea el quien inicialice el modelo
            a un estado consistente */

        controlador = ControladorQytetet.getInstance(obtenerNombreJugadores());
        modelo = modeloqytetet.Qytetet.getInstance();
        sigueElJuego = true;
    }
    
    // Métodos públicos

    public ControladorQytetet getControlador(){return controlador;}
    public modeloqytetet.Qytetet getModelo(){return modelo;}
    
    public ArrayList<String> obtenerNombreJugadores(){
        System.out.println("Introduzca el número de jugadores: ");
        String line = in.nextLine();
        int n_jugadores = Integer.parseInt(line);
        
        ArrayList<String> nombres = new ArrayList <> (); 
        
        for (int i = 1; i <= n_jugadores; i++){
            System.out.println("Introduce el jugador " + i);
            String s = in.nextLine ();
            nombres.add(s);
        }
        
        return nombres;
    
    }
    
    public int elegirCasilla(int opcionMenu){
        
        ArrayList<Integer> casillasValidas = controlador.obtenerCasillasValidas(opcionMenu);
        
        if (casillasValidas.isEmpty())
            return -1;
        
        ArrayList <String> todasLasCasillas = new ArrayList <> ();
        
        for (String string : casillas)
            todasLasCasillas.add(string);
        
        ArrayList <String> arrayDeStrings = new ArrayList <> ();
        for (int casilla : casillasValidas)
            arrayDeStrings.add(todasLasCasillas.get(casilla));
        
        String casillaSeleccionada = leerValorCorrecto(arrayDeStrings);
        
        return todasLasCasillas.indexOf(casillaSeleccionada);
        
    }
    
    public String leerValorCorrecto(ArrayList<String> valoresCorrectos){
        
        System.out.println("Seleccione una opción: \n");
        
        for (String opcion : valoresCorrectos)
            System.out.println(opcion);
        
        String input = null;
     
        do{
            if (input != null)
                System.out.println("Opción no permitida, inténtelo de nuevo\n");
            
            input = in.nextLine();
            
        } while (!valoresCorrectos.contains(input));
        
        return input;     
    }
    
    public int elegirOperacion(){
        ArrayList <Integer> arrayDeOpciones = controlador.obtenerOperacionesJuegoValidas();
        
       
        ArrayList <String> todasLasOpciones = new ArrayList <> ();
        
        for (String string : opciones)
            todasLasOpciones.add(string);
        
       
        ArrayList <String> arrayDeStrings = new ArrayList <>();
        
         for (int opcion : arrayDeOpciones)
             arrayDeStrings.add(todasLasOpciones.get(opcion));
                
        String valorSeleccionado = leerValorCorrecto(arrayDeStrings);
        
        sigueElJuego = !valorSeleccionado.equals("Terminar el juego");
        
        return todasLasOpciones.indexOf(valorSeleccionado);
    }

    public boolean sigueElJuego(){
        return sigueElJuego;
    }

    public static void main (String [] args){
        VistaTextualQytetet ui = new VistaTextualQytetet();
        ControladorQytetet controlador = ui.getControlador();

        int operacionElegida, casillaElegida = 0;
        boolean necesitaElegirCasilla;
        do {
            operacionElegida = ui.elegirOperacion();
            necesitaElegirCasilla = controlador.necesitaElegirCasilla(operacionElegida);
            if (necesitaElegirCasilla)
                casillaElegida = ui.elegirCasilla(operacionElegida);
            if (!necesitaElegirCasilla || casillaElegida >= 0)
                System.out.println(controlador.realizarOperacion(operacionElegida,
                casillaElegida));
        } while (ui.sigueElJuego());
    }
}

   
   
