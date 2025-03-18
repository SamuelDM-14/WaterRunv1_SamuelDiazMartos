/**
 * Jugador
 * @author SDM
 * 07-03-2025
 */
package clases;
/**
 * Clase Jugador.
 * Esta clase se encarga de gestionar la información del jugador.
 */
public class Jugador {
    //Atributos del jugador
    private String nombre = "";
    //Puedo tener un arraylist de objetos partidas
    
    //Metodo constructor de jugador
    public Jugador( String nombre) {
        this.nombre = nombre;
    }


    //Metodo para ver el nombre del jugador.
    public String getNombre() {
        return nombre;
    }

    //Metodo para modificar el nombre del jugador.
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @Override //Metodo toString para mostrar el contenido del Jugador.
    public String toString() {
        return "Jugador [Nombre=" + nombre + "]";
    }
    
    
}
