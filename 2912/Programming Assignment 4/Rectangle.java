import java.io.PrintStream; 
public class Rectangle extends Shape {
    private double x, y, width, height; // fields for creating rectangle tag 

    /**
     * 
     * @param x - cartesian x point
     * @param y - cartesian y point
     * @param width of the rectangle
     * @param height of the rectangle 
     */
    public Rectangle (double x, double y, double width, double height) {
        this.x = x; 
        this.y = y; 
        this.width = width; 
        this.height = height; 
    }

    /**
     * renderAttributes will help with formatting the dimensions for a rectangle tag
     * @param out - where the data will be outputted 
     */
    public void renderAttributes(PrintStream out) {
        out.print("rect "
        + "x=" + super.encapsulateAttribute(x)
        + " y=" + super.encapsulateAttribute(y)      
        + " width=" + super.encapsulateAttribute(width)
        + " height=" + super.encapsulateAttribute(height)        
        );
    }  
}