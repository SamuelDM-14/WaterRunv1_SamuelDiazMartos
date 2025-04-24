/**
 * MismaContrasenaException
 * @author SDM
 * @version 1.8
 * 28-04-2025
 */
package excepciones;

/**
 * MismaContrasenaException
 * Clase de tipo exception que se encarga de gestionar
 * la exception de encontrar la contraseña del usuario en 
 * la base de datos.
 */
public class MismaContrasenaException extends Exception{
    /**
     * Excepción que salta cuando el usuario escribe
     * una contraseña que ya esta asignada al usuario.
     * 
     * @param mensaje Recibe el mensaje de error.
     */
    public MismaContrasenaException (String mensaje){
        super(mensaje);
    }
}
