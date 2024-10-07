// Author: Levi Kuhaulua
// Date Created: 10-06-2024
/* Program Description:
*  This program gets two numbers from the user. 
*  Then it will do some common math functions using ~Recursion~. 
*/

// Library and/or Macro Definitions

#include <stdio.h>
#include <stdbool.h>
#include "getdouble.h"

// Function Prototypes

bool validInputs(double num1, double num2);

int main(void){
    printf("Enter a number: "); 
    double num = getdouble(); 
    printf("Number entered: %.2f\n", num); 
    return 0;
}
