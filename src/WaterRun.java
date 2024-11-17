/*
 * WaterRun
 * Autor: Samuel Díaz Martos
 * 18-11-2024
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WaterRun {
    public static void main(String[] args) throws IOException {
        // Crear un BufferedReader para leer de la entrada estándar
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // Variables del programa.
        boolean empezar=false; // Para comprobar que haya puesto un enter
        int eleccion=0;// Lee la elección del primer menú.
        String entrada; // Leer una línea de texto.
        boolean salir=false;//variable para acabar el programa;
    
       
        //Respuestas del juego
        char re1; //Respuesta jugar o no jugar.
        Boolean jugar =false; //Comprobar si el jugador quiere jugar o no.
        Boolean caracterCorrecto=false; //Comprueba si el caracter que ha puesto en re1 es S o N para salir del bucle.
        int reQ1;
        boolean salirJuego=false;

        //Respuestas aspecto
        int reAspecto;// respuesta de elección de aspecto.
        boolean cambiarAspectoPJ=false;
        int eleccionColorPJ;
        boolean cambiarAspectoW=false;
        int eleccionColorW;
        boolean salirAspecto=false;

        //Respuestas Historial
        int eleccionHistorial;// Respuesta de elección de historial.
        boolean salirHistorial=false;

        // Deja el color como al principio.
        final String COLOR_RESET = "\u001B[0m";

        //Colores para los personajes.
        String colorPj = "\u001B[37m";
        final String COLOR_PJ_BLACK = "\u001B[30m";
        final String COLOR_PJ_RED = "\u001B[31m";
        final String COLOR_PJ_GREEN = "\u001B[32m";
        final String COLOR_PJ_YELLOW = "\u001B[33m";
        final String COLOR_PJ_BLUE = "\u001B[34m";
        final String COLOR_PJ_PURPLE = "\u001B[35m";
        final String COLOR_PJ_CYAN = "\u001B[36m";
        final String COLOR_PJ_WHITE = "\u001B[37m";

        //Colores del fondo.
        String colorW = "\u001B[40m";
        final String COLOR_W_BLACK = "\u001B[40m";
        final String COLOR_W_RED = "\u001B[41m";
        final String COLOR_W_GREEN = "\u001B[42m";
        final String COLOR_W_YELLOW = "\u001B[43m";
        final String COLOR_W_BLUE = "\u001B[44m";
        final String COLOR_W_PURPLE = "\u001B[45m";
        final String COLOR_W_CYAN = "\u001B[46m";
        final String COLOR_W_WHITE = "\u001B[47m";



        //Bienvenida.
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
                    empezar=true;
                }else{
                    System.out.println("Has introducido un caracter incorrecto, pulse enter para empezar.");
                }
            } while (empezar==false);



            do{

                try {
                    
                    do {

                        System.out.println(""" 
                            Elige una opcón del menú.
                            \t1) Jugar.
                            \t2) Aspecto.
                            \t3) Historial de juego.
                            \t4) Salir.
                            """);

                        eleccion=Integer.parseInt(bf.readLine());

                        switch (eleccion) {

                            case 1:
                                eleccion=1;
                                break;

                            case 2:
                                eleccion=2;            
                                break;

                            case 3:
                                eleccion=3;
                                break;

                            case 4:
                                eleccion=4;            
                                break;

                            default:
                                System.out.println("Has elegido un número que no corresponde a ninguna opción. Prueba otra vez.");
                                break;
                                }    

                    } while (eleccion<=0 || eleccion>=5);

                } catch (NumberFormatException e) {
                    System.out.println("No has escrito un número. Prueba otra vez");
                }

                if (eleccion==1) {
                    salirJuego=false;
                        
                    do{
                        System.out.println("""
                            
                        Has elegico jugar.\n
                        Para ponerte en contexto, eres un prisionero condenado injustametne a muerte por ahogamiento.\n
                        Tu desafío inicial es encontrar la manera de escapar de la sala que se irá inundando.\n
                        Para ello, deberas resolver una serie de acertijos o preguntas que te iremos mostrando.\n
                        Al responder las preguntas o acertijos deberas de poner el número correspondiente indicado.\n
                        Ejemplo: ¿Cuantas letras tiene Hola?\n
                        1) 4 \t\t 2) 7 \t\t 3) 5 \t\t 4) 1 \n
                        En este caso tendrias que poner como respuesta \'1\'. \n
                        Si fallas al responder o ponea un caracter no valido se contará como error.\n
                        """);

                        do {

                            System.out.println("¿Estas preparado? (Respuesta con 'S' para si y 'N' para no)");
                            String caracter = bf.readLine();

                                if (caracter.length()==1) {
                                    re1 = caracter.charAt(0);
                                    re1 = Character.toUpperCase(re1);
                                    if (re1=='S') {
                                        System.out.println("Pues que empiece el juego.");     
                                        jugar=true;
                                        caracterCorrecto=true;

                                    }else if (re1 == 'N') {
                                        jugar=false;
                                        caracterCorrecto=true;
                                        salirJuego=true;
                                    }else{
                                        System.out.println("No has escrito ninguna de las 2 opciones. Prueba otra vez.");
                                    }  

                            }else{
                                System.out.println("No has escrito ningun caracter o has escrito uno incorrecto. Prueba otra vez.");
                            }
                        } while (caracterCorrecto==false);

                            if (jugar==true) {
                                System.out.printf("""
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
                                █"""  + colorPj +     """
                                        \t  o  """ + COLOR_RESET + """
                                                    █████████████████████
                                █""" + colorPj + """
                                        \t /L """ + COLOR_RESET + """
                                                    █████████████████████
                                █""" + colorPj + """
                                        \t | """ + COLOR_RESET + """
                                                    █████████████████████
                                █████████████████████████████████████████████████████          
                                                """ + """
                                ¿Cuanto es 2 + 2?

                                1) 2\t\t 2) 4\t\t 3) 75\t\t 4)185
                                        """);
                                reQ1 = Integer.parseInt(bf.readLine());
                                if (reQ1 == 2) {
                                    System.out.println("¡Has acertado! Tu personaje avanza hasta la rendija de salida.");
                                    System.out.printf("""
                                        █████████████████████████████████████████████████████     
                                        █                                                   █
                                        ██                                                  █
                                                                                        | |
                                                                                    o      | | 
                                        ██                                         /L      | |
                                        █                                          |        █
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
                        
                                        ¿Cua
                                                """);
                                }

                            }else{
                                System.out.println("Volviendo al menú principal.");
                                salirJuego=true;
                            }
                    }while(salirJuego==false);
                }else if (eleccion==2) {
                    salirAspecto=false;
                    do {
                        do{

                            System.out.println("""
                                Has elegido la opción de aspecto.
                                En este menú, puedes personalizar el color de tu personaje entre la siguiente selección y el color del agua también.
                                ¿Que quieres personalizar?
                                \t1) Color del personaje.
                                \t2) Color del agua.
                                \t3) Salir.
                                """);
                            try {
                            reAspecto = Integer.parseInt(bf.readLine());

                                if (reAspecto==1) {
                                    System.out.println("Has elegido cambiaR el aspecto de tu personaje.");
                                    cambiarAspectoPJ=true;
                                }else if (reAspecto==2) {
                                    System.out.println("Has elegido cambiar el aspecto del agua.");
                                    cambiarAspectoW=true;
                                }else if (reAspecto==3){
                                    System.out.println("Has elegido salir. Volviendo al menú principal.");
                                    salirAspecto=true;
                                }else{
                                    System.out.println("Opción no reconocida, prueba otra vez.");
                                }
                        
                        } catch (NumberFormatException e) {
                            System.out.println("No has escrito un número. Prueba otra vez");
                        }

                        }while (cambiarAspectoW==false && cambiarAspectoPJ==false && salirAspecto==false);



                        if (cambiarAspectoPJ==true) {
                            try{
                            System.out.println("""
                                Elige un color para tu personaje:
                                \t1)Rojo\t2)Verde\t3)Amarillo\t4)Azul\t5)Morado\t6)Cian\t7)Blanco\t8)Negro\t9)Salir
                                    """);
                            eleccionColorPJ = Integer.parseInt(bf.readLine());
                            switch (eleccionColorPJ) {
                                case 1:
                                System.out.println("Has elegido el color rojo.");
                                cambiarAspectoPJ=false;
                                if (colorW==COLOR_W_RED) {
                                    System.out.println("No se puede hacer esta selección de color. El personaje no puede ser del mismo color que el agua.");
                                }else{
                                    colorPj=COLOR_PJ_RED;
                                }
                                break;
                            case 2:
                                System.out.println("Has elegido el color verde.");
                                cambiarAspectoPJ=false;
                                if (colorW==COLOR_W_GREEN) {
                                    System.out.println("No se puede hacer esta selección de color. El personaje no puede ser del mismo color que el agua.");
                                }else{
                                    colorPj=COLOR_PJ_GREEN;  
                                }                          
                                break;
                            case 3:
                                System.out.println("Has elegido el color amarillo.");
                                cambiarAspectoPJ=false;
                                if (colorW==COLOR_W_YELLOW) {
                                    System.out.println("No se puede hacer esta selección de color. El personaje no puede ser del mismo color que el agua.");
                                }else{
                                    colorPj=COLOR_PJ_YELLOW;        
                                }                      
                                break;
                            case 4:
                                System.out.println("Has elegido el color azul.");
                                cambiarAspectoPJ=false;
                                if (colorW==COLOR_W_BLUE) {
                                    System.out.println("No se puede hacer esta selección de color. El personaje no puede ser del mismo color que el agua.");
                                }else{
                                    colorPj=COLOR_PJ_BLUE;                          
                                }
                                break;
                            case 5:
                                System.out.println("Has elegido el color morado.");
                                cambiarAspectoPJ=false;
                                if (colorW==COLOR_W_PURPLE) {
                                    System.out.println("No se puede hacer esta selección de color. El personaje no puede ser del mismo color que el agua.");
                                }else{
                                    colorPj=COLOR_PJ_PURPLE;                              
                                }
                                break;
                            case 6:
                                System.out.println("Has elegido el color Cian.");
                                cambiarAspectoPJ=false;
                                if (colorW==COLOR_W_CYAN) {
                                    System.out.println("No se puede hacer esta selección de color. El personaje no puede ser del mismo color que el agua.");
                                }else{
                                    colorPj=COLOR_PJ_CYAN;                              
                                }
                                break;
                            case 7:
                                System.out.println("Has elegido el color Blanco.");
                                cambiarAspectoPJ=false;
                                if (colorW==COLOR_W_WHITE) {
                                    System.out.println("No se puede hacer esta selección de color. El personaje no puede ser del mismo color que el agua.");
                                }else{
                                    colorPj=COLOR_PJ_WHITE;  
                                }                            
                                break;
                            case 8:
                                System.out.println("Has elegido el color Negro.");
                                cambiarAspectoPJ=false;
                                if (colorW==COLOR_W_BLACK) {
                                    System.out.println("No se puede hacer esta selección de color. El personaje no puede ser del mismo color que el agua.");
                                }else{
                                    colorPj=COLOR_PJ_BLACK;                              
                                }
                                break;
                            case 9:
                                System.out.println("Has elegido salir. Volviendo al menú principal.");
                                cambiarAspectoPJ=false;
                                break;
                            default:
                                System.out.println("Has escrito un número que no coincide con los de selección. Prueba otra vez.");
                                break;
                            }
                            } catch (NumberFormatException e) {
                                System.out.println("No has escrito un número. Prueba otra vez");
                            }

                        } else if (cambiarAspectoW==true) {
                            try{
                                System.out.println("""
                                    Elige un color para el fondo:
                                    \t1)Rojo\t2)Verde\t3)Amarillo\t4)Azul\t5)Morado\t6)Cian\t7)Blanco\t8)Negro\t9)Salir
                                        """);
                                eleccionColorW = Integer.parseInt(bf.readLine());
                                switch (eleccionColorW) {
                                    case 1:
                                        System.out.println("Has elegido el color rojo.");
                                        cambiarAspectoW=false;
                                        if (colorPj==COLOR_PJ_RED) {
                                            System.out.println("No se puede hacer esta selección de color. El agua no puede ser del mismo color que tu personaje.");
                                        }else{
                                            colorW=COLOR_W_RED;
                                        }
                                        break;
                                    case 2:
                                        System.out.println("Has elegido el color verde.");
                                        cambiarAspectoW=false;
                                        if (colorPj==COLOR_PJ_GREEN) {
                                            System.out.println("No se puede hacer esta selección de color. El agua no puede ser del mismo color que tu personaje.");
                                        }else{
                                            colorW=COLOR_W_GREEN;  
                                        }                          
                                        break;
                                    case 3:
                                        System.out.println("Has elegido el color amarillo.");
                                        cambiarAspectoW=false;
                                        if (colorPj==COLOR_PJ_YELLOW) {
                                            System.out.println("No se puede hacer esta selección de color. El agua no puede ser del mismo color que tu personaje.");
                                        }else{
                                            colorW=COLOR_W_YELLOW;        
                                        }                      
                                        break;
                                    case 4:
                                        System.out.println("Has elegido el color azul.");
                                        cambiarAspectoW=false;
                                        if (colorPj==COLOR_PJ_BLUE) {
                                            System.out.println("No se puede hacer esta selección de color. El agua no puede ser del mismo color que tu personaje.");
                                        }else{
                                            colorW=COLOR_W_BLUE;                          
                                        }
                                        break;
                                    case 5:
                                        System.out.println("Has elegido el color morado.");
                                        cambiarAspectoW=false;
                                        if (colorPj==COLOR_PJ_PURPLE) {
                                            System.out.println("No se puede hacer esta selección de color. El agua no puede ser del mismo color que tu personaje.");
                                        }else{
                                            colorW=COLOR_W_PURPLE;                              
                                        }
                                        break;
                                    case 6:
                                        System.out.println("Has elegido el color Cian.");
                                        cambiarAspectoW=false;
                                        if (colorPj==COLOR_PJ_CYAN) {
                                            System.out.println("No se puede hacer esta selección de color. El agua no puede ser del mismo color que tu personaje.");
                                        }else{
                                            colorW=COLOR_W_CYAN;                              
                                        }
                                        break;
                                    case 7:
                                        System.out.println("Has elegido el color Blanco.");
                                        cambiarAspectoW=false;
                                        if (colorPj==COLOR_PJ_WHITE) {
                                            System.out.println("No se puede hacer esta selección de color. El agua no puede ser del mismo color que tu personaje.");
                                        }else{
                                            colorW=COLOR_W_WHITE;  
                                        }                            
                                        break;
                                    case 8:
                                        System.out.println("Has elegido el color Negro.");
                                        cambiarAspectoW=false;
                                        if (colorPj==COLOR_PJ_BLACK) {
                                            System.out.println("No se puede hacer esta selección de color. El agua no puede ser del mismo color que tu personaje.");
                                        }else{
                                            colorW=COLOR_W_BLACK;                              
                                        }
                                        break;    
                                    case 9:
                                        System.out.println("Has elegido salir. Volviendo al menú principal.");
                                        cambiarAspectoW=false;
                                        break;
                                    default:
                                        System.out.println("Has escrito un número que no coincide con los de selección. Prueba otra vez.");
                                        break;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("No has escrito un número. Prueba otra vez");
                            }
                            }
                    }while (salirAspecto==false);


                }else if (eleccion==3) {
                    salirHistorial=false;
                    do{
                        System.out.println("""
                                Este menú aun no esta disponible. Pulse 3 para salir.
                                \t1) Jugar una partida guardada. (Proximamente)
                                \t2) Revisar elecciónes de partida. (Proximamente)
                                \t3) Salir.
                                """);
                        try {
                            eleccionHistorial=Integer.parseInt(bf.readLine());
                            switch (eleccionHistorial) {
                                case 1:
                                    System.out.println("Ha selecionado \'Jugar partida guardada\', Este menú aun no esta disponible.");
                                    System.out.println("Prueba otra vez");

                                    break;
                                case 2:
                                    System.out.println("Ha selecionado \'Jugar partida guardada\', Este menú aun no esta disponible.");
                                    System.out.println("Prueba otra vez");

                                    break;
                                case 3:
                                    System.out.println("Ha selecionado salir. Volviendo al menú principal");
                                    salirHistorial=true;
                                    break;    

                                default:
                                    System.out.println("El número seleccionado no corresponde a nada. Prueba otra vez.");
                                    break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("No has escrito un número. Prueba otra vez");
                        }

                    }while (salirHistorial==false);
                }else if (eleccion==4) {
                    System.out.println("Saliendo del juego");
                    salir=true;
                }

            }while (salir==false); 
            System.out.println("Muchas gracias por participar.");
        
            }
}
    
