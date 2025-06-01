import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class BackGroundMusic {
    public MediaPlayer backGrounMediaPlayer;

    public BackGroundMusic() {
        String filePath = "E:\\Coffee-Shop-Song.mp3";
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("Not valid: " + filePath);
            return; 
        }

        String mediaPath = file.toURI().toString();

        try {
            Media media = new Media(mediaPath);
            backGrounMediaPlayer = new MediaPlayer(media);
            backGrounMediaPlayer.setCycleCount(MediaPlayer.INDEFINITE); // حلقه بی‌نهایت
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading media");
        }
    }

    public void play() {
        if (backGrounMediaPlayer != null) {
            backGrounMediaPlayer.play();
        }
    }

   
}