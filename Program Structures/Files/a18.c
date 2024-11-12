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

void printRecords(FILE *file, Student); 


int main(void){
    FILE *filePointer = NULL; 
    char *fileName = "students.data"; 

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

    // Load up file contents. 
    printRecords(filePointer, student); 


    // Closing file
    if (fclose(filePointer) == 0) {
        printf("Closed file \"%s\" successfully!\n", fileName); 
    } else {
        printf("Did not close \"%s\" successfully...", fileName); 
    }
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