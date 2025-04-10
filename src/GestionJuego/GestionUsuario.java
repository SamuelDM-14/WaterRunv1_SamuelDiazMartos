
package gestionjuego;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;


import utilidades.Utilidades;
import utilidades.VarGenYConst;
import conexionBD.ConexionBD;

public class GestionUsuario {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    /**
     * 
     * @throws IOException
     */
    public static void validacionUsuario() throws IOException {
        String cuenta;
        System.out.println("¿Tienes cuenta? (S/N)");
        cuenta = Utilidades.leerSNString();
        if (cuenta.equals("S")) {
            usuarioExistente();
        } else {
            crearUsuario();
        }
    }

    private static void usuarioExistente() throws IOException {

        System.out.println("Dime tu nickname: ");
        VarGenYConst.nombreJugador = bf.readLine();
        System.out.println("Escribe la contraseña: ");
        VarGenYConst.contraseña = bf.readLine();

        String sql = "Select nombre, contraseña from jugador where nombre=? and contraseña=?";
        try (Connection conexion = ConexionBD.obtenerConexion();
                PreparedStatement pstm = conexion.prepareStatement(sql);
                Statement smtn = conexion.createStatement();
                ResultSet rs = smtn.executeQuery(sql);) {

            pstm.setString(1, VarGenYConst.nombreJugador);
            pstm.setString(2, VarGenYConst.contraseña);

            int filas = pstm.executeUpdate();

            if (filas == 1) {
                System.out.println("Has iniciado sesión con éxito.");
            } else {
                System.out.println("Tu usuario o contraseña no son correctos o los has escrito mal.");
            }
            conexion.close();
        } catch (SQLException sqle) {
            System.out.println("Error: " + sqle.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void crearUsuario() throws IOException {
        System.out.println("Nesitas una cuenta para jugar. ¿Quieres crear una cuenta? (S/N)");
        String crear = Utilidades.leerSNString();

        if (crear.equals("S")) {
            System.out.println("Dime tu nickname: ");
            VarGenYConst.nombreJugador = bf.readLine();
            System.out.println("Escribe la contraseña: ");
            VarGenYConst.contraseña = bf.readLine();

            String sql = "Select nombre from jugador where nombre='"+VarGenYConst.nombreJugador+"';";

            try (Connection conexion = ConexionBD.obtenerConexion();
                    Statement stm = conexion.createStatement();
                    ResultSet rs = stm.executeQuery(sql);
            ) {

                
                
                if (rs.next()) {
                    System.out.println("Este usuario ya existe.");
                } else {
                    registroUsuario();
                }
                rs.close();
            } catch (SQLException sqle) {
                System.out.println("Error: " + sqle.getMessage());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("Saliendo del juego.");
        }
    }


    
    private static void registroUsuario() {
        System.out.println("[registroUsuario] Entrando al método..."); // ✅ debug
    
        String sql= "INSERT INTO Jugador(nombre, contrasena) VALUES (?, ?);"; // Usa 'contrasena' sin ñ
    
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement pstm2 = conexion.prepareStatement(sql)) {
    
            System.out.println("[registroUsuario] Preparando SQL...");
            pstm2.setString(1, VarGenYConst.nombreJugador);
            pstm2.setString(2, VarGenYConst.contraseña);
    
            pstm2.executeUpdate();
            System.out.println("✅ Usuario creado correctamente");
    
        } catch (SQLException sqle) {
            System.out.println("❌ Error SQL al insertar: " + sqle.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Error general al insertar: " + e.getMessage());
        }
    }
}
