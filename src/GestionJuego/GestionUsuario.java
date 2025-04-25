/**
 * GestionUsuario
 * @author SDM
 * @version 1.8
 * 28-04-2025
 */
package gestionjuego;

import java.io.Console;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import utilidades.Utilidades;
import utilidades.VarGenYConst;
import conexionBD.ConexionBD;
import excepciones.UsuarioExistenteException;
import excepciones.UsuarioNoEncontradoException;
import clases.Partida;
import log.Log;

/**
 * GestionUsuario.
 * Se encargade gestionar la creación de usuario y el inicio de
 * sesión al inicio del juego.
 */
public class GestionUsuario {
    private static boolean dentro = false; // Variable para entrar al juego.
    private static String nombreJugador; // Variable que guardará el nombre del jugador.
    private static String contrasena; // Variable que guardará la contraseña del jugador.

    /**
     * Metodo que se encarga de comprobar la respuesta del usuario a si tiene cuenta
     * y mandarlo a los metodos correspondientes.
     */
    public static void validacionUsuario() {
        String cuentaSN; // Variable que guarda la respuesta del usuario.

        do {
            // Muestra por pantalla la pregunta de si tiene cuenta.
            System.out.println("¿Tienes cuenta? (S/N)");
            // Lee la respuesta del usuario(S/N) y lo manda al metodo correspondiente.
            cuentaSN = Utilidades.leerSNCadena();
            // Solo puede ser N la respuesta ya que leerSNCadena solo devuelve el
            // String si es S o N.

            if (cuentaSN.equals("S")) { // Si la respuesta es S, entra.
                usuarioExistente(); // Llama al metodo usuarioExistente.
            } else { // Si la respuesta es N, entra.
                crearUsuario(); // Llama al metodo crearUsuario.
            }
        } while (!dentro); // Condicion para mantenerse en el bucle tiene que ser false.
    }

    /**
     * Metodo que se encarga de gestionar si el usuario tiene
     * una cuenta existente.
     */
    private static void usuarioExistente() {
        boolean sesionIniciada = false; // Variable booleana para gestionar el bucle.
        boolean errorUsuExis = false; // Variable booleana para gestionar el bucle.
        do {
            System.out.println("Dime tu nickname: "); // Pide el nombre del usuario.
            nombreJugador = Utilidades.leerCadena(); // Lee la respuesta del usuario.
            Console console = System.console();
            if (console != null) {
                char[] passwordChars = console.readPassword("Escribe la contraseña: ");
                contrasena = new String(passwordChars);
            } else {
                // Fallback si System.console() no está disponible (por ejemplo, desde la terminal de VS Code)
                System.out.println("Escribe la contraseña: ");
                contrasena = Utilidades.leerCadena();
            }
            // Sentencia sql que comprueba si hay un usuario con ese nombre y esa
            // contraseña.
            String sql = "Select nombre, contrasena from jugador where nombre='" + nombreJugador + "' and contrasena='"
                    + contrasena + "'";

            try (Connection conexion = ConexionBD.obtenerConexion();
                    // Crea un objeto Connection y llama al metodo obtenerConexion para conectarse a
                    // la base de datos.
                    Statement stm = conexion.createStatement();
                    // Crea un objeto Statement que ejecutará la sentencia sql.
                    ResultSet rs = stm.executeQuery(sql);) {
                // Crea un objeto Resulset que guardará el resultado del Statement.

                if (rs.next()) { // Si el ResulSet contiene algo, entra.
                    // Muestra un mensaje de exito al iniciar sesión.
                    System.out.println("Has iniciado sesión con éxito.");
                    cargarPartidas(); // Carga los datos de las partidas guardadas del jugador.
                    cargarJugador(); // Carga los datos del jugador.
                    dentro = true; // Pone la variable de control del bucle dentro en true.
                    // Pone la variable de control del bucle sesionIniciada en true.
                    sesionIniciada = true;
                } else { // Si el ResuslSet no contiene nada, entra.
                    // Lanza una excepción personalizada al no encontrar un usuario con
                    // el nombre y la contraseña introducidas.
                    throw new UsuarioNoEncontradoException(
                            "No se ha encontrado el usuario con esa contraseña. Contraseña erronea o el usuario no esta en la base de datos");
                }
            } catch (UsuarioNoEncontradoException UNEe) { // Recibe la excepción del usuario no encontrado.
                // Muestra un mensaje de que no se ha encontrado el usuario.
                System.out.println("No se ha encontrado tu usuario.");
                // Manda al metodo guardarError la excepción y el mensaje de la misma.
                Log.guardarError(UNEe, UNEe.getMessage());
                errorUsuExis = true; // Pone la variable de control del bucle a true.
            } catch (SQLException sqle) { // Recibe la excepción de errores sql.
                // Muestra un mensaje de error al buscar al usuario.
                System.out.println("Ha ocurrido un error al buscar tu usuario.");
                // Manda al metodo guardarError la excepción y el mensaje de la misma.
                Log.guardarError(sqle, sqle.getMessage());
                errorUsuExis = true; // Pone la variable de control del bucle a true.
            } catch (Exception e) {
                // Muestra un mensaje de error.
                System.out.println("Ha ocurrido un error.");
                // Manda al metodo guardarError la excepción y el mensaje de la misma.
                Log.guardarError(e, e.getMessage());
                errorUsuExis = true; // Pone la variable de control del bucle a true.
            }
            // Las condiciones para mantenerse en el bucle tiene que ser false ambas.
        } while (!sesionIniciada && !errorUsuExis); 

    }

