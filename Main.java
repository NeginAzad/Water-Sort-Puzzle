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

public class Main extends Application {
public void showVictoryAnimation(Pane pane) {

    for (int i = 0; i < 25; i++) {
        double startX = -100 + Math.random() * 1100;
        double startY = 650;
        double radius = 25 + Math.random() * 10;

        // رنگ بادکنک
        double hue = Math.random() * 360;
        double saturation = 0.9; // اشباع بالا
        double brightness = 0.95; // روشنایی بالا
        Color baseColor = Color.hsb(hue, saturation, brightness);

        // کنتراست رنگ بادکنک
        RadialGradient gradient = new RadialGradient(
            0, 0,
            0.3, 0.3, 1, true,
            CycleMethod.NO_CYCLE,
            new Stop(0, Color.WHITE),
            new Stop(1, baseColor)
        );

        // شکل بادکنک
        Ellipse balloon = new Ellipse(radius, radius + 5);
        balloon.setFill(gradient);

        // انحنای نخ
        Path string = new Path();
        string.setStroke(Color.LIGHTGRAY);
        string.setStrokeWidth(1.5);
        double h = radius + 5;

        string.getElements().add(new MoveTo(0, h));
        string.getElements().add(new CubicCurveTo(-10, h + 20, 10, h + 40, 0, h + 60));
        string.getElements().add(new CubicCurveTo(-10, h + 80, 10, h + 100, 0, h + 120));

        // گروه بادکنک + نخ
        Group balloonGroup = new Group(balloon, string);
        balloonGroup.setLayoutX(startX);
        balloonGroup.setLayoutY(startY);
        pane.getChildren().add(balloonGroup);

        //  حرکت به سمت بالا + پراکندگی افقی
        Duration duration = Duration.seconds(4 + Math.random() * 2);
        TranslateTransition move = new TranslateTransition(duration, balloonGroup);
        move.setByY(-600 - Math.random() * 100);
        move.setByX(-100 + Math.random() * 200);
        move.setDelay(Duration.seconds(Math.random() * 1.5));

        // محو شدن تدریجی
        FadeTransition fade = new FadeTransition(duration, balloonGroup);
        fade.setFromValue(1.0);
        fade.setToValue(0.0);
        fade.setDelay(move.getDelay());

        // پایان انیمیشن: حذف از صحنه
        move.setOnFinished(event -> pane.getChildren().remove(balloonGroup));

        //اجرا
        move.play();
        fade.play();
    }
}
    public void start(Stage stage) throws Exception {
 BackGroundMusic back = new BackGroundMusic();
        back.play();
        showStartScene(stage);
    }
    public void showStartScene(Stage stage) {
 Pane pane = new Pane();

            if(counterWin!=0){
                
               showVictoryAnimation(pane);
            }


    }

    public void showGameScene(Stage stage, int random) {

        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: linear-gradient(to bottom,rgb(235, 237, 218), #c2e9fb);");
        Bottles bottle = new Bottles();
        int[] counter = { 0 };
        ColorArrangment colorArrangment = new ColorArrangment();
        CreateRectangles createRectangles = new CreateRectangles();

        ResetGame resetButton = new ResetGame(pane, createRectangles.bottles, createRectangles, random);
        Button reset = new Button("RESET");

        /*
         * 236 - 365 bahar
         */

        Rectangle[] toppestRect1 = new Rectangle[1];
        Rectangle[] toppestRect2 = new Rectangle[1];
        int[] index1 = new int[1];
        int[] index2 = new int[1];

        switch (random) {
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
        for (int i = 0; i < 6; i++) {

            pane.getChildren().addAll(createRectangles.bottles.get(i).group);
        }
        pane.setOnMouseClicked(event -> {

            label1.setVisible(false);
            label2.setVisible(false);
            label3.setVisible(false);
            label4.setVisible(false);

            double x = event.getX();
            double y = event.getY();

            //بررسی بطری مبدا

            if(bottle.findindex(x , y , createRectangles) != -1 && counter[0] == 0){

                index1[0] = bottle.findindex(x , y , createRectangles);

                if(bottle.findBottle(index1[0], createRectangles).isEmpty()){

                    label1.setVisible(true);
                }
                else{

                   toppestRect1[0] = createRectangles.bottles.get(index1[0]).findToppestRect();
                   counter[0] = 1;
                }
            }
            //بررسی بطری مقصد
            else  if(bottle.findindex(x , y , createRectangles) != -1 && counter[0] == 1){

                index2[0]= bottle.findindex(x , y , createRectangles);
                //هشدار جهت یکسان بودن بطری مبدا و مقصد
                if(createRectangles.bottles.get(index1[0])==createRectangles.bottles.get(index2[0])){

                   label4.setVisible(true);
                }
                //بررسی پر بودن بطری مقصد
                else if(createRectangles.bottles.get(index2[0]).getLittleRectangles().size() == 4){

                    label2.setVisible(true);
                }
                else{
                    //بررسی خالی بودن بطری مقصد
                    if(createRectangles.bottles.get(index2[0]).getLittleRectangles().size() == 0){


                        Rectangle noHight = new Rectangle(createRectangles.bottles.get(index2[0]).getRectangle().getX() , 410 , 60 , 0 );
                        noHight.setFill(toppestRect1[0].getFill());
                        createRectangles.bottles.get(index2[0]).group.getChildren().add(noHight);
                        createRectangles.bottles.get(index1[0]).animation(createRectangles.bottles.get(index2[0]) , noHight,createRectangles,stage);
                    }
                    //بررسی بالاترین رنگ بطری مقصد
                    else if(createRectangles.bottles.get(index2[0]).matchColor(toppestRect1[0])){

                        toppestRect2[0] = createRectangles.bottles.get(index2[0]).findToppestRect();
                        Rectangle noHight = new Rectangle(createRectangles.bottles.get(index2[0]).getRectangle().getX() , toppestRect2[0].getY() , 60 , 0 );
                        noHight.setFill(toppestRect2[0].getFill());
                        createRectangles.bottles.get(index2[0]).group.getChildren().add(noHight);
                        createRectangles.bottles.get(index1[0]).animation(createRectangles.bottles.get(index2[0]) , noHight,createRectangles,stage);

                    }
                    else{
                        label3.setVisible(true);

                    System.out.println("warning");
                    }
                }
                counter[0] = 0;      
            }
              
        });
        Scene scene = new Scene(pane , 900, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}
