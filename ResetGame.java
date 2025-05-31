import java.util.ArrayList;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ResetGame {
    Bottles bottle = new Bottles();
    int random;
    CreateRectangles createRectangles = new CreateRectangles();
    Pane pane = new Pane();
    private ArrayList<Bottles> bottles;

    public ResetGame(Pane pane, ArrayList<Bottles> bottles  , CreateRectangles createRectangles , int random) {
        
        this.pane = pane;
        this.bottles = bottles;
        this.createRectangles = createRectangles;
        this.random = random;
    }

    public void reset() {

        for (Bottles bottle : bottles){

            bottle.group.getChildren().removeAll(bottle.getLittleRectangles());
            bottle.getLittleRectangles().clear();
        }

        ColorArrangment colorArrangment = new ColorArrangment();
        

        switch (random){

            case 1:
                createRectangles.bottle();
                createRectangles.littleRect(colorArrangment.type1());
                break;
                case 2:
                createRectangles.bottle();
                createRectangles.littleRect(colorArrangment.type2());
                break;
              case 3:
                 createRectangles.bottle();
                 createRectangles.littleRect(colorArrangment.type3());
                 break;
             case 4:
                 createRectangles.bottle();
                 createRectangles.littleRect(colorArrangment.type4());
                 break;
             case 5:
                 createRectangles.bottle();
                 createRectangles.littleRect(colorArrangment.type5());
                 break;
        }
    }
}
