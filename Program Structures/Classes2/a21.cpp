// Author: Levi Kuhaulua
// Date Created: 11-26-2024
/* Program Description:
*  Continuation of Complex Class. This time it will
*  implement the logic for arithmetic operations for 
*  complex expressions. 
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
        
        /*
        * Creates a copy of a complex expression. 
        * Parameters: 
        * - complex, Complex Data Type
        */
        Complex(const Complex &complex) {
            real = complex.real;
            imaginary = complex.imaginary;
        }

        /*
        *  Destructor for complex expressions. Prints the expression that is being released. 
        */
        ~Complex() {
            cout << "Releasing memory of: \n";
            print();
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

int main(void){
    
    // Testing Constructor with Arguments
    cout << "Instantiating Complex Constructor with Arguments\n";
    Complex c2 = Complex(2.75, -10.5);
    c2.print();
    
    cout << "\n";

    // Testing Copy Constructor
    cout << "Instantiating Complex Copy Constructor\n";
    Complex c3 = Complex(c2);
    c3.print();

    // This last line break is to space out the destructors
    cout << "\n\n";
    return 0;
}