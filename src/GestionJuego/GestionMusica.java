package gestionjuego;

import java.io.IOException;

import utilidades.ReproductorMusica;
import utilidades.Utilidades;
import utilidades.VarGenYConst;

public class GestionMusica {

    public static void menuMusica(ReproductorMusica musica) throws IOException {
        VarGenYConst.min=1;
        VarGenYConst.max=6;
        final int SALIR = 6;
        VarGenYConst.opcionMenu=8;
        float volumen = musica.obtenerVolumenActual();

        System.out.println(VarGenYConst.MOSTRARMENUS[VarGenYConst.opcionMenu]);
        System.out.println("El volumen actual es: " + volumen);
        int opcion = Utilidades.leerEnteroValidado();

        switch (opcion) {
            case 1:
                establecerVolumen();
                break;
            case 2:
                subirVolumen();
                break; 
            case 3:
                bajarVolumen();
                break;
            case 4:
                detenerMusica();
                break;
            case 5:
                reproducirMusica();
                break;
            case 6:
                
                break;
            default:
                break;
        }
    }

    private static void establecerVolumen(){
        establecerVolumen();
    }

    private static void subirVolumen(){

    }
    
    private static void bajarVolumen(){
        
    }
    
    private static void detenerMusica(){
        
    }
    
    private static void reproducirMusica(){
        
    }
}
