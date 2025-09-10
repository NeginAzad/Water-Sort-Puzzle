 import java.io.File;
<<<<<<< HEAD

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
=======
 import javafx.scene.media.Media;
>>>>>>> 92914a40bd223638e8230763b3f8707e91ac9a4d
 import javafx.scene.media.MediaPlayer;

 public class MusicPourWater {

<<<<<<< HEAD
     public AudioClip audio;

     public MusicPourWater() {
         String filePath = "C:\\Users\\parseh\\Downloads\\music\\water.mp3"; 
         File file = new File(filePath);
=======
     public MediaPlayer mediaPlayer;

     public MusicPourWater() {
         
        String filePath = "C:\\Users\\parseh\\Downloads\\music\\water.mp3"; 
        File file = new File(filePath);
>>>>>>> 92914a40bd223638e8230763b3f8707e91ac9a4d

         if (!file.exists()) {
             System.out.println("Not valid: " + filePath);
             return; 
         }

         String mediaPath = file.toURI().toString();

         try {
<<<<<<< HEAD
              audio = new AudioClip(mediaPath);
             audio.setVolume(1.0); 
         }
          catch (Exception e) {
=======
             Media media = new Media(mediaPath);
             mediaPlayer = new MediaPlayer(media);
             mediaPlayer.setVolume(1.0); 
         } catch (Exception e) {
>>>>>>> 92914a40bd223638e8230763b3f8707e91ac9a4d
             e.printStackTrace();
             System.out.println("Error loading media");
         }
     }

     public void play() {
<<<<<<< HEAD

         if (audio != null) {
             audio.play();
=======
         if (mediaPlayer != null) {
             mediaPlayer.play();
>>>>>>> 92914a40bd223638e8230763b3f8707e91ac9a4d
         }
     }

    
 }