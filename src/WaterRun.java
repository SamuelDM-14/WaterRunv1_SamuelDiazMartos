/**
 * WaterRun
 * @author SDM
 * 18-11-2024
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Utilidades.Utilidades;
import Clases.Escapista;
import Clases.GestionPreguntas;
import Clases.Policia;
import Clases.Pregunta;
/**
 * Clase WaterRun.
 * Maneja todo el juego en sí. 
 */
public class WaterRun {

    private static final String[] MOSTRARMENUS= {"Elige una opcón del menú.\n\t1) Jugar.\n\t2) Dificultad\n\t3) Aspecto\n\t4) Historial de juego.\n\t5) Salir.",
        "Has elegico jugar.\nPara ponerte en contexto, eres un prisionero condenado injustametne a muerte por ahogamiento.\nTu desafío inicial es encontrar la manera de escapar de la sala que se irá inundando.\nPara ello, deberas resolver una serie de acertijos o preguntas que te iremos mostrando.\nAl responder las preguntas o acertijos deberas de poner el número correspondiente indicado.\nEjemplo: ¿Cuantas letras tiene Hola?\n1) 4 \t\t 2) 7 \t\t 3) 5 \t\t 4) 1 \nEn este caso tendrias que poner como respuesta \'1\'. \nSi fallas al responder o ponea un caracter no valido se contará como error.\n¿Estas preparado? (Respuesta con 'S' para si y 'N' para no)\n",
        "Selecciona la dificultad en la que desea jugar. Por defecto esta la dificultad FÁCIL.\n\t 0) FÁCIL\n\t 1) MEDIA\n\t 2) DIFÍCIL\n\t 3) SALIR", 
        "Has elegido la opción de aspecto.\nEn este menú, puedes personalizar el color de tu personaje entre la siguiente selección y el color del agua también.\n¿Que quieres personalizar?\n\t1) Color del personaje.\n\t2) Color del Policia.\n\t3) Salir.",
        "Elige un color para tu personaje:\n\t1)Rojo\t2)Verde\t3)Amarillo\t4)Azul\t5)Morado\t6)Cian\t7)Blanco\t8)Negro\t9)Salir",
        "Elige un color para el policia:\n\t1)Rojo\t2)Verde\t3)Amarillo\t4)Azul\t5)Morado\t6)Cian\t7)Blanco\t8)Negro\t9)Salir",
        "Este menú aun no esta disponible. Pulse 3 para salir.\n\t1) Jugar una partida guardada. (Proximamente)\n\t2) Revisar elecciónes de partida. (Proximamente)\n\t3) Salir."
    };
    private static int opcionMenu=0;
    private static int max = 5;
    private static int min = 0;

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

    /**
     * Bienvenida al juego. Comprueba que solo pongas un enter.
     * @author SDM 
     * @param bf
     * @throws IOException
     */
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
    
