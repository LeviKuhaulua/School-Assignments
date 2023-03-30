public class Rectangle extends Shape implements Display {
    private double length, width; 

    public Rectangle(String color, String shapeName, double length, double width) {
        super(color, shapeName); 
        this.length = length; 
        this.width = width; 
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getArea() {
        return length * width; 
    }
    
    @Override
    public void show() {
        System.out.println(
            "Shape: " + super.getShapeName() + "\n"
            + "Color: " + super.getColor() + "\n"
            + "Area: " + getArea()
        );
    }
}