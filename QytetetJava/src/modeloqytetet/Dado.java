package modeloqytetet;
/* 
     Esta clase representa
     el dado del juego
    */
class Dado {
    // Atributos privados    
    private int valor; // Valor del dado al tirarlo
        
    // Métodos privados
    private static final Dado instance = new Dado (); // Método dado que crea
                                                      // la única instancia de dado
 
    private Dado () {valor = 1;} // Consturctor de la instancia única del dado
                                 // Valor 1 por defecto
    
    // Métodos públicos 
    public static Dado getInstance () {return instance;} // Devuelve la instancia
                                                         // única del dado
    
    public int getValor () {return valor;} // Consultor: devuelve el valor actual
                                           // del dado
    
    // Método toString, que devuelve una cadena con los campos del dado
    @Override
    public String toString (){
        return "Dado{Valor: " + valor+ "}";
    }
    
    //int tirar ();
    
}
