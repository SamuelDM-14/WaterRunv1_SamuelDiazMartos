package conexionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/waterrun";
    private static final String USUARIO = "root";
    private static final String CLAVE = "Samu23022004"; // pon aquí tu contraseña si tienes

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