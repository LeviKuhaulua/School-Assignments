import java.io.PrintStream;
import java.util.ArrayList; 
import java.io.PrintStream;
public class Circle extends Shape {
    private double cx, cy, r; 

    public Circle(ArrayList<String> styles, double cx, double cy, double r) {
        super(styles); 
        this.cx = cx; 
        this.cy = cy; 
        this.r = r; 
    }

    public void renderAttributes(PrintStream out) {
        
    }
}