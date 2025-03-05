package Clases;
/**
 * Clase abstracta que representa a un personaje del juego.
 * Contiene un color y define una acción básica.
 */
public abstract class Personajes {
    /**
     * Color del personaje en consola (ANSI code).
     */
    private String color;

    /**
     * Constructor de la clase Personajes.
     * @param color Color ANSI con el que se representará el personaje.
     */
    public Personajes(String color) {
        this.color = color;
    }

    /**
     * Método que define qué ocurre cuando este personaje recibe un disparo.
     * @param experienciaPolicia experiencia del policía que dispara (afecta a probabilidad de acierto, etc.)
     * @return true si el disparo alcanza y daña (o retrasa) al personaje, false si no lo hace (esquivado).
     */
    public abstract boolean recibirDisparo(int experienciaPolicia);

    /**
     * Obtiene el color del personaje.
     * @return el color (ANSI) del personaje.
     */
    public String getColor() {
        return color;
    }
    
    /**
     * Establece el color del personaje.
     * @param color Nuevo color (ANSI) para el personaje.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Devuelve la información del personaje como texto.
     * @return Cadena con la información relevante de la instancia.
     */
    @Override
    public String toString() {
        return "Personaje { color=" + color + " }";
    }
}