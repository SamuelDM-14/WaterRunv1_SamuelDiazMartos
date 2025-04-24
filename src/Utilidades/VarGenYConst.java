/**
 * Variables Genericas y Constantes
 * @author SDM
 * @version 1.7
 * 17-03-2025
 */
package utilidades;

import java.time.LocalTime;
import java.util.ArrayList;

import clases.Jugador;
import clases.Partida;

/**
 * Esta clase contiene todas las variables genericas y constantes del programa.
 */
public class VarGenYConst {

        // Todos los menús del juego estan aqui. Accederemos a ellos mencionando
        // directamente a MOSTRARMENUS.
        public static final String[] MOSTRARMENUS = {
                        "Elige una opcón del menú.\n\t1) Jugar.\n\t2) Dificultad\n\t3) Aspecto\n\t4) Historial de juego.\n\t5) Opciones de música. \n\t6) Datos del Perfil. \n\t7) Salir.",
                        "Has elegico jugar.\nPara ponerte en contexto, eres un prisionero condenado injustametne a muerte por ahogamiento.\nTu desafío inicial es encontrar la manera de escapar de la sala que se irá inundando.\nPara ello, deberas resolver una serie de acertijos o preguntas que te iremos mostrando.\nAl responder las preguntas o acertijos deberas de poner el número correspondiente indicado.\nEjemplo: ¿Cuantas letras tiene Hola?\n1) 4 \t\t 2) 7 \t\t 3) 5 \t\t 4) 1 \nEn este caso tendrias que poner como respuesta \'1\'. \nSi fallas al responder o ponea un caracter no valido se contará como error.\n¿Estas preparado? (Respuesta con 'S' para si y 'N' para no)\n",
                        "Selecciona la dificultad en la que desea jugar. Por defecto esta la dificultad FÁCIL.\n\t 1) FÁCIL\n\t 2) MEDIA\n\t 3) DIFÍCIL\n\t 4) SALIR",
                        "Has elegido la opción de aspecto.\nEn este menú, puedes personalizar el color de tu personaje entre la siguiente selección y el color del agua también.\n¿Que quieres personalizar?\n\t1) Color del personaje.\n\t2) Color del Policia.\n\t3) Salir.",
                        "Elige un color para tu personaje:\n\t1)Rojo\t2)Verde\t3)Amarillo\t4)Azul\t5)Morado\t6)Cian\t7)Blanco\t8)Negro\t9)Salir",
                        "Elige un color para el policia:\n\t1)Rojo\t2)Verde\t3)Amarillo\t4)Azul\t5)Morado\t6)Cian\t7)Blanco\t8)Negro\t9)Salir",
                        "Has seleccionado el menú de historial. Pulse 4 para salir.\n\t1) Jugar una partida guardada. (Proximamente)\n\t2) Revisar elecciónes de partida. (Proximamente)\n\t3) Datos de partida guardada.\n\t4) Salir.",
                        "Has seleccionado datos del perfil. \n\t1) Cambiar nombre. \n\t2) Cambiar contraseña. \n\t3) Salir",
                        "Has seleccionado Opciones de Música. \n\t1) Establecer volumen. \n\t2) Subir volumen. \n\t3) Bajar volumen. \n\t4) Detener música. \n\t5) Reproducir música. \n\t6) Salir."
                };
        // Variable para mostrar el menú adecuado. En cada metodo cambia.
        public static int opcionMenu = 0;

        // Variables utilizadas para leer números enteros y validar las respuestas.
        public static int max = 5;
        public static int min = 0;

        // Variable para seleccionar la dificultad del jnuego
        public static int dificultad = 0;

        // Deja el color como al principio.
        public static final String COLOR_RESET = "\u001B[0m";

        // Colores para los personajes.
        public static String colorPj = "\u001B[37m";

        // Colores del fondo.
        public static String colorPo = "\u001B[40m";

        // Colores para los personajes.

        public static final String[] COLORESPJ = {
                        "\u001B[31m", // 0=Rojo
                        "\u001B[32m", // 1=Verde
                        "\u001B[33m", // 2=Amarillo
                        "\u001B[34m", // 3=Azul
                        "\u001B[35m", // 4=Morado
                        "\u001B[36m", // 5=Cyan
                        "\u001B[37m", // 6=Blanco
                        "\u001B[30m"// 7=Negro
        };

        // Colores del fondo.

        public static final String[] COLORESPOLICIA = {
                        "\u001B[41m", // 0=Rojo
                        "\u001B[42m", // 1=Verde
                        "\u001B[43m", // 2=Amarillo
                        "\u001B[44m", // 3=Azul
                        "\u001B[45m", // 4=Morado
                        "\u001B[46m", // 5=Cyan
                        "\u001B[47m", // 6=Blanco
                        "\u001B[40m",// 7=NEGRO
        };

        // Variable para salir del juego, te lo hayas pasado o hayas perdido.
        public static boolean salirJuego = false;

        // Guarda los mensajes del juego a los que accederemos mediante el array.
        public static String[] mensajesJuego = { "¡Has acertado! Tu personaje avanza hasta la rendija de salida.",
                        "¡Has acertado! Tu personaje empieza a abrir la cerradura.",
                        "Has fallado.",
                        "Oh no, el agua subió demasiado rápido, has perdido.",
                        "¡Has acertado! Tu personaje ha huido."
        };
        // Guarda el mensaje del policia para cuando acierte el disparo.
        public static String mensajePoli = "¡Has acertado! Tu personaje avan...\n¡OH NO! El policia ha acertado el disparo, el escapista permanece inmovil 1 turno.";
        // Constante para acceder al mensaje de derrota.
        public static final int MENSAJEDER = 3;
        // Constante para acceder al mensaje de victoria.
        public static final int MENSAJEVIC = 4;

        public static boolean iniciar = true;

        // ------------ VARIABLES PARA PARTIDA ------------
        public static LocalTime horaDeinicio;
        public static ArrayList<Partida> partidas = new ArrayList<Partida>();
        public static ArrayList<Partida> partidasSesion = new ArrayList<Partida>();


        public static Jugador jugador = new Jugador(0, null, null, null);

        public static String preguntaJuego;
        public static String respuestaJuego;
}
