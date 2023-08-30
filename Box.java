class BoxClass {
    int height;
    int width;
    int depth;
    BoxClass(){
        height = 100;
        width = 100;
        depth = 100;
    }
    BoxClass(int height, int width, int depth){
        this.height = height;
        this.width = width;
        this.depth = depth;
    }
    void showVolume(){
        System.out.println("The volume of the box is " + (height * width * depth) + " cube unit");
    }
}

public class Box {
    public static void main(String args[]){
        BoxClass box1 = new BoxClass();
        BoxClass box2 = new BoxClass(14, 15, 16);
        box1.showVolume();
        box2.showVolume();
    }
}