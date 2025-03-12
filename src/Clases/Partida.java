/**
 * Partida
 * @author SDM
 * 14-03-2025
 */
package clases;

/**
 * La clase partida se encarga de gestionar la hora de inicio, la hora de fin
 * las respuestas correctas, la dificultad de las preguntas y si ha pasado el
 * nivel o no el jugador.
 */
public class Partida {
    // ------------ VARIABELS DE PARTIDA ------------
    private String fechaIncioPartida = "";
    private String fechaFinPartida = "";
    private String horaIncioPartida = "";
    private String horaFinPartida = "";
    private int respuestasAcertadas = 0;
    private boolean nivelPasado = false;
    private int dificultadJugada = 0;

    // ------------ CONSTRUCTOR DE PARTIDA ------------
    public Partida(String fechaIncioPartida, String fechaFinPartida, String horaIncioPartida, String horaFinPartida,
            int respuestasAcertadas, int dificultadJugada, boolean nivelPasado) {
        this.fechaIncioPartida = fechaIncioPartida;
        this.fechaFinPartida = fechaFinPartida;
        this.horaIncioPartida = horaIncioPartida;
        this.horaFinPartida = horaFinPartida;
        this.respuestasAcertadas = respuestasAcertadas;
        this.dificultadJugada = dificultadJugada;
        this.nivelPasado = nivelPasado;
    }

    // ------------ GETTERS Y SETTERS DE PARTIDA ------------
    // ------------ GET DE FECHA DE INICIO DE PARTIDA ------------
    public String getFechaIncioPartida() {
        return fechaIncioPartida;
    }

    // ------------ SET DE FECHA DE INICIO DE PARTIDA ------------
    public void setFechaIncioPartida(String fechaIncioPartida) {
        this.fechaIncioPartida = fechaIncioPartida;
    }

    // ------------ GET DE FECHA DE FIN DE PARTIDA ------------
    public String getFechaFinPartida() {
        return fechaFinPartida;
    }

    // ------------ SET DE FECHA DE FIN DE PARTIDA ------------
    public void setFechaFinPartida(String fechaFinPartida) {
        this.fechaFinPartida = fechaFinPartida;
    }

    // ------------ GET DE FECHA DE INICIO DE PARTIDA ------------
    public String getHoraIncioPartida() {
        return horaIncioPartida;
    }

    // ------------ SET DE FECHA DE INICIO DE PARTIDA ------------
    public void setHoraIncioPartida(String horaIncioPartida) {
        this.horaIncioPartida = horaIncioPartida;
    }

    // ------------ GET DE FECHA DE FIN DE PARTIDA ------------
    public String getHoraFinPartida() {
        return horaFinPartida;
    }

    // ------------ SET DE FECHA DE FIN DE PARTIDA ------------
    public void setHoraFinPartida(String horaFinPartida) {
        this.horaFinPartida = horaFinPartida;
    }

    // ------------ GET DE RESPUESTAS ACERTADAS DE PARTIDA ------------
    public int getRespuestasAcertadas() {
        return respuestasAcertadas;
    }

    // ------------ SET DE RESPUESTAS ACERTADAS DE PARTIDA ------------
    public void setRespuestasAcertadas(int respuestasAcertadas) {
        this.respuestasAcertadas = respuestasAcertadas;
    }

    // ------------ GET DE NIVEL PASADO DE PARTIDA ------------
    public boolean getNivelPasado() {
        return nivelPasado;
    }

    // ------------ SET DE NIVEL PASADO DE PARTIDA ------------
    public void setNivelPasado(boolean nivelPasado) {
        this.nivelPasado = nivelPasado;
    }

    // ------------ GET DE DIFICULTAD DE PARTIDA ------------
    public int getDificultadJugada() {
        return dificultadJugada;
    }

    // ------------ SET DE DIFICULTAD DE PARTIDA ------------
    public void setDificultadJugada(int dificultadJugada) {
        this.dificultadJugada = dificultadJugada;
    }
    
    // ------------ TOSTRING DE PARTIDA ------------
    @Override
    public String toString() {
        return "Partida [fechaIncioPartida=" + fechaIncioPartida + ", fechaFinPartida=" + fechaFinPartida
                + ", horaIncioPartida=" + horaIncioPartida + ", horaFinPartida=" + horaFinPartida
                + ", respuestasAcertadas=" + respuestasAcertadas + ", nivelPasado=" + nivelPasado
                + ", dificultadJugada=" + dificultadJugada + "]";
    }

}
