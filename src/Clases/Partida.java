/**
 * Partida
 * @author SDM
 * @version 1.7 
 * 14-03-2025
 */
package clases;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * La clase partida se encarga de gestionar la hora de inicio, la hora de fin
 * las respuestas correctas, la dificultad de las preguntas y si ha pasado el
 * nivel o no el jugador.
 */
public class Partida {
    // ------------ VARIABELS DE PARTIDA ------------
    private int id;
    private LocalDate fechaIncioPartida;
    private LocalDate fechaFinPartida;
    private LocalTime horaIncioPartida;
    private LocalTime horaFinPartida;
    private String duracion;
    private int respuestasAcertadas = 0;
    private boolean nivelPasado = false;
    private int dificultadJugada = 0;

    /**
     * Constructor de una partida.
     * 
     * @param id                  Recibe el id de la partida.
     * @param fechaIncioPartida   Recibe la fecha de inicio.
     * @param fechaFinPartida     Recibe la fecha de fin.
     * @param horaIncioPartida    Recibe la hora de inicio.
     * @param horaFinPartida      Recibe la hora de fin.
     * @param respuestasAcertadas Recibe la cantidad de respuestas acertadas.
     * @param nivelPasado         Recibe booleano de nivel pasado.
     * @param dificultadJugada    Recibe la dificultad jugada.
     */
    public Partida(int id, LocalDate fechaIncioPartida, LocalDate fechaFinPartida, LocalTime horaIncioPartida,
            LocalTime horaFinPartida, int respuestasAcertadas, boolean nivelPasado,
            int dificultadJugada) {
        this.id = id;
        this.fechaIncioPartida = fechaIncioPartida;
        this.fechaFinPartida = fechaFinPartida;
        this.horaIncioPartida = horaIncioPartida;
        this.horaFinPartida = horaFinPartida;
        this.respuestasAcertadas = respuestasAcertadas;
        this.nivelPasado = nivelPasado;
        this.dificultadJugada = dificultadJugada;
        this.duracion = obtenerDuracion();
    }

    /**
     * Constructor de una partida sin id y sin duración.
     * 
     * @param fechaIncioPartida   Recibe la fecha de inicio.
     * @param fechaFinPartida     Recibe la fecha de fin.
     * @param horaIncioPartida    Recibe la hora de inicio.
     * @param horaFinPartida      Recibe la hora de fin.
     * @param respuestasAcertadas Recibe la cantidad de respuestas acertadas.
     * @param nivelPasado         Recibe booleano de nivel pasado.
     * @param dificultadJugada    Recibe la dificultad jugada.
     */
    public Partida(LocalDate fechaIncioPartida, LocalDate fechaFinPartida, LocalTime horaIncioPartida,
            LocalTime horaFinPartida, int respuestasAcertadas, boolean nivelPasado,
            int dificultadJugada) {

        this.fechaIncioPartida = fechaIncioPartida;
        this.fechaFinPartida = fechaFinPartida;
        this.horaIncioPartida = horaIncioPartida;
        this.horaFinPartida = horaFinPartida;
        this.respuestasAcertadas = respuestasAcertadas;
        this.nivelPasado = nivelPasado;
        this.dificultadJugada = dificultadJugada;
    }

    // ------------ GETTERS Y SETTERS DE PARTIDA ------------
    // ------------ GET DE FECHA DE INICIO DE PARTIDA ------------
    /**
     * Devuelve la fecha de inicio de la partida.
     * 
     * @return fecha de inicio de la partida.
     */
    public LocalDate getFechaIncioPartida() {
        return fechaIncioPartida;
    }

    // ------------ SET DE FECHA DE INICIO DE PARTIDA ------------
    /**
     * Establece la fecha de inicio de la partida
     * 
     * @param fechaIncioPartida fecha de incio de la partida
     */
    public void setFechaIncioPartida(LocalDate fechaIncioPartida) {
        this.fechaIncioPartida = fechaIncioPartida;
    }

    // ------------ GET DE FECHA DE FIN DE PARTIDA ------------
    /**
     * Devuelve la fecha de fin de la partida
     * 
     * @return fecha de fin de la partida
     */
    public LocalDate getFechaFinPartida() {
        return fechaFinPartida;
    }

    // ------------ SET DE FECHA DE FIN DE PARTIDA ------------
    /**
     * Establece la fecha de fin de la partida
     * 
     * @param fechaFinPartida fecha de fin de la partida
     */
    public void setFechaFinPartida(LocalDate fechaFinPartida) {
        this.fechaFinPartida = fechaFinPartida;
    }

    /**
     * Establece el id de la partida.
     * 
     * @param id id de la partida.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Devuelve el id de la partida.
     * 
     * @return id de la partida.
     */
    public int getId() {
        return id;
    }

