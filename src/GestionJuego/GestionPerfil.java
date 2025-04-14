package gestionjuego;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import conexionBD.ConexionBD;
import excepciones.MismaContrasenaException;
import excepciones.MismoNombreException;
import log.Log;
import utilidades.Utilidades;
import utilidades.VarGenYConst;

public class GestionPerfil {

    public static void menuPerfil() throws IOException {
        VarGenYConst.opcionMenu = 7;
        VarGenYConst.max = 3;
        VarGenYConst.min = 1;
        int opcion;
        boolean salirPerfil = false;
        do {
            System.out.println(VarGenYConst.MOSTRARMENUS[VarGenYConst.opcionMenu]);
            opcion = Utilidades.leerEnteroValidado();

            switch (opcion) {
                case 1:
                    cambiarNombre();
                    break;
                case 2:
                    cambiarContrasena();
                    break;
                case 3:
                    System.out.println("Volviendo al menú principal.");
                    salirPerfil = true;
                    break;

                default:
                    break;
            }
        } while (!salirPerfil);

    }

    private static void cambiarContrasena() throws IOException {
        String cambioContraseña;
        String nuevaContrasena;
        System.out.println("Su contraseña actual es: " + VarGenYConst.jugador.getContrasena()
                + "\n¿Seguro que desea cambiarla?(S/N)");
        cambioContraseña = Utilidades.leerSNCadena();
        try {
            if (cambioContraseña.equals("S")) {
                System.out.println("Introduzca su nueva contraseña");
                nuevaContrasena = Utilidades.leerCadena();
                if (nuevaContrasena.equals(VarGenYConst.jugador.getContrasena())) {
                    throw new MismaContrasenaException(
                            "Has escrito la misma contraseña. No se realizará ningun cambio.");
                } else {
                    String sql = "UPDATE jugador set contrasena = '" + nuevaContrasena + "' where nombre = '"
                            + VarGenYConst.jugador.getNombre() + "'";

                    Connection conexion = ConexionBD.obtenerConexion();
                    Statement stm = conexion.createStatement();
                    stm.execute(sql);
                    VarGenYConst.jugador.setContrasena(nuevaContrasena);
                    System.out.println("Se ha actualizado la contraseña correctamente.");
                    stm.close();
                    conexion.close();
                }
            }
        } catch (MismaContrasenaException MCe) {
            System.out.println("Has escrito la misma contraseña. No se realizará ningun cambio.");
            Log.guardarError(MCe, MCe.getMessage());
        } catch (SQLException sqle) {
            System.out.println("Ha ocurrido un error al cambiar la contraseña.");
            Log.guardarError(sqle, sqle.getMessage());
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error.");
            Log.guardarError(e, e.getMessage());
        }
    }

    private static void cambiarNombre() throws IOException {
        String cambioNombre;
        String nuevoNombre;
        System.out.println("Su nombre actual es: " + VarGenYConst.jugador.getNombre()
                + "\n¿Seguro que desea cambiarlo?(S/N)");
        cambioNombre = Utilidades.leerSNCadena();
        try {
            if (cambioNombre.equals("S")) {
                System.out.println("Introduzca su nuevo nombre");
                nuevoNombre = Utilidades.leerCadena();
                if (nuevoNombre.equals(VarGenYConst.jugador.getNombre())) {
                    throw new MismoNombreException("Has escrito el mismo nombre. No se realizará ningun cambio.");
                } else {
                    String sql = "UPDATE jugador set nombre = '" + nuevoNombre + "' where nombre = '"
                            + VarGenYConst.jugador.getNombre() + "'";

                    Connection conexion = ConexionBD.obtenerConexion();
                    Statement stm = conexion.createStatement();
                    stm.execute(sql);
                    VarGenYConst.jugador.setContrasena(nuevoNombre);
                    System.out.println("Se ha actualizado el nombre correctamente.");
                    stm.close();
                    conexion.close();
                }
            }
        } catch (MismoNombreException MNe) {
            System.out.println("Has escrito el mismo nombre. No se realizará ningun cambio.");
            Log.guardarError(MNe, MNe.getMessage());
        } catch (SQLException sqle) {
            System.out.println("Ha ocurrido un error al cambiar el nombre.");
            Log.guardarError(sqle, sqle.getMessage());
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error.");
            Log.guardarError(e, e.getMessage());
        }
    }
}
