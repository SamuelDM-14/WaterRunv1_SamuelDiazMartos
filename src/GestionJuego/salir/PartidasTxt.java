/**
 * PartidasTxt
 * @author SDM
 * @version 1.8
 * 28-04-2025
 */
package gestionjuego.salir;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import utilidades.VarGenYConst;
/**
 * PartidasTxt
 * Se encarga de guardar las partidas y mostrarlas.
 */
public class PartidasTxt {
    // Variable de control para comprobar que existe el archivo.
    private static boolean txtPartidasCreado = false; 
    // Variable que guardará el nombre del archivo.
    private static String txtPartidas;

    /**
     * Metodo que se encarga de guardar las partidas.
     */
    public static void GuardarPartidasTxt() {
        // Llama al metodo crearArchibo para crear el archivo.txt
        crearArchivoTxt();
        // Crea una variable escritura de tipo PrintWriter inicializada a null.
        PrintWriter escribir = null;
        try {
            // Crea un FileWriter en modo de añadir true, para no sobrescribir el contenido existente.
            FileWriter fw = new FileWriter(txtPartidas, true);
            // Mejora el rendimiento de escritura usando un BufferedWriter.
            BufferedWriter bw = new BufferedWriter(fw);

            // Usa PrintWriter para facilitar la escritura de texto en el archivo.
            escribir = new PrintWriter(bw);

            // Escribe la fecha de sesión, y las partidas guardadas.
            escribir.println("----- PARTIDAS -----");
            escribir.println("Fecha de sesión: " + new Date());
            escribir.println(VarGenYConst.partidasSesion);

            bw.close(); // Cierra el BufferedWriter.
            fw.close(); // Cierra el FileWriter.

        }catch (IOException IOe){ // Recibe una excepción de escritura.
            // Muestra el error por pantalla.
            System.err.println("No se pudo escribir en el archivo de log: " + IOe.getMessage());
        } finally { // Siempre, al terminar entra.
            if (escribir != null) { // Si escribir no es nulo, entra.
                escribir.close(); // Cierra el FileWriter.
            }
        }
    }

    /**
     * Metodo que se encarga de comprobar si existe el archivo partidas.txt
     * y en caso de que no exista crearlo.
     */
    private static void crearArchivoTxt() {
        if (!txtPartidasCreado) { // Si la variable es false, entra.
            txtPartidas = "Partidas.txt"; // Asigna el nombre al txt.
            txtPartidasCreado = true; // Pone la variable de control a true.
        }
    }
    
    /**
     * Metodo que se encarga de mostrar las partidas de la sesión.
     * MODIFICAR
     */
    public static void MostrarPartidasTxt() {
    crearArchivoTxt(); // Comprueba que haya partidas creadas.

    List<String> lineas = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(txtPartidas))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            lineas.add(linea);
        }
    } catch (IOException e) {
        System.err.println("No se pudo leer el archivo: " + e.getMessage());
        return;
    }

    // Buscar el índice de la última "Fecha de sesion:"
    int ultimaSesionIndex = -1;
    for (int i = 0; i < lineas.size(); i++) {
        if (lineas.get(i).startsWith("Fecha de sesion:")) {
            ultimaSesionIndex = i;
        }
    }

    // Mostrar desde la última sesión en adelante
    if (ultimaSesionIndex != -1) {
        System.out.println("----- PARTIDAS DE LA ÚLTIMA SESIÓN -----");
        for (int i = ultimaSesionIndex -1; i < lineas.size(); i++) {
            if (i >= 0) System.out.println(lineas.get(i));
        }
    } else {
        System.out.println("No se encontró ninguna sesión registrada.");
    }
}

}
