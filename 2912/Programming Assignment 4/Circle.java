import java.io.PrintStream;
public class Circle extends Shape {
    private double cx, cy, r; // fields for circle in svg tag 

    /**
     * Circle is the constructor to create a circle object taking in the parameters for the x and y dimensions
     * and the radius dimension
     * @param cx - cartesian x point
     * @param cy - cartesian y point
     * @param r - radius of circle 
     */
    public Circle(double cx, double cy, double r) {
        this.cx = cx; 
        this.cy = cy; 
        this.r = r; 
    }

    /**
     * renderAttributes will help with formatting the attributes inside the circle tag
     * @param out - a PrintStream for where the SVG tag and it's contents should be outputted 
     */
    public void renderAttributes(PrintStream out) {
        out.print(
            "circle "
            + "cx=" + super.encapsulateAttribute(cx)
            + " cy=" + super.encapsulateAttribute(cy)
            + " r=" + super.encapsulateAttribute(r)
        );
    }
}