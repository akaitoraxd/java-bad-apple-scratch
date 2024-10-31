import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Main {
    public static void main(String[] args) throws LineUnavailableException {
        File music = new File("bad_apple.wav");
        List<String> frames = new ArrayList<>();
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(music);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            for (int i = 1; i < 6573; i++){
                StringBuilder frame = new StringBuilder();
                try (BufferedReader reader = new BufferedReader(new FileReader("D:\\Bad-Apple\\frames-ascii\\out (" + i + ").txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    frame.append(line).append("\n");
                }
            }
            frames.add(frame.toString());
        }

        for (String frame : frames){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println(frame);
            try {
                Thread.sleep(31);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}