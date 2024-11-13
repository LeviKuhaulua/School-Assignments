// Author: Levi Kuhaulua
// Date Created: 11-12-2024
/* Program Description:
*  Given an existing Random-Access File, the program will allow the user to edit 
*  the data located inside the file and update. 
*/

// Library and/or Macro Definitions
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h> 
#include <stdbool.h> 
#include "getdouble.h"
#include "student.h"
#include "stringinput.h"

void printRecords(FILE *file, Student); 
void closeFile(FILE *file); 


int main(void){
    FILE *filePointer = NULL; 
    char *fileName = "students.data";  
    bool doneEditing = false; 
    int rowEdit = -1; 
    char editAns = 0; 
    int fieldEditAns = -1; 
    char rowEditAns[MAX] = {'\0'}; 

    // To hold student records pulled from file. 
    Student student = {-1, "", "", 0, 0.0}; 

    printf("Welcome! This program edits the \"%s\" file. Opening the file right now...\n", fileName); 

    // Pointing to the file to edit. 
    filePointer = fopen(fileName, "rb+"); 

    // Checking to see if file exists
    if (filePointer == NULL) {
        printf("File \"%s\" does not exist. Did you run \"create-records.exe\"? \n", fileName); 
        return 0; 
    } 

    // Initial Load: Show file records. 
    printRecords(filePointer, student); 

    do {

        // Asking user if they would like to edit the file. 
        printf("Would you like to edit? (Press 'y' or 'Y' for yes or 'n' or 'N' for no): "); 
        editAns = tolower(getchar()); 

        if (editAns == 'n') {
            printf("Exiting program..."); 
            doneEditing = true; 
        }

        getchar(); 

        // Error checking
        while (!(isalpha(editAns)) || (editAns != 'y' && editAns != 'n')) {
            printf("Invalid input: %c\n", editAns); 

            // Re-prompt for input
            printf("Please enter 'y' or 'Y' for yes or 'n' or 'N' for no: "); 
            editAns = tolower(getchar()); 

            // Skip new-line character. 
            getchar(); 

        }
    } while (!doneEditing);
    
    

    closeFile(filePointer); 
    return 0;
}

/** Prints out all valid records in the file. 
 *  Params: 
 *  - file, FILE struct pointer 
 *  - student, Student struct
 */
void printRecords(FILE *file, Student student) {
    // Record Headers
    printf("\nNumber   FirstName    LastName  Age  GPA  \n"); 
    printf("------   ---------    --------  ---  ---  \n");

    // Printing out students information if it is a valid record
    while (feof(file) == 0) {
        if (fread(&student, sizeof(Student), 1, file) == 1 && student.number != -1) {
            printf("%6d  %10s  %10s  %3d  %3.1f  \n", 
                student.number,
                student.first, 
                student.last,
                student.age,
                student.gpa); 
        }
    }
}


void closeFile(FILE *file) {
    // If error occurs, then that means pointer is already pointing to end. 
    fseek(file, 0, SEEK_END); 
    fclose(file);
}
