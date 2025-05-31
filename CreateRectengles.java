import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import java.util.ArrayList;


public class CreateRectengles {
    
    ArrayList<Bottles> bottles = new ArrayList<>();


    public void bottle(){

        for(int i = 0 ; i < 6 ; i++){

            Rectangle rect = new Rectangle(100+(i*140) , 200 , 60 , 230);
            rect.setFill(Color.LIGHTGRAY);
            rect.setStrokeType(StrokeType.OUTSIDE);
            rect.setStroke(Color.LIGHTGRAY);
            rect.setStrokeWidth(4);
            rect.setArcHeight(15);
            rect.setArcWidth(15);
            Bottles bottle = new Bottles();
            bottle.setRectangle(rect);
            this.bottles.add(bottle);
        }
    }

}
