public class Circle extends Shape {
    private double radius; 

    public Circle(String color, String shapeName, double radius) {
        super(color, shapeName); 
        this.radius = radius; 
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        final double pi = 3.14;
        return pi * (radius * radius); 
    }

    @Override 
    public void show() {
        System.out.println("Color: " + super.getColor() + "\nShape: " + super.getShapeName() + "\nArea: " + getArea());
    }

}