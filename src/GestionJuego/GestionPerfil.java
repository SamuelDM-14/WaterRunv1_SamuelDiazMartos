/**
 * GestionPerfil
 * @author SDM
 * @version 1.8
 * 28-04-2025
 */
package gestionjuego;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conexionBD.ConexionBD;
import excepciones.MismaContrasenaException;
import excepciones.MismoNombreException;
import excepciones.UsuarioExistenteException;
import log.Log;
import utilidades.Utilidades;
import utilidades.VarGenYConst;

/**
 * GestionPerfil
 * Se encarga de gestionar el menú de Perfil y
 * cambiar el nombre y la contraseña del perfil
 */
public class GestionPerfil {

    /**
     * menuPerfil. Muestra el menú de gestion del perfil y te manda según tu
     * elección
     * al apartado correspondiente.
     */
    public static void menuPerfil() {
        VarGenYConst.opcionMenu = 7; // Pone la opcion del menú a 7 para mostrar el menú del perfil.
        VarGenYConst.max = 3; // Pone la variable max a 3 ya que la opción máxima es 3.
        VarGenYConst.min = 1; // Pone la variable min a 1 ya que la opción mínima es 1.
        int opcion; // Variable donde se guardará la opción elegida por el usuario.
        boolean salirPerfil = false; // Variable para salir del bucle del menú.
        do {
            System.out.println(VarGenYConst.MOSTRARMENUS[VarGenYConst.opcionMenu]); // Muestra el menú seleccionado
                                                                                    // previamente.
            opcion = Utilidades.leerEnteroValidado(); // Lee la opción del menú del usuario.

            switch (opcion) {
                case 1:
                    // Al elegir la opción 1, te envia al metodo cambiarNombre().
                    cambiarNombre();
                    break;
                case 2:
                    // Al elegir la opción 2, te envia al metodo cambiarContrasena().
                    cambiarContrasena();
                    break;
                case 3:
                    // Al elegir la opción 3, te devuelve al menú principal.
                    System.out.println("Volviendo al menú principal.");
                    salirPerfil = true; // Cambia la variable para salir a true.
                    break;

                default:
                    break;
            }
        } while (!salirPerfil); // Condicion para mantenerse en el bucle tiene que ser false.

    }

    /**
     * cambiarContrasena. Este metodo nos muestra nuestra la contraseña actual
     * y nos permite cambiarla.
     */
    private static void cambiarContrasena() {
        String cambioContrasena; // Variable para asegurar que el usuario quiere cambiar su contraseña.
        String nuevaContrasena; // Variable para guardar la nueva contraseña del usuario.
        // Muestra la contraseña actual del jugador y pregunta si quiere cambiarla.
        System.out.println("Su contraseña actual es: " + VarGenYConst.jugador.getContrasena()
                + "\n¿Seguro que desea cambiarla?(S/N)");
        // Lee si la respuesta del jugador es S o N y la guarda en la variable
        // cambioContrasena.
        cambioContrasena = Utilidades.leerSNCadena();
        try {
            if (cambioContrasena.equals("S")) { // Si la respeustra del usuario es S entra.
                System.out.println("Introduzca su nueva contraseña"); // Pide la nueva contraseña al usuario.
                // Lee la nueva contraseña y la guarda en la variable de nuevaContrasena
                nuevaContrasena = Utilidades.leerCadena();
                // Si la nueva contraseña es la misma que la que tenía entra.
                if (nuevaContrasena.equals(VarGenYConst.jugador.getContrasena())) {
                    // Lanza una excepción personalizada al tener la misma contraseña y regresa al
                    // menú de Perfil.
                    throw new MismaContrasenaException(
                            "Has escrito la misma contraseña.");
                } else {
                    // Sentencia sql que actualizará la contraseña del usuario.
                    String sql = "UPDATE jugador set contrasena = '" + nuevaContrasena + "' where nombre = '"
                            + VarGenYConst.jugador.getNombre() + "'";
                    // Crea un objeto Connection y llama al metodo obtenerConexion para conectarse a
                    // la base de datos.
                    Connection conexion = ConexionBD.obtenerConexion();
                    // Crea un objeto Statement que ejecutará la sentencia sql.
                    Statement stm = conexion.createStatement();
                    stm.execute(sql); // Ejecuta la sentencia sql.
                    // Actualiza internamente en el código la contraseña del jugador.
                    VarGenYConst.jugador.setContrasena(nuevaContrasena);
                    // Muestra un mensaje de exito en el cambio de contraseña.
                    System.out.println("Se ha actualizado la contraseña correctamente.");
                    stm.close(); // Cierra el Statement.
                    conexion.close(); // Cierra la conexioón a la base de datos.
                }
            }
        } catch (MismaContrasenaException MCe) { // Recibe la excepción de la misma contraseña.
            // Muestra un mensaje de que no se realizaran cambios.
            System.out.println("Has escrito la misma contraseña. No se realizará ningun cambio.");
            // Manda al metodo guardarError la excepción y el mensaje de la misma.
            Log.guardarError(MCe, MCe.getMessage());
        } catch (SQLException sqle) { // Recibe la excepción de errores sql.
            // Muestra un mensaje de error al cambiar la contraseña.
            System.out.println("Ha ocurrido un error al cambiar la contraseña.");
            // Manda al metodo guardarError la excepción y el mensaje de la misma.
            Log.guardarError(sqle, sqle.getMessage());
        } catch (Exception e) { // Recibe la excepción de un fallo general.
            System.out.println("Ha ocurrido un error."); // Muestra que ha ocurrido un error.
            // Manda al metodo guardarError la excepción y el mensaje de la misma.
            Log.guardarError(e, e.getMessage());
        }
    }

