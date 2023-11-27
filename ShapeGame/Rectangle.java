package ShapeGame;

class Rectangle extends Shape {
    double length;
    double width;
    String color;

    Rectangle(Point p1, Point p2, Point p3, String color) {
	    this.length = p1.distance(p2);
	    this.width = p2.distance(p3);
        this.color = color;
    }
	
	@Override
    double area() {
        return length * width;
    }
	
	@Override
    double perimeter() {
        return 2 * (length + width);
    }
	
	@Override
    String color() {
        return color;
    }
	
	@Override
    String compareShape(Shape ob) {
        if (ob instanceof Rectangle) {
    		Rectangle other = (Rectangle) ob;
    		if (this.area() == other.area() && this.perimeter() == other.perimeter()) 
    			return "Matching Rectangles";
    		else
    			return "Non-matching Rectangles";
        } else return "Shapes are not of the same type";	
   	}
}
