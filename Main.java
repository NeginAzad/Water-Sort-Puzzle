import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;    
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application{



    public void start(Stage stage) throws Exception{

        
    } 
    public void showGameScene(Stage stage , int random){

        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: linear-gradient(to bottom,rgb(235, 237, 218), #c2e9fb);");
        Bottles bottle = new Bottles();
        int[] counter = {0};
        ColorArrangment colorArrangment = new ColorArrangment();
        CreateRectangles createRectangles = new CreateRectangles();

        ResetGame resetButton = new ResetGame(pane, createRectangles.bottles, createRectangles,random);
        Button reset = new Button("RESET");

        /*
         236 - 365 bahar
         */

        Rectangle[] toppestRect1 = new Rectangle[1];
        Rectangle[] toppestRect2 = new Rectangle[1];
        int[] index1 = new int[1];
        int[] index2 = new int[1];


    }

    public static void main(String[] args) {

        launch(args);
    }
}