    /**
     * cambiarNombre. Este metodo nos muestra nuestra el nombre actual
     * y nos permite cambiarlo.
     */
    private static void cambiarNombre() {
        String cambioNombre; // Variable para asegurar que el usuario quiere cambiar su nombre.
        String nuevoNombre; // Variable para guardar el nuevo nombre del usuario.
        // Muestra el nombre actual del jugador y pregunta si quiere cambiarlo.
        System.out.println("Su nombre actual es: " + VarGenYConst.jugador.getNombre()
                + "\n¿Seguro que desea cambiarlo?(S/N)");
        // Lee si la respuesta del jugador es S o N y la guarda en la variable
        // cambioNombre
        cambioNombre = Utilidades.leerSNCadena();
        try {
            if (cambioNombre.equals("S")) { // Si la respeustra del usuario es S entra.
                System.out.println("Introduzca su nuevo nombre"); // Pide el nuevo nombre al usuario.
                nuevoNombre = Utilidades.leerCadena(); // Lee el nuevo nombre y lo guarda en la variable de nuevoNombre.
                // Si el nuevo nombre es el mismo que el que tenía, entra.
                if (nuevoNombre.equals(VarGenYConst.jugador.getNombre())) {
                    // Lanza una excepción personalizada al tener el mismo nombre y regresa al menú
                    // de Perfil.
                    throw new MismoNombreException("Has escrito el mismo nombre.");
                } else {
                    // Sentencia SQL para comprobar si hay algún usuario con ese nombre en la base
                    // de datos.
                    String sql1 = "Select nombre from jugador where nombre = '" + nuevoNombre + "'";
                    // Crea un objeto Connection y llama al metodo obtenerConexion para conectarse a
                    // la base de datos.
                    Connection conexion = ConexionBD.obtenerConexion();
                    // Crea un objeto Statement que ejecutará la sentencia sql.
                    Statement stm = conexion.createStatement();
                    // Crea un objeto Resulset que guardará el resultado del Statement.
                    ResultSet rs = stm.executeQuery(sql1);
                    if (rs.next()) { // Si hay algún dato dentro del ResulSet, entra.
                        // Lanza una excepción personalizada al encontrar un usuario con
                        // el mismo nombre y regresa al menú de Perfil.
                        throw new UsuarioExistenteException("Usuario ya existente en la base de datos.");
                    } else { // Entra en caso de no haber encontrado usuarios con el mismo nombre.
                        // Sentencia que actualizará el nombre del usuario.
                        String sql2 = "UPDATE jugador set nombre = '" + nuevoNombre + "' where nombre = '"
                                + VarGenYConst.jugador.getNombre() + "'";
                        // Ejecuta las sql2 para actualizar el nombre del usuario.
                        stm.execute(sql2);
                        // Actualiza internamente en el código el nombre del jugador.
                        VarGenYConst.jugador.setNombre(nuevoNombre);
                        System.out.println("Se ha actualizado el nombre correctamente.");

                    }
                    rs.close(); // Cierra el ResulSet.
                    stm.close(); // Cierra el Statement.
                    conexion.close(); // Cierra el Conection.
                }
            }
        } catch (MismoNombreException MNe) { // Recibe la excepción del mismo nombre de usuario.
            // Muestra un mensaje de que no se realizaran cambios.
            System.out.println("Has escrito el mismo nombre. No se realizará ningun cambio.");
            // Manda al metodo guardarError la excepción y el mensaje de la misma.
            Log.guardarError(MNe, MNe.getMessage());
        } catch (UsuarioExistenteException UEe) { // Recibe la excepción de usuario existente en la base de datos.
            // Muestra un mensaje de que no se realizaran cambios.
            System.out.println("Este usuario ya existe. No se realizaran los cambios.");
            // Manda al metodo guardarError la excepción y el mensaje de la misma.
            Log.guardarError(UEe, UEe.getMessage());
        } catch (SQLException sqle) { // Recibe la excepción de errores sql.
            // Muestra un mensaje de error al cambiar el nombre.
            System.out.println("Ha ocurrido un error al cambiar el nombre.");
            // Manda al metodo guardarError la excepción y el mensaje de la misma.
            Log.guardarError(sqle, sqle.getMessage());
        } catch (Exception e) { // Recibe la excepción de un fallo general.
            // Muestra un mensaje de error.
            System.out.println("Ha ocurrido un error.");
            // Manda al metodo guardarError la excepción y el mensaje de la misma.
            Log.guardarError(e, e.getMessage());
        }
    }
}
