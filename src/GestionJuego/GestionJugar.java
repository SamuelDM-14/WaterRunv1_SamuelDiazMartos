/**
 * GestionJugar
 * @author SDM
 * 07-03-2025
 */
package gestionjuego;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import gestionjuego.juego.Jugar;
import utilidades.Utilidades;
import utilidades.VarGenYConst;

/**
 * GestionJugar
 * Se encarga de gestionar los menús, las selecciones y las variables del juego generales.
 */
public class GestionJugar {

    //Usamos BufferedReader para leer. Creación del objeto.
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));



    
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
            VarGenYConst.max = 5;
            VarGenYConst.min = 1;
            VarGenYConst.opcionMenu = 0;
            System.out.println(VarGenYConst.MOSTRARMENUS[VarGenYConst.opcionMenu]);
    
            eleccion=Utilidades.leerEnteroValidado(); //Lee la entrada.
    
            switch (eleccion) { 
    
                case 1:
                    //Entra en caso de elegir Jugar
                    Jugar.jugar(); // Llama al metodo jugar y le envia el bufferedReader
                    break;

                case 2:
                    //Entra en caso de elegir Dificultad
                    dificultadDelJuego();// Llama al metodo dificultadDelJuego y le envia el BufferedReader
                    break;
                case 3:
                    //Entra en caso de elegir Aspecto
                    Aspecto.cambiarAspecto();// Llama al metodo cambiarAspecto y le envia el bufferedReader
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
        VarGenYConst.opcionMenu= 2;
        VarGenYConst.max=3;
        VarGenYConst.min=0;
        boolean salirDificultad = false;
        int lecturaDif = 0;
        do{
                System.out.println(VarGenYConst.MOSTRARMENUS[VarGenYConst.opcionMenu]);
                lecturaDif=Utilidades.leerEnteroValidado();
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
        VarGenYConst.max = 4;
        VarGenYConst.min = 1;
        VarGenYConst.opcionMenu = 6;
        System.out.println(VarGenYConst.MOSTRARMENUS[VarGenYConst.opcionMenu]);
        eleccionHistorial=Utilidades.leerEnteroValidado(); //Lee la elección
        switch (eleccionHistorial) { //Selecciona según haya elegido.
            case 1:
                System.out.println("Ha selecionado \'Jugar partida guardada\', Este menú aun no esta disponible.");
                break;
            case 2:
                System.out.println("Ha selecionado \'Revisar elecciónes de partida.\', Este menú aun no esta disponible.");
                break;
            case 3: 
                datosPartida();
                break;
            case 4:
                System.out.println("Ha selecionado salir. Volviendo al menú principal");
                salirHistorial=true; //Vuelve al menú principal.
                break;    
            default:
                //No pongo nada debido a que las validaciones correspondientes estan hechas.
                break;
        }

    }while (salirHistorial==false);

    }
    
    private static void datosPartida(){
        System.out.println("Ha selecionado \\'Datos de partida guardada.\\'.");
        System.out.println(VarGenYConst.partida.toString());
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
