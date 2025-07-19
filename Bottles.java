import java.util.ArrayList;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.Stack;

public class Bottles {

    private Stack<Rectangle> littleRect = new Stack<>();
    private ArrayList<Rectangle> matchedRect = new ArrayList<>();
    private Rectangle rectangle = new Rectangle();
    Group group = new Group();

    public void setRectangle(Rectangle rectangle) {

        this.rectangle = rectangle;
        group.getChildren().add(rectangle);
    }

    public Rectangle getRectangle() {

        return rectangle;
    }

    public Stack<Rectangle> getStack() {

        return littleRect;
    }

    public int findindex(double x, double y, CreateRectangles createRectangles) {

        for (int i = 0; i < 6; i++) {

            if (createRectangles.bottles.get(i).getRectangle().contains(x, y)) {

                return i;
            }
        }
        return -1;
    }

    public Bottles findBottle(double x, double y, CreateRectangles createRectangles) {

        for (int i = 0; i < 6; i++) {

            if (createRectangles.bottles.get(i).getRectangle().contains(x, y)) {

                return createRectangles.bottles.get(i);
            }
        }
        return null;
    }

    public boolean isEmpty() {

        if (littleRect.isEmpty()) {

            return true;
        }
        return false;
    }

    public boolean match(Bottles bottle1) {

        matchedRect.clear();

        Color top = (Color) bottle1.getStack().peek().getFill();
        int index1 = bottle1.getStack().size() - 1;
        int index2 = littleRect.size() - 1;
        double y;
        boolean isMatch = false;
        int i = 0;

        if (littleRect.size() == 0) {

            y = 410;
        } else {

            y = littleRect.peek().getY();
        }

        if (littleRect.size() == 0 || top == littleRect.peek().getFill()) {

            isMatch = true;

            while (bottle1.getStack().get(index1).getFill() == top && (index1 >= 0 && index2 < 3)) {

                Rectangle rect = new Rectangle(rectangle.getX(), y - (i * 50), 60, 0);
                rect.setFill(top);
                matchedRect.add(rect);
                i++;
                index1--;
                index2++;

                // اگر داخل شرط وایل این را چک کند دچار خطا می شود برای همین قبل از رفتن به
                // ابتدای حلقه باید چک شود

                if (index1 < 0 || index2 > 3) {

                    break;
                }

            }
        }
        group.getChildren().addAll(matchedRect);
        return isMatch;
    }

    public void add() {

        for(int i = 0 ; i < matchedRect.size() ; i++){

            littleRect.push(matchedRect.get(i));
        }
    }

    public void delete(ArrayList<Rectangle> shouldDelete) {

        group.getChildren().removeAll(shouldDelete);
        
    }

    public boolean isWin(CreateRectangles createRectangles) {

        int counter = 0;
        boolean same = true;

        for (int i = 0; i < 6; i++) {

            if (createRectangles.bottles.get(i).getStack().size() == 4) {

                Color first = (Color) createRectangles.bottles.get(i).getStack().get(0).getFill();

                for (int j = 1; j < 4; j++) {

                    if (!(first.equals((Color) createRectangles.bottles.get(i).getStack().get(j).getFill()))) {

                        same = false;
                        break;
                    }
                }
                if (same) {

                    counter++;
                }
            }
        }
        return counter == 4;
    }

    public void animation(Bottles bottle2 , CreateRectangles createRectangles, Stage stage) {

        ParallelTransition pt1 = new ParallelTransition();
        ParallelTransition pt2 = new ParallelTransition();

        // انیمیشن رفت

        TranslateTransition t1 = new TranslateTransition(Duration.seconds(1), group);
        RotateTransition r1 = new RotateTransition(Duration.seconds(1), group);

        t1.setByY(-150);

        if (bottle2.getRectangle().getX() > rectangle.getX()) {

            t1.setByX(bottle2.getRectangle().getX() - 40 - rectangle.getX());
            r1.setByAngle(20);
        } else {

            double displacement = rectangle.getX() - (bottle2.getRectangle().getX() + 50);

            t1.setByX(-displacement);
            r1.setByAngle(-20);
        }
        pt1.getChildren().addAll(t1, r1);

        //انیمیشن برگشت

        TranslateTransition t2 = new TranslateTransition(Duration.seconds(1), group);
        RotateTransition r2 = new RotateTransition(Duration.seconds(1), group);

        t2.setByY(150);

        if (bottle2.getRectangle().getX() > rectangle.getX()) {

            t2.setByX(-(bottle2.getRectangle().getX() - 40 - rectangle.getX()));
            r2.setByAngle(-20);
        } 
        else {

            double displacement = rectangle.getX() - (bottle2.getRectangle().getX() + 50);

            t2.setByX(displacement);
            r2.setByAngle(20);
        }
        pt2.getChildren().addAll(t2, r2);

        // انیمیشن اب

        SequentialTransition seq1 = new SequentialTransition();
        SequentialTransition seq2 = new SequentialTransition();
        SequentialTransition seq3 = new SequentialTransition();

        ArrayList<Rectangle> shouldDelete = new ArrayList<>();
    

        for (int i = 0; i < bottle2.matchedRect.size(); i++) {
            

            Timeline timeline1 = new Timeline(
                    new KeyFrame(Duration.seconds(0), new KeyValue(littleRect.peek().heightProperty(), 50),
                            new KeyValue(littleRect.peek().yProperty(), littleRect.peek().getY())),
                    new KeyFrame(Duration.seconds(1), new KeyValue(littleRect.peek().heightProperty(), 0),
                            new KeyValue(littleRect.peek().yProperty(), littleRect.peek().getY() + 50)));

            shouldDelete.add(littleRect.pop());               

            Timeline timeline2 = new Timeline();

            KeyFrame keyFrame1 = new KeyFrame(Duration.seconds(0), new KeyValue(bottle2.matchedRect.get(i).heightProperty(), 0),
                    new KeyValue(bottle2.matchedRect.get(i).yProperty(),bottle2.matchedRect.get(i).getY()));
            KeyFrame keyFrame2 = new KeyFrame(Duration.seconds(1), new KeyValue(bottle2.matchedRect.get(i).heightProperty(), 50),
                    new KeyValue(bottle2.matchedRect.get(i).yProperty(), bottle2.matchedRect.get(i).getY() - 50));
            timeline2.getKeyFrames().addAll(keyFrame1, keyFrame2);
            
            seq1.getChildren().add(timeline1);
            seq2.getChildren().add(timeline2);
        }
        MusicPourWater waterSound = new MusicPourWater();

        for(int j = 0 ; j < seq1.getChildren().size() ; j++){

            
            PauseTransition sound = new PauseTransition(Duration.millis(j));
            sound.setOnFinished(e -> {

                waterSound.play();
            });
            ParallelTransition pt3 = new ParallelTransition();
            pt3.getChildren().addAll(seq1.getChildren().get(j) , seq2.getChildren().get(j) , sound);
            seq3.getChildren().add(pt3);
        }

        pt1.setOnFinished(e -> {

            seq3.setOnFinished(event ->{

                delete(shouldDelete);
                bottle2.add();
                pt2.play();
                if(isWin(createRectangles)){

                    PauseTransition pause = new PauseTransition(Duration.seconds(1.5));
                    pause.setOnFinished(ev -> {

                        Main main = new Main();
                        main.counterWin++;
                        main.showStartScene(stage);

                    });
                    pause.play();
                }

            });
            seq3.play();
        });
        pt1.play();
    }
}
