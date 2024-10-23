// Author: Levi Kuhaulua
// Date Created: 10-22-2024
/* Program Description:
*  Learning how to use pointers in C. The program will 
*  output the memory address and value of the variables
*  via pointers. This program will also update the value of 
*  the variables using pointers. 
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

    // Outputting memory address of variables via pointers
    printf("Memory Address of char letter via pointer: 0x%p\n", charPointer); 
    printf("Memory Address of int num via pointer: 0x%p\n", numPointer);
    printf("Memory Address of double aDouble via pointer: 0x%p\n", doublePointer);

    printf("\n"); 

    // Outputting values associated with variables via pointers
    printf("Value of char letter via pointer: %c\n", *charPointer); 
    printf("Value of int num via pointer: %i\n", *numPointer); 
    printf("Value of double aDouble via pointer: %.2f\n", *doublePointer); 

    // Adding 3 to the values of variables via pointers
    *charPointer += 3; 
    *numPointer += 3; 
    *doublePointer += 3; 

    printf("\n"); 

    // Outputting the new values of the pointer
    printf("New value of char letter via pointer: %c\n", *charPointer); 
    printf("New value of int num via pointer: %i\n", *numPointer); 
    printf("New value of double aDouble via pointer: %.2f\n", *doublePointer); 

    printf("\n");

    // Outputting the values of the three variables
    printf("Value of char letter: %c\n", letter); 
    printf("Value of int num: %i\n", num); 
    printf("Value of double aDouble: %.2f\n", aDouble); 

    return 0;
}