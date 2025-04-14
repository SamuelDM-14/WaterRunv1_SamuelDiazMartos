/**
 * JugarFaME
 * @author SDM
 * 17-03-2025
 */
package gestionjuego.juego;

import java.io.IOException;

import clases.GestionPreguntas;
import clases.Partida;
import clases.Pregunta;
import utilidades.VarGenYConst;

/**
 * Esta clase se encarga de gestionar la partida jugando en
 * dificultad fácil y media.
 */
public class JugarFaMe {

    /**
     * Metodo que gestiona la partida de dificultad Facil y Medio
     * 
     * @param dificultad Dificultad de la partida
     * @param salirJuego Variable de salida del juego
     * @throws IOException
     */
    public static void jugarFaMe(Partida partida) throws IOException {

        Boolean lvlPasado = false; // Variable que comprueba si te has pasdo un nivel.
        VarGenYConst.min = 1;
        VarGenYConst.max = 4;
        int reAcertadas = 0;
        int enunciado = 0;
        String respuestaElegida;
        int msglvl = 0;
        boolean acertada = false;
        GestionPreguntas gp = new GestionPreguntas();
        Pregunta p = gp.getPregunta(VarGenYConst.dificultad, enunciado);
        String[] pantallas = UtilidadesJuego.gestorPantallas();
        int mostrarPantalla = 0;
        String pantalla = pantallas[mostrarPantalla]; // Mas adelante, incluido el color del personaje y del agua

        do {
            reAcertadas = 0;
            pantalla = pantallas[mostrarPantalla]; // Mas adelante, incluido el color del personaje y del agua
            UtilidadesJuego.mostrarPregunta(p, pantalla);
            respuestaElegida = UtilidadesJuego.leerRespuesta(p);

            if (respuestaElegida.equals(p.getRespuestaCorrecta())) {
                VarGenYConst.max = 3;
                reAcertadas++;
                enunciado++;
                msglvl = 0;
                p = gp.getPregunta(VarGenYConst.dificultad, enunciado);

                System.out.println(VarGenYConst.mensajesJuego[msglvl]);

                mostrarPantalla++;
                pantalla = pantallas[mostrarPantalla]; // Mas adelante, incluido el color del personaje y del agua

                UtilidadesJuego.mostrarPregunta(p, pantalla);
                respuestaElegida = UtilidadesJuego.leerRespuesta(p);

                if (respuestaElegida.equals(p.getRespuestaCorrecta())) {
                    VarGenYConst.max = 4;
                    reAcertadas++;
                    enunciado++;
                    msglvl = 1;
                    p = gp.getPregunta(VarGenYConst.dificultad, enunciado);

                    System.out.println(VarGenYConst.mensajesJuego[msglvl]);
                    pantalla = pantallas[mostrarPantalla]; // Mas adelante, incluido el color del personaje y del agua
                    UtilidadesJuego.mostrarPregunta(p, pantalla);
                    respuestaElegida = UtilidadesJuego.leerRespuesta(p);
                    if (respuestaElegida.equals(p.getRespuestaCorrecta())) {
                        reAcertadas++;
                        acertada = true;
                        UtilidadesJuego.finalizarJuegoFaMe(acertada, reAcertadas, msglvl);
                        lvlPasado = true; // pone lvlPasado en true para salir del bucle.
                        GuardarPartidas.guardarPartida(reAcertadas, lvlPasado, partida);
                    } else {
                        UtilidadesJuego.finalizarJuegoFaMe(acertada, reAcertadas, msglvl);
                        GuardarPartidas.guardarPartida(reAcertadas, lvlPasado, partida);
                    }
                } else {
                    VarGenYConst.max = 4;
                    enunciado++;
                    msglvl = 2;
                    p = gp.getPregunta(VarGenYConst.dificultad, enunciado);

                    System.out.println(VarGenYConst.mensajesJuego[msglvl]);
                    pantalla = pantallas[mostrarPantalla]; // Mas adelante, incluido el color del personaje y del agua
                    UtilidadesJuego.mostrarPregunta(p, pantalla);
                    respuestaElegida = UtilidadesJuego.leerRespuesta(p);
                    if (respuestaElegida.equals(p.getRespuestaCorrecta())) {

                        reAcertadas++;
                        acertada = true;
                        UtilidadesJuego.finalizarJuegoFaMe(acertada, reAcertadas, msglvl);
                        GuardarPartidas.guardarPartida(reAcertadas, lvlPasado, partida);
                    } else {
                        UtilidadesJuego.finalizarJuegoFaMe(acertada, reAcertadas, msglvl);
                        GuardarPartidas.guardarPartida(reAcertadas, lvlPasado, partida);
                    }
                }
            } else {
                VarGenYConst.max = 3;
                enunciado++;
                msglvl = 2;
                p = gp.getPregunta(VarGenYConst.dificultad, enunciado);

                System.out.println(VarGenYConst.mensajesJuego[msglvl]);
                pantalla = pantallas[mostrarPantalla]; // Mas adelante, incluido el color del personaje y del agua
                UtilidadesJuego.mostrarPregunta(p, pantalla);
                respuestaElegida = UtilidadesJuego.leerRespuesta(p);
                if (respuestaElegida.equals(p.getRespuestaCorrecta())) {
                    VarGenYConst.max = 4;
                    reAcertadas++;
                    enunciado++;
                    msglvl = 0;
                    p = gp.getPregunta(VarGenYConst.dificultad, enunciado);

                    System.out.println(VarGenYConst.mensajesJuego[msglvl]);
                    mostrarPantalla++;
                    pantalla = pantallas[mostrarPantalla]; // Mas adelante, incluido el color del personaje y del agua
                    UtilidadesJuego.mostrarPregunta(p, pantalla);
                    respuestaElegida = UtilidadesJuego.leerRespuesta(p);
                    if (respuestaElegida.equals(p.getRespuestaCorrecta())) {
                        reAcertadas++;
                        acertada = true;
                        UtilidadesJuego.finalizarJuegoFaMe(acertada, reAcertadas, msglvl);
                        GuardarPartidas.guardarPartida(reAcertadas, lvlPasado, partida);
                    } else {
                        UtilidadesJuego.finalizarJuegoFaMe(acertada, reAcertadas, msglvl);
                        GuardarPartidas.guardarPartida(reAcertadas, lvlPasado, partida);
                    }
                } else {
                    VarGenYConst.max = 4;
                    enunciado++;
                    p = gp.getPregunta(VarGenYConst.dificultad, enunciado);
                    msglvl = 2;
                    System.out.println(VarGenYConst.mensajesJuego[msglvl]);
                    pantalla = pantallas[mostrarPantalla]; // Mas adelante, incluido el color del personaje y del agua

                    UtilidadesJuego.mostrarPregunta(p, pantalla);
                    respuestaElegida = UtilidadesJuego.leerRespuesta(p);

                    if (respuestaElegida.equals(p.getRespuestaCorrecta())) {
                        reAcertadas++;
                        acertada = true;
                        UtilidadesJuego.finalizarJuegoFaMe(acertada, reAcertadas, msglvl);
                        GuardarPartidas.guardarPartida(reAcertadas, lvlPasado, partida);
                    } else {
                        UtilidadesJuego.finalizarJuegoFaMe(acertada, reAcertadas, msglvl);
                        GuardarPartidas.guardarPartida(reAcertadas, lvlPasado, partida);
                    }

                }

            }

        } while (VarGenYConst.salirJuego == false && lvlPasado == false);
    }

}
