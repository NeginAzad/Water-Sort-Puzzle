import java.util.ArrayList;
import javafx.scene.layout.Pane;

public class ResetGame {
    int random;
    Bottles bottle = new Bottles();
    CreateRectangles createRectangles = new CreateRectangles();
    Pane pane = new Pane();
    private ArrayList<Bottles> bottles;

    public ResetGame(Pane pane, ArrayList<Bottles> bottles,CreateRectangles createRectangles,int random ) {
        this.createRectangles=createRectangles;
        this.pane = pane;
        this.bottles = bottles;
        this.random=random;
    }


    

    
}
