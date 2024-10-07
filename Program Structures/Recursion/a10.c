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



int main(void){

    // Grabbing input from user 
    printf("Enter two positive integers, separated by a space, the first smaller than the second: "); 
    double num1 = getdouble();  
    double num2 = getdouble(); 
    
    // Checking for invalid input. 
    if (num1 < 0 || num2 < 0) {
        printf("Invalid Input: Both numbers must be positive"); 
    } 

    if (num1 > num2) {
        printf("Invalid Input: First number must be smaller than the second"); 
    }
    
    return 0;
}


