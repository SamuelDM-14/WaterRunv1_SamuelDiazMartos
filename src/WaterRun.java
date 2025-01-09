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
        Boolean lvlPasado = false; //Variable que comprueba si te has pasdo un nivel.
        int reQ1=0; //Variables que guardan las respuestas de las preguntas.
        int reQ2=0;
        int reQ3=0;
        boolean salirJuego=false;
        int reAcertadas=0;

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



            do{ //Bucle menú (Se repite hasta indicar salir.)

                try { 
                    
                    do {

                        System.out.println(""" 
                            Elige una opcón del menú.
                            \t1) Jugar.
                            \t2) Aspecto.
                            \t3) Historial de juego.
                            \t4) Salir.
                            """);

                        eleccion=Integer.parseInt(bf.readLine()); //Lee la entrada.

                        switch (eleccion) { 

                            case 1:
                                eleccion=1; // Jugar
                                break;

                            case 2:
                                eleccion=2; // Aspecto            
                                break;

                            case 3:
                                eleccion=3; // Historial
                                break;

                            case 4:
                                eleccion=4; // Salir    
                                break;

                            default:
                                System.out.println("Has elegido un número que no corresponde a ninguna opción. Prueba otra vez.");
                                break;
                                }    

                    } while (eleccion<=0 || eleccion>=5); //Repite hasta que la elección sea 1, 2, 3 o 4.

                } catch (NumberFormatException e) { //Si escribe una letra le muestra este error 
                    System.out.println("No has escrito un número. Prueba otra vez");
                }

                if (eleccion==1) { //Entra en caso de elegir Jugar
                    salirJuego=false; //Pone en false el salir. Si has jugado sin recargar el programa te sacaria en la primera seleccion de salir.
                        
                    do{ //Repite hasta que el jugador indique que quiera salir. Más adelante, cuando se
                        //pase un nivel, le dará la opcion de guardar y de salir. 
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
                        """); //Explicación de como funcionan las respuestas y como funciona el juego.

                        do { //Repite hasta que escribas el caracter correcto.

                            System.out.println("¿Estas preparado? (Respuesta con 'S' para si y 'N' para no)");
                            String caracter = bf.readLine(); //Guarda la respuesta en un string.

                                if (caracter.length()==1) { //Comprueba que el string sea de 1 caracter.
                                    re1 = caracter.charAt(0); //combierte el string en caracter y lo guarda en re1
                                    re1 = Character.toUpperCase(re1); //pasa el re1 a mayusculas y lo guarda de nuevo en re1
                                    if (re1=='S') {
                                        System.out.println("Pues que empiece el juego.");     
                                        jugar=true; //Variable para entrar al juego
                                        caracterCorrecto=true;//variable del caracter para salir del bucle

                                    }else if (re1 == 'N') {
                                        jugar=false; //Variable para entrar al juego
                                        caracterCorrecto=true;//variable del caracter para salir del bucle
                                        salirJuego=true; //Variable para volver al menú
                                    }else{
                                        System.out.println("No has escrito ninguna de las 2 opciones. Prueba otra vez.");
                                    }  

                            }else{
                                System.out.println("No has escrito ningun caracter o has escrito uno incorrecto. Prueba otra vez.");
                            }
                        } while (caracterCorrecto==false);

                            if (jugar==true) { //Inicio del juego
                                do{
                                reAcertadas=0;
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
                                        """); //Mas adelante, incluido el color del personaje y del agua
                                reQ1 = Integer.parseInt(bf.readLine()); //Comprueba la respuesta 1
                                if (reQ1 == 2) { 
                                    reAcertadas=reAcertadas+1;
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
                        
                                        ¿Tiene 5 letras tiene la palabra \"QUESO\"?
                                        \t1) Verdadero \t\t 2) Falso
                                                """);
                                    reQ2=Integer.parseInt(bf.readLine()); //Lee la segunda respuesta
                                    if (reQ2==1) { 

                                        System.out.println("¡Has acertado! Tu personaje empieza a abrir la cerradura.");
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
                            
                                            ¿Cuanto es 5x5?
                                                """);
                                        reQ3 = Integer.parseInt(bf.readLine()); //Lee la respuesta 3
                                        if (reQ3==25) {
                                            System.out.println("¡Has acertado! Tu personaje ha huido.");
                                            lvlPasado = true; //pone lvlPasado en true para salir del bucle.
                                            salirJuego = true; //Te manda al menú princial.
                                        }else{
                                            System.out.println("Has fallado.");
                                            System.out.println("Oh no, el agua subió demasiado rápido, has perdido.");
                                            salirJuego=true; //Te saca del juego tras perder
                                        }
                                    }else{
                                        System.out.println("Has fallado.");
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
                            
                                            ¿Cuanto es 5x5?
                                                """);
                                        reQ3 = Integer.parseInt(bf.readLine());
                                        if (reQ3==25) {
                                            System.out.println("¡Has acertado! Tu personaje empieza a abir la cerradura.");
                                            System.out.println("Oh no, el agua subió demasiado rápido, has perdido.");
                                            salirJuego=true;
                                        }
                                    }    
                                }else{
                                    System.out.printf("""
                                        Has fallado.\n
                                        
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

                                        ¿Tiene 5 letras tiene la palabra \"QUESO\"?
                                        \t1) Verdadero \t\t 2) Falso
                                                        """);
                                    reQ2=Integer.parseInt(bf.readLine()); //Lee la segunda respuesta
                                    if (reQ2==1) { 
                    
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
                                             
                                            ¿Cuanto es 5x5?
                                                """);
                                        reQ3 = Integer.parseInt(bf.readLine());//lee la respuesta 3
                                        if (reQ3==25) {
                                            System.out.println("¡Has acertado! Tu personaje empieza a abir la cerradura.");
                                            System.out.println("Oh no, el agua subió demasiado rápido, has perdido.");
                                            salirJuego=true; //te saca del juego tras perder
                                        }
                                        }else{
                                            System.out.println("Has fallado.");
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

                                                                ¿Cuanto es 5x5?
                                                                    """);
                                            reQ3 = Integer.parseInt(bf.readLine());//lee la respuesta 3
                                            if (reQ3==25) {
                                                System.out.println("¡Has acertado! Tu personaje empieza a abir la cerradura.");
                                                System.out.println("Oh no, el agua subió demasiado rápido, has perdido.");
                                                salirJuego=true; //Te saca del juego tras perder
                                            }else{
                                                System.out.println("Has fallado.");
                                                System.out.println("Oh no, el agua subió demasiado rápido, has perdido.");
                                                salirJuego=true; //Te saca del juego tras perder
                                            }
                            
                                        }
                                    }

                                }while(salirJuego==false && lvlPasado==false);
                            }else{ //Si eliges no jugar 
                                System.out.println("Volviendo al menú principal.");
                                salirJuego=true; //Variable salir del bucle juego.
                            }
                    }while(salirJuego==false);
                }else if (eleccion==2) { //Aspecto
                    salirAspecto=false; //Pone salirAspecto en false, ya que sino cuando eligieras cualquier cosa dentro de los submenús
                                        //Te sacaraía instantaneamente al menú general. 
                    do { //Repite hasta que el usuario seleccione salir.
                        do{
                            //Muestra opciones de aspecto.
                            System.out.println("""
                                Has elegido la opción de aspecto.
                                En este menú, puedes personalizar el color de tu personaje entre la siguiente selección y el color del agua también.
                                ¿Que quieres personalizar?
                                \t1) Color del personaje.
                                \t2) Color del agua.
                                \t3) Salir.
                                """);
                            try { //Comprueba que escribas solo números.
                                reAspecto = Integer.parseInt(bf.readLine()); //Lee respuesta y la guarda en reAspecto

                                if (reAspecto==1) { 
                                    System.out.println("Has elegido cambiaR el aspecto de tu personaje.");
                                    cambiarAspectoPJ=true; //pone cambiar Aspecto del personaje en verdadero
                                }else if (reAspecto==2) {
                                    System.out.println("Has elegido cambiar el aspecto del agua.");
                                    cambiarAspectoW=true;//pone cambiar Aspecto del agua en verdadero
                                }else if (reAspecto==3){
                                    System.out.println("Has elegido salir. Volviendo al menú principal.");
                                    salirAspecto=true;//sale al menú principal.
                                }else{
                                    System.out.println("Opción no reconocida, prueba otra vez."); //Si no has escrito un número, te lo pide hasta que escribas uno. 
                                }
                        
                            } catch (NumberFormatException e) {
                            System.out.println("No has escrito un número. Prueba otra vez");
                            }

                        }while (cambiarAspectoW==false && cambiarAspectoPJ==false && salirAspecto==false);



                        if (cambiarAspectoPJ==true) { //cambias el aspecto del Personaje
                            try{ //comprueba que solo escribas números.
                                //Muestra las opciones de colores.
                            System.out.println("""
                                Elige un color para tu personaje:
                                \t1)Rojo\t2)Verde\t3)Amarillo\t4)Azul\t5)Morado\t6)Cian\t7)Blanco\t8)Negro\t9)Salir
                                    """);
                            eleccionColorPJ = Integer.parseInt(bf.readLine()); //Lee la elección del color
                            switch (eleccionColorPJ) { //Según la elección se mete en el case correspondiente.
                                case 1:
                                System.out.println("Has elegido el color rojo.");
                                cambiarAspectoPJ=false; //CambiarAspecto a false para que no colapse.
                                if (colorW==COLOR_W_RED) { //Comprueba que el agua no tenga ese color.
                                    System.out.println("No se puede hacer esta selección de color. El personaje no puede ser del mismo color que el agua.");
                                }else{
                                    colorPj=COLOR_PJ_RED; //Si el agua es de otro color, asigna el color seleccionado al jugador.
                                }
                                break;
                            case 2:
                                System.out.println("Has elegido el color verde.");
                                cambiarAspectoPJ=false;//CambiarAspecto a false para que no colapse.
                                if (colorW==COLOR_W_GREEN) {//Comprueba que el agua no tenga ese color.
                                    System.out.println("No se puede hacer esta selección de color. El personaje no puede ser del mismo color que el agua.");
                                }else{
                                    colorPj=COLOR_PJ_GREEN;  //Si el agua es de otro color, asigna el color seleccionado al jugador.
                                }                          
                                break;
                            case 3:
                                System.out.println("Has elegido el color amarillo.");
                                cambiarAspectoPJ=false;//CambiarAspecto a false para que no colapse.
                                if (colorW==COLOR_W_YELLOW) {//Comprueba que el agua no tenga ese color.
                                    System.out.println("No se puede hacer esta selección de color. El personaje no puede ser del mismo color que el agua.");
                                }else{
                                    colorPj=COLOR_PJ_YELLOW;     //Si el agua es de otro color, asigna el color seleccionado al jugador.   
                                }                      
                                break;
                            case 4:
                                System.out.println("Has elegido el color azul.");
                                cambiarAspectoPJ=false;//CambiarAspecto a false para que no colapse.
                                if (colorW==COLOR_W_BLUE) {//Comprueba que el agua no tenga ese color.
                                    System.out.println("No se puede hacer esta selección de color. El personaje no puede ser del mismo color que el agua.");
                                }else{
                                    colorPj=COLOR_PJ_BLUE;         //Si el agua es de otro color, asigna el color seleccionado al jugador.                 
                                }
                                break;
                            case 5:
                                System.out.println("Has elegido el color morado.");
                                cambiarAspectoPJ=false;//CambiarAspecto a false para que no colapse.
                                if (colorW==COLOR_W_PURPLE) {//Comprueba que el agua no tenga ese color.
                                    System.out.println("No se puede hacer esta selección de color. El personaje no puede ser del mismo color que el agua.");
                                }else{
                                    colorPj=COLOR_PJ_PURPLE;       //Si el agua es de otro color, asigna el color seleccionado al jugador.                       
                                }
                                break;
                            case 6:
                                System.out.println("Has elegido el color Cian.");
                                cambiarAspectoPJ=false;//CambiarAspecto a false para que no colapse.
                                if (colorW==COLOR_W_CYAN) {//Comprueba que el agua no tenga ese color.
                                    System.out.println("No se puede hacer esta selección de color. El personaje no puede ser del mismo color que el agua.");
                                }else{
                                    colorPj=COLOR_PJ_CYAN;             //Si el agua es de otro color, asigna el color seleccionado al jugador.                 
                                }
                                break;
                            case 7:
                                System.out.println("Has elegido el color Blanco.");
                                cambiarAspectoPJ=false;//CambiarAspecto a false para que no colapse.
                                if (colorW==COLOR_W_WHITE) {//Comprueba que el agua no tenga ese color.
                                    System.out.println("No se puede hacer esta selección de color. El personaje no puede ser del mismo color que el agua.");
                                }else{
                                    colorPj=COLOR_PJ_WHITE;  //Si el agua es de otro color, asigna el color seleccionado al jugador.
                                }                            
                                break;
                            case 8:
                                System.out.println("Has elegido el color Negro.");
                                cambiarAspectoPJ=false;//CambiarAspecto a false para que no colapse.
                                if (colorW==COLOR_W_BLACK) {//Comprueba que el agua no tenga ese color.
                                    System.out.println("No se puede hacer esta selección de color. El personaje no puede ser del mismo color que el agua.");
                                }else{
                                    colorPj=COLOR_PJ_BLACK;     //Si el agua es de otro color, asigna el color seleccionado al jugador.                         
                                }
                                break;
                            case 9:
                                System.out.println("Has elegido salir. Volviendo al menú de aspecto."); 
                                cambiarAspectoPJ=false;//CambiarAspecto a false para que no colapse.
                                break;
                            default:
                                System.out.println("Has escrito un número que no coincide con los de selección. Prueba otra vez.");
                                break;
                            }
                            } catch (NumberFormatException e) {
                                System.out.println("No has escrito un número. Prueba otra vez");
                            }

                        } else if (cambiarAspectoW==true) {
                            try{ //Prueba que escribas un número.
                                //Muestra las opciones de colores.
                                System.out.println("""
                                    Elige un color para el fondo:
                                    \t1)Rojo\t2)Verde\t3)Amarillo\t4)Azul\t5)Morado\t6)Cian\t7)Blanco\t8)Negro\t9)Salir
                                        """);
                                eleccionColorW = Integer.parseInt(bf.readLine()); //Lee el color elegido.
                                switch (eleccionColorW) { //selecciona segun el número elegido.
                                    case 1:
                                        System.out.println("Has elegido el color rojo.");
                                        cambiarAspectoW=false; //CambiarAspecto a false para que no colapse.
                                        if (colorPj==COLOR_PJ_RED) { //Comprueba que el personaje no tenga ese color
                                            System.out.println("No se puede hacer esta selección de color. El agua no puede ser del mismo color que tu personaje.");
                                        }else{
                                            colorW=COLOR_W_RED; //Si el personaje es de otro color, asigna el color seleccionado al agua.
                                        }
                                        break;
                                    case 2:
                                        System.out.println("Has elegido el color verde.");
                                        cambiarAspectoW=false;//CambiarAspecto a false para que no colapse.
                                        if (colorPj==COLOR_PJ_GREEN) {//Comprueba que el personaje no tenga ese color
                                            System.out.println("No se puede hacer esta selección de color. El agua no puede ser del mismo color que tu personaje.");
                                        }else{
                                            colorW=COLOR_W_GREEN;  //Si el personaje es de otro color, asigna el color seleccionado al agua.
                                        }                          
                                        break;
                                    case 3:
                                        System.out.println("Has elegido el color amarillo.");
                                        cambiarAspectoW=false;//CambiarAspecto a false para que no colapse.
                                        if (colorPj==COLOR_PJ_YELLOW) {//Comprueba que el personaje no tenga ese color
                                            System.out.println("No se puede hacer esta selección de color. El agua no puede ser del mismo color que tu personaje.");
                                        }else{
                                            colorW=COLOR_W_YELLOW; //Si el personaje es de otro color, asigna el color seleccionado al agua.       
                                        }                      
                                        break;
                                    case 4:
                                        System.out.println("Has elegido el color azul.");
                                        cambiarAspectoW=false;//CambiarAspecto a false para que no colapse.
                                        if (colorPj==COLOR_PJ_BLUE) {//Comprueba que el personaje no tenga ese color
                                            System.out.println("No se puede hacer esta selección de color. El agua no puede ser del mismo color que tu personaje.");
                                        }else{
                                            colorW=COLOR_W_BLUE;  //Si el personaje es de otro color, asigna el color seleccionado al agua.                        
                                        }
                                        break;
                                    case 5:
                                        System.out.println("Has elegido el color morado.");
                                        cambiarAspectoW=false;//CambiarAspecto a false para que no colapse.
                                        if (colorPj==COLOR_PJ_PURPLE) {//Comprueba que el personaje no tenga ese color
                                            System.out.println("No se puede hacer esta selección de color. El agua no puede ser del mismo color que tu personaje.");
                                        }else{
                                            colorW=COLOR_W_PURPLE;  //Si el personaje es de otro color, asigna el color seleccionado al agua.                            
                                        }
                                        break;
                                    case 6:
                                        System.out.println("Has elegido el color Cian.");
                                        cambiarAspectoW=false;//CambiarAspecto a false para que no colapse.
                                        if (colorPj==COLOR_PJ_CYAN) {//Comprueba que el personaje no tenga ese color
                                            System.out.println("No se puede hacer esta selección de color. El agua no puede ser del mismo color que tu personaje.");
                                        }else{
                                            colorW=COLOR_W_CYAN;//Si el personaje es de otro color, asigna el color seleccionado al agua.                              
                                        }
                                        break;
                                    case 7:
                                        System.out.println("Has elegido el color Blanco.");
                                        cambiarAspectoW=false;//CambiarAspecto a false para que no colapse.
                                        if (colorPj==COLOR_PJ_WHITE) {//Comprueba que el personaje no tenga ese color
                                            System.out.println("No se puede hacer esta selección de color. El agua no puede ser del mismo color que tu personaje.");
                                        }else{
                                            colorW=COLOR_W_WHITE;//Si el personaje es de otro color, asigna el color seleccionado al agua.  
                                        }                            
                                        break;
                                    case 8:
                                        System.out.println("Has elegido el color Negro.");
                                        cambiarAspectoW=false;//CambiarAspecto a false para que no colapse.
                                        if (colorPj==COLOR_PJ_BLACK) {//Comprueba que el personaje no tenga ese color
                                            System.out.println("No se puede hacer esta selección de color. El agua no puede ser del mismo color que tu personaje.");
                                        }else{
                                            colorW=COLOR_W_BLACK; //Si el personaje es de otro color, asigna el color seleccionado al agua.                             
                                        }
                                        break;    
                                    case 9:
                                        System.out.println("Has elegido salir. Volviendo al menú principal.");
                                        cambiarAspectoW=false;//CambiarAspecto a false para que no colapse.
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


                }else if (eleccion==3) { //Historial
                    salirHistorial=false; //Pone en false el salirHistorial. Si has seleccionado previamente esta opción y has salido, 
                                          //Te sacaria en cuanto eligieras algo que te mueva a este menú.
                    do{ //Repite hasta que el usuario seleccione salir.
                        //Muestra las opciones. (No disponible de momento.)
                        System.out.println("""
                                Este menú aun no esta disponible. Pulse 3 para salir.
                                \t1) Jugar una partida guardada. (Proximamente)
                                \t2) Revisar elecciónes de partida. (Proximamente)
                                \t3) Salir.
                                """);
                        try { //Comprueba que escribas solo números
                            eleccionHistorial=Integer.parseInt(bf.readLine()); //Lee la elección
                            switch (eleccionHistorial) { //Selecciona según haya elegido.
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
                                    salirHistorial=true; //Vuelve al menú principal.
                                    break;    

                                default:
                                    System.out.println("El número seleccionado no corresponde a nada. Prueba otra vez.");
                                    break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("No has escrito un número. Prueba otra vez");
                        }

                    }while (salirHistorial==false);
                }else if (eleccion==4) {// Salir
                    System.out.println("Saliendo del juego");
                    salir=true; //Pone salir en true para salir del bucle del menú.
                }

            }while (salir==false); 
            System.out.println("Muchas gracias por participar."); //Muestra mensaje de agradecimiento.
        
            }
}
    
