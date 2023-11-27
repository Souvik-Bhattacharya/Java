package ShapeGame;
import java.lang.Math;

class Point{
    double x, y;
    Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    double distance(Point p){
        double tmpx = (this.x > p.x) ? (this.x - p.x) : (p.x - this.x);
        double tmpy = (this.y > p.y) ? (this.y - p.y) : (p.y - this.y);

        double tmp = (tmpx*tmpx) + (tmpy*tmpy);
        return Math.sqrt(tmp);
    }
}