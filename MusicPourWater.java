 import java.io.File;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
 import javafx.scene.media.MediaPlayer;

 public class MusicPourWater {

     public AudioClip audio;

     public MusicPourWater() {
         String filePath = "C:\\Users\\parseh\\Downloads\\music\\water.mp3"; 
         File file = new File(filePath);

         if (!file.exists()) {
             System.out.println("Not valid: " + filePath);
             return; 
         }

         String mediaPath = file.toURI().toString();

         try {
              audio = new AudioClip(mediaPath);
             audio.setVolume(1.0); 
         }
          catch (Exception e) {
             e.printStackTrace();
             System.out.println("Error loading media");
         }
     }

     public void play() {

         if (audio != null) {
             audio.play();
         }
     }

    
 }