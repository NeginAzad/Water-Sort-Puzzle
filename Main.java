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

    int counterWin = 0;

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
                    new Stop(1, baseColor));

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

            // حرکت به سمت بالا + پراکندگی افقی
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

            // اجرا
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

        if (counterWin != 0) {

            showVictoryAnimation(pane);
        }
        // تیتر وسط
        Label title = new Label("WATERBOTTLE");
        title.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 40));
        title.setTextFill(Color.WHITE);
        title.setAlignment(Pos.CENTER);
        title.setPrefWidth(800); // بیاد وسط
        title.setLayoutY(40);

        // دیزاین تیتر
        title.setStyle(
                "-fx-background-color: rgba(50, 115, 220, 0.8);" +
                        "-fx-padding: 15 50;" +
                        "-fx-border-radius: 25;" +
                        "-fx-background-radius: 25;" +
                        "-fx-border-color: #7abaff;" +
                        "-fx-border-width: 4;");

        // ....
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.web("#66ccff"));
        shadow.setRadius(12);
        shadow.setSpread(0.3);
        shadow.setOffsetX(0);
        shadow.setOffsetY(0);
        title.setEffect(shadow);

        pane.getChildren().add(title);
        // رنگ دکمه ها
        String[] buttonColors = {
                "#2196F3", // آبی روشن
                "#4CAF50", // سبز
                "#FFC107", // زرد
                "#FF5722", // نارنجی
                "#9C27B0" // بنفش
        };

        // هاور دکمه
        String hoverTextColor = "#2196F3"; // هاور متن ابی

        for (int i = 1; i <= 5; i++) {
            final int level = i;
            final int index = i - 1;

            Button button = new Button("Level " + i);
            button.setLayoutX(320);
            button.setLayoutY(120 + (i * 70));
            button.setPrefWidth(160);

            button.setStyle(
                    "-fx-background-color: " + buttonColors[index] + ";" +
                            "-fx-text-fill: white;" +
                            "-fx-font-size: 20px;" +
                            "-fx-font-weight: bold;" +
                            "-fx-padding: 12 30;" +
                            "-fx-border-radius: 30;" +
                            "-fx-background-radius: 30;" +
                            "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 8, 0, 0, 4);");

            button.setFont(Font.font("Arial", FontWeight.BOLD, 20));
            pane.getChildren().add(button);

            button.setOnMouseEntered(e -> button.setStyle(
                    "-fx-background-color: white;" +
                            "-fx-text-fill: " + buttonColors[index] + ";" +
                            "-fx-font-size: 20px;" +
                            "-fx-font-weight: bold;" +
                            "-fx-padding: 12 30;" +
                            "-fx-border-radius: 30;" +
                            "-fx-background-radius: 30;" +
                            "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 12, 0, 0, 6);"));

            button.setOnMouseExited(e -> button.setStyle(
                    "-fx-background-color: " + buttonColors[index] + ";" +
                            "-fx-text-fill: white;" +
                            "-fx-font-size: 20px;" +
                            "-fx-font-weight: bold;" +
                            "-fx-padding: 12 30;" +
                            "-fx-border-radius: 30;" +
                            "-fx-background-radius: 30;" +
                            "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 8, 0, 0, 4);"));

            button.setOnAction(e -> {
                try {
                    showGameScene(stage, level);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
        }
        // پس زمینه
        pane.setStyle("-fx-background-color: linear-gradient(to bottom,rgb(243, 249, 192), #c2e9fb);");

        Scene startScene = new Scene(pane, 800, 600);
        stage.setScene(startScene);
        stage.show();
    }

    public void showGameScene(Stage stage, int random) {

        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: linear-gradient(to bottom,rgb(235, 237, 218), #c2e9fb);");
        Bottles bottle = new Bottles();
        int[] counter = {0};
        ColorArrangment colorArrangment = new ColorArrangment();
        CreateRectangles createRectangles = new CreateRectangles();

        ResetGame resetButton = new ResetGame(pane, createRectangles.bottles, createRectangles,random);
        Button reset = new Button("RESET");

reset.setStyle(
    "-fx-background-color: linear-gradient(to bottom, rgb(255, 239, 213), rgb(255, 218, 185));" +  // گرادیانت کرم روشن به کرم پررنگ
    "-fx-text-fill: rgb(139, 69, 19);" +  // رنگ متن قهوه‌ای 
    "-fx-font-size: 20px;" +
    "-fx-font-weight: bold;" +
    "-fx-padding: 12 25;" +
    "-fx-border-radius: 30;" +
    "-fx-background-radius: 30;" +
    "-fx-border-color: rgb(222, 184, 135);" +  // رنگ حاشیه کرم 
    "-fx-border-width: 3px;" +
    "-fx-effect: dropshadow(three-pass-box, rgba(222, 184, 135, 0.7), 8, 0, 0, 6);"
);

reset.setOnMouseEntered(e -> {
    reset.setStyle(
        "-fx-background-color: linear-gradient(to bottom, rgb(255, 218, 185), rgb(210, 180, 140));" +  // کرم پررنگ به کرم تیره‌
        "-fx-text-fill: rgb(255, 250, 240);" +  // متن سفید کرم روشن
        "-fx-font-size: 20px;" +
        "-fx-font-weight: bold;" +
        "-fx-padding: 12 25;" +
        "-fx-border-radius: 30;" +
        "-fx-background-radius: 30;" +
        "-fx-border-color: rgb(205, 133, 63);" +  // حاشیه قهوه‌ای طلایی پررنگ
        "-fx-border-width: 3px;" +
        "-fx-effect: dropshadow(three-pass-box, rgba(205, 133, 63, 0.9), 10, 0, 0, 8);"
    );
});

reset.setOnMouseExited(e -> {
    reset.setStyle(
        "-fx-background-color: linear-gradient(to bottom, rgb(255, 239, 213), rgb(255, 218, 185));" +
        "-fx-text-fill: rgb(139, 69, 19);" +
        "-fx-font-size: 20px;" +
        "-fx-font-weight: bold;" +
        "-fx-padding: 12 25;" +
        "-fx-border-radius: 30;" +
        "-fx-background-radius: 30;" +
        "-fx-border-color: rgb(222, 184, 135);" +
        "-fx-border-width: 3px;" +
        "-fx-effect: dropshadow(three-pass-box, rgba(222, 184, 135, 0.7), 8, 0, 0, 6);"
    );
});

reset.setLayoutX(50);
reset.setLayoutY(50);
pane.getChildren().add(reset);

reset.setOnAction(e -> {
    resetButton.reset();
});
//دکمه های هشدار

Label label1 = new Label("the chosen bottle is empty!");
label1.setLayoutX(300);
label1.setLayoutY(10);
label1.setTextFill(Color.RED);
label1.setFont(new Font("Comic Sans MS", 20));
label1.setStyle(
    "-fx-background-color: #ffebeb; " +         // پس‌زمینه 
    "-fx-border-color: #ff4c4c; " +             // حاشیه قرمز
    "-fx-border-width: 3; " +
    "-fx-border-radius: 15; " +
    "-fx-background-radius: 15; " +
    "-fx-padding: 8 15 8 15; " +
    "-fx-effect: dropshadow(gaussian, #ff4c4c, 10, 0.5, 0, 0); " +
    "-fx-font-weight: bold;"
);

        Rectangle[] toppestRect1 = new Rectangle[1];
        Rectangle[] toppestRect2 = new Rectangle[1];
        int[] index1 = new int[1];
        int[] index2 = new int[1];


    }

    public static void main(String[] args) {

        launch(args);
    }
}
