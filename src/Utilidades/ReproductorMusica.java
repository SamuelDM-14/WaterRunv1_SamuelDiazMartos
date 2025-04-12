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

    public void establecerVolumen(float nivel) {
        if (controlVolumen != null) {
            float nivelLimitado = Math.max(controlVolumen.getMinimum(), Math.min(nivel, controlVolumen.getMaximum()));
            controlVolumen.setValue(nivelLimitado);
        }
    }

    public void subirVolumen(float paso) {
        if (controlVolumen != null) {
            float nuevoNivel = controlVolumen.getValue() + paso;
            establecerVolumen(nuevoNivel);
            System.out.println("Volumen aumentado a: " + controlVolumen.getValue() + " dB");
        }
    }

    public void bajarVolumen(float paso) {
        if (controlVolumen != null) {
            float nuevoNivel = controlVolumen.getValue() - paso;
            establecerVolumen(nuevoNivel);
            System.out.println("Volumen reducido a: " + controlVolumen.getValue() + " dB");
        }
    }

    public float obtenerVolumenActual() {
        return controlVolumen != null ? controlVolumen.getValue() : Float.NaN;
    }
}
