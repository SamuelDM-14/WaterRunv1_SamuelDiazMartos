/**
 * JugarDifícil
 * @author SDM
 * 17-03-2025
 */
package gestionjuego.juego;

import java.io.IOException;

import clases.Escapista;
import clases.GestionPreguntas;
import clases.Partida;
import clases.Policia;
import clases.Pregunta;
import utilidades.VarGenYConst;

/**
 * Esta clase se encarga de gestionar la partida en la
 * dificultad difícil.
 */
public class JugarDificil {

    /**
     * Metodo que gestiona la partida de dificultad Dificil
     * 
     * @param dificultad Dificultad de la partida
     * @param salirJuego Variable de salida del juego
     * @throws IOException
     */
    public static void jugarDificil(Partida partida) {

        Boolean lvlPasado = false; // Variable que comprueba si te has pasdo un nivel.
        int reAcertadas = 0;
        int enunciado = 0;

        VarGenYConst.min = 1;
        VarGenYConst.max = 4;
        int msglvl = 0;
        boolean frenado = false;
        boolean acertada = false;
        String respuestaElegida;

        Escapista escapista = new Escapista(VarGenYConst.colorPj);
        Policia policia = new Policia(VarGenYConst.colorPo, 5);

        GestionPreguntas gp = new GestionPreguntas();
        Pregunta p = gp.getPregunta(VarGenYConst.dificultad, enunciado);

        String[] pantallas = UtilidadesJuego.gestorPantallas();
        int mostrarPantalla = 0;
        String pantalla = pantallas[mostrarPantalla]; // Mas adelante, incluido el color del personaje y del agua

        do {

            reAcertadas = 0;
            pantalla = pantallas[mostrarPantalla];

            UtilidadesJuego.mostrarPregunta(p, pantalla);
            respuestaElegida = UtilidadesJuego.leerRespuesta(p);

            if (respuestaElegida.equals(p.getRespuestaCorrecta())) {

                reAcertadas++;
                enunciado++;
                p = gp.getPregunta(VarGenYConst.dificultad, enunciado);

                if (policia.disparar(escapista, VarGenYConst.dificultad)) {
                    frenado = true;
                    System.out.println(VarGenYConst.mensajePoli);

                    UtilidadesJuego.mostrarPregunta(p, pantalla);
                    respuestaElegida = UtilidadesJuego.leerRespuesta(p);

                    if (respuestaElegida.equals(p.getRespuestaCorrecta())) {
                        // configuraciones variables
                        mostrarPantalla++;
                        reAcertadas++;
                        enunciado++;
                        p = gp.getPregunta(VarGenYConst.dificultad, enunciado);
                        pantalla = pantallas[mostrarPantalla]; // Mas adelante, incluido el color del personaje y del
                                                               // agua

                        // Se muestra por pantalla
                        System.out.println(VarGenYConst.mensajesJuego[msglvl]);
                        UtilidadesJuego.mostrarPregunta(p, pantalla);
                        respuestaElegida = UtilidadesJuego.leerRespuesta(p);

                        if (respuestaElegida.equals(p.getRespuestaCorrecta())) {
                            reAcertadas++;
                            acertada = true;
                            UtilidadesJuego.finalizarJuegoDificil(acertada, reAcertadas, msglvl, frenado);
                            GuardarPartidas.guardarPartida(reAcertadas, lvlPasado, partida);
                        } else {
                            UtilidadesJuego.finalizarJuegoDificil(acertada, reAcertadas, msglvl, frenado);
                            GuardarPartidas.guardarPartida(reAcertadas, lvlPasado, partida);
                        }

                    } else {

                        enunciado++;
                        p = gp.getPregunta(VarGenYConst.dificultad, enunciado);
                        msglvl = 2;

                        System.out.println(VarGenYConst.mensajesJuego[msglvl]);
                        UtilidadesJuego.mostrarPregunta(p, pantalla);
                        respuestaElegida = UtilidadesJuego.leerRespuesta(p);
                        if (respuestaElegida.equals(p.getRespuestaCorrecta())) {
                            reAcertadas++;
                            acertada = true;
                            UtilidadesJuego.finalizarJuegoDificil(acertada, reAcertadas, msglvl, frenado);
                            GuardarPartidas.guardarPartida(reAcertadas, lvlPasado, partida);
                        } else {
                            UtilidadesJuego.finalizarJuegoDificil(acertada, reAcertadas, msglvl, frenado);
                            GuardarPartidas.guardarPartida(reAcertadas, lvlPasado, partida);
                        }
                    }

                } else {
                    msglvl = 0;
                    mostrarPantalla++;
                    pantalla = pantallas[mostrarPantalla]; // Mas adelante, incluido el color del personaje y del agua

                    System.out.println(VarGenYConst.mensajesJuego[msglvl]);
                    UtilidadesJuego.mostrarPregunta(p, pantalla);
                    respuestaElegida = UtilidadesJuego.leerRespuesta(p);

                    if (respuestaElegida.equals(p.getRespuestaCorrecta())) {
                        reAcertadas++;
                        enunciado++;
                        p = gp.getPregunta(VarGenYConst.dificultad, enunciado);

                        if (policia.disparar(escapista, VarGenYConst.dificultad)) {
                            System.out.println(VarGenYConst.mensajePoli);
                            pantalla = pantallas[mostrarPantalla]; // Mas adelante, incluido el color del personaje y
                                                                   // del agua
                                                                   UtilidadesJuego.mostrarPregunta(p, pantalla);
                            respuestaElegida = UtilidadesJuego.leerRespuesta(p);

                            if (respuestaElegida.equals(p.getRespuestaCorrecta())) {
                                reAcertadas++;
                                acertada = true;
                                UtilidadesJuego.finalizarJuegoDificil(acertada, reAcertadas, msglvl, frenado);
                                GuardarPartidas.guardarPartida(reAcertadas, lvlPasado, partida);
                            } else {
                                UtilidadesJuego.finalizarJuegoDificil(acertada, reAcertadas, msglvl, frenado);
                                GuardarPartidas.guardarPartida(reAcertadas, lvlPasado, partida);
                            }
                        } else {
                            msglvl = 1;
                            pantalla = pantallas[mostrarPantalla]; // Mas adelante, incluido el color del personaje y
                                                                   // del agua
                            System.out.println(VarGenYConst.mensajesJuego[msglvl]);
                            UtilidadesJuego.mostrarPregunta(p, pantalla);
                            respuestaElegida = UtilidadesJuego.leerRespuesta(p);

                            if (respuestaElegida.equals(p.getRespuestaCorrecta())) {
                                reAcertadas++;
                                acertada = true;
                                UtilidadesJuego.finalizarJuegoDificil(acertada, reAcertadas, msglvl, frenado);
                                lvlPasado = true; // pone lvlPasado en true para salir del bucle.
                                GuardarPartidas.guardarPartida(reAcertadas, lvlPasado, partida);
                            } else {
                                UtilidadesJuego.finalizarJuegoDificil(acertada, reAcertadas, msglvl, frenado);
                                GuardarPartidas.guardarPartida(reAcertadas, lvlPasado, partida);
                            }

                        }
                    } else {
                        enunciado++;
                        msglvl = 2;
                        p = gp.getPregunta(VarGenYConst.dificultad, enunciado);
                        System.out.println(VarGenYConst.mensajesJuego[msglvl]);
                        pantalla = pantallas[mostrarPantalla]; // Mas adelante, incluido el color del personaje y del
                                                               // agua
                                                               UtilidadesJuego.mostrarPregunta(p, pantalla);
                        respuestaElegida = UtilidadesJuego.leerRespuesta(p);
                        if (respuestaElegida.equals(p.getRespuestaCorrecta())) {
                            reAcertadas++;
                            acertada = true;
                            UtilidadesJuego.finalizarJuegoDificil(acertada, reAcertadas, msglvl, frenado);
                            GuardarPartidas.guardarPartida(reAcertadas, lvlPasado, partida);
                        } else {
                            UtilidadesJuego.finalizarJuegoDificil(acertada, reAcertadas, msglvl, frenado);
                            GuardarPartidas.guardarPartida(reAcertadas, lvlPasado, partida);
                        }
                    }

                }
            } else {
                enunciado++;
                msglvl = 2;
                p = gp.getPregunta(VarGenYConst.dificultad, enunciado);

                System.out.println(VarGenYConst.mensajesJuego[msglvl]);
                pantalla = pantallas[mostrarPantalla]; // Mas adelante, incluido el color del personaje y del agua

                UtilidadesJuego.mostrarPregunta(p, pantalla);
                respuestaElegida = UtilidadesJuego.leerRespuesta(p);

                if (respuestaElegida.equals(p.getRespuestaCorrecta())) {
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
                        UtilidadesJuego.finalizarJuegoDificil(acertada, reAcertadas, msglvl, frenado);
                        GuardarPartidas.guardarPartida(reAcertadas, lvlPasado, partida);
                    } else {
                        UtilidadesJuego.finalizarJuegoDificil(acertada, reAcertadas, msglvl, frenado);
                        GuardarPartidas.guardarPartida(reAcertadas, lvlPasado, partida);
                    }
                } else {
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
                        UtilidadesJuego.finalizarJuegoDificil(acertada, reAcertadas, msglvl, frenado);
                        GuardarPartidas.guardarPartida(reAcertadas, lvlPasado, partida);
                    } else {
                        UtilidadesJuego.finalizarJuegoDificil(acertada, reAcertadas, msglvl, frenado);
                        GuardarPartidas.guardarPartida(reAcertadas, lvlPasado, partida);
                    }

                }

            }
        } while (VarGenYConst.salirJuego == false && lvlPasado == false);

    }

}
