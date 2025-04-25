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

import log.Log;
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
            // Crea un FileWriter en modo de añadir true, para no sobrescribir el contenido
            // existente.
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

        } catch (IOException IOe) { // Recibe una excepción de escritura.
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
     * Cuenta las líneas del archivo al iniciar la sesión.
     */
    private static int contarLineasArchivo() {
        crearArchivoTxt(); // Asegura que el archivo está definido
        int contador = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(txtPartidas));
            while (br.readLine() != null) {
                contador++;
            }
            br.close();
        } catch (IOException e) {
            System.err.println("No se pudo contar líneas del archivo: " + e.getMessage());
            Log.guardarError(e, e.getMessage());
        }
        return contador;
    }

    /**
     * Método que muestra solo las partidas desde que se inició el programa.
     */
    public static void MostrarPartidasTxt() {
        crearArchivoTxt(); // Asegura que el archivo está definido
        int lineasIniciales = contarLineasArchivo();
        List<String> lineas = new ArrayList<>();
        boolean lecturaExitosa = true;

        try {
            BufferedReader br = new BufferedReader(new FileReader(txtPartidas));
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
            br.close();
        } catch (IOException e) {
            System.err.println("No se pudo leer el archivo: " + e.getMessage());
            Log.guardarError(e, e.getMessage());
            lecturaExitosa = false;
        }

        if (lecturaExitosa) {
            if (lineasIniciales < lineas.size()) {
                System.out.println("----- PARTIDAS DE LA SESIÓN ACTUAL -----");
                for (int i = lineasIniciales; i < lineas.size(); i++) {
                    System.out.println(lineas.get(i));
                }
            } else {
                System.out.println("No hay nuevas partidas desde que se inició el programa.");
            }
        }
    }
}
