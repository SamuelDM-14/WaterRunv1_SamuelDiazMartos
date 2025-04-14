package gestionjuego.juego;

import java.io.IOException;
import clases.Pregunta;
import utilidades.Utilidades;
import utilidades.VarGenYConst;

public class UtilidadesJuego {
    
    /**
     * Metodo qeu devuelve un array de pantallas para mostrar en el juego.
     * 
     * @return Devuelve un array con las pantallas a mostrar.
     */
    public static String[] gestorPantallas() {

        // pantalla1 del juego
        String pantalla1 = """
                █████████████████████████████████████████████████████
                █                                                   █
                ██                                                  █
                                                                   | |
                                                                   | |
                ██                                                 | |
                █                                                   █
                █                                         ███████████
                █                                         ███████████
                █                                         ███████████
                █                                         ███████████
                █                                         ███████████
                █                                         ███████████
                █                               █████████████████████
                █                               █████████████████████
                █                               █████████████████████
                █""" + VarGenYConst.colorPj + """
                \t  o  """ + VarGenYConst.COLOR_RESET + """
                                     █████████████████████
                █""" + VarGenYConst.colorPj + """
                \t /L """ + VarGenYConst.COLOR_RESET + """
                                     █████████████████████
                █""" + VarGenYConst.colorPj + """
                \t | """ + VarGenYConst.COLOR_RESET + """
                                      █████████████████████
                █████████████████████████████████████████████████████
                        """;
        // pantalla 2 del juego.
        String pantalla2 = """
                █████████████████████████████████████████████████████
                █                                                   █
                ██                                                  █
                                                                   | |
                                                            """ + VarGenYConst.colorPj + """
                \t\t\t\t\t     o""" + VarGenYConst.COLOR_RESET + """
                \t   | |
                ██                                         """ + VarGenYConst.colorPj + """
                \t\t\t\t\t    /L""" + VarGenYConst.COLOR_RESET + """
                     | |
                █                                          """ + VarGenYConst.colorPj + """
                \t\t\t\t\t    |""" + VarGenYConst.COLOR_RESET + """
                \t    █
                █                                         ███████████
                █                                         ███████████
                █                                         ███████████
                █                                         ███████████
                █                                         ███████████
                █                                         ███████████
                █                               █████████████████████
                █                               █████████████████████
                █                               █████████████████████
                █                               █████████████████████
                █                               █████████████████████
                █                               █████████████████████
                █████████████████████████████████████████████████████
                    """;

        // Array de pantallas
        String[] pantallas = { pantalla1, pantalla2 };
        return pantallas;
    }

    /**
     * Muestra las preguntas del juego.
     * 
     * @param p        Recibe el objeto pregunta.
     * @param pantalla Recibe el String que muestra las pantallas de juego.
     */
    public static void mostrarPregunta(Pregunta p, String pantalla) {

        System.out.println(pantalla);
        System.out.println(p.getEnunciado());
        String[] opciones = p.getOpciones();
        for (int i = 0; i < opciones.length; i++) {
            if (!opciones[i].isEmpty()) {
                System.out.println((i + 1) + ") " + opciones[i]);
            }
        }

    }

    /**
     * Lee las respuestas del usuario por pregunta y devuelve el dato de la
     * respuesta.
     * 
     * @param p Recibe el objeto pregunta.
     * @return Devuelve el dato de la respuesta.
     * @throws IOException Excepción para poder leer con BufferedReader.
     */
    public static String leerRespuesta(Pregunta p) {
        int respuesta = Utilidades.leerEnteroValidado(); // Comprueba la respuesta 1
        return p.getOpciones()[respuesta - 1];
    }

    /**
     * Este método se encarga de ejecutar todos los finales posibles en la
     * dificultad dificil.
     * 
     * @param acertada    Manda si la última pregunta fue acertada o no.
     * @param reAcertadas Manda el número de respuestas acertadas.
     * @param msglvl      Manda un entero para mostrar el mensaje adecuado.
     * @param frenado     Manda si el jugador fue frenado en alguna pregunta o no.
     */
    public static void finalizarJuegoDificil(boolean acertada, int reAcertadas, int msglvl, boolean frenado) {
        switch (reAcertadas) {

            case 0:
                msglvl = 0;
                msgGeneral(msglvl);
                break;

            case 1:
                if (acertada && !frenado) {
                    msglvl = 0;
                    msgGeneral(msglvl);
                } else if (acertada && frenado) {
                    msglvl = 0;
                    msgGeneral(msglvl);
                } else {
                    msglvl = 0;
                    msgGeneral(msglvl);
                }
                break;

            case 2:
                if (acertada && !frenado) {
                    msglvl = 1;
                    msgGeneral(msglvl);
                } else if (acertada && frenado) {
                    msglvl = 0;
                    msgGeneral(msglvl);
                } else if (!acertada) {
                    msglvl = 2;
                    msgGeneral(msglvl);
                } else {
                    msglvl = 0;
                    msgGeneral(msglvl);
                }
                break;
            case 3:
                System.out.println(VarGenYConst.mensajesJuego[VarGenYConst.MENSAJEVIC]);
                VarGenYConst.salirJuego = true; // Te saca del juego tras perder
                break;
            default:
                break;
        }
    }

    /**
     * Manda un mensjae general Cuando pierdes.
     * 
     * @param msglvl Entero que indica que mensaje mandar.
     */
    private static void msgGeneral(int msglvl) {
        System.out.println(VarGenYConst.mensajesJuego[msglvl]);
        System.out.println(VarGenYConst.mensajesJuego[VarGenYConst.MENSAJEDER]);
        VarGenYConst.salirJuego = true; // Te saca del juego tras perder
    }

    /**
     * Manda los mensajes de finalización de juego de las dificultades fácil y
     * media.
     * 
     * @param acertada    Recibe si ha acertado la última pregunta.
     * @param reAcertadas Recibe el total de las respuestas acertadas.
     * @param msglvl      Recibe un entero que se usará para seleccionar un mensaje
     *                    específico.
     */
    public static void finalizarJuegoFaMe(boolean acertada, int reAcertadas, int msglvl) {
        switch (reAcertadas) {

            case 0:
                msglvl = 2;
                msgGeneral(msglvl);
                break;

            case 1:
                if (acertada) {
                    msglvl = 0;
                    msgGeneral(msglvl);
                } else {
                    msglvl = 2;
                    msgGeneral(msglvl);
                }
                break;

            case 2:
                if (acertada) {
                    msglvl = 1;
                    msgGeneral(msglvl);
                } else if (!acertada) {
                    msglvl = 2;
                    msgGeneral(msglvl);
                } else {
                    msglvl = 2;
                    msgGeneral(msglvl);
                }
                break;
            case 3:
                System.out.println(VarGenYConst.mensajesJuego[VarGenYConst.MENSAJEVIC]);
                VarGenYConst.salirJuego = true; // Te saca del juego
                break;
            default:
                break;
        }
    }



}
