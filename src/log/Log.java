/**
 * Log
 * @author SDM
 * 28-04-2025
 */

package log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Log
 * Esta clase se encargaga de crear archivos.log que
 * guardan los errores dentro del juego.
 */
public class Log {
    private static boolean logCreado=false; // Variable de control booleana.
    private static String logNombre; // Variable que guarda el nombre del log.

    /**
     * Metodo que crea una estructura. Crea la carpeta logs si no
     * esta creada y crea el archivo log de la sesión.
     */
    private static void crearArchivoLog(){
        if (!logCreado) { // Comprueba que el archivo log no este creado.
            // Guarada el formato de fecha y hora que usaremos para distingir los ficheros.
            String fechaLog = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date()); 
            // Crea un archivo llamado logs.
            File carpetaLogs = new File("logs");
            if (!carpetaLogs.exists()) { // Si carpetaLogs no existe, entra.
                carpetaLogs.mkdir(); // Crea una carpeta con el nombre asignado en la variable.
            }
            // Crea el fichero.log con el formato asignado.
            logNombre = "logs/Log-" + fechaLog + ".log";
            logCreado = true; // Cambia la variable de control logCreado a true.
        }

    }
    /**
     * Metodo que guarda los errores en el archivo.log
     * de la sesión. 
     * 
     * @param e // Recibe una excepción.
     * @param mensaje // Recibe un mensaje de error.
     */ 
    public static void guardarError(Exception e, String mensaje) {
        // Llama a crearArchivoLog para comprobar que el archivo no esta creado.
        crearArchivoLog();

        // Crea una variable escritura de tipo PrintWriter inicializada a null.
        PrintWriter escritura = null;
        try{
            // Crea un FileWriter en modo de añadir true, para no sobrescribir el contenido existente.
            FileWriter fw = new FileWriter(logNombre, true);
            // Mejora el rendimiento de escritura usando un BufferedWriter.
            BufferedWriter bw = new BufferedWriter(fw);

            // Usa PrintWriter para facilitar la escritura de texto en el archivo.
            escritura = new PrintWriter(bw);
            
            // Escribe el error, con su mensaje, la fecha y su tipo de error.
            escritura.println("---- ERROR ----");
            escritura.println("Mensaje: " + mensaje);
            escritura.println("Fecha: " + new Date());
            escritura.println("Excepción: " + e.toString());
            escritura.println(); // Deja una linea en blanco después de cada error.

            bw.close(); // Cierra el BufferedWriter.
            fw.close(); // Cierra el FileWriter.

        }catch (IOException IOe){ // Recibe una excepción de escritura.
            // Muestra el error por pantalla.
            System.err.println("No se pudo escribir en el archivo de log: " + IOe.getMessage());
        } finally { // Siempre, al terminar entra.
            if (escritura != null) { // Si escritura no es nulo, entra.
                escritura.close(); // Cierra escritura.
            }
        }
    }
}