    private static void crearUsuario() {
        boolean usuExistente = false; // Variable booleana de control del bucle.
        boolean salirCrearUsu = false; // Variable booleana de control del bucle.
        boolean errorCrearUsu = false; // Variable booleana de control del bucle.
        do {
            // Muestra un mensaje por pantalla de si quiere crear una cuenta.
            System.out.println("Nesitas una cuenta para jugar. ¿Quieres crear una cuenta? (S/N)");
            // Lee la respuesta del usuario(S/N) y la guarda en la variable crear.
            String crear = Utilidades.leerSNCadena();
            // Solo puede ser N la respuesta ya que leerSNCadena solo devuelve el
            // String si es S o N.

            if (crear.equals("S")) { // Si la respuesta es S, entra.
                System.out.println("Dime tu nickname: "); // Pide el nombre del usuario.
                nombreJugador = Utilidades.leerCadena(); // Lee el nombre escrito.
                System.out.println("Escribe la contraseña: "); // Pide la contrasñea del usuario.
                contrasena = Utilidades.leerCadena(); // Lee la contraseña escrita.

                // Sentencia SQL que buscará si existe algún jugador con ese nombre.
                String sql = "Select nombre from jugador where nombre='" + nombreJugador + "';";

                try (Connection conexion = ConexionBD.obtenerConexion();
                        // Crea un objeto Connection y llama al metodo obtenerConexion para conectarse a
                        // la base de datos.
                        Statement stm = conexion.createStatement();
                        // Crea un objeto Statement que ejecutará la sentencia sql.
                        ResultSet rs = stm.executeQuery(sql);) {
                        // Crea un objeto Resulset que guardará el resultado del Statement.

                    if (rs.next()) { // Si el ResulSet contiene algo, entra.
                        usuExistente = true; // Cambia la variable de control a true.
                        // Lanza una excepción personalizada al encontrar a un usuario
                        // con el mismo nombre introducido.
                        throw new UsuarioExistenteException("Usuario ya existente en la base de datos.");
                    } else { // Si el ResulSet esta vacío, entra.
                        // Llama al metodo registroUsuario para registrar al usuario.
                        registroUsuario();
                        // Al volver de registroUsuario, cambia la variable usuExistente a true.
                        usuExistente = true;
                    }
                    // Recibe la excepción de usuario existente en la base de datos.
                } catch (UsuarioExistenteException UEe) {
                    // Muestra un mensaje de que no se realizaran cambios.
                    System.out.println("Este usuario ya existe.");
                    // Manda al metodo guardarError la excepción y el mensaje de la misma.
                    Log.guardarError(UEe, UEe.getMessage());
                } catch (SQLException sqle) { // Recibe la excepción de errores sql.
                    // Muestra un mensaje de error al buscar al usuario.
                    System.out.println("Ha ocurrido un error al buscar tu usuario.");
                    // Manda al metodo guardarError la excepción y el mensaje de la misma.
                    Log.guardarError(sqle, sqle.getMessage());
                    errorCrearUsu = true; // Pone la variable de control del bucle a true.
                } catch (Exception e) {
                    // Muestra un mensaje de error.
                    System.out.println("Ha ocurrido un error.");
                    // Manda al metodo guardarError la excepción y el mensaje de la misma.
                    Log.guardarError(e, e.getMessage());
                    errorCrearUsu = true; // Pone la variable de control del bucle a true.
                }
            } else { // Si la respuesta es N, entra.
                // Muestra un mensaje para salir del juego.
                System.out.println("Saliendo del juego.");
                dentro = true; // Cambia la variable dentro a true.
                salirCrearUsu = true; // Cambia la variable salirCrearUsu a true.
                VarGenYConst.iniciar = false; // Cambia la variable iniciar a true.
            }
        // Todas las condiciones, para mantenerse en el bucle, tiene que ser false .
        } while (!usuExistente && !salirCrearUsu && !errorCrearUsu); 

    }

