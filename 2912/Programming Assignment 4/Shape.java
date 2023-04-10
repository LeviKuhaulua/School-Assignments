import java.io.PrintStream;
import java.util.*;
public abstract class Shape {
    // Field containing the styles of each Shape 
    private ArrayList<String> styles; 


    public Shape(ArrayList<String> styles) {
        this.styles = styles; 
    }

    /**
     * renderAttributes - abstract method for printing out the attributes to Standard Output 
     * @param out - where it should print out the attribute information
     */
    public abstract void renderAttributes(PrintStream out); 

    /**
     * render - prints out the style sheet for each Shape object 
     * @param out
     */
    public void render(PrintStream out) {
        out.println(styles); 
    }

    /**
     * addStyle - adds the object's style to the list
     * @param key - the type of style
     * @param value - dimensions of the style 
     */
    public void addStyle(String key, String value) {
        styles.add(key); 
        styles.add(value);
    }
}