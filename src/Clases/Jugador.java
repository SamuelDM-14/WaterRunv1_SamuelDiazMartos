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
    private String contraseña = "";
    private ArrayList<Partida> partidas;

    // Puedo tener un arraylist de objetos partidas
    // Metodo constructor de jugador
    public Jugador(String nombre, String contraseña, ArrayList<Partida> partidas) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.partidas = partidas;
    }

    public Jugador(int id, String nombre, String contraseña, ArrayList<Partida> partidas) {
        this.id_Jugador = id;
        this.nombre = nombre;
        this.contraseña = contraseña;
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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
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
        return "Jugador [nombre=" + nombre + ", partidas=" + partidas.size() + "]";
    }

}
