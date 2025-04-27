/**
 * NumeroFueraDeRangoException
 * @author SDM
 * @version 1.8
 * 28-04-2025
 */
package excepciones;

/**
 * NumeroFueraDeRangoException 
 * Clase de tipo exception que se encarga de gestionar
 * la exception de un número fuera del rango marcado.
 */
public class NumeroFueraDeRangoException extends Exception {
    /**
     * Excepción que salta cuando el usuario, pone un número
     * que no se encuentra en el rango de selección.
     * 
     * @param mensaje Recibe el mensaje de error.
     */
    public NumeroFueraDeRangoException (String mensaje){
        super(mensaje);
    }
}
