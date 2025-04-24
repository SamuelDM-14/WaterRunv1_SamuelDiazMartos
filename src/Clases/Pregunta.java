/**
 * Pregunta
 * @author SDM
 * 07-03-2025
 */
package clases;


import java.util.ArrayList;

/**
 * Clase que representa una pregunta con un enunciado, sus opciones de respuesta
 * y la respuesta correcta (en texto).
 */
public class Pregunta {

    private String enunciado;
    private ArrayList<String> opciones; // Ej: {"2", "4", "75", "185"}
    private String respuestaCorrecta; // Texto exacto que es la respuesta correcta (por ejemplo, "4")

    /**
     * Constructor de la clase Pregunta.
     * 
     * @param enunciado         Texto de la pregunta.
     * @param opciones          Array con todas las opciones de respuesta.
     * @param respuestaCorrecta Cadena de texto que es la respuesta correcta.
     */
    public Pregunta(String enunciado, ArrayList<String> opciones, String respuestaCorrecta) {
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    /**
     * Devuelve el enunciado de la pregunta.
     * @return Cadena con el enunciado de la pregunta.
     */
    public String getEnunciado() {
        return enunciado;
    }

    /**
     * Modifica el enunciado de la pregunta.
     * @param enunciado Recibe el enunciado de la pregunta.
     */
    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    /**
     * Devuelve las opciones de las preguntas.
     * @return Devuelve las opciones.
     */
    public ArrayList<String> getOpciones() {
        return opciones;
    }

    /**
     * Modifica el enunciado de la pregunta.
     * @param opciones Recibe el enunciado de la pregunta.
     */
    public void setOpciones(ArrayList<String> opciones) {
        this.opciones = opciones;
    }

    /**
     * Modifica la respuesta correcta de la pregunta.
     * @param respuestaCorrecta Recibe la respuesta correcta.
     */
    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    /**
     * Devuelve la respuesta correcta de la pregunta.
     * @return respuestaCorrecta.
     */
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
