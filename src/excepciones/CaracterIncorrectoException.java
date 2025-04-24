/**
 * CaracterIncorrectoException
 * @author SDM
 * @version 1.8
 * 28-04-2025
 */
package excepciones;

/**
 * CaracterIncorrectoException
 * Clase de tipo exception que se encarga de gestionar
 * la exception de que al escribir en una cadena escriba
 * un caracter incorrecto.
 */
public class CaracterIncorrectoException extends Exception {
    /**
     * Excepción que salta cuando el usuario, pone un caracter
     * incorrecto debido a que no es ninguno de los indicados en 
     * la pregunta.
     * 
     * @param mensaje Recibe el mensaje de error.
     */
    public CaracterIncorrectoException (String mensaje){
        super(mensaje);
    }
}
