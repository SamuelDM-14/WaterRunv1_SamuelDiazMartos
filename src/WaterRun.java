/*
 * WaterRun
 * Autor: Samuel Díaz Martos
 * 18-11-2024
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WaterRun {

    // Deja el color como al principio.
    private static final String COLOR_RESET = "\u001B[0m";

    //Colores para los personajes.
    private static String colorPj = "\u001B[37m";
    private static final String[] COLORESPJ = {
        "\u001B[31m",//0=Rojo
        "\u001B[32m",//1=Verde
        "\u001B[33m",//2=Amarillo
        "\u001B[34m",//3=Azul
        "\u001B[35m",//4=Morado
        "\u001B[36m",//5=Cyan
        "\u001B[37m",//6=Blanco
        "\u001B[30m"// 7=Negro
    };
        
    //Colores del fondo.
    private static String colorPo = "\u001B[40m";
    private static final String[] COLORESPOLICIA= {
        "\u001B[41m",//0=Rojo
        "\u001B[42m",//1=Verde
        "\u001B[43m",//2=Amarillo
        "\u001B[44m",//3=Azul
        "\u001B[45m",//4=Morado
        "\u001B[46m",//5=Cyan
        "\u001B[47m",//6=Blanco
        "\u001B[40m",//7=NEGRO
    };
    private static int dificultad=0;
    private static void bienvenida(BufferedReader bf) throws IOException{
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
        menu1(bf);
    }
        
    private static void menu1(BufferedReader bf) throws IOException{
        //variables menu1
        boolean salir=false;//variable para acabar el programa; 
        int eleccion=0;// Lee la elección del primer menú.

        do{ //Bucle menú (Se repite hasta indicar salir.)
    
            try { 
                    
                do {
    
                    System.out.println(""" 
                        Elige una opcón del menú.
                        \t1) Jugar.
                        \t2) Dificultad
                        \t3) Aspecto.
                        \t4) Historial de juego.
                        \t5) Salir.
                    """);
    
                    eleccion=Integer.parseInt(bf.readLine()); //Lee la entrada.
    
                    switch (eleccion) { 
    
                        case 1:
                            //Entra en caso de elegir Jugar
                            jugar(bf); // Llama al metodo jugar y le envia el bufferedReader
                            break;

                        case 2:
                            dificultadDelJuego(bf);
                            break;
                        case 3:
                            //Entra en caso de elegir Aspecto
                            cambiarAspecto(bf);// Llama al metodo cambiarAspecto y le envia el bufferedReader
                            
                            break;

                        case 4:
                            //Entra en caso de elegir Historial
                            historial(bf);// Llama al metodo historial y le envia el bufferedReader
                            
                            break;

                        case 5:
                            //Entra en caso de elegir Salir
                            System.out.println("Saliendo del juego");
                            salir=true; //Pone salir en true para salir del bucle del menú. 
                            break;

                        default:
                            System.out.println("Has elegido un número que no corresponde a ninguna opción. Prueba otra vez.");
                            break;
                    };  
                } while (eleccion<=0 || eleccion>=6); //Repite hasta que la elección sea 1, 2, 3 o 4.
    
            } catch (NumberFormatException e) { //Si escribe una letra le muestra este error 
                System.out.println("No has escrito un número. Prueba otra vez");
            }
        
        }while (salir==false); 
        System.out.println("Muchas gracias por participar."); //Muestra mensaje de agradecimiento.
    }
    
    private static void jugar(BufferedReader bf) throws IOException{
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
        int reCorrecta; 
    
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
                    Escapista escapista = new Escapista(colorPj);
                    Policia policia = new Policia(colorPo, 5);
                    if (dificultad==2) {
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
                            """); //Mas adelante, incluido el color del personaje y del agua
                            System.out.println(Preguntas.getPreguntas(dificultad, 0));
                            
                            reQ1 = Integer.parseInt(bf.readLine()); //Comprueba la respuesta 1
                            reCorrecta= Preguntas.getRespuestas(dificultad, 0);
                            


                            if (reQ1 == reCorrecta) { 
                                reAcertadas=reAcertadas+1;
                                if (policia.disparar(escapista, dificultad)) {
                                    System.out.println("¡OH NO! El policia ha acertado el disparo, el escapista permanece inmovil 1 turno.");

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
                                    """);

                                    System.out.println(Preguntas.getPreguntas(dificultad,1));
                                    reQ2=Integer.parseInt(bf.readLine()); //Lee la segunda respuesta
                                    reCorrecta= Preguntas.getRespuestas(dificultad, 1);
                                    if (reQ2==reCorrecta) { 
    
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
            
                                        """);
                                        System.out.println(Preguntas.getPreguntas(dificultad,2));
                                        reQ3 = Integer.parseInt(bf.readLine()); //Lee la respuesta 3
                                        reCorrecta= Preguntas.getRespuestas(dificultad, 2);
                                        if (reQ3==reCorrecta) {
                                            System.out.println("¡Has acertado! Tu personaje empieza a abrir la cerradura.");
                                            System.out.println("Oh no, el agua subió demasiado rápido, has perdido.");
                                            salirJuego=true; //Te saca del juego tras perder
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
                                        """);

                                        System.out.println(Preguntas.getPreguntas(dificultad,2));
                                        reQ3 = Integer.parseInt(bf.readLine());
                                        reCorrecta= Preguntas.getRespuestas(dificultad, 2);
                                        if (reQ3==reCorrecta) {
                                            System.out.println("¡Has acertado! Tu personaje empieza a abir la cerradura.");
                                            System.out.println("Oh no, el agua subió demasiado rápido, has perdido.");
                                            salirJuego=true;
                                        }else{
                                            System.out.println("Has fallado.");
                                            System.out.println("Oh no, el agua subió demasiado rápido, has perdido.");
                                            salirJuego=true; //Te saca del juego tras perder
                                        }
                                    }

                                } else {
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
        
                                    """);
                                    System.out.println(Preguntas.getPreguntas(dificultad,1));
                                    reQ2=Integer.parseInt(bf.readLine()); //Lee la segunda respuesta
                                    reCorrecta= Preguntas.getRespuestas(dificultad, 1);
                                    if (reQ2==reCorrecta) { 
                                        if (policia.disparar(escapista, dificultad)) {
                                            System.out.println("¡OH NO! El policia ha acertado el disparo, el escapista permanece inmovil 1 turno.");
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
                
                                            """);
                                            System.out.println(Preguntas.getPreguntas(dificultad,2));
                                            reQ3 = Integer.parseInt(bf.readLine()); //Lee la respuesta 3
                                            reCorrecta= Preguntas.getRespuestas(dificultad, 2);
                                            if (reQ3==reCorrecta) {
                                                System.out.println("¡Has acertado! Tu personaje empieza a abrir la cerradura.");
                                                System.out.println("Oh no, el agua subió demasiado rápido, has perdido.");
                                                salirJuego=true; //Te saca del juego tras perder
                                            }else{
                                                System.out.println("Has fallado.");
                                                System.out.println("Oh no, el agua subió demasiado rápido, has perdido.");
                                                salirJuego=true; //Te saca del juego tras perder
                                            }
                                        } else {
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
            
                                            """);
                                            System.out.println(Preguntas.getPreguntas(dificultad,2));
                                            reQ3 = Integer.parseInt(bf.readLine()); //Lee la respuesta 3
                                            reCorrecta= Preguntas.getRespuestas(dificultad, 2);
                                            if (reQ3==reCorrecta) {
                                                System.out.println("¡Has acertado! Tu personaje ha huido.");
                                                lvlPasado = true; //pone lvlPasado en true para salir del bucle.
                                                salirJuego = true; //Te manda al menú princial.
                                            }else{
                                                System.out.println("Has fallado.");
                                                System.out.println("Oh no, el agua subió demasiado rápido, has perdido.");
                                                salirJuego=true; //Te saca del juego tras perder
                                            }
                                            
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
            
                                        """);
                                        System.out.println(Preguntas.getPreguntas(dificultad,2));
                                        reQ3 = Integer.parseInt(bf.readLine());
                                        reCorrecta= Preguntas.getRespuestas(dificultad, 2);
                                        if (reQ3==reCorrecta) {
                                            System.out.println("¡Has acertado! Tu personaje empieza a abir la cerradura.");
                                            System.out.println("Oh no, el agua subió demasiado rápido, has perdido.");
                                            salirJuego=true;
                                        }else{
                                            System.out.println("Has fallado.");
                                            System.out.println("Oh no, el agua subió demasiado rápido, has perdido.");
                                            salirJuego=true; //Te saca del juego tras perder
                                        }
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
    
                                """);
                                System.out.println(Preguntas.getPreguntas(dificultad,1));
                                reQ2=Integer.parseInt(bf.readLine()); //Lee la segunda respuesta
                                reCorrecta= Preguntas.getRespuestas(dificultad, 1);
                                if (reQ2==reCorrecta) { 
                    
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
    
                                    """);
                                    System.out.println(Preguntas.getPreguntas(dificultad,2));
                                    reQ3 = Integer.parseInt(bf.readLine());//lee la respuesta 3
                                    reCorrecta= Preguntas.getRespuestas(dificultad, 2);
                                    if (reQ3==reCorrecta) {
                                        System.out.println("¡Has acertado! Tu personaje empieza a abir la cerradura.");
                                        System.out.println("Oh no, el agua subió demasiado rápido, has perdido.");
                                        salirJuego=true; //te saca del juego tras perder
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
    
                                    """);
                                    System.out.println(Preguntas.getPreguntas(dificultad,2));
                                    reQ3 = Integer.parseInt(bf.readLine());//lee la respuesta 3
                                    reCorrecta=Preguntas.getRespuestas(dificultad, 2);
                                    if (reQ3==reCorrecta) {
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
    
                            if (policia.disparar(escapista, dificultad)) {
                                System.out.println("¡OH NO! El policia ha acertado el disparo, el escapista permanece inmovil 1 turno.");
                            
                            } else {
                                
                            }
                        }while(salirJuego==false && lvlPasado==false);
                            
                    }else{
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
                            """); //Mas adelante, incluido el color del personaje y del agua
                            System.out.println(Preguntas.getPreguntas(dificultad, 0));
                            
                            reQ1 = Integer.parseInt(bf.readLine()); //Comprueba la respuesta 1
                            reCorrecta= Preguntas.getRespuestas(dificultad, 0);
                            if (reQ1 == reCorrecta) { 
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
    
                                """);
                                System.out.println(Preguntas.getPreguntas(dificultad,1));
                                reQ2=Integer.parseInt(bf.readLine()); //Lee la segunda respuesta
                                reCorrecta= Preguntas.getRespuestas(dificultad, 1);
                                if (reQ2==reCorrecta) { 
    
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
    
                                    """);
                                    System.out.println(Preguntas.getPreguntas(dificultad,2));
                                    reQ3 = Integer.parseInt(bf.readLine()); //Lee la respuesta 3
                                    reCorrecta= Preguntas.getRespuestas(dificultad, 2);
                                    if (reQ3==reCorrecta) {
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
    
                                    """);
                                    System.out.println(Preguntas.getPreguntas(dificultad,2));
                                    reQ3 = Integer.parseInt(bf.readLine());
                                    reCorrecta= Preguntas.getRespuestas(dificultad, 2);
                                    if (reQ3==reCorrecta) {
                                        System.out.println("¡Has acertado! Tu personaje empieza a abir la cerradura.");
                                        System.out.println("Oh no, el agua subió demasiado rápido, has perdido.");
                                        salirJuego=true;
                                    }else{
                                        System.out.println("Has fallado.");
                                        System.out.println("Oh no, el agua subió demasiado rápido, has perdido.");
                                        salirJuego=true; //Te saca del juego tras perder
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
    
                                """);
                                System.out.println(Preguntas.getPreguntas(dificultad,1));
                                reQ2=Integer.parseInt(bf.readLine()); //Lee la segunda respuesta
                                reCorrecta= Preguntas.getRespuestas(dificultad, 1);
                                if (reQ2==reCorrecta) { 
                    
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
    
                                    """);
                                    System.out.println(Preguntas.getPreguntas(dificultad,2));
                                    reQ3 = Integer.parseInt(bf.readLine());//lee la respuesta 3
                                    reCorrecta= Preguntas.getRespuestas(dificultad, 2);
                                    if (reQ3==reCorrecta) {
                                        System.out.println("¡Has acertado! Tu personaje empieza a abir la cerradura.");
                                        System.out.println("Oh no, el agua subió demasiado rápido, has perdido.");
                                        salirJuego=true; //te saca del juego tras perder
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
    
                                    """);
                                    System.out.println(Preguntas.getPreguntas(dificultad,2));
                                    reQ3 = Integer.parseInt(bf.readLine());//lee la respuesta 3
                                    reCorrecta=Preguntas.getRespuestas(dificultad, 2);
                                    if (reQ3==reCorrecta) {
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
    
                    }

                }else{ //Si eliges no jugar 
                    System.out.println("Volviendo al menú principal.");
                    salirJuego=true; //Variable salir del bucle juego.
                }
        }while(salirJuego==false);
       
    }
    
    private static void dificultadDelJuego(BufferedReader bf) throws IOException{
        boolean salirDificultad = false;
        do{
            try{
                System.out.println("""
                                        Selecciona la dificultad en la que desea jugar. Por defecto esta la dificultad FÁCIL. 
                                        \t 0) FÁCIL
                                        \t 1) MEDIA
                                        \t 2) DIFÍCIL
                                        \t 3) SALIR 
                                            """);
                dificultad=Integer.parseInt(bf.readLine());
                switch (dificultad) {
                    case 0:
                        System.out.println("Has elegido la dificultad \"FÁCIL\". Volviendo al menú principal.");
                        salirDificultad=true;
                        break;
                    case 1:
                        System.out.println("Has elegido la dificultad \"MEDIA\". Volviendo al menú principal.");
                        salirDificultad=true;
                        break;
                    case 2:
                        System.out.println("Has elegido la dificultad \"DIFÍCIL\". Volviendo al menú principal.");
                        salirDificultad=true;
                        break;   
                    case 3:
                        System.out.println("Has elegido \"SALIR\". Volviendo al menú principal.");
                        salirDificultad=true;
                        break;     
                    default:
                        System.out.println("No has elegido un número de la selección, prueba otra vez.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("No has escrito un número. Prueba otra vez");
            }
        }while (salirDificultad=false);
    }
    
    private static void cambiarAspecto(BufferedReader bf) throws IOException{
        
        //Respuestas aspecto
        int reAspecto;// respuesta de elección de aspecto.
        boolean cambiarAspectoPJ=false;
        int eleccionColorPJ;
        boolean cambiarAspectoW=false;
        int eleccioncolorPo;
        boolean salirAspecto=false;
        //Aspecto
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
                    \t2) Color del Policia.
                    \t3) Salir.
                    """);
                try { //Comprueba que escribas solo números.
                    reAspecto = Integer.parseInt(bf.readLine()); //Lee respuesta y la guarda en reAspecto

                    if (reAspecto==1) { 
                        System.out.println("Has elegido cambiaR el aspecto de tu personaje.");
                        cambiarAspectoPJ=true; //pone cambiar Aspecto del personaje en verdadero
                    }else if (reAspecto==2) {
                        System.out.println("Has elegido cambiar el aspecto del Policia.");
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
                    if (colorPo==COLORESPOLICIA[0]) { //Comprueba que el agua no tenga ese color.
                        System.out.println("No se puede hacer esta selección de color. El personaje no puede ser del mismo color que el agua.");
                    }else{
                        colorPj=COLORESPJ[0]; //Si el agua es de otro color, asigna el color seleccionado al jugador.
                    }
                    break;
                case 2:
                    System.out.println("Has elegido el color verde.");
                    cambiarAspectoPJ=false;//CambiarAspecto a false para que no colapse.
                    if (colorPo==COLORESPOLICIA[1]) {//Comprueba que el agua no tenga ese color.
                        System.out.println("No se puede hacer esta selección de color. El personaje no puede ser del mismo color que el agua.");
                    }else{
                        colorPj=COLORESPJ[1];  //Si el agua es de otro color, asigna el color seleccionado al jugador.
                    }                          
                    break;
                case 3:
                    System.out.println("Has elegido el color amarillo.");
                    cambiarAspectoPJ=false;//CambiarAspecto a false para que no colapse.
                    if (colorPo==COLORESPOLICIA[2]) {//Comprueba que el agua no tenga ese color.
                        System.out.println("No se puede hacer esta selección de color. El personaje no puede ser del mismo color que el agua.");
                    }else{
                        colorPj=COLORESPJ[2];     //Si el agua es de otro color, asigna el color seleccionado al jugador.   
                    }                      
                    break;
                case 4:
                    System.out.println("Has elegido el color azul.");
                    cambiarAspectoPJ=false;//CambiarAspecto a false para que no colapse.
                    if (colorPo==COLORESPOLICIA[3]) {//Comprueba que el agua no tenga ese color.
                        System.out.println("No se puede hacer esta selección de color. El personaje no puede ser del mismo color que el agua.");
                    }else{
                        colorPj=COLORESPJ[3];         //Si el agua es de otro color, asigna el color seleccionado al jugador.                 
                    }
                    break;
                case 5:
                    System.out.println("Has elegido el color morado.");
                    cambiarAspectoPJ=false;//CambiarAspecto a false para que no colapse.
                    if (colorPo==COLORESPOLICIA[4]) {//Comprueba que el agua no tenga ese color.
                        System.out.println("No se puede hacer esta selección de color. El personaje no puede ser del mismo color que el agua.");
                    }else{
                        colorPj=COLORESPJ[4];       //Si el agua es de otro color, asigna el color seleccionado al jugador.                       
                    }
                    break;
                case 6:
                    System.out.println("Has elegido el color Cian.");
                    cambiarAspectoPJ=false;//CambiarAspecto a false para que no colapse.
                    if (colorPo==COLORESPOLICIA[5]) {//Comprueba que el agua no tenga ese color.
                        System.out.println("No se puede hacer esta selección de color. El personaje no puede ser del mismo color que el agua.");
                    }else{
                        colorPj=COLORESPJ[5];             //Si el agua es de otro color, asigna el color seleccionado al jugador.                 
                    }
                    break;
                case 7:
                    System.out.println("Has elegido el color Blanco.");
                    cambiarAspectoPJ=false;//CambiarAspecto a false para que no colapse.
                    if (colorPo==COLORESPOLICIA[6]) {//Comprueba que el agua no tenga ese color.
                        System.out.println("No se puede hacer esta selección de color. El personaje no puede ser del mismo color que el agua.");
                    }else{
                        colorPj=COLORESPJ[6];  //Si el agua es de otro color, asigna el color seleccionado al jugador.
                    }                            
                    break;
                case 8:
                    System.out.println("Has elegido el color Negro.");
                    cambiarAspectoPJ=false;//CambiarAspecto a false para que no colapse.
                    if (colorPo==COLORESPOLICIA[7]) {//Comprueba que el agua no tenga ese color.
                        System.out.println("No se puede hacer esta selección de color. El personaje no puede ser del mismo color que el agua.");
                    }else{
                        colorPj=COLORESPJ[7];     //Si el agua es de otro color, asigna el color seleccionado al jugador.                         
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
                    eleccioncolorPo = Integer.parseInt(bf.readLine()); //Lee el color elegido.
                    switch (eleccioncolorPo) { //selecciona segun el número elegido.
                        case 1:
                            System.out.println("Has elegido el color rojo.");
                            cambiarAspectoW=false; //CambiarAspecto a false para que no colapse.
                            if (colorPj==COLORESPJ[0]) { //Comprueba que el personaje no tenga ese color
                                System.out.println("No se puede hacer esta selección de color. El agua no puede ser del mismo color que tu personaje.");
                            }else{
                                colorPo=COLORESPOLICIA[0]; //Si el personaje es de otro color, asigna el color seleccionado al agua.
                            }
                            break;
                        case 2:
                            System.out.println("Has elegido el color verde.");
                            cambiarAspectoW=false;//CambiarAspecto a false para que no colapse.
                            if (colorPj==COLORESPJ[1]) {//Comprueba que el personaje no tenga ese color
                                System.out.println("No se puede hacer esta selección de color. El agua no puede ser del mismo color que tu personaje.");
                            }else{
                                colorPo=COLORESPOLICIA[1];  //Si el personaje es de otro color, asigna el color seleccionado al agua.
                            }                          
                            break;
                        case 3:
                            System.out.println("Has elegido el color amarillo.");
                            cambiarAspectoW=false;//CambiarAspecto a false para que no colapse.
                            if (colorPj==COLORESPJ[2]) {//Comprueba que el personaje no tenga ese color
                                System.out.println("No se puede hacer esta selección de color. El agua no puede ser del mismo color que tu personaje.");
                            }else{
                                colorPo=COLORESPOLICIA[2]; //Si el personaje es de otro color, asigna el color seleccionado al agua.       
                            }                      
                            break;
                        case 4:
                            System.out.println("Has elegido el color azul.");
                            cambiarAspectoW=false;//CambiarAspecto a false para que no colapse.
                            if (colorPj==COLORESPJ[3]) {//Comprueba que el personaje no tenga ese color
                                System.out.println("No se puede hacer esta selección de color. El agua no puede ser del mismo color que tu personaje.");
                            }else{
                                colorPo=COLORESPOLICIA[3];  //Si el personaje es de otro color, asigna el color seleccionado al agua.                        
                            }
                            break;
                        case 5:
                            System.out.println("Has elegido el color morado.");
                            cambiarAspectoW=false;//CambiarAspecto a false para que no colapse.
                            if (colorPj==COLORESPJ[4]) {//Comprueba que el personaje no tenga ese color
                                System.out.println("No se puede hacer esta selección de color. El agua no puede ser del mismo color que tu personaje.");
                            }else{
                                colorPo=COLORESPOLICIA[4];  //Si el personaje es de otro color, asigna el color seleccionado al agua.                            
                            }
                            break;
                        case 6:
                            System.out.println("Has elegido el color Cian.");
                            cambiarAspectoW=false;//CambiarAspecto a false para que no colapse.
                            if (colorPj==COLORESPJ[5]) {//Comprueba que el personaje no tenga ese color
                                System.out.println("No se puede hacer esta selección de color. El agua no puede ser del mismo color que tu personaje.");
                            }else{
                                colorPo=COLORESPOLICIA[5];//Si el personaje es de otro color, asigna el color seleccionado al agua.                              
                            }
                            break;
                        case 7:
                            System.out.println("Has elegido el color Blanco.");
                            cambiarAspectoW=false;//CambiarAspecto a false para que no colapse.
                            if (colorPj==COLORESPJ[6]) {//Comprueba que el personaje no tenga ese color
                                System.out.println("No se puede hacer esta selección de color. El agua no puede ser del mismo color que tu personaje.");
                            }else{
                                colorPo=COLORESPOLICIA[6];//Si el personaje es de otro color, asigna el color seleccionado al agua.  
                            }                            
                            break;
                        case 8:
                            System.out.println("Has elegido el color Negro.");
                            cambiarAspectoW=false;//CambiarAspecto a false para que no colapse.
                            if (colorPj==COLORESPJ[7]) {//Comprueba que el personaje no tenga ese color
                                System.out.println("No se puede hacer esta selección de color. El agua no puede ser del mismo color que tu personaje.");
                            }else{
                                colorPo=COLORESPOLICIA[7]; //Si el personaje es de otro color, asigna el color seleccionado al agua.                             
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
    }
    
    private static void historial(BufferedReader bf) throws IOException{
    //Respuestas Historial
    int eleccionHistorial;// Respuesta de elección de historial.
    boolean salirHistorial=false;
    
    //Historial
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
                    System.out.println("Ha selecionado \'Revisar elecciónes de partida.\', Este menú aun no esta disponible.");
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

    }
    public static void main(String[] args) throws IOException {
        // Crear un BufferedReader para leer de la entrada estándar
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        //Llamamos al metodo bienvenida y le enviamos nuestro bufferedReader
        bienvenida(bf);



        
    }
}
    
