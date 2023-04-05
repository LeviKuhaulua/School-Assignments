import java.util.ArrayList; 
public class Circle extends Shape {
    private double cx, cy, r; 

    public Circle(ArrayList<String> styles, double cx, double cy, double r) {
        super(styles); 
        this.cx = cx; 
        this.cy = cy; 
        this.r = r; 
    }
}