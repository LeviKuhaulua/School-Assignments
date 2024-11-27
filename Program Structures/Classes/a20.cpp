// Author: Levi Kuhaulua
// Date Created: 11-26-2024
/* Program Description:
*  Creates a class labeled Complex that allows users to 
*  perform arithmetic operations with complex numbers. 
*/


#include <iostream>
#include <cmath> 
using namespace std; 

class Complex {
    // Public Methods
    public: 
        
        /* Defines a Complex expression with parameters to specify the real number and imaginary number.
        *  Parameters: 
        *  r - double 
        *  i - double
        */
        Complex(double r, double i) {
            real = r;
            imaginary = i;
        }
        
        /* 
        *   Defines a Complex expression with default values of 0 for the real and imaginary number.
        */
        Complex() {
            real = 0.0;
            imaginary = 0.0;
        }
        
        /*  Set the real and imaginary numbers to the new arguments. 
        *   Parameters: 
        *   r - double,
        *   i - double 
        */
        void setNumbers(double r, double i) {
            real = r; 
            imaginary = i; 
        }
        
        /* 
        *  Returns the real number in the complex expression
        */
        double getReal() {
            return real;
        }
        
        /*
        *  Returns the imaginary number in the complex expression
        */
        double getImaginary() {
            return imaginary;
        }
        
        // Prints out the complex expression 
        void print() const {
            if (imaginary < 0) {
                // absolute value is used so that complex expression does not look like this: a - -bi
                cout << real << " - " << abs(imaginary) << "i\n";
            } else {
                cout << real << " + " << imaginary << "i\n";
            }
        }

    // Private Data Members
    private: 
        
        double real; 
        double imaginary; 
};

int main(void) {
    
    // Testing with no argument constructor
    cout << "Testing No Argument Constructor and Print Function\n";
    Complex c1 = Complex();
    cout << "Complex Expression: ";
    c1.print();
    
    cout << "\n\n";

    // Testing with arguments constructor. This will also test for negative numbers
    cout << "Testing Argument Constructor with Accessor Methods\n"; 
    Complex c2 = Complex(1.0, -1.75);
    cout << "Complex Expression: "; 
    c2.print(); 
    
    // Testing accessor methods
    cout << "Real Number: " << c2.getReal() << "\n";
    cout << "Imaginary Number: " << c2.getImaginary() << "\n";
    
    cout << "\n\n";
    
    // Testing mutator methods.
    Complex c3 = Complex(10.0, 0.0);
    cout << "Complex Expression: ";
    c3.print();  

    cout << "Changing Numbers to 100\n"; 
    c3.setNumbers(100, 100);
    cout << "New Complex Expression: ";
    c3.print(); 
    
    return 0;
}