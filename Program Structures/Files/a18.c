// Author: Levi Kuhaulua
// Date Created: 11-12-2024
/* Program Description:
*  Given an existing Random-Access File, the program will allow the user to edit 
*  the data located inside the file and update. 
*/

// Library and/or Macro Definitions
#include <stdio.h>
#include <stdlib.h>
#include "getdouble.h"
#include "student.h"

// Function Prototypes

// Other things to declare

int main(void){
    FILE *filePointer = NULL; 
    char *fileName = "students.data"; 

    printf("Welcome! This program edits the \"%s\" file. Opening the file right now...\n", fileName); 

    // Pointing to the file to edit. 
    filePointer = fopen(fileName, "rb+"); 

    // Checking to see if file exists
    if (filePointer == NULL) {
        printf("File \"%s\" does not exist. Did you run \"create-records.exe\"? \n", fileName); 
        return 0; 
    } 

    printf("File opened successfully!\n"); 

    // Closing file
    if (fclose(filePointer) == 0) {
        printf("Closed file \"%s\" successfully!\n", fileName); 
    } else {
        printf("Did not close \"%s\" successfully...", fileName); 
    }
    return 0;
}