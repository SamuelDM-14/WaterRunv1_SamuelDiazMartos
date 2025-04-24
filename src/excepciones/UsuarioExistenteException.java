/**
 * UsuarioExistenteException
 * @author SDM
 * @version 1.8
 * 28-04-2025
 */
package excepciones;

/**
 * UsuarioExistenteException
 * Clase de tipo exception que se encarga de gestionar
 * la exception de Usuario Existente.
 */
public class UsuarioExistenteException extends Exception{

    /**
     * Excepción que salta cuando el usuario, pone un 
     * nombre ya guardado en la base de datos.
     * @param mensaje Recibe el mensaje de error.
     */
    public UsuarioExistenteException (String mensaje){
        super(mensaje);
    }
}
