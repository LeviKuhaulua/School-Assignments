/**
 * Learning how Abstract classes work. 
 * 
 * Keyword >> abstract - placed after the accessifier 
 * 
 * Abstract Classes have abstract methods >> method head and signature but no body
 *  - Each sub-class will need to have the method in there with the code related to that method 
 *     - See show() in this class and then the show() in Rectangle 
 * See demo file to learn how the abstract method works. 
 * 
 */

public abstract class Shape {
    private String color, shapeName; 

    public Shape(String color, String shapeName) {
        this.color = color; 
        this.shapeName = shapeName; 
    }

    public void setColor(String color) {
        this.color = color; 
    }

    public void setShapeName(String shapeName) {
        this.shapeName = shapeName; 
    }

    public String getColor() {
        return color; 
    }

    public String getShapeName() {
        return shapeName; 
    }

    public abstract void show();
}