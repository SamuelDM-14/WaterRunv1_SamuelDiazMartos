package utilidades;

import javax.sound.sampled.*;
import java.io.File;

public class MusicPlayer {

    private Clip clip;

    public void playMusic(String filepath) {
        stopMusic(); // Detenemos cualquier música anterior
        try {
            File musicPath = new File(filepath);
            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                clip.start();
            } else {
                System.out.println("No se encontró el archivo de música: " + filepath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopMusic() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }
    public void setVolume(float level) {
        if (clip != null) {
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            // El valor debe estar en el rango del control (usualmente entre -80.0f y 6.0f)
            float clampedLevel = Math.max(gainControl.getMinimum(), Math.min(level, gainControl.getMaximum()));
            gainControl.setValue(clampedLevel);
        }
    }
    
}
