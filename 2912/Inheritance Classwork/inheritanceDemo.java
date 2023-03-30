public class inheritanceDemo {
    public static void main(String[] args) {
        Shape shapeOne = new Shape("Red", "Circle"); 
        shapeOne.show(); 

        System.out.println();
        Rectangle rectangleOne = new Rectangle("Blue", "Rectangle", 3.0, 4.0);
        rectangleOne.show(); 

        System.out.println();
        Square squareOne = new Square("Green", "Square", 6.0, 6.0, 6.0); 
        squareOne.show(); 

        System.out.println();
        Circle circleOne = new Circle("Light-Blue", "Circle", 5.0); 
        circleOne.show(); 
    }
}