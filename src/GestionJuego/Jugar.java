package gestionjuego;

import java.io.IOException;

import clases.Escapista;
import clases.GestionPreguntas;
import clases.Policia;
import clases.Pregunta;
import utilidades.Utilidades;

public class Jugar {


    private static String[] gestorPantallas(String colorPj, String COLOR_RESET){
        String pantalla1="""
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
        █"""  + colorPj + """
            \t  o  """ + COLOR_RESET + """
                             █████████████████████
        █""" + colorPj + """
            \t /L """ + COLOR_RESET + """
                             █████████████████████
        █""" + colorPj + """
            \t | """ + COLOR_RESET + """
                          █████████████████████
    █████████████████████████████████████████████████████  
            """;

        String pantalla2 ="""
            █████████████████████████████████████████████████████     
            █                                                   █
            ██                                                  █
                                                               | |
                                                        """ + colorPj + """
                                                        \t\t\t\t\t     o""" + COLOR_RESET  + """
            \t   | |
            ██                                         """ + colorPj + """
                                                        \t\t\t\t\t    /L""" + COLOR_RESET  + """
                 | |
            █                                          """ + colorPj + """
                                                        \t\t\t\t\t    |""" + COLOR_RESET  + """
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
        String[] pantallas = {pantalla1, pantalla2 };
        return pantallas;
    }



    /**
     * Jugar. Muestra el juego, el cual va sacando preguntas y respuestas y comprobandolas.
     * @author SDM
     * @param bf
     * @throws IOException
     */
    public static void jugar(String[] MOSTRARMENUS, String colorPj, String colorPo, int dificultad, String COLOR_RESET) throws IOException{
        //Respuestas del juego
        int opcionMenu= 1;
        int max=4;
        int min=1;
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
                    String[] pantallas = gestorPantallas(colorPj, COLOR_RESET);
                    int mostrarPantalla = 0;
                    String pantalla= pantallas[mostrarPantalla]; //Mas adelante, incluido el color del personaje y del agua
                    if (dificultad==2) {
                        do{
                            opciones=p.getOpciones();   
                            reAcertadas=0;
                            System.out.println(pantalla);
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
                                    pantalla= pantallas[mostrarPantalla]; //Mas adelante, incluido el color del personaje y del agua
                                    System.out.println(pantalla);

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
                                    mostrarPantalla++;
                                    System.out.println("¡Has acertado! Tu personaje avanza hasta la rendija de salida.");
                                    pantalla= pantallas[mostrarPantalla]; //Mas adelante, incluido el color del personaje y del agua
                                    System.out.println(pantalla);

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
                                            pantalla= pantallas[mostrarPantalla]; //Mas adelante, incluido el color del personaje y del agua
                                            System.out.println(pantalla);
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
                                            pantalla= pantallas[mostrarPantalla]; //Mas adelante, incluido el color del personaje y del agua
                                            System.out.println(pantalla);
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
                                        pantalla= pantallas[mostrarPantalla]; //Mas adelante, incluido el color del personaje y del agua
                                        System.out.println(pantalla);
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
                                System.out.println("Has fallado."); 
                                pantalla= pantallas[mostrarPantalla]; //Mas adelante, incluido el color del personaje y del agua
                                System.out.println(pantalla);
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
                                    mostrarPantalla++;
                                    pantalla= pantallas[mostrarPantalla]; //Mas adelante, incluido el color del personaje y del agua
                                    System.out.println(pantalla);
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
                                    pantalla= pantallas[mostrarPantalla]; //Mas adelante, incluido el color del personaje y del agua
                                    System.out.println(pantalla);
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
                            pantalla= pantallas[mostrarPantalla]; //Mas adelante, incluido el color del personaje y del agua
                            System.out.println(pantalla);
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
                                mostrarPantalla++;
                                pantalla= pantallas[mostrarPantalla]; //Mas adelante, incluido el color del personaje y del agua
                                System.out.println(pantalla);
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
                                    pantalla= pantallas[mostrarPantalla]; //Mas adelante, incluido el color del personaje y del agua
                                    System.out.println(pantalla);
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
                                    pantalla= pantallas[mostrarPantalla]; //Mas adelante, incluido el color del personaje y del agua
                                    System.out.println(pantalla);
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
                                System.out.println("Has fallado.");
                                pantalla= pantallas[mostrarPantalla]; //Mas adelante, incluido el color del personaje y del agua
                                System.out.println(pantalla);
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
                                    mostrarPantalla++;
                                    pantalla= pantallas[mostrarPantalla]; //Mas adelante, incluido el color del personaje y del agua
                                    System.out.println(pantalla);
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
                                    pantalla= pantallas[mostrarPantalla]; //Mas adelante, incluido el color del personaje y del agua
                                    System.out.println(pantalla);
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
    
}
