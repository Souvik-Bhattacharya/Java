package ShapeGame;
import java.lang.Math;

class Triangle extends Shape {
    double side1;
    double side2;
    double side3;
    String color;
	
    Triangle(Point p1, Point p2, Point p3, String color){
        this.side1 = p1.distance(p2);
        this.side2 = p2.distance(p3);
        this.side3 = p3.distance(p1);
        this.color = color;
    }
    
    @Override
    double area() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
    
	@Override
    double perimeter() {
        return side1 + side2 + side3;
    }
	
	@Override
    String color() {
        return this.color;
    }
	
	@Override
    String compareShape(Shape ob) {
        if (ob instanceof Triangle) {
            Triangle other = (Triangle) ob;
            if (this.area() == other.area() && this.perimeter() == other.perimeter()){
                return "Matching Triangles";
            } 
            else{
                return "Non-matching Triangles";
            }
        } 
        else {
            return "Shapes are not of the same type";
        }
    }
}
