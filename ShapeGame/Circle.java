package ShapeGame;

import java.lang.Math;

class Circle extends Shape {
    double radius;
    String color;
	
    Circle(Point c, Point p1, String color) {
        this.radius = c.distance(p1);
        this.color = color;
    }
	
	@Override
    double area() {
        return Math.PI * radius * radius;
    }
	
	@Override
    double perimeter() {
        return 2 * Math.PI * radius;
    }
	
	@Override
    String color() {
        return color;
    }

	@Override
    String compareShape(Shape ob) {
        if (ob instanceof Circle) {
            Circle other = (Circle) ob;
            if (this.area() == other.area() && this.perimeter() == other.perimeter()) {
                return "Matching Circles";
            } else {
                return "Non-matching Circles";
            }
        } else {
            return "Shapes are not of the same type";
        }
    }
}
 
