import java.util.ArrayList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GameState {
    public ArrayList<ArrayList<Color>> colors = new ArrayList<>();
    public ArrayList<ArrayList<Double>> heights = new ArrayList<>();
    public ArrayList<ArrayList<Double>> yPositions = new ArrayList<>();

     public GameState(ArrayList<Bottles> bottles) {
        for (Bottles bottle : bottles) {
            ArrayList<Color> bottleColors = new ArrayList<>();
            ArrayList<Double> bottleHeights = new ArrayList<>();
            ArrayList<Double> bottleYs = new ArrayList<>();

            for (Rectangle rect : bottle.getLittleRectangles()) {
                bottleColors.add((Color) rect.getFill());
                bottleHeights.add(rect.getHeight());
                bottleYs.add(rect.getY());
            }

}
     }
    }