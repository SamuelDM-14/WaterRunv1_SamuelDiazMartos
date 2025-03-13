/**
 * GestionJugar
 * @author SDM
 * 07-03-2025
 */
package gestionjuego;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import utilidades.Utilidades;

/**
 * GestionJugar
 * Se encarga de gestionar los menús, las selecciones y las variables del juego generales.
 */
public class GestionJugar {

    //Usamos BufferedReader para leer. Creación del objeto.
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    // Todos los menús del juego estan aqui. Accederemos a ellos mencionando directamente a MOSTRARMENUS.
    private static final String[] MOSTRARMENUS= {"Elige una opcón del menú.\n\t1) Jugar.\n\t2) Dificultad\n\t3) Aspecto\n\t4) Historial de juego.\n\t5) Salir.",
        "Has elegico jugar.\nPara ponerte en contexto, eres un prisionero condenado injustametne a muerte por ahogamiento.\nTu desafío inicial es encontrar la manera de escapar de la sala que se irá inundando.\nPara ello, deberas resolver una serie de acertijos o preguntas que te iremos mostrando.\nAl responder las preguntas o acertijos deberas de poner el número correspondiente indicado.\nEjemplo: ¿Cuantas letras tiene Hola?\n1) 4 \t\t 2) 7 \t\t 3) 5 \t\t 4) 1 \nEn este caso tendrias que poner como respuesta \'1\'. \nSi fallas al responder o ponea un caracter no valido se contará como error.\n¿Estas preparado? (Respuesta con 'S' para si y 'N' para no)\n",
        "Selecciona la dificultad en la que desea jugar. Por defecto esta la dificultad FÁCIL.\n\t 0) FÁCIL\n\t 1) MEDIA\n\t 2) DIFÍCIL\n\t 3) SALIR", 
        "Has elegido la opción de aspecto.\nEn este menú, puedes personalizar el color de tu personaje entre la siguiente selección y el color del agua también.\n¿Que quieres personalizar?\n\t1) Color del personaje.\n\t2) Color del Policia.\n\t3) Salir.",
        "Elige un color para tu personaje:\n\t1)Rojo\t2)Verde\t3)Amarillo\t4)Azul\t5)Morado\t6)Cian\t7)Blanco\t8)Negro\t9)Salir",
        "Elige un color para el policia:\n\t1)Rojo\t2)Verde\t3)Amarillo\t4)Azul\t5)Morado\t6)Cian\t7)Blanco\t8)Negro\t9)Salir",
        "Este menú aun no esta disponible. Pulse 3 para salir.\n\t1) Jugar una partida guardada. (Proximamente)\n\t2) Revisar elecciónes de partida. (Proximamente)\n\t3) Salir."
    };
    //Variable para mostrar el menú adecuado. En cada metodo cambia.
    private static int opcionMenu=0;

    //Variables utilizadas para leer números enteros y validar las respuestas.
    private static int max = 5;
    private static int min = 0;



    //Variable para seleccionar la dificultad del jnuego
    private static int dificultad=0;

    
    /**
     * Menu1. Muestra las diferentes opciones de menú y te manda según tu selección al apartado correspondiente.
     * @author SDM
     * @param bf
     * @throws IOException
     */
    private static void menu1() throws IOException{
        //variables menu1
        boolean salir=false;//variable para acabar el programa; 
        int eleccion=0;// Lee la elección del primer menú.

        do{ //Bucle menú (Se repite hasta indicar salir.)
            max = 5;
            min = 1;
            opcionMenu = 0;
            System.out.println(MOSTRARMENUS[opcionMenu]);
    
            eleccion=Utilidades.leerEnteroValidado(min, max); //Lee la entrada.
    
            switch (eleccion) { 
    
                case 1:
                    //Entra en caso de elegir Jugar
                    Jugar.jugar(MOSTRARMENUS, dificultad);; // Llama al metodo jugar y le envia el bufferedReader
                    break;

                case 2:
                    //Entra en caso de elegir Dificultad
                    dificultadDelJuego();// Llama al metodo dificultadDelJuego y le envia el BufferedReader
                    break;
                case 3:
                    //Entra en caso de elegir Aspecto
                    Aspecto.cambiarAspecto(MOSTRARMENUS);// Llama al metodo cambiarAspecto y le envia el bufferedReader
                    break;

                case 4:
                    //Entra en caso de elegir Historial
                    historial();// Llama al metodo historial y le envia el bufferedReader
                    break;

                case 5:
                    //Entra en caso de elegir Salir
                    System.out.println("Saliendo del juego");
                    salir=true; //Pone salir en true para salir del bucle del menú. 
                    break;
            };  
        }while (salir==false); 
        System.out.println("Muchas gracias por participar."); //Muestra mensaje de agradecimiento.
    }


