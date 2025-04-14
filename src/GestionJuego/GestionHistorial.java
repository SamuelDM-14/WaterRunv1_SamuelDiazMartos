package gestionjuego;

import java.io.IOException;

import utilidades.Utilidades;
import utilidades.VarGenYConst;

public class GestionHistorial {
        /**
     * Historial. Actualmente sin funcionamiento.
     * 
     * @author SDM
     * @throws IOException
     */
    public static void historial() {
        // Respuestas Historial
        int eleccionHistorial;// Respuesta de elección de historial.
        boolean salirHistorial = false;

        // Historial
        salirHistorial = false; // Pone en false el salirHistorial. Si has seleccionado previamente esta opción
                                // y has salido,
        // Te sacaria en cuanto eligieras algo que te mueva a este menú.
        do { // Repite hasta que el usuario seleccione salir.
             // Muestra las opciones. (No disponible de momento.)
            VarGenYConst.max = 4;
            VarGenYConst.min = 1;
            VarGenYConst.opcionMenu = 6;
            System.out.println(VarGenYConst.MOSTRARMENUS[VarGenYConst.opcionMenu]);
            eleccionHistorial = Utilidades.leerEnteroValidado(); // Lee la elección
            switch (eleccionHistorial) { // Selecciona según haya elegido.
                case 1:
                    System.out.println("Ha selecionado Jugar partida guardada, Este menú aun no esta disponible.");
                    break;
                case 2:
                    System.out.println(
                            "Ha selecionado Revisar elecciónes de partida., Este menú aun no esta disponible.");
                    break;
                case 3:
                    datosPartida();
                    break;
                case 4:
                    System.out.println("Ha selecionado salir. Volviendo al menú principal");
                    salirHistorial = true; // Vuelve al menú principal.
                    break;
                default:
                    // No pongo nada debido a que las validaciones correspondientes estan hechas.
                    break;
            }

        } while (salirHistorial == false);

    }

    /**
     * Metodo que se encarga de mostrar los datos de la partida.
     * Actualmente solo se guarda los datos de la última partida.
     * 
     * @author SDM
     */
    private static void datosPartida() {
        System.out.println("Ha selecionado Datos de partida guardada.");
        if (VarGenYConst.partidas.isEmpty()) {
            System.out.println("No hay partidas guardadas.");
        }else{
            System.out.println(VarGenYConst.partidas);
        }

    }
}
