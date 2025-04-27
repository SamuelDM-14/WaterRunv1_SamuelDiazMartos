/**
 * Jugador
 * @author SDM
 * @versin 1.6
 * 07-03-2025
 */
package clases;

import java.util.ArrayList;

/**
 * Clase Jugador.
 * Esta clase se encarga de gestionar la información del jugador.
 */
public class Jugador {
    // Atributos del jugador
    private int id_Jugador;
    private String nombre = "";
    private String contrasena = "";
    private ArrayList<Partida> partidas;

    /**
     * Metodo constructor de jugador sin el id.
     * 
     * @param nombre     Recibe el nombre del jugador.
     * @param contrasena Recibe la contraseña del jugador.
     * @param partidas   Recibe el ArrayList de partidas del jugador.
     */
    public Jugador(String nombre, String contrasena, ArrayList<Partida> partidas) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.partidas = partidas;
    }

    /**
     * Metodo constructor del jugador con todos sus atributos.
     * 
     * @param id         Recibe el id del jugador.
     * @param nombre     Recibe el nombre del jugador.
     * @param contrasena Recibe la contraseña del jugador.
     * @param partidas   Recibe el ArrayList de partidas del jugador.
     */
    public Jugador(int id, String nombre, String contrasena, ArrayList<Partida> partidas) {
        this.id_Jugador = id;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.partidas = partidas;
    }

    /**
     * Metodo para ver el ArrayList de partidas del jugador.
     * 
     * @return Devuelve el ArrayList de partidas del jugador.
     */
    public ArrayList<Partida> getPartidas() {
        return partidas;
    }

    /**
     * Metodo para modificar el ArrayList de partidas del jugador.
     * 
     * @param partidas Recibe el nuevo ArrayList de partidas del jugador.
     */
    public void setPartidas(ArrayList<Partida> partidas) {
        this.partidas = partidas;
    }

    /**
     * Metodo para ver el id del jugador.
     * 
     * @return Devuelve el id del jugador.
     */
    public int getId_Jugador() {
        return id_Jugador;
    }

    /**
     * Metodo para modificar el id del jugador.
     * 
     * @param id_Jugador Recibe el nuevo id del jugador.
     */
    public void setId_Jugador(int id_Jugador) {
        this.id_Jugador = id_Jugador;
    }

    /**
     * Metodo para ver la ccontraseña del jugador.
     * 
     * @return Devuelve la contraseña del jugador.
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Metodo para modificar la contraseña del jugador.
     * 
     * @param contrasena Recibe la nueva contraseña del jugador.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Metodo para ver el nickcname del jugador.
     * 
     * @return Devuelve el nombre del jugador
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo para modificar el nickcname del jugador.
     * 
     * @param nombre Recibe el nuevo nombre del jugador.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Jugador [id_Jugador=" + id_Jugador + ", nombre=" + nombre + ", contraseña=" + contrasena + ", partidas="
                + partidas + "]";
    }

}
