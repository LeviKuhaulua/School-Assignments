import java.io.PrintStream;
import java.util.*;
public abstract class Shape {
    // Field containing the styles of each Shape 
    private ArrayList<String> styles = new ArrayList<>(); 



    /**
     * renderAttributes - abstract method for printing out the attributes to Standard Output 
     * @param out - where it should print out the attribute information
     */
    public abstract void renderAttributes(PrintStream out); 

    /**
     * render will print out the shape's attributes and style 
     * @param out - where the data should be outputted
     */
    public void render(PrintStream out) {
        out.print("<");
        renderAttributes(out); 
        out.print(" "); 
        out.print("style='"); 
        // Adding each style for the shape
        for (int i = 0; i < styles.size(); i++) {
            if (i % 2 != 0) out.print(styles.get(i).concat(";")); 
            else out.print(styles.get(i).concat(":")); 
             
        }
        out.print("'/>"); 
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

    /**
     * encapsulateAttribute will take an attribute of a svg or shape tag and then encapsulate it with single quotation marks 
     * @param attribute or the field to create the tag 
     * @return the attribute encapsulated with single quotations 
     */
    public static String encapsulateAttribute(double attribute) {
        return "'" + attribute + "'"; 
    }
}