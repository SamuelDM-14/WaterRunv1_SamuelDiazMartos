/**
 * Jugar
 * @author SDM
 * 07-03-2025
 */
package gestionjuego.juego;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import clases.Partida;
import utilidades.ReproductorMusica;
import utilidades.Utilidades;
import utilidades.VarGenYConst;

/**
 * Esta clase se encarga de toda la gestion general de jugar.
 */
public class Jugar {

    public static LocalDate fechaFinPartida;// Guarda la fecha del fin de la partida.
    public static LocalTime horaFinPartida;// Guarda la hora de fin de partida.

    /**
     * Jugar. Muestra el juego, el cual va sacando preguntas y respuestas y
     * comprobandolas.
     * 
     * @author SDM
     * @param bf
     * @throws IOException
     */
    public static void jugar(ReproductorMusica jugador) throws IOException {
        // Respuestas del juego
        VarGenYConst.opcionMenu = 1;

        char re1; // Respuesta jugar o no jugar.
        Boolean jugar = false; // Comprobar si el jugador quiere jugar o no.

        VarGenYConst.salirJuego = false; // Pone en false el salir. Si has jugado sin recargar el programa te sacaria en
                                         // la primera seleccion de salir.

        do { // Repite hasta que el jugador indique que quiera salir. Más adelante, cuando se
             // pase un nivel, le dará la opcion de guardar y de salir.
            System.out.println(VarGenYConst.MOSTRARMENUS[VarGenYConst.opcionMenu]); // Explicación de como funcionan las
                                                                                    // respuestas y como
            // funciona el juego.
            re1 = Utilidades.leerSN();

            if (re1 == 'S') {
                jugar = true; // Variable para entrar al juego
                jugador.detener();;
                jugador.reproducir("src/Wavs/tetris.wav");
            } else if (re1 == 'N') {
                jugar = false; // Variable para entrar al juego
                VarGenYConst.salirJuego = true; // Variable para volver al menú
            } else {
                System.out.println("No has escrito ninguna de las 2 opciones. Prueba otra vez.");
            }

            if (jugar == true) { // Inicio del juego
                LocalDate fechaIncioPartida = LocalDate.now();
                VarGenYConst.horaDeinicio = LocalTime.now();
                Partida partida = new Partida(fechaIncioPartida, null, horaFinPartida, null, 0, VarGenYConst.dificultad, false);
                if (VarGenYConst.dificultad == 2) {
                    // Llama al metodo jugarDificil para gestionar el juego en esa dificultad
                    JugarDificil.jugarDificil(partida);
                } else {
                    // Llama al metodo jugarFaMe para gestionar el juego en facil y medio
                    JugarFaMe.jugarFaMe(partida);
                }
                jugador.detener();;
                jugador.reproducir("src/Wavs/resonant.wav");
            } else { // Si eliges no jugar
                System.out.println("Volviendo al menú principal.");
                VarGenYConst.salirJuego = true; // Variable salir del bucle juego.
            }
        } while (VarGenYConst.salirJuego == false);

    }

}
