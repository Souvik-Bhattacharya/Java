package box;

class Box {
    private Object volume;

    Box(){
        volume = 0;
    }

    Box(int height, int width, int depth){
        volume = height * width * depth;
    }

    Box(float height, float width, float depth){
        volume = height * width * depth;
    }

    Box(double height, double width, double depth){
        volume = height * width * depth;
    }

    void showVolume(){
        System.out.println("The volume of the box is " + volume + " cube unit");
    }
}

public class Demo {
    public static void main(String args[]){
        Box box1 = new Box();
        Box box2 = new Box(14, 15, 16);
        Box box3 = new Box(14.1f, 15.2f, 16.3f);
        Box box4 = new Box(14.1, 15.2, 16.3);

        box1.showVolume();
        box2.showVolume();
        box3.showVolume();
        box4.showVolume();
    }
}