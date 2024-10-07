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
        printf("Sum from %d to %d = %d", num1, num2, sum); 

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
