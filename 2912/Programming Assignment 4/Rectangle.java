import java.util.ArrayList;
import java.io.PrintStream; 
public class Rectangle extends Shape {
    private double x, y, width, height; 

    public Rectangle (ArrayList<String> styles, double x, double y, double width, double height) {
        super(styles); 
        this.x = x; 
        this.y = y; 
        this.width = width; 
        this.height = height; 
    }

    public void renderAttributes(PrintStream out) {
        
    }
}