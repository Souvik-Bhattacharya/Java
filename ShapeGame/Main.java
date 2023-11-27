package ShapeGame;

public class Main{
    public static void main(String args[]){
        
        Point p1 = new Point(1,2);
        Point p2 = new Point(5,2);
		Point p3 = new Point(5,4);
		Point c = new Point(0,0);
		
        Shape triangle1 = new Triangle(p1, p2, p3, "Red");
        Shape triangle2 = new Triangle(p1, p2, p3, "Blue");
        
        Shape rectangle1 = new Rectangle(p1, p2, p3, "Green");

        Shape circle1 = new Circle(c, p1, "Orange");
        Shape circle2 = new Circle(c, p2, "Purple");

        System.out.println(triangle1.compareShape(triangle2));
        System.out.println(triangle1.compareShape(rectangle1));
        System.out.println(circle1.compareShape(circle2));
    
    }
}