/**
 * MasCaracteresPermitidosException
 * @author SDM
 * @version 1.8
 * 28-04-2025
 */
package excepciones;

/**
 * MasCaracteresPermitidosException
 * Clase de tipo exception que se encarga de gestionar
 * la exception de que al escribir en una cadena supere el 
 * máximo de caracteres requeridos.
 */
public class MasCaracteresPermitidosException extends Exception{
    /**
     * Excepción que salta cuando el usuario, pone un número
     * de caracteres superior a lo establecido.
     * 
     * @param mensaje Recibe el mensaje de error.
     */
    public MasCaracteresPermitidosException (String mensaje){
        super(mensaje);
    }
}
