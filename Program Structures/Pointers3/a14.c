// Author: Levi Kuhaulua
// Date Created: 10-24-2024
/* Program Description:
*  The program will take an input through command line arguments 
*  that follows this format: PROGRAM NUM1 OPERATION NUM2. 
*  Using the arguments it will then evaluate the expression. 
*/

// Library and/or Macro Definitions
#include <stdio.h>
#include <stdbool.h>

// Function Prototypes
int add(int, int); 
int mult(int, int); 
int div(int, int); 
int sub(int, int); 

int main(int argc, char *argv[]){
    
    // Error checking to see if argument count is EXACTLY equal to 4 arguments. 
    if (argc != 4) {
        printf("Invalid number of arguments. Please have 4 arguments that follows this format\n"); 
        printf("./a14 num1 operation num2.\n* NOTE: num1 and num2 should be from 0-9.\n");
        return -1;  
    }

    // Error checking for invalid number arguments. Valid = 0-9
    int num1 = (int) argv[1][0] - '0'; 
    int num2 = (int) argv[3][0] - '0'; 

    if (num1 < 0 || num1 > 9) {
        printf("Invalid argument: %c\n", (num1 + '0')); 
        printf("Argument must be from 0-9.\nExiting Program..."); 
        return -1; 
    } 

    if (num2 < 0 || num2 > 9) {
        printf("Invalid argument: %c\n", (num2 + '0')); 
        printf("Argument must be from 0-9.\nExiting Program..."); 
        return -1; 
    }

    
    
    // What should run if 4 arguments are detected. 
    printf("Hello World");
    return 0;
}