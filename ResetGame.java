import java.util.ArrayList;
import javafx.scene.layout.Pane;

public class ResetGame {
    int random;
    Bottles bottle = new Bottles();
    CreateRectangles createRectangles = new CreateRectangles();
    Pane pane = new Pane();
    private ArrayList<Bottles> bottles;

    public ResetGame(Pane pane, ArrayList<Bottles> bottles,CreateRectangles createRectangles,int random ) {
<<<<<<< HEAD
        this.createRectangles=createRectangles;
=======
        
        this.createRectangles = createRectangles;
>>>>>>> 92914a40bd223638e8230763b3f8707e91ac9a4d
        this.pane = pane;
        this.bottles = bottles;
        this.random=random;
    }

    public void reset() {

        for (Bottles bottle : bottles){

<<<<<<< HEAD
            bottle.group.getChildren().removeAll(bottle.getLittleRectangles());
            bottle.getLittleRectangles().clear();
=======
            bottle.group.getChildren().removeAll(bottle.getStack());
            bottle.getStack().clear();
>>>>>>> 92914a40bd223638e8230763b3f8707e91ac9a4d
        }

        ColorArrangment colorArrangment = new ColorArrangment();
        

        switch (random){

            case 1:
<<<<<<< HEAD
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
=======
                createRectangles.littleRect(colorArrangment.type1());
                break;
            case 2:
                 createRectangles.littleRect(colorArrangment.type2());
               break;
             case 3:
                  createRectangles.littleRect(colorArrangment.type3());
                break;
             case 4:
                   createRectangles.littleRect(colorArrangment.type4());
                 break;
            case 5:
                   createRectangles.littleRect(colorArrangment.type5());
                   break;
>>>>>>> 92914a40bd223638e8230763b3f8707e91ac9a4d
         
        }
    }
}
