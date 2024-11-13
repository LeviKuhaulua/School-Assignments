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
    int fieldEdit = -1; 

    char *userInput[3] = {"\0"}; 
    int sizeName = 0; 
    int age = 0; 
    double gpa = 0.0; 
    char dummyString[MAX_STRING] = {'\0'}; 
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
            break; 
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

        // Grab student record
        printf("Enter number that you would like to edit: "); 
        rowEdit = (int) getdouble(); 
    
        // Pulls record to student variable 
        fseek(filePointer, (rowEdit * sizeof(Student)), SEEK_SET);
        fread(&student, sizeof(Student), 1, filePointer); 
        
        // If invalid record, then prompt user to enter a valid record number to edit. 
        while (student.number == -1) {
            printf("Invalid record entered: %i\n", rowEdit); 
            printf("Please enter a valid record number: "); 
            rowEdit = getdouble(); 
            
            fseek(filePointer, rowEdit * sizeof(Student), SEEK_SET); 
            fread(&student, sizeof(Student), 1, filePointer); 
        }

        // Print out specific information of that student. 
        printf("%6d  %10s  %10s  %3d  %3.1f  \n", 
                student.number,
                student.first, 
                student.last,
                student.age,
                student.gpa); 

        // Prompt user for what field to edit. 
        printf("Enter one of these numbers to edit a field: \n"); 
        printf("- (1) first name\n"); 
        printf("- (2) last name\n");
        printf("- (3) age\n"); 
        printf("- (4) gpa\n"); 

        fieldEdit = (int) getdouble(); 

        // Check if what user entered was invalid. 
        while (fieldEdit < 1 || fieldEdit > 4) {
            printf("Invalid Input: %i\n", fieldEdit + 1); 
            printf("Enter (1) for first name, (2) for last name, (3) for age, or (4) for gpa: "); 
            fieldEdit = (int) getdouble(); 
        }

        // Edit specific field information
        switch (fieldEdit) {
            // First two cases (1) and (2) deal with editing name fields. 
            case 1: 
                sizeName = getstring(student.first, MAX_STRING); 
                while (sizeName > MAX_STRING - 2) {
                    printf("Invalid input. First name cannot be longer than %d characters\n", MAX_STRING - 2);
                    getline2(dummyString, MAX_STRING); 
                    sizeName = getstring(student.first, MAX_STRING); 
                }
                break; 
            case 2: 
                sizeName = getstring(student.last, MAX_STRING); 
                while (sizeName > MAX_STRING - 2) {
                    printf("Invalid input. Last name cannot be longer than %d characters\n", MAX_STRING - 2); 
                    sizeName = getstring(student.last, MAX_STRING); 
                }
                break; 
            // Last two cases deal with editing number fields. 
            case 3: 
                printf("Age: ");
                age = (int) getdouble(); 
                while (age <= 0) {
                    printf("Invalid input: %i\n", age); 
                    printf("Age: "); 
                    age = (int) getdouble(); 
                } 
                student.age = age; 
                break; 

            case 4: 
                printf("GPA: "); 
                gpa = getdouble(); 
                while (gpa <= 0) {
                    printf("Invalid input: %.2f\n", gpa); 
                    gpa = getdouble(); 
                }
                student.gpa = gpa; 
                break; 

            // This shouldn't occur... 
            default: 
                printf("Editing a non-existent field"); 
                return -1; 
        }

        // Writing updates to a file. 
        fseek(filePointer, rowEdit * sizeof(Student), SEEK_SET); 
        fwrite(&student, sizeof(Student), 1, filePointer); 
        rewind(filePointer); 
        printRecords(filePointer, student); 


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
