// Author: Levi Kuhaulua
// Date Created: 11-26-2024
/* Program Description:
*  Extends the Complex class by overloading the following operators: 
*  arithmetic operations, >> (cin), << (cout), ==, and != operators. 
*  This will help make the Complex Data Type more flexible and allows 
*  for more abstraction. 
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
            real += c.real;
            imaginary += c.imaginary;
            return Complex(real, imaginary); 
        }

        /* Subtracts two complex expressions. 
        *  Parameters: 
        *  - c, Complex Data Type
        */
        Complex sub(const Complex &c) {
            real -= c.real;
            imaginary -= c.imaginary;
            return Complex(real, imaginary); 
        }

        /* Multiply two complex expressions. 
        *  Parameters: 
        *  - c, Complex Data Type
        */
        Complex multiply(const Complex &c) {
            double r = real; 
            real = (real * c.real) - (imaginary * c.imaginary);
            
            // r = initial value of real number BEFORE we performed arithmetic operation.
            imaginary = (imaginary * c.real) + (r * c.imaginary); 
            return Complex(real, imaginary); 
        }
        
        /* Divides two complex expressions.
        *  Parameters: 
        *  - c, Complex Data Type
        */
        Complex divide(const Complex &c) {
            double r = real; 
            double denominator = c.real * c.real + c.imaginary * c.imaginary;
            real = (real * c.real + imaginary * c.imaginary) / denominator;

            // r = initial value of real number BEFORE we performed arithmetic operation.
            imaginary = (imaginary * c.real - r * c.imaginary) / denominator; 
            return Complex(real, imaginary); 
        }

    // Private Data Members
    private: 
        double real; 
        double imaginary; 
};


int main(void){
    cout << "Hello World!";
    return 0;
}