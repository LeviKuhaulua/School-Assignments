/*
 * Learning the difference between interfaces and abstract classes
 */

public class interfaceDemo {
    public static void main(String[] args) {
        Display[] shapeArray = new Display[4]; 
        shapeArray[0] = new Rectangle("Blue", "Rectangle", 5.3, 3.5); 
        shapeArray[1] = new Square("Green", "Square", 3, 2, 4.3); 
        shapeArray[2] = new Square("Purple", "Square", 1, 2, 3.69); 
        shapeArray[3] = new Rectangle("Violet", "Rectangle", 3, 12); 

        /*
         * shapeArray data type: Display
         * In Display.java there contains the only method show() 
         * for each element in shapeArray >> look for the show method in that particular subclass implementing the interface 
         */
        for (int i = 0; i < shapeArray.length; i++) {
            System.out.println("Shape " + (i + 1));
            shapeArray[i].show(); 
            System.out.println();
        }

        
        /*
            shapeArray[0].getArea(); | Error Message >> getArea() is undefined for Display type. 
            This is because there is no getArea() method in Display file. Either add in getArea() method
            or create a new interface with that method in mind. 
        */
        
    }
}