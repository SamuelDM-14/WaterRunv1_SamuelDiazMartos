/**
 * UsuarioNoEncontradoException
 * @author SDM
 * @version 1.8
 * 28-04-2025
 */
package excepciones;

/**
 * UsuarioNoEncontradoException
 * Clase de tipo exception que se encarga de gestionar
 * la exception de Usuario No Encontrado.
 */
public class UsuarioNoEncontradoException extends Exception {
    /**
     * Excepción que salta cuando el usuario, pone un nombre
     * que no aparece en la base de datos al iniciar sesión.
     * 
     * @param mensaje Recibe el mensaje de error.
     */
    public UsuarioNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
