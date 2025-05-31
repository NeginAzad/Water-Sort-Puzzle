public class Bottles {
    
    private ArrayList<Rectangle> littleRectangles = new ArrayList<>();
    private Rectangle rectangle = new Rectangle();
     Group group = new Group();
     //ایندکس بالاترین مستطیل
     private int index;

     public  void setRectangle( Rectangle rectangle){

        this.rectangle = rectangle;
        group.getChildren().add(rectangle);
    }
    public Rectangle getRectangle(){

        return  rectangle;
    }
    public ArrayList<Rectangle> getLittleRectangles(){

        return littleRectangles;
    }

    public int findindex(double x, double y , CreateRectangles createRectangles){

        for(int i = 0 ; i < 6 ; i++){

            if(createRectangles.bottles.get(i).getRectangle().contains(x , y)){

                return i;
            }
        }
        return  -1;
    }
    public Bottles findBottle( int index , CreateRectangles createRectangles){

        return createRectangles.bottles.get(index);

    }
    public  boolean isEmpty(){

        if(littleRectangles.isEmpty()){

            return  true;
        }
        return  false;
    }
    public Rectangle findToppestRect(){

        double minY = littleRectangles.get(0).getY();
        index = 0;

        for(int i = 0 ; i < littleRectangles.size() ; i++){

            if(minY > littleRectangles.get(i).getY()){

                minY = littleRectangles.get(i).getY();
                index = i;
            }
        }
        return littleRectangles.get(index);
    }
    public boolean matchColor(Rectangle rect){

        if(findToppestRect().getFill() == rect.getFill()){

            return  true;
        }
        return  false;
    }
    public void add(Rectangle rect){

        Rectangle rec = new Rectangle(rect.getX() , rect.getY() , 60 , 50);
        rec.setFill(rect.getFill());
        rec.setX(rectangle.getX());

        if(littleRectangles.size() !=  0){


            rec.setY(findToppestRect().getY()-50);
        }
        else{
            rec.setY(360);
        }
        group.getChildren().remove(rect);
        littleRectangles.add(rec);
        group.getChildren().add(rec);
    }
    public void delete(){

        group.getChildren().remove(littleRectangles.get(index));
        littleRectangles.remove(index);

    }
    public boolean isWin(CreateRectangles createRectangles){

        int counter = 0;
        boolean same  =true;

        for(int i = 0 ; i < 6 ; i++){

            if(createRectangles.bottles.get(i).getLittleRectangles().size() == 4) {

                Color first = (Color) createRectangles.bottles.get(i).getLittleRectangles().get(0).getFill();

                for (int j = 1; j < 4; j++) {


                    if (!(first.equals((Color) createRectangles.bottles.get(i).getLittleRectangles().get(j).getFill()))) {

                        same = false;
                        break;
                    }
                }
                if(same){

                    counter++;
                }
            }
        }
        return counter == 4;
    }
    public void animation(Bottles bot , Rectangle rect , CreateRectangles createRectangles , Stage stage){

        //انیمیشن رفتن
        TranslateTransition t1 = new TranslateTransition(Duration.seconds(1) , group);
        RotateTransition r1 = new RotateTransition(Duration.seconds(1) , group);
        ParallelTransition pt1 = new ParallelTransition();

        t1.setByY(-150);

        if(rect.getX() > rectangle.getX()){

            t1.setByX(rect.getX()-40-rectangle.getX());
            r1.setByAngle(20);
        }
        else{

            double displacement = rectangle.getX() - (rect.getX()+50);

            t1.setByX(-displacement);
            r1.setByAngle(-20);
        }
        pt1.getChildren().addAll(t1 , r1);
    }
}
