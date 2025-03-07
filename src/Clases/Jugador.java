package clases;
public class Jugador {

    private String fechaInicio = "";
    private String nombre = "";

    
    public Jugador(String fechaInicio, String nombre) {
        this.fechaInicio = fechaInicio;
        this.nombre = nombre;
    }


    public String getFechaInicio() {
        return fechaInicio;
    }


    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @Override
    public String toString() {
        return "Jugador [fechaInicio=" + fechaInicio + ", nombre=" + nombre + "]";
    }
    
    
}