    // ------------ GET DE FECHA DE INICIO DE PARTIDA ------------
    /**
     * Devuelve la hora de inicio de la partida.
     * 
     * @return hora de inicio de la partida.
     */
    public LocalTime getHoraIncioPartida() {
        return horaIncioPartida;
    }

    // ------------ SET DE FECHA DE INICIO DE PARTIDA ------------
    /**
     * Establece la hora de inicio de la partida
     * 
     * @param horaIncioPartida hora de inicio de la partida
     */
    public void setHoraIncioPartida(LocalTime horaIncioPartida) {
        this.horaIncioPartida = horaIncioPartida;
    }

    // ------------ GET DE FECHA DE FIN DE PARTIDA ------------
    /**
     * Devuelve la hora de fin de la partida
     * 
     * @return hora de fin de la partida
     */
    public LocalTime getHoraFinPartida() {
        return horaFinPartida;
    }

    // ------------ SET DE FECHA DE FIN DE PARTIDA ------------
    /**
     * Establece la hora de fin de la partida
     * 
     * @param horaFinPartida hora de fin de la partida
     */
    public void setHoraFinPartida(LocalTime horaFinPartida) {
        this.horaFinPartida = horaFinPartida;
    }

    // ------------ GET DE RESPUESTAS ACERTADAS DE PARTIDA ------------
    /**
     * Devuelve las respuestas acert adas
     * 
     * @return respuestasAcertadas
     */
    public int getRespuestasAcertadas() {
        return respuestasAcertadas;
    }

    // ------------ SET DE RESPUESTAS ACERTADAS DE PARTIDA ------------
    /**
     * Establece las respuestas acertadas
     * 
     * @param respuestasAcertadas respuestas acertadas
     */
    public void setRespuestasAcertadas(int respuestasAcertadas) {
        this.respuestasAcertadas = respuestasAcertadas;
    }

    // ------------ GET DE NIVEL PASADO DE PARTIDA ------------
    /**
     * Devuelve el nivel pasado
     * 
     * @return nivel pasado
     */
    public boolean getNivelPasado() {
        return nivelPasado;
    }

    // ------------ SET DE NIVEL PASADO DE PARTIDA ------------
    /**
     * Establece el nivel pasado
     * 
     * @param nivelPasado nivel pasado
     */
    public void setNivelPasado(boolean nivelPasado) {
        this.nivelPasado = nivelPasado;
    }

    // ------------ GET DE DIFICULTAD DE PARTIDA ------------
    /**
     * Devuelve la dificultad jugada.
     * 
     * @return dificultad Jugada
     */
    public int getDificultadJugada() {
        return dificultadJugada;
    }

    // ------------ SET DE DIFICULTAD DE PARTIDA ------------
    /**
     * Establece la dificultad jugada
     * 
     * @param dificultadJugada Dificultad jugada
     */
    public void setDificultadJugada(int dificultadJugada) {
        this.dificultadJugada = dificultadJugada;
    }

    /**
     * Devuelve la duración de la partida
     * 
     * @return Duración de la partida
     */
    public String obtenerDuracion() {
        Duration duracionPartida = Duration.between(this.horaFinPartida, this.horaIncioPartida);
        long segundosTotales = duracionPartida.getSeconds();
        long horas = segundosTotales / 3600;
        long minutos = (segundosTotales % 3600) / 60;
        long segundos = segundosTotales % 60;

        duracion = String.format("%02d:%02d:%02d", horas, minutos, segundos);

        return duracion;
    }

    /**
     * Devuelve la duración de la partida.
     * 
     * @return duración de la partida.
     */
    public String getDuracion() {
        return duracion;
    }

    /**
     * Establece la duración de la partida.
     * 
     * @param duracion duración de la partida,
     */
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    // ------------ TOSTRING DE PARTIDA ------------
    @Override
    public String toString() {
        return String.format(
                """

                        +-----------------------------------------------+
                        |           DATOS DE LA PARTIDA                 |
                        +--------------------------+--------------------+
                        | %-24s | %-18s |
                        | %-24s | %-18s |
                        | %-24s | %-18s |
                        | %-24s | %-18s |
                        | %-24s | %-18s |
                        | %-24s | %-18d |
                        | %-24s | %-18s |
                        | %-24s | %-18d |
                        +--------------------------+--------------------+
                        """,
                "Fecha de inicio", fechaIncioPartida,
                "Fecha de fin", fechaFinPartida,
                "Hora de inicio", horaIncioPartida,
                "Hora de fin", horaFinPartida,
                "Duración", duracion,
                "Respuestas acertadas", respuestasAcertadas,
                "Nivel pasado", nivelPasado ? "Sí" : "No",
                "Dificultad jugada", dificultadJugada);
    }
}
