import java.util.ArrayList;
import java.io.PrintStream; 
public class Svg {
    // Fields for Svg class 
    private ArrayList<Shape> shapes; // List of shapes 
    private double height, width; // Dimensions of Svg

    /**
     * Svg constructor that takes in parameters for height, width, and what kind of shapes to draw 
     * @param shapes - ArrayList of Shape objects
     * @param height - height of the svg 
     * @param width - width of the svg 
     */
    public Svg(double width, double height) {
        this.height = height; 
        this.width = width; 
    }

    /**
     * addShape takes a Shape object and adds it to the ArrayList
     * @param Shape object 
     */
    public void addShape(Shape shape) {
        shapes.add(shape); 
    }

    /**
     * render will print out the svg dimensions 
     * @param out - the printStream 
     */
    public void render(PrintStream out) {
        out.println("<svg width=" + encapsulateDimensions(width) + "height=" + encapsulateDimensions(height) + ">"); 
        out.println("</svg>");
    }

    public String encapsulateDimensions(double dimension) {
        return String.valueOf("'" + dimension + "'"); 
    }


}