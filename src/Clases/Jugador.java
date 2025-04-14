/**
 * Jugador
 * @author SDM
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

    // Puedo tener un arraylist de objetos partidas
    // Metodo constructor de jugador
    public Jugador(String nombre, String contrasena, ArrayList<Partida> partidas) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.partidas = partidas;
    }

    public Jugador(int id, String nombre, String contrasena, ArrayList<Partida> partidas) {
        this.id_Jugador = id;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.partidas = partidas;
    }

    public ArrayList<Partida> getPartidas() {
        return partidas;
    }

    public void setPartidas(ArrayList<Partida> partidas) {
        this.partidas = partidas;
    }

    public int getId_Jugador() {
        return id_Jugador;
    } 

    public void setId_Jugador(int id_Jugador) {
        this.id_Jugador = id_Jugador;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    // Metodo para ver el nickcname del jugador.
    public String getNombre() {
        return nombre;
    }

    // Metodo para modificar el nickcname del jugador.
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Jugador [id_Jugador=" + id_Jugador + ", nombre=" + nombre + ", contraseña=" + contrasena + ", partidas="
                + partidas + "]";
    }



}
