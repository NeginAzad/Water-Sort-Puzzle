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
    public void littleRect(Color[][] color){

        for(int i = 0 ; i < 4 ; i++){

            for(int j = 0 ; j < 4 ; j++) {

                Rectangle rect = bottles.get(i).getRectangle();
                Rectangle rectangle = new Rectangle(rect.getX(), 360 - (50 * j), 60, 50);
                rectangle.setFill(color[i][j]);

                bottles.get(i).getLittleRectangles().add(rectangle);
            }
            bottles.get(i).group.getChildren().addAll(bottles.get(i).getLittleRectangles());
        }
        bottles.get(4).group.getChildren().addAll(bottles.get(4).getLittleRectangles());
        bottles.get(5).group.getChildren().addAll(bottles.get(5).getLittleRectangles());
    }

}
