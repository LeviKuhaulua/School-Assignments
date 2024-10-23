// Author: Levi Kuhaulua
// Date Created: 10-22-2024
/* Program Description:
*  The program utilizes pointers and arrays to understand their 
*  relationship. We will use a function with a call-by-reference parameter
*  and manipulate the value. For arrays, it will go over the different ways to 
*  access array elements using different notations and also output the memory address. 
*/

// Library and/or Macro Definitions
#include <stdio.h>

// Function Prototypes
void addNum(int *number); 

int main(void){
    // Declaring int variable and pointer to variable. 
    int number = 100; 
    int *numPointer = &number;

    // Display value of variable BEFORE function call
    printf("Value of int number: %i\n", *numPointer);  

    // Calling function with pass-by-reference param
    addNum(numPointer); 

    // Displaying value of variable AFTER function call.
    printf("Value of int number AFTER function call: %i\n", *numPointer); 

    // Creating integer array with five values and pointer for array. 
    int fib[] = {1, 1, 2, 3, 5};
    int *fibPointer = fib; 

    printf("\n\n"); 

    /* 
    *  Display 5th element of array using four different notations: 
    *  Array Subscript
    *  Pointer Offset
    *  Array Subscript via Pointer
    *  Pointer Offset via Pointer
    */
    printf("5th element in fib array using array subscript: %i\n", fib[4]); 
    printf("5th element in fib array using pointer offset: %i\n", *(fib + 4)); 
    printf("5th element in fib array using array subscript (pointer): %i\n", fibPointer[4]);
    printf("5th element in fib array using pointer offset (pointer): %i\n", *(fibPointer + 4));  

    return 0;
}

/* addNum function:
 * Simple function that will add 10 to a number. 
 * Parameters: 
 * - number, an int; pass-by-reference. 
 */
void addNum(int *number) {
    // Display value of variable before doing manipulation. 
    printf("Value of int number inside function BEFORE manipulating value: %i\n", *number); 

    // Doing the actual manipulation
    *number += 10;

    // Displaying the value of variable after doing manipulation
    printf("New value of int number AFTER manipulating value: %i\n", *number); 

}