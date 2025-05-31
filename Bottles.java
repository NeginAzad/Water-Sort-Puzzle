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

}