    /**
     * Metodo que se encarga de insertar los datos del usuario en la base de datos.
     */
    private static void registroUsuario() {
        boolean usuCreado = false; // Variable de control booleana.
        boolean errorRegistroUsu = false; // Variable de control booleana.
        do {
            // Sentencia SQL que inserta en la tabla jugador un nuevo jugador con
            // el nombre y la contraseña que introduzcamos.
            String sql = "INSERT INTO Jugador(nombre, contrasena) VALUES (?, ?);";

            try (Connection conexion = ConexionBD.obtenerConexion();
                // Crea un objeto Connection y llama al metodo obtenerConexion para conectarse a
                // la base de datos.
                PreparedStatement pstm2 = conexion.prepareStatement(sql)) {
                // Crea un objeto PReparedStatement para sustituir las ? de la sentencia 
                // sql por los datos introducidos.

                // Cambia la primera ? por la variable nombreJugador.
                pstm2.setString(1, nombreJugador); 
                // Cambia la segunda ? por la variable contrasena.
                pstm2.setString(2, contrasena);
                // Ejecuta la sentencia slq
                pstm2.executeUpdate();
                //Muestra un mensaje de éxito al crear el usuario.
                System.out.println("Usuario creado correctamente");
                cargarJugador(); // Carga el jugador.
                usuCreado = true; // Cambia la variable usuCreado a true.
                dentro = true; // Cambia la variable usuCreado a true.

            } catch (SQLException sqle) { // Recibe la excepción de errores sql.
                // Muestra un mensaje de error al buscar al usuario.
                System.out.println("Ha ocurrido un error al buscar tu usuario.");
                // Manda al metodo guardarError la excepción y el mensaje de la misma.
                Log.guardarError(sqle, sqle.getMessage());
                errorRegistroUsu = true; // Pone la variable de control del bucle a true.
            } catch (Exception e) {
                // Muestra un mensaje de error.
                System.out.println("Ha ocurrido un error.");
                // Manda al metodo guardarError la excepción y el mensaje de la misma.
                Log.guardarError(e, e.getMessage());
                errorRegistroUsu = true; // Pone la variable de control del bucle a true.
            }
        // Todas las condiciones, para mantenerse en el bucle, tiene que ser false.
        } while (!usuCreado && !errorRegistroUsu);
    }

