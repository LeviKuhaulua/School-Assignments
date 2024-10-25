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

    int (*functionArr[5])(int, int) = {add, NULL, sub, mult, div}; 
    
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

    // Error checking for operation argument. Valid = '+', '-', '/', '.'
    int operation = (int) argv[2][0] - '+'; 

    switch(operation) {
        case 0: case 2: case 3: case 4: 
            break; 
        default: 
            printf("Invalid operation: %c\n", (operation + '+')); 
            printf("Valid operation: '+', '-', '/', '.'\nExiting Program...\n");
            return -1; 
    }

    // Error checking to see if we're dividing by 0. 
    if (operation == 4 && num2 == 0) {
        printf("Error: Cannot divide by 0\n"); 
        return -1; 
    }

    /*
    * Function call will execute the appropriate function based on the operation, and it will output
    * the first part of the expression. Function call also returns the result of the expression, which is what
    * is being inputted into the printf statement. 
    */
    printf("%i\n", functionArr[operation](num1, num2)); 
    return 0;
}

/* add
 * Output the beginning part of expression and return the sum. 
 * Params: 
 * - arg1, integer 
 * - arg2, integer
 */
int add(int arg1, int arg2) {
    printf("%i + %i = ", arg1, arg2); 
    return arg1 + arg2; 
}

/* sub
 * Output the beginning part of expression and return the difference. 
 * Params: 
 * - arg1, integer
 * - arg2, integer
 */
int sub(int arg1, int arg2) {
    printf("%i - %i = ", arg1, arg2); 
    return arg1 - arg2; 
}

/* mult
 * Output the beginning part of expression and return the product. 
 * Params: 
 * - arg1, integer
 * - arg2, integer
 */
int mult(int arg1, int arg2) {
    printf("%i * %i = ", arg1, arg2); 
    return arg1 * arg2; 
}

/* div
* Output the beginning part of expression and return the quotient.
* Params: 
* - arg1, integer
* - arg2, integer
*/
int div(int arg1, int arg2) {
    printf("%i / %i = ", arg1, arg2); 
    return arg1 / arg2; 
}