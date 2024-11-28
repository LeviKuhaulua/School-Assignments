// Author: Levi Kuhaulua
// Date Created: 11-27-2024
/* Program Description:
*  Creating two classes to demonstrate object inheritance in classes.
*  A circle class and a cylinder class that is derived from / inherits it's 
*  parent class, the circle. 
*/


#include <iostream>

// Error checking for negative values
#include <stdexcept>
using namespace std;
 
class Circle {
    
    public: 
        
        static constexpr double PI = 3.1415926;
        
        // Initializes a Circle with a radius of 0
        Circle() {
            radius = 0; 
        } 
        
        // Initializes a Circle with radius 'r'
        Circle(double r) {
            setRadius(r);
        }
        
        // Copy constructor that initializes a Circle based on another Circle's radius
        Circle(const Circle &c) {
            setRadius(c.radius);
        }
        
        // Sets a Circle's radius to r 
        void setRadius(double r) {
            // Error checking to see if radius that is passed is negative
            if (isNegativeRadius(r)) {
                throw invalid_argument("Radius cannot be negative!");
            }
            radius = r; 
        }
        
        // Returns the radius
        double getRadius() {
            return radius;
        }
        
        // Calculates the area of a circle. Formula: PI * r * r
        double calculateArea() {
            return PI * radius * radius;
        }
        
        // Prints out a Circle's information (in this case, it's radius)
        void print() const {
            cout << "Circle with Radius " << radius << "\n";
        }

    protected: 
        double radius; 
    
    private: 
        // Returns true if the radius is negative, otherwise, false
        bool isNegativeRadius(double r) {
            return r < 0;
        }
};


// Cylinder class. Derived from Circle class
class Cylinder: public Circle {
    
    public: 
        
        // Initializes a Cylinder with radius and height of 0
        Cylinder():Circle() {
            // Radius is set by super constructor
            height = 0; 
        }
        

        // Creates a Cylinder with radius r and height h
        Cylinder(double r, double h):Circle(r) {
            // Radius is set by super constructor
            setHeight(h);
        }
        

        // Creates a new Cylinder based on dimensions of another Cylinder
        Cylinder(const Cylinder &cy) { 
            Circle::setRadius(cy.radius);
            setHeight(cy.height);
        }
        

        // Sets the height of the cylinder
        void setHeight(double h) {
            if (isNegativeHeight(h)) {
                throw invalid_argument("Height cannot be negative!");
            }
            height = h;
        }
        
        // Returns the height of the cylinder
        double getHeight() {
            return height; 
        }

        /*
        *  It's okay to not have setRadius or getRadius method for Cylinder class since 
        *  that is essentially the same as the Base Class version
        */

       //  Function Override of Base Class. Finds the total surface area of the Cylinder
       double calculateArea() {
            double bases = 2 * Circle::calculateArea();
            double lateral = 2 * PI * radius * height;
            return bases + lateral; 
        }
        
       // Calculates the volume of a cylinder. Formula: PI * r * r * h
       double calculateVolume() {
            return Circle::calculateArea() * height;
       } 

       // Prints Cylinder information, radius and height
       void print() const {
            cout << "Cylinder with radius " << radius << " and height " << height << "\n";
       }

    private: 
        // No other derived classes, so we can leave this as private
        double height;
        
        // Returns true if height is negative, otherwise false
        bool isNegativeHeight(double h) {
            return h < 0;
        }
};


int main(void){
    
    // Testing Circle
    Circle a(3.75);
    a.print(); 
    cout << "Area: " << a.calculateArea() << "\n";
    
    // Changing radius and getting a new one
    cout << "Changing radius\n";
    a.setRadius(5);
    cout << "New Radius: " << a.getRadius() << "\n";

    cout << "\n\n";
    
    // This will throw an error
    // Circle b(-3.75);
    
    // Testing Cylinder
    cout << "Testing Cylinders\n";
    Cylinder b = Cylinder(3, 4);
    b.print();

    // Setting new radius and height and calculating area
    b.setHeight(5);
    b.setRadius(2);
    cout << "Changing height and radius...\n" << "New Expression: ";
    b.print(); 
    cout << "Area of Cylinder: " << b.calculateArea() << "\n";
    cout << "\n\n";


    // Copy constructor, grabbing radius and height, and calculating volume
    cout << "Creating Copy...\n";
    Cylinder c = Cylinder(b); 
    cout << "Radius of Copy: " << c.getRadius() << "\n";
    cout << "Height of Copy: " << c.getHeight() << "\n";
    cout << "Volume of Copy: " << c.calculateVolume() << "\n";  
    
    return 0;
}