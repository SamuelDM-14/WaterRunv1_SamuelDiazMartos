/**
 * Pregunta
 * @author SDM
 * 07-03-2025
 */
package clases;

/**
 * Clase que representa una pregunta con un enunciado, sus opciones de respuesta
 * y la respuesta correcta (en texto).
 */
public class Pregunta {

    private String enunciado;
    private String[] opciones; // Ej: {"2", "4", "75", "185"}
    private String respuestaCorrecta; // Texto exacto que es la respuesta correcta (por ejemplo, "4")

    /**
     * Constructor de la clase Pregunta.
     * 
     * @param enunciado         Texto de la pregunta.
     * @param opciones          Array con todas las opciones de respuesta.
     * @param respuestaCorrecta Cadena de texto que es la respuesta correcta.
     */
    public Pregunta(String enunciado, String[] opciones, String respuestaCorrecta) {
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String[] getOpciones() {
        return opciones;
    }

    public void setOpciones(String[] opciones) {
        this.opciones = opciones;
    }

    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    @Override
    public String toString() {
        return "Pregunta{" +
                "enunciado='" + enunciado + '\'' +
                ", respuestaCorrecta='" + respuestaCorrecta + '\'' +
                '}';
    }
}
