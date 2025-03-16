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

import clases.Escapista;
import clases.GestionPreguntas;
import clases.Partida;
import clases.Policia;
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

    public static String leerRespuesta(Pregunta p) throws IOException {
        int respuesta = leerEnteroValidado(); // Comprueba la respuesta 1
        return p.getOpciones()[respuesta - 1];
    }

    private static void fJElse(int msglvl) {
        msglvl = 2;
        System.out.println(VarGenYConst.mensajesJuego[msglvl]);
        System.out.println(VarGenYConst.mensajesJuego[VarGenYConst.MENSAJEDER]);
        VarGenYConst.salirJuego = true; // Te saca del juego tras perder

    }

    /**
     * Este método se encarga de ejecutar todos los finales posibles en la dificultad dificil.
     * @param acertada Manda si la última pregunta fue acertada o no.
     * @param reAcertadas Manda el número de respuestas acertadas.
     * @param msglvl Manda un entero para mostrar el mensaje adecuado.
     * @param frenado Manda si el jugador fue frenado en alguna pregunta o no.
     */
    public static void finalizarJuegoDificil(boolean acertada, int reAcertadas, int msglvl, boolean frenado) {
        switch (reAcertadas) {

            case 0:
                fJElse(msglvl);
                break;

            case 1:
                if (acertada && !frenado) {
                    msglvl = 0;
                    msgGeneral(msglvl);
                } else if (acertada && frenado) {
                    msglvl= 0;
                    msgGeneral(msglvl);
                } else {
                    fJElse(msglvl);
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
                    msglvl = 0;
                    msgGeneral(msglvl);
                } else {
                    fJElse(msglvl);
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

    private static void msgGeneral(int msglvl){
        System.out.println(VarGenYConst.mensajesJuego[msglvl]);
        System.out.println(VarGenYConst.mensajesJuego[VarGenYConst.MENSAJEDER]);
        VarGenYConst.salirJuego = true; // Te saca del juego tras perder
    }
    public static void finalizarJuegoFaMe(boolean acertada, int reAcertadas, int msglvl) {
        switch (reAcertadas) {

            case 0:
                fJElse(msglvl);
                break;

            case 1:
                if (acertada) {
                    msglvl = 0;
                    msgGeneral(msglvl);
                } else {
                    fJElse(msglvl);
                }
                break;

            case 2:
                if (acertada) {
                    msglvl = 1;
                    msgGeneral(msglvl);
                } else if (!acertada) {
                    msglvl = 0;
                    msgGeneral(msglvl);
                } else {
                    fJElse(msglvl);
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

    public static void finalizarJuegoPasado() {

    }

    public static void guardarPartida(int reAcertadas, boolean lvlPasado) {
        VarGenYConst.fechaFinPartida = LocalDate.now();
        VarGenYConst.horaFinPartida = LocalTime.now();
        VarGenYConst.partida = new Partida(VarGenYConst.fechaIncioPartida, VarGenYConst.fechaFinPartida,
                VarGenYConst.horaIncioPartida, VarGenYConst.horaFinPartida, reAcertadas, VarGenYConst.dificultad, lvlPasado);
    }
}
