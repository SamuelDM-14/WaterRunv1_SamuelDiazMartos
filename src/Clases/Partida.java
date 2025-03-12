/**
 * Partida
 * @author SDM
 * 14-03-2025
 */
package clases;

/**
 * La clase partida se encarga de gestionar la hora de inicio, la hora de fin
 * las respuestas correctas, la dificultad de las preguntas y si ha pasado el nivel o no el jugador.
 */
public class Partida {
    //------------ VARIABELS DE PARTIDA ------------
    private String incioPartida = "";
    private String finPartida = "";
    private int respuestasAcertadas  = 0;
    private boolean nivelPasado = false;
    private int dificultadJugada = 0;

    //------------ CONSTRUCTOR DE PARTIDA ------------
    public Partida(String incioPartida, String finPartida, int respuestasAcertadas, int dificultadJugada, boolean nivelPasado) {
        this.incioPartida = incioPartida;
        this.finPartida = finPartida;
        this.respuestasAcertadas = respuestasAcertadas;
        this.dificultadJugada = dificultadJugada;
        this.nivelPasado = nivelPasado;
    }

    //------------ GETTERS Y SETTERS DE PARTIDA ------------
    //------------ GET DE INICIO DE PARTIDA ------------
    public String getIncioPartida() {
        return incioPartida;
    }
     //------------ SET DE INICIO DE PARTIDA ------------
    public void setIncioPartida(String incioPartida) {
        this.incioPartida = incioPartida;
    }

    //------------ GET DE FIN DE PARTIDA ------------
    public String getFinPartida() {
        return finPartida;
    }
    //------------ SET DE FIN DE PARTIDA ------------
    public void setFinPartida(String finPartida) {
        this.finPartida = finPartida;
    }

    //------------ GET DE RESPUESTAS ACERTADAS DE PARTIDA ------------
    public int getRespuestasAcertadas() {
        return respuestasAcertadas;
    }
    //------------ SET DE RESPUESTAS ACERTADAS DE PARTIDA ------------
    public void setRespuestasAcertadas(int respuestasAcertadas) {
        this.respuestasAcertadas = respuestasAcertadas;
    }

    //------------ GET DE NIVEL PASADO DE PARTIDA ------------
    public boolean getNivelPasado() {
        return nivelPasado;
    }
    //------------ SET DE NIVEL PASADO DE PARTIDA ------------
    public void setNivelPasado(boolean nivelPasado) {
        this.nivelPasado = nivelPasado;
    }

    //------------ GET DE DIFICULTAD DE PARTIDA ------------
    public int getDificultadJugada() {
        return dificultadJugada;
    }
    //------------ SET DE DIFICULTAD DE PARTIDA ------------
    public void setDificultadJugada(int dificultadJugada) {
        this.dificultadJugada = dificultadJugada;
    }

    //------------ TOSTRING DE PARTIDA ------------
    @Override
    public String toString() {
        return "Partida [incioPartida=" + incioPartida + ", finPartida=" + finPartida + ", respuestasAcertadas="
                + respuestasAcertadas + ", nivelPasado=" + nivelPasado + ", dificultadJugada=" + dificultadJugada + "]";
    }

    
}
