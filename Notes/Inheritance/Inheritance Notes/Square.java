public class Square extends Rectangle {
    private double edge; 

    public Square(String color, String shapeName, double length, double width, double edge) {
        super(color, shapeName, length, width); 
        this.edge = edge; 
    }

    public void setEdge(double edge) {
        this.edge = edge;
    }

    public double getEdge() {
        return edge;
    }

    public double getArea() {
        return edge * edge; 
    }

    @Override 
    public void show() {
        System.out.println(
            "Shape: " + super.getShapeName()
            + "\nEdge Dimension: " + edge
            + "\nArea: " + getArea()
        );
    }
}