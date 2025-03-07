/**
 * WaterRun
 * @author SDM
 * 18-11-2024
 */

import java.io.IOException;

import gestionjuego.GestionJugar;
/**
 * Clase WaterRun.
 * Es el motor inicial del juego. Llama a GestionJugar para gestionar todos los menús
 */
public class WaterRun {


    /**
     * Main WaterRun. Llama a bienvendia.
     * @author SDM
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {        
        //Llamamos al metodo bienvenida y le enviamos nuestro bufferedReader
        GestionJugar.bienvenida();
    }
}
    
