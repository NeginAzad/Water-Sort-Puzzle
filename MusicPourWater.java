 import java.io.File;
 import javafx.scene.media.Media;
 import javafx.scene.media.MediaPlayer;

 public class MusicPourWater {

     public MediaPlayer mediaPlayer;

     public MusicPourWater() {
         String filePath = "C:\\Users\\parseh\\Downloads\\music\\water.mp3"; 
         File file = new File(filePath);

         if (!file.exists()) {
             System.out.println("Not valid: " + filePath);
             return; 
         }

         String mediaPath = file.toURI().toString();

         try {
             Media media = new Media(mediaPath);
             mediaPlayer = new MediaPlayer(media);
             mediaPlayer.setVolume(1.0); 
         } catch (Exception e) {
             e.printStackTrace();
             System.out.println("Error loading media");
         }
     }

     public void play() {
         if (mediaPlayer != null) {
             mediaPlayer.play();
         }
     }

    
 }