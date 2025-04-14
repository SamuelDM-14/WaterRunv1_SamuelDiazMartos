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

public class GuardarPartidas {
        /**
     * Guarda los datos de las partidas.
     * 
     * @param reAcertadas Recibe el número de respuestas acertadas.
     * @param lvlPasado   Recibe si el nivel se ha pasado o no.
     * @param partida     Recibe el objeto partida.
     */
    public static void guardarPartida(int reAcertadas, boolean lvlPasado, Partida partida) {
        LocalDate fechaDeFin = LocalDate.now();
        LocalTime horaDeFin = LocalTime.now();

        partida.setFechaFinPartida(fechaDeFin);
        partida.setHoraFinPartida(horaDeFin);
        partida.setNivelPasado(lvlPasado);
        partida.setRespuestasAcertadas(reAcertadas);

        String sql = "INSERT INTO partidas VALUES(default, '" + partida.getFechaIncioPartida() + "', '"
                + partida.getFechaFinPartida() + "', '" +
                partida.getHoraIncioPartida() + "', '" + partida.getHoraIncioPartida() + "', '"
                + partida.getRespuestasAcertadas() + "', " + partida.getNivelPasado() + ", '"
                + partida.getDificultadJugada() + "')";

        try {
            Connection conexion = ConexionBD.obtenerConexion();
            Statement stm = conexion.createStatement();
            stm.execute(sql);
            guardarPartidaJugador(conexion);

            stm.close();
            conexion.close();
        } catch (SQLException sqle) {
            System.out.println("Ha ocurrido un error.");
            Log.guardarError(sqle, sqle.getMessage());
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error.");
            Log.guardarError(e, e.getMessage());
        }
        partida.setFechaFinPartida(fechaDeFin);
        partida.setHoraFinPartida(horaDeFin);
        partida.setNivelPasado(lvlPasado);
        partida.setRespuestasAcertadas(reAcertadas);
        VarGenYConst.partidas.add(partida);
        VarGenYConst.autoIncremental++;
    }

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
