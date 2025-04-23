/**
 * GestionJugar
 * @author SDM
 * 07-03-2025
 */
package gestionjuego;


import gestionjuego.juego.Jugar;
import gestionjuego.salir.GestionSalir;
import utilidades.ReproductorMusica;
import utilidades.Utilidades;
import utilidades.VarGenYConst;

/**
 * GestionJugar
 * Se encarga de gestionar los menús, las selecciones y las variables del juego
 * generales.
 */
public class GestionJugar {
    private static ReproductorMusica musica = new ReproductorMusica();

    /**
     * Menu1. Muestra las diferentes opciones de menú y te manda según tu selección
     * al apartado correspondiente.
     */
    private static void menu1() {
        // variables menu1
        boolean salir = false;// variable para acabar el programa;
        int eleccion = 0;// Lee la elección del primer menú.

        do { // Bucle menú (Se repite hasta indicar salir.)
            VarGenYConst.max = 7;
            VarGenYConst.min = 1;
            VarGenYConst.opcionMenu = 0;
            System.out.println(VarGenYConst.MOSTRARMENUS[VarGenYConst.opcionMenu]);

            eleccion = Utilidades.leerEnteroValidado(); // Lee la entrada.

            switch (eleccion) {

                case 1:
                    // Entra en caso de elegir Jugar.
                    Jugar.jugar(musica); // Llama al metodo jugar y le envia el objeto ReproductorMusica.
                    break;

                case 2:
                    // Entra en caso de elegir Dificultad.
                    dificultadDelJuego();// Llama al metodo dificultadDelJuego.
                    break;
                case 3:
                    // Entra en caso de elegir Aspecto.
                    GestionAspecto.cambiarAspecto();// Llama al metodo cambiarAspecto.
                    break;

                case 4:
                    // Entra en caso de elegir Historial.
                    GestionHistorial.historial();;// Llama al metodo historial.
                    break;

                case 5:
                    // Entra en caso de elegir Opciones de Música.
                    GestionMusica.menuMusica(musica);// Llama al metodo menuMusica y le envia un objeto ReproductorMusica.
                    break;
                case 6:
                    // Entra en caso de elegir Opciones de Música.
                    GestionPerfil.menuPerfil();// Llama al metodo menuPerfil.
                    break;
                case 7:
                    // Entra en caso de elegir Salir.
                    GestionSalir.salir();
                    salir = true; // Pone salir en true para salir del bucle del menú.
                    break;
            }
            ;
        } while (salir == false);
        System.out.println("Muchas gracias por participar."); // Muestra mensaje de agradecimiento.
    }

    /**
     * Dificultad. Te permite elegir la dificultad con la que jugar.
     */
    private static void dificultadDelJuego() {
        VarGenYConst.opcionMenu = 2;
        VarGenYConst.max = 3;
        VarGenYConst.min = 0;
        boolean salirDificultad = false;
        int lecturaDif = 0;
        do {
            System.out.println(VarGenYConst.MOSTRARMENUS[VarGenYConst.opcionMenu]);
            lecturaDif = Utilidades.leerEnteroValidado();
            switch (lecturaDif) {
                case 0:
                    VarGenYConst.dificultad = lecturaDif;
                    System.out.println("Has elegido la dificultad \"FÁCIL\".");
                    break;
                case 1:
                    VarGenYConst.dificultad = lecturaDif;
                    System.out.println("Has elegido la dificultad \"MEDIA\".");
                    break;
                case 2:
                    VarGenYConst.dificultad = lecturaDif;
                    System.out.println("Has elegido la dificultad \"DIFÍCIL\".");
                    break;
                case 3:
                    System.out.println("Has elegido \"SALIR\". Volviendo al menú principal.");
                    salirDificultad = true;
                    break;
            }
        } while (salirDificultad == false);
    }



    /**
     * Bienvenida al juego. Comprueba que solo pongas un enter.
     */
    public static void bienvenida() {

        // Bienvenida. Usamos tres comillas para poder escribir en varias lineas.
        System.out.println("""

                    ██████  ██ ███████ ███    ██ ██    ██ ███████ ███    ██ ██ ██████   ██████
                    ██   ██ ██ ██      ████   ██ ██    ██ ██      ████   ██ ██ ██   ██ ██    ██
                    ██████  ██ █████   ██ ██  ██ ██    ██ █████   ██ ██  ██ ██ ██   ██ ██    ██
                    ██   ██ ██ ██      ██  ██ ██  ██  ██  ██      ██  ██ ██ ██ ██   ██ ██    ██
                    ██████  ██ ███████ ██   ████   ████   ███████ ██   ████ ██ ██████   ██████

                """);

        GestionUsuario.validacionUsuario();

        if (VarGenYConst.iniciar) {
            validacionEntrada();
        }
    }

    /**
     * 
     */
    private static void validacionEntrada() {
        // variables
        boolean empezar = false; // Para comprobar que haya puesto un enter
        String entrada = ""; // Leer una línea de texto.
        System.out.println("Pulsa \'Enter\' para continuar");

        do {
            entrada = Utilidades.leerCadena();// Guarda en entrada el caracter introducido.
            if (entrada.isEmpty()) { // Comprueba que la entrada esté vacía
                System.out.println("¡Vamos a empezar a jugar!\n");
                // 🔊 Reproducir música de fondo
                musica.reproducir("src/Wavs/resonant.wav");
                empezar = true;// Cambia la variable a verdadero para salir del bucle.
            } else {
                System.out.println("Has introducido un caracter incorrecto, pulse enter para empezar.");
            }
        } while (empezar == false);
        // Llamamos al metodo menu1 y le enviamos el bufferedReader
        menu1();
    }

}
