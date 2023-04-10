import java.util.ArrayList; 
import java.io.PrintStream; 
public class Line extends Shape {
    private double x1, y1, x2, y2; 

    public Line(ArrayList<String> styles, double x1, double x2, double y1, double y2) {
        super(styles); 
        this.x1 = x1; 
        this.x2 = x2; 
        this.y1 = y1; 
        this.y2 = y2; 
    }

    public void renderAttributes(PrintStream out) {
        
    }
}