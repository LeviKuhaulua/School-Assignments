// Author: Levi Kuhaulua
// Date Created: 10-06-2024
/* Program Description:
*  This program gets two numbers from the user. 
*  Then it will do some common math functions using ~Recursion~. 
*/

// Library and/or Macro Definitions

#include <stdio.h>
#include "getdouble.h"

// Function Prototypes

void displayRange(int start, int end); 
int addNums(int start, int end);
int multNums(int start, int end); 
int power(int num1, int num2); 


int main(void){

    // Grabbing input from user 
    printf("Enter two positive integers, separated by a space, the first smaller than the second: "); 
    int num1 = getdouble();  
    int num2 = getdouble(); 
    
    // Checking for invalid input. 
    if (num1 < 0 || num2 < 0) {
        printf("Invalid Input: Both numbers must be positive"); 
    } else if (num1 >= num2) {
        printf("Invalid Input: First number must be smaller than the second"); 
    } else {

        // Recursive Functions: 

        // Display Range
        printf("From %i to %i: ", num1, num2); 
        displayRange(num1, num2); 

        // Get Sum 
        int sum = addNums(num1, num2); 
        printf("Sum from %d to %d = %d\n", num1, num2, sum); 

        // Get Product
        int product = multNums(num1, num2); 
        printf("Product from %d to %d = %d\n", num1, num2, product); 

        // Calculate first number to the power of second number
        int powerCalc = power(num1, num2); 
        printf("%d to the power of %d = %d", num1, num2, powerCalc); 

    }

    

    return 0;
}

/*
 * Output integers from start to end. 
 * Start = first number inputted. 
 * End = second number inputted. 
 */
void displayRange(int start, int end) {
    // Base Case
    if (start == end) {
        printf("%i\n", end); 
    } else {
        // Recursive Call
        printf("%i ", start); 
        displayRange(start + 1, end); 
    }
}

/*
 * Recursive function to find the sum of integers from start to end. 
 */
int addNums(int start, int end) {
    int result = 0; 
    
    // Base Case
    if (start == end) {
        result = end; 
    } else {
        // Recursive Call
        result = start + addNums(start + 1, end);
    }

    return result; 
}

/*
 * Recursive function to get the product of integers from start to end. 
 */
int multNums(int start, int end) {
    int result = 0; 

    // Base Case
    if (start == end) {
        result = end; 
    } else {
        // Recursive Call
        result = start * multNums(start + 1, end); 
    }

    return result; 
}

/*
 * Recursive function for calculating the first number to the power of the second number
 */
int power(int num1, int num2) {
    int result = 0; 

    // Base Case
    if (num2 == 0) {
        result = 1;  
    } else {
        // Recursive Call
        result = num1 * power(num1, num2 - 1); 
    }

    return result; 

}