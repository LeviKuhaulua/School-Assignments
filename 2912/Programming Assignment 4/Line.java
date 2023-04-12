import java.io.PrintStream; 
public class Line extends Shape {
    private double x1, y1, x2, y2; // Fields for creating a line tag 

    /**
     * Line constructor for creating a line tag
     * @param x1 - cartesian x point
     * @param y1 - cartesian y point
     * @param x2 - cartesian x2 point 
     * @param y2 - cartesian y2 point 
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.x1 = x1; 
        this.x2 = x2; 
        this.y1 = y1; 
        this.y2 = y2; 
    }

    /**
     * renderAttributes will format the line attributes 
     * @param out - where the data will be outputted 
     */
    public void renderAttributes(PrintStream out) {
        out.print("line x1=" + super.encapsulateAttribute(x1) 
        + " y1=" + super.encapsulateAttribute(y1) 
        + " x2=" + super.encapsulateAttribute(x2) 
        + " y2=" + super.encapsulateAttribute(y2));
    }
}