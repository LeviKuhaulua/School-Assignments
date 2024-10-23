// Author: Levi Kuhaulua
// Date Created: 10-22-2024
/* Program Description:
*  Learning how to use pointers in C. The program will 
*  output the memory address of three variables and change 
*  the values of the variables via pointers. 
*/

// Library and/or Macro Definitions
#include <stdio.h>


int main(void){

    // Declaring char, int, and double variable and assigning them value.
    char letter = 'a'; 
    int num = 25;
    double aDouble = 1.00; 

    // Declaring pointers to point to their specific variables
    char *charPointer = &letter; 
    int *numPointer = &num; 
    double *doublePointer = &aDouble; 

    

    return 0;
}