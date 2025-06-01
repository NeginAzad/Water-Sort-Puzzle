 import java.io.File;
 import javafx.scene.media.MediaPlayer;

 public class MusicPourWater {

    public MediaPlayer mediaPlayer;
     

     public MusicPourWater() {

        String filePath = "E:\\water-pill.mp3"; 
         File file = new File(filePath);

         if (!file.exists()) {
             System.out.println("Not valid: " + filePath);
             return; 
         }
         

    
 }
}