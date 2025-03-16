package gestionjuego.juego;

import java.io.IOException;

import clases.Escapista;
import clases.GestionPreguntas;
import clases.Policia;
import clases.Pregunta;
import utilidades.Utilidades;
import utilidades.VarGenYConst;

public class JugarDificil {
    
        /**
     * Metodo que gestiona la partida de dificultad Dificil
     * 
     * @param dificultad Dificultad de la partida
     * @param salirJuego Variable de salida del juego
     * @throws IOException
     */
    public static void jugarDificil() throws IOException {
        Boolean lvlPasado = false; // Variable que comprueba si te has pasdo un nivel.
        int reAcertadas = 0;
        int enunciado = 0;
        int max = 4;
        int min = 1;

        int msglvl=0;;
        int reJugador;
        String[] opciones;
        String respuestaElegida;
        Escapista escapista = new Escapista(VarGenYConst.colorPj);
        Policia policia = new Policia(VarGenYConst.colorPo, 5);
        GestionPreguntas gp = new GestionPreguntas();
        Pregunta p = gp.getPregunta(VarGenYConst.dificultad, enunciado);
        String[] pantallas = Utilidades.gestorPantallas();
        int mostrarPantalla = 0;
        String pantalla = pantallas[mostrarPantalla]; // Mas adelante, incluido el color del personaje y del agua


        do {
            opciones = p.getOpciones();
            reAcertadas = 0;
            pantalla = pantallas[mostrarPantalla];
            System.out.println(pantalla);
            System.out.println(p.getEnunciado());
            for (int i = 0; i < opciones.length; i++) {
                if (!opciones[i].isEmpty()) {
                    System.out.println((i + 1) + ") " + opciones[i]);
                }
            }
            reJugador = Utilidades.leerEnteroValidado(min, max); // Comprueba la respuesta 1
            respuestaElegida = opciones[reJugador - 1];


            if (respuestaElegida.equals(p.getRespuestaCorrecta())) {

                reAcertadas++;
                enunciado++;
                p = gp.getPregunta(VarGenYConst.dificultad, enunciado);
                opciones = p.getOpciones();

                if (policia.disparar(escapista, VarGenYConst.dificultad)) {

                    System.out.println(VarGenYConst.mensajePoli);

                    System.out.println(pantalla);

                    System.out.println(p.getEnunciado());
                    for (int i = 0; i < opciones.length; i++) {
                        if (!opciones[i].isEmpty()) {
                            System.out.println((i + 1) + ") " + opciones[i]);
                        }
                    }
                    reJugador = Utilidades.leerEnteroValidado(min, max); // Comprueba la respuesta 1
                    respuestaElegida = opciones[reJugador - 1];

                    if (respuestaElegida.equals(p.getRespuestaCorrecta())) {
                        //configuraciones variables
                        mostrarPantalla++;
                        reAcertadas++;
                        enunciado++;
                        p = gp.getPregunta(VarGenYConst.dificultad, enunciado);
                        opciones = p.getOpciones();
                        pantalla = pantallas[mostrarPantalla]; // Mas adelante, incluido el color del personaje y del agua

                        //Se muestra por pantalla
                        System.out.println(VarGenYConst.mensajesJuego[msglvl]);
                        System.out.println(pantalla);
                        System.out.println(p.getEnunciado());
                        for (int i = 0; i < opciones.length; i++) {
                            if (!opciones[i].isEmpty()) {
                                System.out.println((i + 1) + ") " + opciones[i]);
                            }
                        }
                        reJugador = Utilidades.leerEnteroValidado(min, max); // Comprueba la respuesta 1
                        respuestaElegida = opciones[reJugador - 1];

                        if (respuestaElegida.equals(p.getRespuestaCorrecta())) {
                            msglvl = 1;
                            System.out.println(VarGenYConst.mensajesJuego[msglvl]);
                            System.out.println(VarGenYConst.mensajesJuego[VarGenYConst.MENSAJEFIN]);
                            VarGenYConst.salirJuego = true; // Te saca del juego tras perder
                        } else {
                            msglvl = 2;
                            System.out.println(VarGenYConst.mensajesJuego[msglvl]);
                            System.out.println(VarGenYConst.mensajesJuego[VarGenYConst.MENSAJEFIN]);
                            VarGenYConst.salirJuego = true; // Te saca del juego tras perder
                        }


                    } else {


                        enunciado++;
                        p = gp.getPregunta(VarGenYConst.dificultad, enunciado);
                        opciones = p.getOpciones();
                        msglvl = 2;

                        System.out.println(VarGenYConst.mensajesJuego[msglvl]);
                        System.out.println(pantalla);
                        System.out.println(p.getEnunciado());
                        for (int i = 0; i < opciones.length; i++) {
                            if (!opciones[i].isEmpty()) {
                                System.out.println((i + 1) + ") " + opciones[i]);
                            }
                        }
                        reJugador = Utilidades.leerEnteroValidado(min, max); // Comprueba la respuesta 1
                        respuestaElegida = opciones[reJugador - 1];

                        if (respuestaElegida.equals(p.getRespuestaCorrecta())) {
                            msglvl = 1;
                            System.out.println(VarGenYConst.mensajesJuego[msglvl]);
                            System.out.println(VarGenYConst.mensajesJuego[VarGenYConst.MENSAJEFIN]);
                            VarGenYConst.salirJuego = true;
                        } else {
                            msglvl = 2;
                            System.out.println(VarGenYConst.mensajesJuego[msglvl]);
                            System.out.println(VarGenYConst.mensajesJuego[VarGenYConst.MENSAJEFIN]);
                            VarGenYConst.salirJuego = true; // Te saca del juego tras perder
                        }
                    }

                } else {
                    mostrarPantalla++;
                    System.out.println("¡Has acertado! Tu personaje avanza hasta la rendija de salida.");
                    pantalla = pantallas[mostrarPantalla]; // Mas adelante, incluido el color del personaje y del agua
                    System.out.println(pantalla);

                    System.out.println(p.getEnunciado());
                    for (int i = 0; i < opciones.length; i++) {
                        if (!opciones[i].isEmpty()) {
                            System.out.println((i + 1) + ") " + opciones[i]);
                        }
                    }
                    reJugador = Utilidades.leerEnteroValidado(min, max); // Comprueba la respuesta 1
                    respuestaElegida = opciones[reJugador - 1];
                    if (respuestaElegida.equals(p.getRespuestaCorrecta())) {
                        reAcertadas = reAcertadas + 1;
                        enunciado++;
                        p = gp.getPregunta(VarGenYConst.dificultad, enunciado);
                        opciones = p.getOpciones();
                        if (policia.disparar(escapista, VarGenYConst.dificultad)) {
                            System.out.println(
                                    "¡OH NO! El policia ha acertado el disparo, el escapista permanece inmovil 1 turno.");
                            pantalla = pantallas[mostrarPantalla]; // Mas adelante, incluido el color del personaje y
                                                                   // del agua
                            System.out.println(pantalla);
                            System.out.println(p.getEnunciado());
                            for (int i = 0; i < opciones.length; i++) {
                                if (!opciones[i].isEmpty()) {
                                    System.out.println((i + 1) + ") " + opciones[i]);
                                }
                            }
                            reJugador = Utilidades.leerEnteroValidado(min, max); // Comprueba la respuesta 1
                            respuestaElegida = opciones[reJugador - 1];
                            if (respuestaElegida.equals(p.getRespuestaCorrecta())) {
                                System.out.println("¡Has acertado! Tu personaje empieza a abrir la cerradura.");
                                System.out.println("Oh no, el agua subió demasiado rápido, has perdido.");
                                VarGenYConst.salirJuego = true; // Te saca del juego tras perder
                            } else {
                                System.out.println("Has fallado.");
                                System.out.println("Oh no, el agua subió demasiado rápido, has perdido.");
                                VarGenYConst.salirJuego = true; // Te saca del juego tras perder
                            }
                        } else {
                            pantalla = pantallas[mostrarPantalla]; // Mas adelante, incluido el color del personaje y
                                                                   // del agua
                            System.out.println(pantalla);
                            System.out.println(p.getEnunciado());
                            for (int i = 0; i < opciones.length; i++) {
                                if (!opciones[i].isEmpty()) {
                                    System.out.println((i + 1) + ") " + opciones[i]);
                                }
                            }
                            reJugador = Utilidades.leerEnteroValidado(min, max); // Comprueba la respuesta 1
                            respuestaElegida = opciones[reJugador - 1];
                            if (respuestaElegida.equals(p.getRespuestaCorrecta())) {
                                System.out.println("¡Has acertado! Tu personaje ha huido.");
                                lvlPasado = true; // pone lvlPasado en true para salir del bucle.
                                VarGenYConst.salirJuego = true; // Te manda al menú princial.
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
                        pantalla = pantallas[mostrarPantalla]; // Mas adelante, incluido el color del personaje y del
                                                               // agua
                        System.out.println(pantalla);
                        System.out.println(p.getEnunciado());
                        for (int i = 0; i < opciones.length; i++) {
                            if (!opciones[i].isEmpty()) {
                                System.out.println((i + 1) + ") " + opciones[i]);
                            }
                        }
                        reJugador = Utilidades.leerEnteroValidado(min, max); // Comprueba la respuesta 1
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
                reJugador = Utilidades.leerEnteroValidado(min, max); // Comprueba la respuesta 1
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
                    reJugador = Utilidades.leerEnteroValidado(min, max); // Comprueba la respuesta 1
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
                    reJugador = Utilidades.leerEnteroValidado(VarGenYConst.min, VarGenYConst.max);
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
