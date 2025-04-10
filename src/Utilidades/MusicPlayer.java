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
}
