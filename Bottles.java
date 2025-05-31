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
}
