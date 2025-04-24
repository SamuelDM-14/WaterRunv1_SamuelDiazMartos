/**
 * GuardarPartidas
 * @author SDM
 * @version 1.8
 * 28-04-2025
 */
package gestionjuego.juego;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;

import clases.Partida;
import conexionBD.ConexionBD;
import log.Log;
import utilidades.VarGenYConst;

/**
 * GuardarPartidas
 * Se encarga de conectarse a la base de datos y guardar las 
 * partidas asociandolas al jugador correspondiente.
 */
public class GuardarPartidas {
    /**
     * Guarda los datos de las partidas.
     * 
     * @param reAcertadas Recibe el número de respuestas acertadas.
     * @param lvlPasado   Recibe si el nivel se ha pasado o no.
     * @param partida     Recibe el objeto partida.
     */
    public static void guardarPartida(int reAcertadas, boolean lvlPasado, Partida partida) {
        LocalDate fechaDeFin = LocalDate.now(); // Variable que guarda la fecha actual.
        LocalTime horaDeFin = LocalTime.now(); // Variable que guarda la hora actual.

        // Asignamos los datos que tenemos al objeto partida.
        partida.setFechaFinPartida(fechaDeFin); 
        partida.setHoraFinPartida(horaDeFin);
        partida.setNivelPasado(lvlPasado);
        partida.setRespuestasAcertadas(reAcertadas);

        // Sentencia sql que inserta los datos de la partida en la base de datos.
        String sql = "INSERT INTO partidas VALUES(default, '" + partida.getFechaIncioPartida() + "', '"
                + partida.getFechaFinPartida() + "', '" +
                partida.getHoraIncioPartida() + "', '" + partida.getHoraIncioPartida() + "', '"
                + partida.getRespuestasAcertadas() + "', " + partida.getNivelPasado() + ", '"
                + partida.getDificultadJugada() + "')";

        try {
            Connection conexion = ConexionBD.obtenerConexion();
            Statement stm = conexion.createStatement();
            // Ejecuta la sentencia SQL.
            stm.execute(sql);
            // Llama al metodo guardarPartidaJugador.
            guardarPartidaJugador(conexion);

            stm.close(); // Cierra el Statement.
            conexion.close(); // Cierra el objeto Connection.
        } catch (SQLException sqle) {
            System.out.println("Ha ocurrido un error.");
            Log.guardarError(sqle, sqle.getMessage());
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error.");
            Log.guardarError(e, e.getMessage());
        }
        // Añade la partida al ArrayList de partidas
        VarGenYConst.partidas.add(partida);
        // Añade la partida al ArrayList de partidas de la sesión.
        VarGenYConst.partidasSesion.add(partida);
    }

    /**
     * Metodo que se encarga de asociar las partidas y los jugadores.
     * @param conexion Recibe el objeto Conection.
     */
    private static void guardarPartidaJugador(Connection conexion) {
        String sql2 = "INSERT INTO partidas_jugador SELECT (SELECT id_jugador from jugador where nombre = '"
                + VarGenYConst.jugador.getNombre() + "'), (select max(id_partida) from partidas)";

        try {
            Statement stm = conexion.createStatement();
            stm.execute(sql2);
        } catch (SQLException sqle) {
            System.out.println("Ha ocurrido un error.");
            Log.guardarError(sqle, sqle.getMessage());
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error.");
            Log.guardarError(e, e.getMessage());
        }
    }

}
