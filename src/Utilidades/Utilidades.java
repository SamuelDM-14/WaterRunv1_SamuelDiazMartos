/**
 * Utilidades
 * @author SDM
 * 07-03-2025
 */
package utilidades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;

import clases.Partida;
import clases.Pregunta;

/**
 * Archivo Utilidades que usaremos para metodos de validación
 */
public class Utilidades {

    // Usamos BufferedReader para leer. Creación del objeto.
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Lee un único caracter desde teclado ('S' o 'N'), validando que no sea otro.
     * 
     * @return 'S' o 'N' en mayúscula
     * @throws IOException
     */
    public static char leerSN() throws IOException {
        boolean valido = false;
        char c = ' '; // variable donde guardaremos la elección
        do { // Repite hasta que escribas el caracter correcto.

            String caracter = bf.readLine(); // Guarda la respuesta en un string.

            if (caracter.length() == 1) { // Comprueba que el string sea de 1 caracter.
                c = caracter.charAt(0); // combierte el string en caracter y lo guarda en re1
                c = Character.toUpperCase(c); // pasa el re1 a mayusculas y lo guarda de nuevo en re1
                if (c == 'S' || c == 'N') {
                    valido = true;
                } else {
                    System.out.println("No has escrito ninguna de las 2 opciones. Prueba otra vez.");
                }
            } else {
                System.out.println("No has escrito un único caracter. Prueba otra vez.");
            }
        } while (!valido);

        return c;
    }

    /**
     * Lee un número entero, validando que esté entre min y max.
     * Si el usuario escribe algo inválido (caracteres no numéricos o número fuera
     * de rango), el método vuelve a pedirlo.
     * 
     * @return el número entero válido que el usuario introduzca
     */
    public static int leerEnteroValidado() throws IOException {
        boolean valido = false;
        int valor = 0; // variable para guardar la lectura
        while (!valido) {
            try {
                String linea = bf.readLine(); // leer texto
                valor = Integer.parseInt(linea); // convertir a int
                if (valor >= VarGenYConst.min && valor <= VarGenYConst.max) {
                    valido = true; // se cumple la condición → marcamos como válido
                } else {
                    System.out.println(
                            "Error: Debes escribir un número entre " + VarGenYConst.min + " y " + VarGenYConst.max
                                    + ". Inténtalo de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: No has escrito un número válido. Inténtalo de nuevo.");
            }
        }
        // Cuando salgamos del while, 'valido == true', y 'valor' está en rango
        return valor;
    }

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
    public static String leerRespuesta(Pregunta p) throws IOException {
        int respuesta = leerEnteroValidado(); // Comprueba la respuesta 1
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
                VarGenYConst.salirJuego = true; // Te saca del juego tras perder
                break;
            default:
                break;
        }
    }

    /**
     * Guarda los datos de las partidas.
     * 
     * @param reAcertadas Recibe el número de respuestas acertadas.
     * @param lvlPasado   Recibe si el nivel se ha pasado o no.
     */
    public static void guardarPartida(int reAcertadas, boolean lvlPasado) {
        VarGenYConst.fechaFinPartida = LocalDate.now();
        VarGenYConst.horaFinPartida = LocalTime.now();
        VarGenYConst.partida = new Partida(VarGenYConst.fechaIncioPartida, VarGenYConst.fechaFinPartida,
                VarGenYConst.horaIncioPartida, VarGenYConst.horaFinPartida, reAcertadas, VarGenYConst.dificultad,
                lvlPasado);
    }

}
