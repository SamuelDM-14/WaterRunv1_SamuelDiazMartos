
package gestionjuego;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import clases.Jugador;
import utilidades.Utilidades;
import utilidades.VarGenYConst;
import conexionBD.ConexionBD;
import clases.Partida;
import log.Log;

public class GestionUsuario {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static boolean dentro = false;
    private static String nombreJugador;
    private static String contraseña;

    /**
     * 
     * @throws IOException
     */
    public static void validacionUsuario() throws IOException {
        String cuenta;

        do {
            System.out.println("¿Tienes cuenta? (S/N)");
            cuenta = Utilidades.leerSNString();
            if (cuenta.equals("S")) {
                usuarioExistente();
            } else {
                crearUsuario();
            }
        } while (!dentro);
    }

    private static void usuarioExistente() throws IOException {
        boolean sesionIniciada = false;
        do {
            System.out.println("Dime tu nickname: ");
            nombreJugador = bf.readLine();
            System.out.println("Escribe la contraseña: ");
            contraseña = bf.readLine();

            String sql = "Select nombre, contrasena from jugador where nombre='" + nombreJugador + "' and contrasena='"
                    + contraseña + "'";
            try (Connection conexion = ConexionBD.obtenerConexion();
                    Statement stm = conexion.createStatement();
                    ResultSet rs = stm.executeQuery(sql);) {

                if (rs.next()) {
                    System.out.println("Has iniciado sesión con éxito.");
                    cargarJugadorYPartidas();
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

    private static void crearUsuario() throws IOException {
        boolean usuExistente = false;
        boolean salirCrearUsu = false;
        do {
            System.out.println("Nesitas una cuenta para jugar. ¿Quieres crear una cuenta? (S/N)");
            String crear = Utilidades.leerSNString();

            if (crear.equals("S")) {
                System.out.println("Dime tu nickname: ");
                nombreJugador = bf.readLine();
                System.out.println("Escribe la contraseña: ");
                contraseña = bf.readLine();

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
                pstm2.setString(2, contraseña);

                pstm2.executeUpdate();
                System.out.println("Usuario creado correctamente");
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

    private static void cargarJugadorYPartidas() {
        String sql = "SELECT p.* FROM partidas p inner join partidas_jugador pj on pj.id_partida = p.id_partida inner join jugador j on pj.id_jugador = j.id_jugador where j.nombre = '"
                + nombreJugador + "'";
        List<Partida> partidas = new ArrayList<>();
        try {
            Connection conexion = ConexionBD.obtenerConexion();
            Statement stm = conexion.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id_partida");
                LocalDate fechaInicio = rs.getDate("fecha_inicio_partida").toLocalDate();
                LocalDate fechaFin = rs.getDate("fecha_fin_partida").toLocalDate();
                LocalTime horaInicio = rs.getTime("hora_inicio_partida").toLocalTime();
                LocalTime horaFin = rs.getTime("hora_fin_partida").toLocalTime();
                int respuestasAcertadas = rs.getInt("respuestas_acertadas");
                boolean nivelPasado = rs.getBoolean("nivel_pasado");
                int dificultad = rs.getInt("dificultad_jugada");

                Partida partida = new Partida(id, fechaInicio, fechaFin, horaInicio, horaFin,
                        respuestasAcertadas, nivelPasado, dificultad);
                partidas.add(partida);
            }

            conexion.close();
        } catch (SQLException sqle) {
            System.out.println("Ha ocurrido un error al crear el usuario.");
            Log.guardarError(sqle, sqle.getMessage());
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error.");
            Log.guardarError(e, e.getMessage());
        }

    }
}
