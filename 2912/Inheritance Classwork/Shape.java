
public class Shape {
    private String color, shapeName; 

    public Shape(String color, String shapeName) {
        this.color = color; 
        this.shapeName = shapeName; 
    }

    public String getColor() {
        return color; 
    }

    public String getShapeName() {
        return shapeName; 
    }

    public void setColor(String color) {
        this.color = color; 
    }

    public void setShapeName(String shapeName) {
        this.shapeName = shapeName; 
    }

    public void show() {
        System.out.println("Color: " + color + "\nShape: " + shapeName); 
    }
}
