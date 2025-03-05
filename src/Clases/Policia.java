package Clases;
/**
 * Clase Policia, extiende de Personajes y permite disparar a otros personajes.
 */
public class Policia extends Personajes {
    private int experiencia;

    /**
     * Constructor de la clase Policia.
     * @param color color ANSI que mostrará en consola.
     * @param experiencia nivel de habilidad del policía para disparar.
     */
    public Policia(String color, int experiencia) {
        super(color);
        this.experiencia = experiencia;
    }

    /**
     * Dispara a un objetivo, si la dificultad es alta (2).
     * @param objetivo Personaje al que se dispara.
     * @param dificultad nivel de dificultad del juego (0=fácil,1=media,2=difícil)
     * @return true si el disparo causó retraso/daño, false en caso contrario.
     */
    public boolean disparar(Personajes objetivo, int dificultad) {
        boolean retrasaPregunta = false;

        if (dificultad == 2) {
            System.out.println("¡El policía dispara contra " + objetivo.getClass().getSimpleName() + "!");
            // El propio objetivo decide si esquiva o no, en su método recibirDisparo
            boolean haImpactado = objetivo.recibirDisparo(this.experiencia);

            if (haImpactado) {
                System.out.println("¡El disparo acertó! Se retrasa una pregunta.");
                retrasaPregunta = true;
            } else {
                System.out.println("El disparo fue esquivado. El objetivo sigue en movimiento.");
            }
        }
        return retrasaPregunta;
    }
    
    // Getters y setters
    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    @Override
    public String toString() {
        return "Policia { experiencia=" + experiencia + ", color=" + getColor() + " }";
    }

    @Override
    public boolean recibirDisparo(int experienciaPolicia) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'recibirDisparo'");
    }
}
