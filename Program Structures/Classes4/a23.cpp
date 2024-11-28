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
            radius = c.radius; 
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


    private: 
        // No other derived classes, so we can leave this as private.
        double height;
};


int main(void){
    Circle a(3);
    cout << a.calculateArea();
    
    return 0;
}