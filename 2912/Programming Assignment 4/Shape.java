import java.io.PrintStream;
import java.util.*;
import java.io.PrintStream; 
public abstract class Shape {
    private ArrayList<String> styles; 


    public Shape(ArrayList<String> styles) {
        this.styles = styles; 
    }

    // abstract void renderAttributes(PrintStream out); 
}