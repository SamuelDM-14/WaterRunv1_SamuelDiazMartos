package gestionjuego;

import utilidades.ReproductorMusica;
import utilidades.Utilidades;
import utilidades.VarGenYConst;

public class GestionMusica {
    private static float cambiarVolumen = 10; 
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

    private static void establecerVolumen(ReproductorMusica musica) {
        VarGenYConst.max=100;
        VarGenYConst.min=0;
        System.out.println("Pon un número del 0 al 100");
        cambiarVolumen = Utilidades.leerEnteroValidado();
        musica.establecerVolumen(cambiarVolumen);
    }

    private static void subirVolumen(ReproductorMusica musica){
        musica.subirVolumen(cambiarVolumen);
    }
    
    private static void bajarVolumen(ReproductorMusica musica){
        musica.bajarVolumen(cambiarVolumen);
    }
    
    private static void detenerMusica(ReproductorMusica musica){
        musica.detener();
    }
    
    private static void reproducirMusica(ReproductorMusica musica){
        musica.reproducir("src/Wavs/resonant.wav");
    }

}