    /**
     * Menu1. Muestra las diferentes opciones de menú y te manda según tu selección al apartado correspondiente.
     * @author SDM
     * @param bf
     * @throws IOException
     */
    private static void menu1(BufferedReader bf) throws IOException{
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
                    jugar(bf); // Llama al metodo jugar y le envia el bufferedReader
                    break;

                case 2:
                    //Entra en caso de elegir Dificultad
                    dificultadDelJuego(bf);// Llama al metodo dificultadDelJuego y le envia el BufferedReader
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
            };  
        }while (salir==false); 
        System.out.println("Muchas gracias por participar."); //Muestra mensaje de agradecimiento.
    }


    

    

    /**
     * Jugar. Muestra el juego, el cual va sacando preguntas y respuestas y comprobandolas.
     * @author SDM
     * @param bf
     * @throws IOException
     */
    private static void jugar(BufferedReader bf) throws IOException{
        //Respuestas del juego
        opcionMenu= 1;
        max=4;
        min=1;
        char re1; //Respuesta jugar o no jugar.
        Boolean jugar =false; //Comprobar si el jugador quiere jugar o no.
        Boolean lvlPasado = false; //Variable que comprueba si te has pasdo un nivel.
        boolean salirJuego=false;
        int reAcertadas=0;
        int reJugador;
        int enunciado=0;
        String[] opciones;
        String respuestaElegida;
    
        salirJuego=false; //Pone en false el salir. Si has jugado sin recargar el programa te sacaria en la primera seleccion de salir.
            
        do{ //Repite hasta que el jugador indique que quiera salir. Más adelante, cuando se
            //pase un nivel, le dará la opcion de guardar y de salir. 
            System.out.println(MOSTRARMENUS[opcionMenu]); //Explicación de como funcionan las respuestas y como funciona el juego.
            re1=Utilidades.leerSN();

            if (re1=='S') {
                jugar=true; //Variable para entrar al juego                
            }else if (re1 == 'N') {
                jugar=false; //Variable para entrar al juego
                salirJuego=true; //Variable para volver al menú
            }else{
                System.out.println("No has escrito ninguna de las 2 opciones. Prueba otra vez.");
            }  
                                
                if (jugar==true) { //Inicio del juego
                    Escapista escapista = new Escapista(colorPj);
                    Policia policia = new Policia(colorPo, 5);
                    GestionPreguntas gp = new GestionPreguntas();
                    Pregunta p = gp.getPregunta(dificultad, enunciado);

                    if (dificultad==2) {
                        do{
                            opciones=p.getOpciones();    

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
                            System.out.println(p.getEnunciado());
                            for(int i = 0; i < opciones.length; i++){
                                if (!opciones[i].isEmpty()) {
                                    System.out.println((i + 1) + ") " + opciones[i]);
                                }
                            }
                            reJugador = Utilidades.leerEnteroValidado(min, max); //Comprueba la respuesta 1
                            respuestaElegida = opciones[reJugador - 1];
                            if (respuestaElegida.equals(p.getRespuestaCorrecta())) { 
                                reAcertadas=reAcertadas+1;
                                enunciado++;
                                p = gp.getPregunta(dificultad, enunciado);
                                opciones=p.getOpciones();  
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

                                    System.out.println(p.getEnunciado());
                                    for(int i = 0; i < opciones.length; i++){
                                        if (!opciones[i].isEmpty()) {
                                            System.out.println((i + 1) + ") " + opciones[i]);
                                        }
                                    }
                                    reJugador = Utilidades.leerEnteroValidado(min, max); //Comprueba la respuesta 1
                                    respuestaElegida = opciones[reJugador - 1];
                                    if (respuestaElegida.equals(p.getRespuestaCorrecta())) { 
                                        reAcertadas=reAcertadas+1;
                                        enunciado++;
                                        p = gp.getPregunta(dificultad, enunciado);
                                        opciones=p.getOpciones(); 
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
                                        System.out.println(p.getEnunciado());
                                        for(int i = 0; i < opciones.length; i++){
                                            if (!opciones[i].isEmpty()) {
                                                System.out.println((i + 1) + ") " + opciones[i]);
                                            }
                                        }
                                        reJugador = Utilidades.leerEnteroValidado(min, max); //Comprueba la respuesta 1
                                        respuestaElegida = opciones[reJugador - 1];
                                        if (respuestaElegida.equals(p.getRespuestaCorrecta())) {
                                            System.out.println("¡Has acertado! Tu personaje empieza a abrir la cerradura.");
                                            System.out.println("Oh no, el agua subió demasiado rápido, has perdido.");
                                            salirJuego=true; //Te saca del juego tras perder
                                        }else{
                                            System.out.println("Has fallado.");
                                            System.out.println("Oh no, el agua subió demasiado rápido, has perdido.");
                                            salirJuego=true; //Te saca del juego tras perder
                                        }
                                    }else {
                                        enunciado++;
                                        p = gp.getPregunta(dificultad, enunciado);
                                        opciones=p.getOpciones(); 
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
                                        System.out.println(p.getEnunciado());
                                        for(int i = 0; i < opciones.length; i++){
                                            if (!opciones[i].isEmpty()) {
                                                System.out.println((i + 1) + ") " + opciones[i]);
                                            }
                                        }
                                        reJugador = Utilidades.leerEnteroValidado(min, max); //Comprueba la respuesta 1
                                        respuestaElegida = opciones[reJugador - 1];
                                        if (respuestaElegida.equals(p.getRespuestaCorrecta())) { 
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
                                    System.out.println(p.getEnunciado());
                                    for(int i = 0; i < opciones.length; i++){
                                        if (!opciones[i].isEmpty()) {
                                            System.out.println((i + 1) + ") " + opciones[i]);
                                        }
                                    }
                                    reJugador = Utilidades.leerEnteroValidado(min, max); //Comprueba la respuesta 1
                                    respuestaElegida = opciones[reJugador - 1];
                                    if (respuestaElegida.equals(p.getRespuestaCorrecta())) { 
                                        reAcertadas=reAcertadas+1;
                                        enunciado++;
                                        p = gp.getPregunta(dificultad, enunciado);
                                        opciones=p.getOpciones(); 
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
                                            System.out.println(p.getEnunciado());
                                            for(int i = 0; i < opciones.length; i++){
                                                if (!opciones[i].isEmpty()) {
                                                    System.out.println((i + 1) + ") " + opciones[i]);
                                                }
                                            }
                                            reJugador = Utilidades.leerEnteroValidado(min, max); //Comprueba la respuesta 1
                                            respuestaElegida = opciones[reJugador - 1];
                                            if (respuestaElegida.equals(p.getRespuestaCorrecta())) { 
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
                                            System.out.println(p.getEnunciado());
                                            for(int i = 0; i < opciones.length; i++){
                                                if (!opciones[i].isEmpty()) {
                                                    System.out.println((i + 1) + ") " + opciones[i]);
                                                }
                                            }
                                            reJugador = Utilidades.leerEnteroValidado(min, max); //Comprueba la respuesta 1
                                            respuestaElegida = opciones[reJugador - 1];
                                            if (respuestaElegida.equals(p.getRespuestaCorrecta())) { 
                                                System.out.println("¡Has acertado! Tu personaje ha huido.");
                                                lvlPasado = true; //pone lvlPasado en true para salir del bucle.
                                                salirJuego = true; //Te manda al menú princial.
                                            }else{
                                                System.out.println("Has fallado.");
                                                System.out.println("Oh no, el agua subió demasiado rápido, has perdido.");
                                                salirJuego=true; //Te saca del juego tras perder
                                            }
                                            
                                        }
                                    }else {
                                        enunciado++;
                                        p = gp.getPregunta(dificultad, enunciado);
                                        opciones=p.getOpciones(); 
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
                                        System.out.println(p.getEnunciado());
                                        for(int i = 0; i < opciones.length; i++){
                                            if (!opciones[i].isEmpty()) {
                                                System.out.println((i + 1) + ") " + opciones[i]);
                                            }
                                        }
                                        reJugador = Utilidades.leerEnteroValidado(min, max); //Comprueba la respuesta 1
                                        respuestaElegida = opciones[reJugador - 1];
                                        if (respuestaElegida.equals(p.getRespuestaCorrecta())) { 
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
                            }else {
                                enunciado++;
                                p = gp.getPregunta(dificultad, enunciado);
                                opciones=p.getOpciones(); 
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
                                System.out.println(p.getEnunciado());
                                for(int i = 0; i < opciones.length; i++){
                                    if (!opciones[i].isEmpty()) {
                                        System.out.println((i + 1) + ") " + opciones[i]);
                                    }
                                }
                                reJugador = Utilidades.leerEnteroValidado(min, max); //Comprueba la respuesta 1
                                respuestaElegida = opciones[reJugador - 1];
                                if (respuestaElegida.equals(p.getRespuestaCorrecta())) { 
                                    reAcertadas=reAcertadas+1;
                                    enunciado++;
                                    p = gp.getPregunta(dificultad, enunciado);
                                    opciones=p.getOpciones(); 
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
                                    System.out.println(p.getEnunciado());
                                    for(int i = 0; i < opciones.length; i++){
                                        if (!opciones[i].isEmpty()) {
                                            System.out.println((i + 1) + ") " + opciones[i]);
                                        }
                                    }
                                    reJugador = Utilidades.leerEnteroValidado(min, max); //Comprueba la respuesta 1
                                    respuestaElegida = opciones[reJugador - 1];
                                    if (respuestaElegida.equals(p.getRespuestaCorrecta())) { 
                                        System.out.println("¡Has acertado! Tu personaje empieza a abir la cerradura.");
                                        System.out.println("Oh no, el agua subió demasiado rápido, has perdido.");
                                        salirJuego=true; //te saca del juego tras perder
                                    }else{
                                        System.out.println("Has fallado.");
                                        System.out.println("Oh no, el agua subió demasiado rápido, has perdido.");
                                        salirJuego=true; //Te saca del juego tras perder
                                    }
                                }else {
                                    enunciado++;
                                    p = gp.getPregunta(dificultad, enunciado);
                                    opciones=p.getOpciones(); 
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
                                    System.out.println(p.getEnunciado());
                                    for(int i = 0; i < opciones.length; i++){
                                        if (!opciones[i].isEmpty()) {
                                            System.out.println((i + 1) + ") " + opciones[i]);
                                        }
                                    }
                                    reJugador = Utilidades.leerEnteroValidado(min, max);
                                    respuestaElegida = opciones[reJugador - 1];
                                    if (respuestaElegida.equals(p.getRespuestaCorrecta())) { 
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
                            
                    }else{
                        opciones=p.getOpciones();
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
                            System.out.println(p.getEnunciado());
                            for(int i = 0; i < opciones.length; i++){
                                if (!opciones[i].isEmpty()) {
                                    System.out.println((i + 1) + ") " + opciones[i]);
                                }
                            }
                            reJugador = Utilidades.leerEnteroValidado(min, max); //Comprueba la respuesta 1
                            respuestaElegida = opciones[reJugador - 1];
                            if (respuestaElegida.equals(p.getRespuestaCorrecta())) { 
                                reAcertadas=reAcertadas+1;
                                enunciado++;
                                p = gp.getPregunta(dificultad, enunciado);
                                opciones=p.getOpciones(); 
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
                                System.out.println(p.getEnunciado());
                                for(int i = 0; i < opciones.length; i++){
                                    if (!opciones[i].isEmpty()) {
                                        System.out.println((i + 1) + ") " + opciones[i]);
                                    }
                                }
                                reJugador = Utilidades.leerEnteroValidado(min, max); //Comprueba la respuesta 1
                                respuestaElegida = opciones[reJugador - 1];
                                if (respuestaElegida.equals(p.getRespuestaCorrecta())) { 
                                    reAcertadas=reAcertadas+1;
                                    enunciado++;
                                    p = gp.getPregunta(dificultad, enunciado);
                                    opciones=p.getOpciones(); 
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
                                    System.out.println(p.getEnunciado());
                                    for(int i = 0; i < opciones.length; i++){
                                        if (!opciones[i].isEmpty()) {
                                            System.out.println((i + 1) + ") " + opciones[i]);
                                        }
                                    }
                                    reJugador = Utilidades.leerEnteroValidado(min, max); //Comprueba la respuesta 1
                                    respuestaElegida = opciones[reJugador - 1];
                                    if (respuestaElegida.equals(p.getRespuestaCorrecta())) { 
                                        p = gp.getPregunta(dificultad, enunciado);
                                        System.out.println("¡Has acertado! Tu personaje ha huido.");
                                        lvlPasado = true; //pone lvlPasado en true para salir del bucle.
                                        salirJuego = true; //Te manda al menú princial.
                                    }else{
                                        System.out.println("Has fallado.");
                                        System.out.println("Oh no, el agua subió demasiado rápido, has perdido.");
                                        salirJuego=true; //Te saca del juego tras perder
                                    }
                                }else {
                                    enunciado++;
                                    p = gp.getPregunta(dificultad, enunciado);
                                    opciones=p.getOpciones(); 
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
                                    System.out.println(p.getEnunciado());
                                    for(int i = 0; i < opciones.length; i++){
                                        if (!opciones[i].isEmpty()) {
                                            System.out.println((i + 1) + ") " + opciones[i]);
                                        }
                                    }
                                    reJugador = Utilidades.leerEnteroValidado(min, max); //Comprueba la respuesta 1
                                    respuestaElegida = opciones[reJugador - 1];
                                    if (respuestaElegida.equals(p.getRespuestaCorrecta())) { 
                                        System.out.println("¡Has acertado! Tu personaje empieza a abir la cerradura.");
                                        System.out.println("Oh no, el agua subió demasiado rápido, has perdido.");
                                        salirJuego=true;
                                    }else{
                                        System.out.println("Has fallado.");
                                        System.out.println("Oh no, el agua subió demasiado rápido, has perdido.");
                                        salirJuego=true; //Te saca del juego tras perder
                                    }
                                }    
                            }else {
                                enunciado++;
                                p = gp.getPregunta(dificultad, enunciado);
                                opciones=p.getOpciones(); 
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
                                System.out.println(p.getEnunciado());
                                for(int i = 0; i < opciones.length; i++){
                                    if (!opciones[i].isEmpty()) {
                                        System.out.println((i + 1) + ") " + opciones[i]);
                                    }
                                }
                                reJugador = Utilidades.leerEnteroValidado(min, max); //Comprueba la respuesta 1
                                respuestaElegida = opciones[reJugador - 1];
                                if (respuestaElegida.equals(p.getRespuestaCorrecta())) { 
                                    reAcertadas=reAcertadas+1;
                                    enunciado++;
                                    p = gp.getPregunta(dificultad, enunciado);
                                    opciones=p.getOpciones(); 
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
                                    System.out.println(p.getEnunciado());
                                    for(int i = 0; i < opciones.length; i++){
                                        if (!opciones[i].isEmpty()) {
                                            System.out.println((i + 1) + ") " + opciones[i]);
                                        }
                                    }
                                    reJugador = Utilidades.leerEnteroValidado(min, max); //Comprueba la respuesta 1
                                    respuestaElegida = opciones[reJugador - 1];
                                    if (respuestaElegida.equals(p.getRespuestaCorrecta())) { 
                                        System.out.println("¡Has acertado! Tu personaje empieza a abir la cerradura.");
                                        System.out.println("Oh no, el agua subió demasiado rápido, has perdido.");
                                        salirJuego=true; //te saca del juego tras perder
                                    }else{
                                        System.out.println("Has fallado.");
                                        System.out.println("Oh no, el agua subió demasiado rápido, has perdido.");
                                        salirJuego=true; //Te saca del juego tras perder
                                    }
                                }else {
                                    enunciado++;
                                    p = gp.getPregunta(dificultad, enunciado);
                                    opciones=p.getOpciones(); 
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
                                    System.out.println(p.getEnunciado());
                                    for(int i = 0; i < opciones.length; i++){
                                        if (!opciones[i].isEmpty()) {
                                            System.out.println((i + 1) + ") " + opciones[i]);
                                        }
                                    }
                                    reJugador = Utilidades.leerEnteroValidado(min, max); //Comprueba la respuesta 1
                                    respuestaElegida = opciones[reJugador - 1];
                                    if (respuestaElegida.equals(p.getRespuestaCorrecta())) { 
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
    
    /**
     * Dificultad. Te permite elegir la dificultad con la que jugar.
     * @author SDM
     * @param bf
     * @throws IOException
     */
    private static void dificultadDelJuego(BufferedReader bf) throws IOException{
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
     * cambiarAspectoPJ. Te permite elegir el color del personaje.
     * @param bf
     * @throws IOException
     */
    private static void cambiarAspectoPJ(BufferedReader bf) throws IOException{
        //cambias el aspecto del Personaje
        int eleccionColorPJ;
        opcionMenu= 4;
        max=9;
        min=1;
        //Muestra las opciones de colores.
        System.out.println("Has elegido cambiaR el aspecto de tu personaje.");
        System.out.println(MOSTRARMENUS[opcionMenu]);
        eleccionColorPJ = Utilidades.leerEnteroValidado(min, max); //Lee la elección del color
        switch (eleccionColorPJ) { //Según la elección se mete en el case correspondiente.
            case 1:
            System.out.println("Has elegido el color rojo.");
            if (colorPo==COLORESPOLICIA[0]) { //Comprueba que el agua no tenga ese color.
                System.out.println("No se puede hacer esta selección de color. El personaje no puede ser del mismo color que el agua.");
            }else{
                colorPj=COLORESPJ[0]; //Si el agua es de otro color, asigna el color seleccionado al jugador.
            }
            break;
        case 2:
            System.out.println("Has elegido el color verde.");
            if (colorPo==COLORESPOLICIA[1]) {//Comprueba que el agua no tenga ese color.
                System.out.println("No se puede hacer esta selección de color. El personaje no puede ser del mismo color que el agua.");
            }else{
                colorPj=COLORESPJ[1];  //Si el agua es de otro color, asigna el color seleccionado al jugador.
            }                          
            break;
        case 3:
            System.out.println("Has elegido el color amarillo.");
            if (colorPo==COLORESPOLICIA[2]) {//Comprueba que el agua no tenga ese color.
                System.out.println("No se puede hacer esta selección de color. El personaje no puede ser del mismo color que el agua.");
            }else{
                colorPj=COLORESPJ[2];     //Si el agua es de otro color, asigna el color seleccionado al jugador.   
            }                      
            break;
        case 4:
            System.out.println("Has elegido el color azul.");
            if (colorPo==COLORESPOLICIA[3]) {//Comprueba que el agua no tenga ese color.
                System.out.println("No se puede hacer esta selección de color. El personaje no puede ser del mismo color que el agua.");
            }else{
                colorPj=COLORESPJ[3];         //Si el agua es de otro color, asigna el color seleccionado al jugador.                 
            }
            break;
        case 5:
            System.out.println("Has elegido el color morado.");
            if (colorPo==COLORESPOLICIA[4]) {//Comprueba que el agua no tenga ese color.
                System.out.println("No se puede hacer esta selección de color. El personaje no puede ser del mismo color que el agua.");
            }else{
                colorPj=COLORESPJ[4];       //Si el agua es de otro color, asigna el color seleccionado al jugador.                       
            }
            break;
        case 6:
            System.out.println("Has elegido el color Cian.");
            if (colorPo==COLORESPOLICIA[5]) {//Comprueba que el agua no tenga ese color.
                System.out.println("No se puede hacer esta selección de color. El personaje no puede ser del mismo color que el agua.");
            }else{
                colorPj=COLORESPJ[5];             //Si el agua es de otro color, asigna el color seleccionado al jugador.                 
            }
            break;
        case 7:
            System.out.println("Has elegido el color Blanco.");
            if (colorPo==COLORESPOLICIA[6]) {//Comprueba que el agua no tenga ese color.
                System.out.println("No se puede hacer esta selección de color. El personaje no puede ser del mismo color que el agua.");
            }else{
                colorPj=COLORESPJ[6];  //Si el agua es de otro color, asigna el color seleccionado al jugador.
            }                            
            break;
        case 8:
            System.out.println("Has elegido el color Negro.");
            if (colorPo==COLORESPOLICIA[7]) {//Comprueba que el agua no tenga ese color.
                System.out.println("No se puede hacer esta selección de color. El personaje no puede ser del mismo color que el agua.");
            }else{
                colorPj=COLORESPJ[7];     //Si el agua es de otro color, asigna el color seleccionado al jugador.                         
            }
            break;
        case 9:
            System.out.println("Has elegido salir. Volviendo al menú de aspecto."); 
            break;
        default:
            //No pongo nada debido a que las validaciones correspondientes estan hechas.
            break;
        }
    }

    /**
     * cambiarAspectoPo. Te permite elegir el color del policia (AUN NO INCLUIDO EN EL JUEGO).
     * @param bf
     * @throws IOException
     */
    private static void cambiarAspectoPo(BufferedReader bf) throws IOException{
        int eleccioncolorPo;
        opcionMenu= 5;
        max=9;
        min=1;
            //Muestra las opciones de colores.
            System.out.println("Has elegido cambiar el aspecto del Policia.");
            System.out.println(MOSTRARMENUS[opcionMenu]);
            eleccioncolorPo = Utilidades.leerEnteroValidado(min, max); //Lee el color elegido.
            switch (eleccioncolorPo) { //selecciona segun el número elegido.
                case 1:
                    System.out.println("Has elegido el color rojo.");
                    if (colorPj==COLORESPJ[0]) { //Comprueba que el personaje no tenga ese color
                        System.out.println("No se puede hacer esta selección de color. El agua no puede ser del mismo color que tu personaje.");
                    }else{
                        colorPo=COLORESPOLICIA[0]; //Si el personaje es de otro color, asigna el color seleccionado al agua.
                    }
                    break;
                case 2:
                    System.out.println("Has elegido el color verde.");                    
                    if (colorPj==COLORESPJ[1]) {//Comprueba que el personaje no tenga ese color
                        System.out.println("No se puede hacer esta selección de color. El agua no puede ser del mismo color que tu personaje.");
                    }else{
                        colorPo=COLORESPOLICIA[1];  //Si el personaje es de otro color, asigna el color seleccionado al agua.
                    }                          
                    break;
                case 3:
                    System.out.println("Has elegido el color amarillo.");                    
                    if (colorPj==COLORESPJ[2]) {//Comprueba que el personaje no tenga ese color
                        System.out.println("No se puede hacer esta selección de color. El agua no puede ser del mismo color que tu personaje.");
                    }else{
                        colorPo=COLORESPOLICIA[2]; //Si el personaje es de otro color, asigna el color seleccionado al agua.       
                    }                      
                    break;
                case 4:
                    System.out.println("Has elegido el color azul.");                    
                    if (colorPj==COLORESPJ[3]) {//Comprueba que el personaje no tenga ese color
                        System.out.println("No se puede hacer esta selección de color. El agua no puede ser del mismo color que tu personaje.");
                    }else{
                        colorPo=COLORESPOLICIA[3];  //Si el personaje es de otro color, asigna el color seleccionado al agua.                        
                    }
                    break;
                case 5:
                    System.out.println("Has elegido el color morado.");                    
                    if (colorPj==COLORESPJ[4]) {//Comprueba que el personaje no tenga ese color
                        System.out.println("No se puede hacer esta selección de color. El agua no puede ser del mismo color que tu personaje.");
                    }else{
                        colorPo=COLORESPOLICIA[4];  //Si el personaje es de otro color, asigna el color seleccionado al agua.                            
                    }
                    break;
                case 6:
                    System.out.println("Has elegido el color Cian.");                    
                    if (colorPj==COLORESPJ[5]) {//Comprueba que el personaje no tenga ese color
                        System.out.println("No se puede hacer esta selección de color. El agua no puede ser del mismo color que tu personaje.");
                    }else{
                        colorPo=COLORESPOLICIA[5];//Si el personaje es de otro color, asigna el color seleccionado al agua.                              
                    }
                    break;
                case 7:
                    System.out.println("Has elegido el color Blanco.");                    
                    if (colorPj==COLORESPJ[6]) {//Comprueba que el personaje no tenga ese color
                        System.out.println("No se puede hacer esta selección de color. El agua no puede ser del mismo color que tu personaje.");
                    }else{
                        colorPo=COLORESPOLICIA[6];//Si el personaje es de otro color, asigna el color seleccionado al agua.  
                    }                            
                    break;
                case 8:
                    System.out.println("Has elegido el color Negro.");                    
                    if (colorPj==COLORESPJ[7]) {//Comprueba que el personaje no tenga ese color
                        System.out.println("No se puede hacer esta selección de color. El agua no puede ser del mismo color que tu personaje.");
                    }else{
                        colorPo=COLORESPOLICIA[7]; //Si el personaje es de otro color, asigna el color seleccionado al agua.                             
                    }
                    break;    
                case 9:
                    System.out.println("Has elegido salir. Volviendo al menú principal.");                    
                    break;
                default:
                    //No pongo nada debido a que las validaciones correspondientes estan hechas.
                    break;
            }
        }
    
    /**
     * Aspecto. Te permite cambiar el Aspecto del personaje.
     * @author SDM
     * @param bf
     * @throws IOException
     */
    private static void cambiarAspecto(BufferedReader bf) throws IOException{

        //Respuestas aspecto
        int reAspecto;// respuesta de elección de aspecto.


        boolean salirAspecto=false;
        //Aspecto
        salirAspecto=false; //Pone salirAspecto en false, ya que sino cuando eligieras cualquier cosa dentro de los submenús
        //Te sacaraía instantaneamente al menú general. 
        do { //Repite hasta que el usuario seleccione salir.
            opcionMenu= 3;
            max=3;
            min=1;
            //Muestra opciones de aspecto.
            System.out.println(MOSTRARMENUS[opcionMenu]);

            reAspecto = Utilidades.leerEnteroValidado(min, max); //Lee respuesta y la guarda en reAspecto

            switch (reAspecto) {
                case 1:
                    cambiarAspectoPJ(bf);// Llama al meteodo cambiarAspectoPJ y le envia el BufferedReader
                    break;
                case 2:
                    cambiarAspectoPo(bf);// Llama al meteodo cambiarAspectoPo y le envia el BufferedReader
                    break;
                case 3: 
                    System.out.println("Has elegido salir. Volviendo al menú principal.");
                    salirAspecto=true;//sale al menú principal.
                    break;
                default:
                    //No pongo nada debido a que las validaciones correspondientes estan hechas.
                    break;
            }


       }while (salirAspecto==false);
    }
    
    /**
     * Historial. Actualmente sin funcionamiento.
     * @author SDM
     * @param bf
     * @throws IOException
     */
    private static void historial(BufferedReader bf) throws IOException{
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
     * Main WaterRun. Llama a bienvendia.
     * @author SDM
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // Crear un BufferedReader para leer de la entrada estándar
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        //Llamamos al metodo bienvenida y le enviamos nuestro bufferedReader
        bienvenida(bf);
    }
}
    
