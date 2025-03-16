package gestionjuego.juego;

import java.io.IOException;

import clases.GestionPreguntas;
import clases.Pregunta;
import utilidades.Utilidades;
import utilidades.VarGenYConst;

public class JugarFaMe {

        /**
     * Metodo que gestiona la partida de dificultad Facil y Medio
     * 
     * @param dificultad Dificultad de la partida
     * @param salirJuego Variable de salida del juego
     * @throws IOException
     */
    public static void jugarFaMe() throws IOException {
        Boolean lvlPasado = false; // Variable que comprueba si te has pasdo un nivel.
        VarGenYConst.min = 1;
        VarGenYConst.max = 4;
        
        int reAcertadas = 0;
        int enunciado = 0;
        int reJugador;
        String[] opciones;
        String respuestaElegida;
        GestionPreguntas gp = new GestionPreguntas();
        Pregunta p = gp.getPregunta(VarGenYConst.dificultad, enunciado);
        String[] pantallas = Utilidades.gestorPantallas();
        int mostrarPantalla = 0;
        String pantalla = pantallas[mostrarPantalla]; // Mas adelante, incluido el color del personaje y del agua

        opciones = p.getOpciones();
        do {
            reAcertadas = 0;
            pantalla = pantallas[mostrarPantalla]; // Mas adelante, incluido el color del personaje y del agua
            System.out.println(pantalla);
            System.out.println(p.getEnunciado());
            for (int i = 0; i < opciones.length; i++) {
                if (!opciones[i].isEmpty()) {
                    System.out.println((i + 1) + ") " + opciones[i]);
                }
            }
            reJugador = Utilidades.leerEnteroValidado(VarGenYConst.min, VarGenYConst.max); // Comprueba la respuesta 1
            respuestaElegida = opciones[reJugador - 1];
            if (respuestaElegida.equals(p.getRespuestaCorrecta())) {
                reAcertadas = reAcertadas + 1;
                enunciado++;
                p = gp.getPregunta(VarGenYConst.dificultad, enunciado);
                opciones = p.getOpciones();
                System.out.println("¡Has acertado! Tu personaje avanza hasta la rendija de salida.");
                mostrarPantalla++;
                pantalla = pantallas[mostrarPantalla]; // Mas adelante, incluido el color del personaje y del agua
                System.out.println(pantalla);
                System.out.println(p.getEnunciado());
                for (int i = 0; i < opciones.length; i++) {
                    if (!opciones[i].isEmpty()) {
                        System.out.println((i + 1) + ") " + opciones[i]);
                    }
                }
                reJugador = Utilidades.leerEnteroValidado(VarGenYConst.min, VarGenYConst.max); // Comprueba la respuesta 1
                respuestaElegida = opciones[reJugador - 1];
                if (respuestaElegida.equals(p.getRespuestaCorrecta())) {
                    reAcertadas = reAcertadas + 1;
                    enunciado++;
                    p = gp.getPregunta(VarGenYConst.dificultad, enunciado);
                    opciones = p.getOpciones();
                    System.out.println("¡Has acertado! Tu personaje empieza a abrir la cerradura.");
                    pantalla = pantallas[mostrarPantalla]; // Mas adelante, incluido el color del personaje y del agua
                    System.out.println(pantalla);
                    System.out.println(p.getEnunciado());
                    for (int i = 0; i < opciones.length; i++) {
                        if (!opciones[i].isEmpty()) {
                            System.out.println((i + 1) + ") " + opciones[i]);
                        }
                    }
                    reJugador = Utilidades.leerEnteroValidado(VarGenYConst.min, VarGenYConst.max); // Comprueba la respuesta 1
                    respuestaElegida = opciones[reJugador - 1];
                    if (respuestaElegida.equals(p.getRespuestaCorrecta())) {
                        p = gp.getPregunta(VarGenYConst.dificultad, enunciado);
                        System.out.println("¡Has acertado! Tu personaje ha huido.");
                        lvlPasado = true; // pone lvlPasado en true para salir del bucle.
                        VarGenYConst.salirJuego = true; // Te manda al menú princial.
                    } else {
                        System.out.println("Has fallado.");
                        System.out.println("Oh no, el agua subió demasiado rápido, has perdido.");
                        VarGenYConst.salirJuego = true; // Te saca del juego tras perder
                    }
                } else {
                    enunciado++;
                    p = gp.getPregunta(VarGenYConst.dificultad, enunciado);
                    opciones = p.getOpciones();
                    System.out.println("Has fallado.");
                    pantalla = pantallas[mostrarPantalla]; // Mas adelante, incluido el color del personaje y del agua
                    System.out.println(pantalla);
                    System.out.println(p.getEnunciado());
                    for (int i = 0; i < opciones.length; i++) {
                        if (!opciones[i].isEmpty()) {
                            System.out.println((i + 1) + ") " + opciones[i]);
                        }
                    }
                    reJugador = Utilidades.leerEnteroValidado(VarGenYConst.min, VarGenYConst.max); // Comprueba la respuesta 1
                    respuestaElegida = opciones[reJugador - 1];
                    if (respuestaElegida.equals(p.getRespuestaCorrecta())) {
                        System.out.println("¡Has acertado! Tu personaje empieza a abir la cerradura.");
                        System.out.println("Oh no, el agua subió demasiado rápido, has perdido.");
                        VarGenYConst.salirJuego = true;
                    } else {
                        System.out.println("Has fallado.");
                        System.out.println("Oh no, el agua subió demasiado rápido, has perdido.");
                        VarGenYConst.salirJuego = true; // Te saca del juego tras perder
                    }
                }
            } else {
                enunciado++;
                p = gp.getPregunta(VarGenYConst.dificultad, enunciado);
                opciones = p.getOpciones();
                System.out.println("Has fallado.");
                pantalla = pantallas[mostrarPantalla]; // Mas adelante, incluido el color del personaje y del agua
                System.out.println(pantalla);
                System.out.println(p.getEnunciado());
                for (int i = 0; i < opciones.length; i++) {
                    if (!opciones[i].isEmpty()) {
                        System.out.println((i + 1) + ") " + opciones[i]);
                    }
                }
                reJugador = Utilidades.leerEnteroValidado(VarGenYConst.min, VarGenYConst.max); // Comprueba la respuesta 1
                respuestaElegida = opciones[reJugador - 1];
                if (respuestaElegida.equals(p.getRespuestaCorrecta())) {
                    reAcertadas = reAcertadas + 1;
                    enunciado++;
                    p = gp.getPregunta(VarGenYConst.dificultad, enunciado);
                    opciones = p.getOpciones();
                    System.out.println("¡Has acertado! Tu personaje avanza hasta la rendija de salida.");
                    mostrarPantalla++;
                    pantalla = pantallas[mostrarPantalla]; // Mas adelante, incluido el color del personaje y del agua
                    System.out.println(pantalla);
                    System.out.println(p.getEnunciado());
                    for (int i = 0; i < opciones.length; i++) {
                        if (!opciones[i].isEmpty()) {
                            System.out.println((i + 1) + ") " + opciones[i]);
                        }
                    }
                    reJugador = Utilidades.leerEnteroValidado(VarGenYConst.min, VarGenYConst.max); // Comprueba la respuesta 1
                    respuestaElegida = opciones[reJugador - 1];
                    if (respuestaElegida.equals(p.getRespuestaCorrecta())) {
                        System.out.println("¡Has acertado! Tu personaje empieza a abir la cerradura.");
                        System.out.println("Oh no, el agua subió demasiado rápido, has perdido.");
                        VarGenYConst.salirJuego = true; // te saca del juego tras perder
                    } else {
                        System.out.println("Has fallado.");
                        System.out.println("Oh no, el agua subió demasiado rápido, has perdido.");
                        VarGenYConst.salirJuego = true; // Te saca del juego tras perder
                    }
                } else {
                    enunciado++;
                    p = gp.getPregunta(VarGenYConst.dificultad, enunciado);
                    opciones = p.getOpciones();
                    System.out.println("Has fallado.");
                    pantalla = pantallas[mostrarPantalla]; // Mas adelante, incluido el color del personaje y del agua
                    System.out.println(pantalla);
                    System.out.println(p.getEnunciado());
                    for (int i = 0; i < opciones.length; i++) {
                        if (!opciones[i].isEmpty()) {
                            System.out.println((i + 1) + ") " + opciones[i]);
                        }
                    }
                    reJugador = Utilidades.leerEnteroValidado(VarGenYConst.min, VarGenYConst.max); // Comprueba la respuesta 1
                    respuestaElegida = opciones[reJugador - 1];
                    if (respuestaElegida.equals(p.getRespuestaCorrecta())) {
                        System.out.println("¡Has acertado! Tu personaje empieza a abir la cerradura.");
                        System.out.println("Oh no, el agua subió demasiado rápido, has perdido.");
                        VarGenYConst.salirJuego = true; // Te saca del juego tras perder
                    } else {
                        System.out.println("Has fallado.");
                        System.out.println("Oh no, el agua subió demasiado rápido, has perdido.");
                        VarGenYConst.salirJuego = true; // Te saca del juego tras perder
                    }

                }

            }

        } while (VarGenYConst.salirJuego == false && lvlPasado == false);
    }

}
