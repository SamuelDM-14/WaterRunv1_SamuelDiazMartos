/**
 * GestionMusica
 * @author SDM
 * @version 1.8
 * 28-04-2025
 */
package gestionjuego;

import utilidades.ReproductorMusica;
import utilidades.Utilidades;
import utilidades.VarGenYConst;

/**
 * GestionMusica
 * Se encarga de gestionar todo lo relacionado con la 
 * música del juego.
 */
public class GestionMusica {
    // Asigna a una variable el valor por el cual se va a aumentar o 
    // disminuir el volumen.
    private static float cambiarVolumen = 10;  
    
    /**
     * Metodo que muestra el menú de opciones de música y gestiona
     * sus opciones.
     * 
     * @param musica Recibe un objeto ReproductorMusica.
     */
    public static void menuMusica(ReproductorMusica musica) {
        VarGenYConst.opcionMenu=8;

        boolean salirVolumen = false;
        do {
            VarGenYConst.min=1;
            VarGenYConst.max=6;

        
            float volumen = musica.obtenerVolumenActual();
            System.out.println(VarGenYConst.MOSTRARMENUS[VarGenYConst.opcionMenu]);
            System.out.println("El volumen actual es: " + volumen);
            int opcion = Utilidades.leerEnteroValidado();
    
            switch (opcion) {
                case 1:
                    establecerVolumen(musica);
                    break;
                case 2:
                    subirVolumen(musica);
                    break; 
                case 3:
                    bajarVolumen(musica);
                    break;
                case 4:
                    detenerMusica(musica);
                    break;
                case 5:
                    reproducirMusica(musica);
                    break;
                case 6:
                    System.out.println("Volviendo al menú principal.");
                    salirVolumen = true;
                    break;
                default:
                    break;
            }
        } while (!salirVolumen);

    }

    /**
     * Metodo para establecer volumen de la música. 
     * 
     * @param musica Recibe un objeto ReproductorMusica.
     */
    private static void establecerVolumen(ReproductorMusica musica) {
        VarGenYConst.max=100;
        VarGenYConst.min=0;
        float cambioVolumen = 0;
        System.out.println("Pon un número del 0 al 100");
        cambioVolumen = Utilidades.leerEnteroValidado();
        musica.establecerVolumen(cambioVolumen);
    }

    /**
     * Metodo para subir volumen de manera automatica.
     * Sube una cantidad de volumen como el número asignado 
     * en la variable cambiarVolumen.
     * 
     * @param musica Recibe un objeto ReproductorMusica.
     */
    private static void subirVolumen(ReproductorMusica musica){
        musica.subirVolumen(cambiarVolumen);
    }
    
    /**
     * Metodo para bajar el volumen de manera automatica.
     * Sube una cantidad de volumen como el número asignado 
     * en la variable cambiarVolumen.
     * 
     * @param musica Recibe un objeto ReproductorMuscia.
     */
    private static void bajarVolumen(ReproductorMusica musica){
        musica.bajarVolumen(cambiarVolumen);
    }
    
    /**
     * Metodo para detener la música.
     * 
     * @param musica Recibe un objeto ReproductorMusica.
     */
    private static void detenerMusica(ReproductorMusica musica){
        musica.detener();
    }
    
    /**
     * Metodo que empieza a reproducir música.
     * 
     * @param musica Recibe un objeto ReproductorMusica.
     */
    private static void reproducirMusica(ReproductorMusica musica){
        musica.reproducir("src/Wavs/resonant.wav");
    }

}
