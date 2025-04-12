
package gestionjuego;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;


import utilidades.Utilidades;
import utilidades.VarGenYConst;
import conexionBD.ConexionBD;
import log.Log;


public class GestionUsuario {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static boolean dentro = false;
    /**
     * 
     * @throws IOException
     */
    public static void validacionUsuario() throws IOException {
        String cuenta;
        
        do{
            System.out.println("¿Tienes cuenta? (S/N)");
            cuenta = Utilidades.leerSNString();
            if (cuenta.equals("S")) {
                usuarioExistente();
            } else {
                crearUsuario();
            }
        }while (!dentro); 
    }

    private static void usuarioExistente() throws IOException {
        boolean sesionIniciada = false;
        do {
            System.out.println("Dime tu nickname: ");
            VarGenYConst.nombreJugador = bf.readLine();
            System.out.println("Escribe la contraseña: ");
            VarGenYConst.contraseña = bf.readLine();

            String sql = "Select nombre, contrasena from jugador where nombre='"+ VarGenYConst.nombreJugador+"' and contrasena='"+VarGenYConst.contraseña+"'";
            try (Connection conexion = ConexionBD.obtenerConexion();
                    Statement stm = conexion.createStatement();
                    ResultSet rs = stm.executeQuery(sql);
                    ) {

                if (rs.next()) {
                    System.out.println("Has iniciado sesión con éxito.");
                    dentro=true;
                    sesionIniciada= true;
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
        boolean usuExistente=false;
        do {
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
                        usuExistente=true;
                    } else {
                        registroUsuario();
                        usuExistente=true;
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
            }
        } while (!usuExistente);
        
    }



    private static void registroUsuario() {
        boolean usuCreado= false;
        do {
            String sql= "INSERT INTO Jugador(nombre, contrasena) VALUES (?, ?);"; 
    
            try (Connection conexion = ConexionBD.obtenerConexion();
                PreparedStatement pstm2 = conexion.prepareStatement(sql)) {
                pstm2.setString(1, VarGenYConst.nombreJugador);
                pstm2.setString(2, VarGenYConst.contraseña);
        
                pstm2.executeUpdate();
                System.out.println("Usuario creado correctamente");
                usuCreado= true;
                dentro=true;
                
            } catch (SQLException sqle) {
                System.out.println("Ha ocurrido un error al buscar tu usuario.");
                Log.guardarError(sqle, sqle.getMessage());
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error.");
                Log.guardarError(e, e.getMessage());
            }
        } while (!usuCreado);
        
    }
}
