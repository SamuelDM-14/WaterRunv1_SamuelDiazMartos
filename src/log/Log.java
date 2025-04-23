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
 * 
 */
public class Log {
    private static boolean logCreado=false;
    private static String logNombre;

    /**
     * 
     */
    private static void crearArchivoLog(){
        if (!logCreado) {
            String fechaLog = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
            File carpetaLogs = new File("logs");
            if (!carpetaLogs.exists()) {
                carpetaLogs.mkdir();
            }
            logNombre = "logs/Log-" + fechaLog + ".log";
            logCreado = true; 
        }

    }
    /**
     * 
     * @param e
     * @param mensaje
     */
    public static void guardarError(Exception e, String mensaje) {

        crearArchivoLog();
        PrintWriter escritura = null;
        try{
            FileWriter fw = new FileWriter(logNombre, true);
            BufferedWriter bw = new BufferedWriter(fw);

            escritura = new PrintWriter(bw);
            
            escritura.println("---- ERROR ----");
            escritura.println("Mensaje: " + mensaje);
            escritura.println("Fecha: " + new Date());
            escritura.println("Excepción: " + e.toString());
            escritura.println();

        }catch (IOException IOe){
            System.err.println("No se pudo escribir en el archivo de log: " + IOe.getMessage());
        } finally {
            if (escritura != null) {
                escritura.close();
            }
        };
    }
}
