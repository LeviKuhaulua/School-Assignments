/*
 * Interfaces are a lot like abstract classes
 * Keyword >> interface - replaces the class keyword in file 
 * 
 * Interfaces have their own methods - contain no body 
 * These methods work the same as abstract methods for the abstract classes 
 *   - see Shape.java for notes on abstract methods 
 * Variables in the interface MUST contain keywords static and final 
 *   - doesn't really make sense to use variables in interface
 * 
 * To have a class use an interface >> have the class use implement keyword
 *   - see Rectangle.java 
 * 
 * IMPORTANT NOTE: Can only use the methods in interface
 * using methods outside of interface file will result in an error. 
 * see interfaceDemo.java
 * 
 */

public interface Display {
    
    public void show();
}