    /**
     * Metodo que se encarga de guardar las partidas asignadas al jugador 
     */
    private static void cargarPartidas() {
        // Sentencia sql que muestra todos los datos de las partidas que tiene 
        // asignadas el jugador.
        String sql = "SELECT p.* FROM partidas p inner join partidas_jugador pj on pj.id_partida = p.id_partida inner join jugador j on pj.id_jugador = j.id_jugador where j.nombre = '"
                + nombreJugador + "'";
        // Inicializa el ArrayList de partidas.
        VarGenYConst.partidas = new ArrayList<>();
        try {
            // Crea un objeto Connection y llama al metodo obtenerConexion para conectarse a
            // la base de datos.
            Connection conexion = ConexionBD.obtenerConexion();
            // Crea un objeto Statement que ejecutará la sentencia sql.
            Statement stm = conexion.createStatement();
            // Crea un objeto Resulset que guardará el resultado del Statement.            
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) { // Mientras ResulSet tenga una siguiente linea, sigue.
                // Asigna los datos de las partidas a variables.
                int id = rs.getInt("id_partida");
                LocalDate fechaInicio = rs.getDate("fecha_inicio").toLocalDate();
                LocalDate fechaFin = rs.getDate("fecha_fin").toLocalDate();
                LocalTime horaInicio = rs.getTime("hora_inicio").toLocalTime();
                LocalTime horaFin = rs.getTime("hora_fin").toLocalTime();
                int respuestasAcertadas = rs.getInt("respuestas_acertadas");
                boolean nivelPasado = rs.getBoolean("nivel_pasado");
                int dificultad = rs.getInt("dificultad");

                // Crea una partida con los datos guaradados.
                Partida partida = new Partida(id, fechaInicio, fechaFin, horaInicio, horaFin,
                        respuestasAcertadas, nivelPasado, dificultad);
                // Añade al ArrayList de partidas la partida.
                VarGenYConst.partidas.add(partida);
            }
            rs.close(); // Cierra el ResulSet.
            stm.close(); // Cierra el Statement.
            conexion.close(); // Cierra el Connection.
        } catch (SQLException sqle) { // Recibe la excepción de errores sql.
            // Muestra un mensaje de error al buscar al usuario.
            System.out.println("Ha ocurrido un error al buscar tu usuario.");
            // Manda al metodo guardarError la excepción y el mensaje de la misma.
            Log.guardarError(sqle, sqle.getMessage());
        } catch (Exception e) {
            // Muestra un mensaje de error.
            System.out.println("Ha ocurrido un error.");
            // Manda al metodo guardarError la excepción y el mensaje de la misma.
            Log.guardarError(e, e.getMessage());
        }

    }

    /**
     * 
     */
    private static void cargarJugador() {
        // Sentencia SQL que busca el id del jugador con el nombre que escribimos.
        String sql = "SELECT id_jugador FROM jugador where nombre = '" + nombreJugador + "'";
        try {
            // Crea un objeto Connection y llama al metodo obtenerConexion para conectarse a
            // la base de datos.
            Connection conexion = ConexionBD.obtenerConexion();
            // Crea un objeto Statement que ejecutará la sentencia sql.
            Statement stm = conexion.createStatement();
            // Crea un objeto Resulset que guardará el resultado del Statement.            
            ResultSet rs = stm.executeQuery(sql);

            if (rs.next()) { // Si el ResulSet encuentra alguna linea, entra.
                // Guarda el id del jugador en una variable
                int id_jugador = rs.getInt("id_jugador");

                // Asigna los datos del usuario y las partidas a la clase jugador.
                VarGenYConst.jugador.setId_Jugador(id_jugador);
                VarGenYConst.jugador.setNombre(nombreJugador);
                VarGenYConst.jugador.setContrasena(contrasena);
                VarGenYConst.jugador.setPartidas(VarGenYConst.partidas);
            }
            rs.close(); // Cierra el ResulSet.
            stm.close(); // Cierra el Statement.
            conexion.close(); // Cierra el Connection.
        } catch (SQLException sqle) { // Recibe la excepción de errores sql.
            // Muestra un mensaje de error al buscar al usuario.
            System.out.println("Ha ocurrido un error al buscar tu usuario.");
            // Manda al metodo guardarError la excepción y el mensaje de la misma.
            Log.guardarError(sqle, sqle.getMessage());
        } catch (Exception e) {
            // Muestra un mensaje de error.
            System.out.println("Ha ocurrido un error.");
            // Manda al metodo guardarError la excepción y el mensaje de la misma.
            Log.guardarError(e, e.getMessage());
        }

    }
}
