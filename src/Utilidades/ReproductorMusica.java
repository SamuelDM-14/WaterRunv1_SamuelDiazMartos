/**
 * ReproductorMusica
 * @author SDM
 * @version 1.8
 * 28-04-2025
 */
package utilidades;

import javax.sound.sampled.*;
import java.io.File;

/**
 * La clase ReproductorMuscia se encarga de gestionar la música del juego.
 * Establece un volumen general, aumenta o disminuye el volumen y
 * detiene e incia la música.
 */
public class ReproductorMusica {

    private Clip clip;
    private FloatControl controlVolumen;

    /**
     * Metodo para inicar la múscia.
     * 
     * @param rutaArchivo Recibe un String con la ruta del archivo.
     */
    public void reproducir(String rutaArchivo) {
        detener(); // Detener música anterior
        try {
            File archivoMusica = new File(rutaArchivo);
            if (archivoMusica.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(archivoMusica);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                clip.start();

                // Inicializar control de volumen
                controlVolumen = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                float volumenInicial = 50;
                establecerVolumen(volumenInicial);
            } else {
                System.out.println("Archivo no encontrado: " + rutaArchivo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para detener la música.
     */
    public void detener() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }

    /**
     * Metodo para establecer volumen.
     * 
     * @param nivelUsuario Recibe el nivel de volumen que quiere el usuario.
     */
    public void establecerVolumen(float nivelUsuario) {
        if (controlVolumen != null) {
            float min = controlVolumen.getMinimum(); // Ej: -80.0
            float max = controlVolumen.getMaximum(); // Ej: 6.0

            // Limitar nivelUsuario entre 0 y 100
            nivelUsuario = Math.max(0, Math.min(nivelUsuario, 100));

            // Convertir de 0-100 a min-max en decibelios
            float volumenDB = min + (nivelUsuario / 100f) * (max - min);

            controlVolumen.setValue(volumenDB);
        }
    }

    /**
     * Metodo para subir el volumen.
     * 
     * @param paso Recibe el número con el que debe incrementar el volumen.
     */
    public void subirVolumen(float paso) {
        if (controlVolumen != null) {
            float nuevoNivel = obtenerVolumenActual() + paso;
            establecerVolumen(nuevoNivel);
            System.out.println("Volumen aumentado a: " + obtenerVolumenActual() + ".");
        }
    }

    
    /**
     * Metodo para bajar el volumen.
     * 
     * @param paso Recibe el número con el que debe decrementar el volumen. 
     */
    public void bajarVolumen(float paso) {
        if (controlVolumen != null) {
            float nuevoNivel = obtenerVolumenActual() - paso;
            establecerVolumen(nuevoNivel);
            System.out.println("Volumen reducido a: " + obtenerVolumenActual() + ".");
        }
    }

    /**
     * Metodo para obtener el volumen actual de la música.
     * 
     * @return Devuelve el volumen actual de la múscia.
     */
    public float obtenerVolumenActual() {
        if (controlVolumen != null) {
            float min = controlVolumen.getMinimum(); // Ej: -80.0
            float max = controlVolumen.getMaximum(); // Ej: 6.0
            float actual = controlVolumen.getValue(); // Ej: -20.0

            // Calcular porcentaje
            float porcentaje = 100f * (actual - min) / (max - min);

            // Redondear al entero más cercano
            return Math.round(porcentaje);
        }
        return -1; // o 0, o lanzar excepción, según lo que prefieras

    }
}
