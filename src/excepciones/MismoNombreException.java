/**
 * MismoNombreException
 * @author SDM
 * @version 1.8
 * 28-04-2025
 */
package excepciones;

/**
 * MismoNombreException 
 * Clase de tipo exception que se encarga de gestionar
 * la exception de encontrar el nombre del usuario en 
 * la base de datos.
 */
public class MismoNombreException extends Exception{
    /**
     * Excepción que salta cuando el usuario escribe
     * un nombre que ya se encuentra en la base de datos
     * para crear o para cambiar el nombre.
     * 
     * @param mensaje Recibe el mensaje de error.
     */
    public MismoNombreException (String mensaje){
        super(mensaje);
    }
}
