/**
 * GestionSalir
 * @author SDM
 * @version 1.8
 * 28-04-2025
 */
package gestionjuego.salir;

import utilidades.VarGenYConst;
/**
 * GestionSalir
 * Se encarga de gestionar el fin del programa, guardando las partidas de la 
 * sesión en un txt y mostrando solo las partidas de esta sesión
 */
public class GestionSalir {

    /**
     * Metodo que comprueba si se han jugado partidas en esta sesión 
     * y llama a los metodos correspondientes para guardarlas y
     * mostrarlas en caso de que existan.
     */
    public static void salir(){
        // Si el ArrayList de partidasSesion esta vacío, entra.
        if (VarGenYConst.partidasSesion.isEmpty()) {
            // Muestra un mensaje de salida del juego.
            System.out.println("Saliendo del juego");
        }else{ // Si el ArrayList de partidasSesion contiene algo, entra.
            // Llama al metodo GuardarPartidasTxt.
            PartidasTxt.guardarPartidasTxt();
            System.out.println("Estas han sido tus partidas: ");
            // LLama al metodo MostarPartidasTxt.
            PartidasTxt.mostrarPartidasTxt();
            System.out.println("Saliendo del juego"); 
        }

    }
}
