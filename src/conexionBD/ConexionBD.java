/**
 * ConexionBD
 * @author SDM
 * @version 1.8
 * 28-04-2025
 */
package conexionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ConexionBD
 * Se encarga de gestionar la conexión de base de datos.
 */
public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/waterrun";
    private static final String USUARIO = "root";
    private static final String CLAVE = "Samu23022004"; // pon aquí tu contraseña si tienes

    /**
     * Metodo que se encarga de conectarse a la base de datos.
     * 
     * @return Devuelve la conexión a la base de datos.
     * @throws SQLException 
     */
    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CLAVE);
    }
    /*public static void main(String[] args) throws SQLException {
        try {
            obtenerConexion();
            System.out.println("Estas dentro");
        } catch (SQLException sqle) {
            System.out.println("Error: "+ sqle.getMessage() );
        }  catch (Exception e) {
            System.out.println("Error: "+ e.getMessage() );ç
        }
    }*/
}