    /**
     * Dificultad. Te permite elegir la dificultad con la que jugar.
     * @author SDM
     * @param bf
     * @throws IOException
     */
    private static void dificultadDelJuego() throws IOException{
        opcionMenu= 2;
        max=3;
        min=0;
        boolean salirDificultad = false;
        int lecturaDif = 0;
        do{
                System.out.println(MOSTRARMENUS[opcionMenu]);
                lecturaDif=Utilidades.leerEnteroValidado(min, max);
                switch (lecturaDif) {
                    case 0:
                        dificultad = lecturaDif;
                        System.out.println("Has elegido la dificultad \"FÁCIL\".");
                        break;
                    case 1:
                        dificultad = lecturaDif;
                        System.out.println("Has elegido la dificultad \"MEDIA\".");
                        break;
                    case 2:
                        dificultad = lecturaDif;
                        System.out.println("Has elegido la dificultad \"DIFÍCIL\".");
                        break;   
                    case 3:
                        System.out.println("Has elegido \"SALIR\". Volviendo al menú principal.");
                        salirDificultad=true;
                        break;
                }
        }while (salirDificultad==false);
    }


    /**
     * Historial. Actualmente sin funcionamiento.
     * @author SDM
     * @param bf
     * @throws IOException
     */
    private static void historial() throws IOException{
    //Respuestas Historial
    int eleccionHistorial;// Respuesta de elección de historial.
    boolean salirHistorial=false;
    
    //Historial
    salirHistorial=false; //Pone en false el salirHistorial. Si has seleccionado previamente esta opción y has salido, 
    //Te sacaria en cuanto eligieras algo que te mueva a este menú.
    do{ //Repite hasta que el usuario seleccione salir.
        //Muestra las opciones. (No disponible de momento.)
        max = 3;
        min = 1;
        opcionMenu = 6;
        System.out.println(MOSTRARMENUS[opcionMenu]);
        eleccionHistorial=Utilidades.leerEnteroValidado(min, max); //Lee la elección
        switch (eleccionHistorial) { //Selecciona según haya elegido.
            case 1:
                System.out.println("Ha selecionado \'Jugar partida guardada\', Este menú aun no esta disponible.");
                break;
            case 2:
                System.out.println("Ha selecionado \'Revisar elecciónes de partida.\', Este menú aun no esta disponible.");
                break;
            case 3:
                System.out.println("Ha selecionado salir. Volviendo al menú principal");
                salirHistorial=true; //Vuelve al menú principal.
                break;    
            default:
                //No pongo nada debido a que las validaciones correspondientes estan hechas.
                break;
        }

    }while (salirHistorial==false);

    }
    
    
    /**
     * Bienvenida al juego. Comprueba que solo pongas un enter.
     * @author SDM 
     * @param bf
     * @throws IOException
     */
    public static void bienvenida() throws IOException{
        //variables Bienvenida
        boolean empezar=false; // Para comprobar que haya puesto un enter
        String entrada=""; // Leer una línea de texto.

        //Bienvenida. Usamos tres comillas para poder escribir en varias lineas.
        //Este recurso lo vamos a usar bastante a lo largo del codigo.
        System.out.println(""" 
    
            ██████  ██ ███████ ███    ██ ██    ██ ███████ ███    ██ ██ ██████   ██████  
            ██   ██ ██ ██      ████   ██ ██    ██ ██      ████   ██ ██ ██   ██ ██    ██ 
            ██████  ██ █████   ██ ██  ██ ██    ██ █████   ██ ██  ██ ██ ██   ██ ██    ██ 
            ██   ██ ██ ██      ██  ██ ██  ██  ██  ██      ██  ██ ██ ██ ██   ██ ██    ██ 
            ██████  ██ ███████ ██   ████   ████   ███████ ██   ████ ██ ██████   ██████  
                    
            
            Pulsa \'Enter\' para continuar
        """);
    
        do {
            entrada=bf.readLine();//Guarda en entrada el caracter introducido.
            if (entrada.isEmpty()) { // Comprueba que la entrada esté vacía
                System.out.println("¡Vamos a empezar a jugar!\n");
                empezar=true;//Cambia la variable a verdadero para salir del bucle.
            }else{
                System.out.println("Has introducido un caracter incorrecto, pulse enter para empezar.");
            }
        } while (empezar==false);
        //Llamamos al metodo menu1 y le enviamos el bufferedReader
        menu1();
    }
    
}
