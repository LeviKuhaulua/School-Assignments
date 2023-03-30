/**
 * Demo for using and understanding how abstract classes work. 
 */
public class demo {
   
    public static void main(String[] args) {
        /* 
            Incorrect Syntax >> will throw an error message since Shape class is abstract 
            Shape aShape = new Shape("Blue", "Rectangle"); 
            Correct Syntax >> can only declare it but nothing else
            Shape aShape; 
        */

        Shape[] shapeArray = new Shape[4]; 
        shapeArray[0] = new Rectangle("Blue", "Rectangle", 3.5, 4.2); 
        shapeArray[1] = new Square("Violet", "Square", 3.5, 4.3, 2.75); 
        shapeArray[2] = new Square("Red", "Square", 5.6, 3.9, 4.20); 
        shapeArray[3] = new Rectangle("Green", "Rectangle", 9.1, 10.0); 


        /*
         * shapeArray[0].show() >> looks for the show() method in the Rectangle class
         * 
         */


        // Printing information of each element in shapeArray
            for (int i = 0; i < shapeArray.length; i++) {
                System.out.println("Shape " + (i + 1));
                shapeArray[i].show(); 
                System.out.println();
            }

        // What if you only wanted to show area? 
        
        /* 
            Incorrect Syntax >> shapeArray[i].getArea() because there doesn't exist a getArea method in Shape class
            for (int i = 0; i < shapeArray.length; i++) {
                System.out.println("Shape " + (i + 1));
                shapeArray[i].getArea(); 
                System.out.println();
            }
        */ 

        // Solution >> Type-Casting 
        Rectangle oneRectangle = (Rectangle) shapeArray[0]; 
        System.out.println(oneRectangle.getArea());
        System.out.println();



    }
}