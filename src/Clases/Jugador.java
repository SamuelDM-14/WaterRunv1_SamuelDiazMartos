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
    private String fechaInicio = "";
    private String nombre = "";

    //Metodo constructor de jugador
    public Jugador(String fechaInicio, String nombre) {
        this.fechaInicio = fechaInicio;
        this.nombre = nombre;
    }

    //Metodo para ver la fecha de inicio.
    public String getFechaInicio() {
        return fechaInicio;
    }

    //Metodo para modificar la fecha de inicio
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
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
        return "Jugador [fechaInicio=" + fechaInicio + ", nombre=" + nombre + "]";
    }
    
    
}
