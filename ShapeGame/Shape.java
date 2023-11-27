package ShapeGame;

abstract class Shape{
    abstract double area();
    abstract double perimeter();
    abstract String color();
    abstract String compareShape(Shape obj);
}