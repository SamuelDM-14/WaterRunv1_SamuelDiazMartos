
package gestionjuego;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import utilidades.Utilidades;
import utilidades.VarGenYConst;
import conexionBD.ConexionBD;
import clases.Partida;
import log.Log;

public class GestionUsuario {
    private static boolean dentro = false;
    private static String nombreJugador;
    private static String contrasena;

    public static void validacionUsuario() {
        String cuenta;

        do {
            System.out.println("¿Tienes cuenta? (S/N)");
            cuenta = Utilidades.leerSNCadena();
            if (cuenta.equals("S")) {
                usuarioExistente();
            } else {
                crearUsuario();
            }
        } while (!dentro);
    }

    private static void usuarioExistente() {
        boolean sesionIniciada = false;
        do {
            System.out.println("Dime tu nickname: ");
            nombreJugador = Utilidades.leerCadena();
            System.out.println("Escribe la contraseña: ");
            contrasena =  Utilidades.leerCadena();

            String sql = "Select nombre, contrasena from jugador where nombre='" + nombreJugador + "' and contrasena='"
                    + contrasena + "'";
            try (Connection conexion = ConexionBD.obtenerConexion();
                    Statement stm = conexion.createStatement();
                    ResultSet rs = stm.executeQuery(sql);) {

                if (rs.next()) {
                    System.out.println("Has iniciado sesión con éxito.");
                    cargarPartidas();
                    cargarJugador();
                    dentro = true;
                    sesionIniciada = true;
                } else {
                    System.out.println("Tu usuario o contraseña no son correctos o los has escrito mal.");

                }
                conexion.close();
            } catch (SQLException sqle) {
                System.out.println("Ha ocurrido un error al buscar tu usuario.");
                Log.guardarError(sqle, sqle.getMessage());
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error.");
                Log.guardarError(e, e.getMessage());
            }
        } while (!sesionIniciada);

    }

    private static void crearUsuario() {
        boolean usuExistente = false;
        boolean salirCrearUsu = false;
        do {
            System.out.println("Nesitas una cuenta para jugar. ¿Quieres crear una cuenta? (S/N)");
            String crear = Utilidades.leerSNCadena();

            if (crear.equals("S")) {
                System.out.println("Dime tu nickname: ");
                nombreJugador = Utilidades.leerCadena();
                System.out.println("Escribe la contraseña: ");
                contrasena = Utilidades.leerCadena();

                String sql = "Select nombre from jugador where nombre='" + nombreJugador + "';";

                try (Connection conexion = ConexionBD.obtenerConexion();
                        Statement stm = conexion.createStatement();
                        ResultSet rs = stm.executeQuery(sql);) {

                    if (rs.next()) {
                        System.out.println("Este usuario ya existe.");
                        usuExistente = true;
                    } else {
                        registroUsuario();
                        usuExistente = true;
                    }
                    rs.close();
                } catch (SQLException sqle) {
                    System.out.println("Ha ocurrido un error al buscar tu usuario.");
                    Log.guardarError(sqle, sqle.getMessage());
                } catch (Exception e) {
                    System.out.println("Ha ocurrido un error.");
                    Log.guardarError(e, e.getMessage());
                }
            } else {
                System.out.println("Saliendo del juego.");
                dentro = true;
                salirCrearUsu = true;
                VarGenYConst.iniciar = false;
            }
        } while (!usuExistente && !salirCrearUsu);

    }

    private static void registroUsuario() {
        boolean usuCreado = false;
        do {
            String sql = "INSERT INTO Jugador(nombre, contrasena) VALUES (?, ?);";

            try (Connection conexion = ConexionBD.obtenerConexion();
                    PreparedStatement pstm2 = conexion.prepareStatement(sql)) {
                pstm2.setString(1, nombreJugador);
                pstm2.setString(2, contrasena);

                pstm2.executeUpdate();
                System.out.println("Usuario creado correctamente");
                cargarJugador();
                usuCreado = true;
                dentro = true;

            } catch (SQLException sqle) {
                System.out.println("Ha ocurrido un error al crear el usuario.");
                Log.guardarError(sqle, sqle.getMessage());
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error.");
                Log.guardarError(e, e.getMessage());
            }
        } while (!usuCreado);
    }

    private static void cargarPartidas() {
        String sql = "SELECT p.* FROM partidas p inner join partidas_jugador pj on pj.id_partida = p.id_partida inner join jugador j on pj.id_jugador = j.id_jugador where j.nombre = '"
                + nombreJugador + "'";
        VarGenYConst.partidas = new ArrayList<>();
        try {
            Connection conexion = ConexionBD.obtenerConexion();
            Statement stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id_partida");
                LocalDate fechaInicio = rs.getDate("fecha_inicio").toLocalDate();
                LocalDate fechaFin = rs.getDate("fecha_fin").toLocalDate();
                LocalTime horaInicio = rs.getTime("hora_inicio").toLocalTime();
                LocalTime horaFin = rs.getTime("hora_fin").toLocalTime();
                int respuestasAcertadas = rs.getInt("respuestas_acertadas");
                boolean nivelPasado = rs.getBoolean("nivel_pasado");
                int dificultad = rs.getInt("dificultad");

                Partida partida = new Partida(id, fechaInicio, fechaFin, horaInicio, horaFin,
                        respuestasAcertadas, nivelPasado, dificultad);
                VarGenYConst.partidas.add(partida);
            }

            conexion.close();
        } catch (SQLException sqle) {
            System.out.println("Ha ocurrido un error al cargar las partidas.");
            Log.guardarError(sqle, sqle.getMessage());
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error.");
            Log.guardarError(e, e.getMessage());
        }

    }

    private static void cargarJugador() {
        String sql = "SELECT id_jugador FROM jugador where nombre = '" + nombreJugador + "'";
        try {
            Connection conexion = ConexionBD.obtenerConexion();
            Statement stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                int id_jugador = rs.getInt("id_jugador");

                VarGenYConst.jugador.setId_Jugador(id_jugador);
                VarGenYConst.jugador.setNombre(nombreJugador);
                VarGenYConst.jugador.setContrasena(contrasena);
                VarGenYConst.jugador.setPartidas(VarGenYConst.partidas);
            }
            rs.close();
            stm.close();
            conexion.close();
        } catch (SQLException sqle) {
            System.out.println("Ha ocurrido un error al cargar el jugador.");
            Log.guardarError(sqle, sqle.getMessage());
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error.");
            Log.guardarError(e, e.getMessage());
        }
    }
}
