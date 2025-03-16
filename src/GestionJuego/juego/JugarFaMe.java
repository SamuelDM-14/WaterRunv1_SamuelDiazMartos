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

        int reAcertadas = 0;
        int enunciado = 0;
        String respuestaElegida;
        int msglvl = 0;
        boolean acertada = false;
        GestionPreguntas gp = new GestionPreguntas();
        Pregunta p = gp.getPregunta(VarGenYConst.dificultad, enunciado);
        String[] pantallas = Utilidades.gestorPantallas();
        int mostrarPantalla = 0;
        String pantalla = pantallas[mostrarPantalla]; // Mas adelante, incluido el color del personaje y del agua

        do {
            reAcertadas = 0;
            pantalla = pantallas[mostrarPantalla]; // Mas adelante, incluido el color del personaje y del agua
            Utilidades.mostrarPregunta(p, pantalla);
            respuestaElegida = Utilidades.leerRespuesta(p);

            if (respuestaElegida.equals(p.getRespuestaCorrecta())) {
                reAcertadas++;
                enunciado++;
                msglvl = 0;
                p = gp.getPregunta(VarGenYConst.dificultad, enunciado);

                System.out.println(VarGenYConst.mensajesJuego[msglvl]);

                mostrarPantalla++;
                pantalla = pantallas[mostrarPantalla]; // Mas adelante, incluido el color del personaje y del agua

                Utilidades.mostrarPregunta(p, pantalla);
                respuestaElegida = Utilidades.leerRespuesta(p);

                if (respuestaElegida.equals(p.getRespuestaCorrecta())) {
                    reAcertadas++;
                    enunciado++;
                    msglvl = 1;
                    p = gp.getPregunta(VarGenYConst.dificultad, enunciado);

                    System.out.println(VarGenYConst.mensajesJuego[msglvl]);
                    pantalla = pantallas[mostrarPantalla]; // Mas adelante, incluido el color del personaje y del agua
                    Utilidades.mostrarPregunta(p, pantalla);
                    respuestaElegida = Utilidades.leerRespuesta(p);
                    if (respuestaElegida.equals(p.getRespuestaCorrecta())) {
                        acertada = true;
                        Utilidades.finalizarJuegoFaMe(acertada, reAcertadas, msglvl);
                        lvlPasado = true; // pone lvlPasado en true para salir del bucle.
                        Utilidades.guardarPartida(reAcertadas, lvlPasado);
                    } else {
                        Utilidades.finalizarJuegoFaMe(acertada, reAcertadas, msglvl);
                        Utilidades.guardarPartida(reAcertadas, lvlPasado);
                    }
                } else {
                    enunciado++;
                    msglvl = 2;
                    p = gp.getPregunta(VarGenYConst.dificultad, enunciado);

                    System.out.println(VarGenYConst.mensajesJuego[msglvl]);
                    pantalla = pantallas[mostrarPantalla]; // Mas adelante, incluido el color del personaje y del agua
                    Utilidades.mostrarPregunta(p, pantalla);
                    respuestaElegida = Utilidades.leerRespuesta(p);
                    if (respuestaElegida.equals(p.getRespuestaCorrecta())) {
                        acertada = true;
                        Utilidades.finalizarJuegoFaMe(acertada, reAcertadas, msglvl);
                        Utilidades.guardarPartida(reAcertadas, lvlPasado);
                    } else {
                        Utilidades.finalizarJuegoFaMe(acertada, reAcertadas, msglvl);
                        Utilidades.guardarPartida(reAcertadas, lvlPasado);
                    }
                }
            } else {
                enunciado++;
                msglvl = 2;
                p = gp.getPregunta(VarGenYConst.dificultad, enunciado);

                System.out.println(VarGenYConst.mensajesJuego[msglvl]);
                pantalla = pantallas[mostrarPantalla]; // Mas adelante, incluido el color del personaje y del agua
                Utilidades.mostrarPregunta(p, pantalla);
                respuestaElegida = Utilidades.leerRespuesta(p);
                if (respuestaElegida.equals(p.getRespuestaCorrecta())) {
                    reAcertadas++;
                    enunciado++;
                    msglvl = 0;
                    p = gp.getPregunta(VarGenYConst.dificultad, enunciado);

                    System.out.println(VarGenYConst.mensajesJuego[msglvl]);
                    mostrarPantalla++;
                    pantalla = pantallas[mostrarPantalla]; // Mas adelante, incluido el color del personaje y del agua
                    Utilidades.mostrarPregunta(p, pantalla);
                    respuestaElegida = Utilidades.leerRespuesta(p);
                    if (respuestaElegida.equals(p.getRespuestaCorrecta())) {
                        acertada = true;
                        Utilidades.finalizarJuegoFaMe(acertada, reAcertadas, msglvl);
                        Utilidades.guardarPartida(reAcertadas, lvlPasado);
                    } else {
                        Utilidades.finalizarJuegoFaMe(acertada, reAcertadas, msglvl);
                        Utilidades.guardarPartida(reAcertadas, lvlPasado);
                    }
                } else {
                    enunciado++;
                    p = gp.getPregunta(VarGenYConst.dificultad, enunciado);
                    msglvl = 2;
                    System.out.println(VarGenYConst.mensajesJuego[msglvl]);
                    pantalla = pantallas[mostrarPantalla]; // Mas adelante, incluido el color del personaje y del agua

                    Utilidades.mostrarPregunta(p, pantalla);
                    respuestaElegida = Utilidades.leerRespuesta(p);

                    if (respuestaElegida.equals(p.getRespuestaCorrecta())) {
                        acertada = true;
                        Utilidades.finalizarJuegoFaMe(acertada, reAcertadas, msglvl);
                        Utilidades.guardarPartida(reAcertadas, lvlPasado);
                    } else {
                        Utilidades.finalizarJuegoFaMe(acertada, reAcertadas, msglvl);
                        Utilidades.guardarPartida(reAcertadas, lvlPasado);
                    }

                }

            }

        } while (VarGenYConst.salirJuego == false && lvlPasado == false);
    }

}
