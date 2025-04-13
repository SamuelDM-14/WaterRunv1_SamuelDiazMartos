package utilidades;

import javax.sound.sampled.*;
import java.io.File;

public class ReproductorMusica {

    private Clip clip;
    private FloatControl controlVolumen;

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

    public void detener() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }
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

    public void subirVolumen(float paso) {
        if (controlVolumen != null) {
            float nuevoNivel = obtenerVolumenActual() + paso;
            establecerVolumen(nuevoNivel);
            System.out.println("Volumen aumentado a: "  + obtenerVolumenActual() + ".");
        }
    }

    public void bajarVolumen(float paso) {
        if (controlVolumen != null) {
            float nuevoNivel = obtenerVolumenActual() - paso;
            establecerVolumen(nuevoNivel);
            System.out.println("Volumen reducido a: " + obtenerVolumenActual() + ".");
        }
    }

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
