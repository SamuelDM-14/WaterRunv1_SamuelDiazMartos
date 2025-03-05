package Clases;
import java.util.Random;

/**
 * Clase que representa a un Escapista, hereda de Personajes.
 */
public class Escapista extends Personajes {
    private static final int MASEXPERINCIA = 20; //fija como probabilidad 20% para esquivar el disparo si experienciaPolicia>EXPERIENCIA.
    private static final int MENOSEXPERINCIA = 60;//fija como probabilidad 60% para esquivar el disparo si experienciaPolicia<EXPERIENCIA.
    private static final int EXPERIENCIA = 5;// fija la experiencia a superar para que la probabilidad de disparo sea una u otra.
    private Random random; // generador de números aleatorios

    /**
     * Constructor del Escapista.
     * @param color color ANSI con el que se representará al escapista.
     */
    public Escapista(String color) {
        super(color);
        this.random = new Random();
    }

    /**
     * Método que define qué ocurre cuando el escapista recibe un disparo.
     * @param experienciaPolicia nivel de experiencia del policía que dispara.
     * @return true si el disparo impacta, false si es esquivado.
     */
    @Override
    public boolean recibirDisparo(int experienciaPolicia) {
        // Cuanto mayor sea la experiencia del policía, más probable es que acierte.
        // Por ejemplo: si experiencia > 5 => 20% de fallo del policía (80% acierto).
        //              si experiencia <= 5 => 60% de fallo (40% acierto).
        int probabilidadFallo = (experienciaPolicia > EXPERIENCIA) ? MASEXPERINCIA : MENOSEXPERINCIA;
        int chance = random.nextInt(100); // 0..99
        boolean esquivado = (chance < probabilidadFallo); 
        // 'esquivado == true' significa que el disparo falla y no impacta.

        if (esquivado) {
            System.out.println("¡El escapista ha esquivado el disparo!");
            return false; // no ha impactado
        } else {
            System.out.println("¡El escapista no logró esquivar el disparo!");
            return true; // el disparo ha impactado
        }
    }

    @Override
    public String toString() {
        return "Escapista { color=" + getColor() + " }";
    }
}