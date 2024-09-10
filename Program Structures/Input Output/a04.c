// Author: Levi Kuhaulua
// Date Created: 09-09-2024
/* Purpose: 
*  Program will prompt user for two characters and display them, 
*  then prompt for two numbers and display them. 
*/

#include <stdio.h>
#include "getdouble.h"

int main(void) {

    // Getting the letters and displaying them. 
    printf("Enter a letter: "); 
    char firstLetter = getchar(); 
    printf("The 1st letter entered was: %c \n", firstLetter); 

    // Removes the newline character from input stream
    getchar(); 

    printf("Enter another letter: "); 
    char secondLetter = getchar(); 
    printf("The 2nd letter entered was: %c \n", secondLetter); 

    // Removes the newline character from input stream
    getchar(); 


    // Prompt for numbers and output them
    printf("Enter a number: "); 
    double num1 = getdouble(); 
    printf("The 1st number entered was: %f \n", num1); 

    printf("Enter another number: "); 
    double num2 = getdouble(); 
    printf("The 2nd number entered was: %f \n", num2); 

    return 0; 
}