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
            cout << "Destructor: ";
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
        
        /* Adds two complex expressions.
        *  Parameters: 
        *  - c, Complex Data Type
        */
        Complex add(const Complex &c) {
            return Complex(real + c.real, imaginary + c.imaginary); 
        }

        /* Subtracts two complex expressions. 
        *  Parameters: 
        *  - c, Complex Data Type
        */
        Complex sub(const Complex &c) {
            return Complex(real - c.real, imaginary - c.imaginary); 
        }

        /* Multiply two complex expressions. 
        *  Parameters: 
        *  - c, Complex Data Type
        */
        Complex multiply(const Complex &c) {
            double newReal = (real * c.real) - (imaginary * c.imaginary);
            double newImaginary = (imaginary * c.real) + (real * c.imaginary); 
            return Complex(newReal, newImaginary); 
        }
        
        /* Divides two complex expressions.
        *  Parameters: 
        *  - c, Complex Data Type
        */
        Complex divide(const Complex &c) {
            // Variables to store new values of Complex Expressions
            double denominator = c.real * c.real + c.imaginary * c.imaginary;
            double newReal = (real * c.real + imaginary * c.imaginary) / denominator;
            double newImaginary = (imaginary * c.real - real * c.imaginary) / denominator; 
            return Complex(newReal, newImaginary); 
        }

    // Private Data Members
    private: 
        double real; 
        double imaginary; 
};

int main(void){
    
    // Testing Constructor with Arguments
    cout << "Instantiating Complex Constructor with Arguments\n";
    Complex c1 = Complex(1.1, 2.3);
    c1.print();
    
    cout << "\n";

    // Testing Copy Constructor
    cout << "Instantiating Complex Copy Constructor\n";
    Complex c2(c1);
    c2.print();
    
    cout << "\n"; 

    // Testing Adding Function
    cout << "Adding Both Expressions\n";
    Complex c3 = c1.add(c2);
    cout << "New Expression: "; 
    c3.print(); 

    cout << "\n"; 

    // Testing Subtracting Function
    cout << "Subtracting Both Expressions\n";
    Complex c4 = c1.sub(c2); 
    cout << "New Expression: ";
    c4.print(); 

    cout << "\n"; 

    // Testing Multiply Function
    cout << "Multiplying Both Expressions\n"; 
    Complex c5 = c1.multiply(c2);  
    cout << "New Expression: ";
    c5.print(); 
    
    cout << "\n"; 

    // Testing Divide Function
    cout << "Dividing both expressions\n";  
    Complex c6 = c1.divide(c2);
    cout << "New Expression: "; 
    c6.print(); 

    // This last line break is to space out the destructors
    cout << "\n\n";
    return 0;
}