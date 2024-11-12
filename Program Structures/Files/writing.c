/*
Writes to a file with 20 fixed-length records
*/
#include <stdio.h>   
#include <stdlib.h>
#include "student.h"
#include "getdouble.h"
#include "stringinput.h"

void printStudent(Student);
  
int main(){   
   Student studentX = {-1, "", "", 0, 0.0 };      
   FILE *filePointer = NULL;    
   char *fileName = "students.data";
   int fileClosed = 0;  
   int seekError = 0;
   int writeError = 0;
   int sizeFirstName = 0;
   int sizeLastName = 0;
   char dummyString[MAX_STRING] = {'\0'};
  
   /*
   open a connection to a file
   note: using "wb" will overwrite the data
   "rb+" = update an existing file for reading and writing
   "b" is for binary file
   */ 
   filePointer = fopen(fileName,"rb+");
  //if error, filePointer is NULL 
   if(filePointer == NULL){
      printf("File \"%s\" could not be opened. \n", fileName); 
      exit(1); //end the program
   }//end of else   
   else {       
      printf("Enter student number (0 to %d), or %d to quit: \n", MAX_RECORDS-1, MAX_RECORDS); 
      studentX.number = getdouble();    
      while(studentX.number >= 0 && studentX.number < MAX_RECORDS){
      //get user input
         printf("Enter first name, last name, age, and gpa separated by spaces: \n");         
         sizeFirstName = getstring(studentX.first, MAX_STRING);
         //note: we use MAX_STRING - 2, as the getstring() function only reads size-1 characters, 
         //so the function actually reads size-2 characters, 
         //as the function needs to identify the space or newline character or tab
         //that is used to separate the string inputs from the user
	 if(sizeFirstName > MAX_STRING - 2){
	   printf("ERROR: Cannot enter first name greater than %d characters\n", MAX_STRING - 2); 
           //remove the rest of the characters from input stream
	   getline2(dummyString, MAX_STRING);
	   continue;
	 }
         sizeLastName = getstring(studentX.last, MAX_STRING);
	 if(sizeLastName > MAX_STRING - 2){
           printf("ERROR: Cannot enter last name greater than %d characters\n", MAX_STRING - 2);
           //remove the rest of the characters from input stream
           getline2(dummyString, MAX_STRING);
           continue;
         }
         studentX.age = getdouble();
         studentX.gpa = getdouble();

	 // error checking
	 //printf("sizeFirstName = %d (%s)\n", sizeFirstName, studentX.first);
	 //printf("sizeLastName =  %d (%s)\n", sizeLastName, studentX.last);

      //find record to update in file
         seekError = fseek(filePointer,(studentX.number)*sizeof(Student), SEEK_SET);
         if(0==seekError){
            printf("Record #%d was correctly located in file  \"%s\". \n", studentX.number, fileName);
         }
         else{
            printf("Record #%d was NOT correctly located in file  \"%s\". \n", studentX.number, fileName);
         }
         
         //write new record to file
         writeError = fwrite(&studentX,sizeof(Student),1,filePointer);
         if(1 == writeError){
            printf("Record #%d was correctly written to file  \"%s\". \n", studentX.number, fileName);
         }
         else{
            printf("Record #%d was NOT correctly written to file  \"%s\". \n", studentX.number, fileName);
         }
         //output record
         printStudent(studentX);
         //prompt user again      
         printf("Enter student number (0 to %d), or %d to quit: \n", MAX_RECORDS-1, MAX_RECORDS);
         studentX.number = getdouble();     
      }      
    //close the file connection
      fileClosed = fclose(filePointer);
      if(0 == fileClosed){
         printf("File connection to \"%s\" closed successfully.\n", fileName);
      }//end of if
      else{
         printf("File connection to \"%s\" did NOT close successfully.\n", fileName);
      }//end of else    
   }//end of else 
}//end of main

 //display Student structure
void printStudent(Student studentX){
   printf("%6d  %10s  %10s  %3d  %3.1f  \n", 
               studentX.number, 
               studentX.first, 
               studentX.last, 
               studentX.age, 
               studentX.gpa);
}

/*

Enter student number (0 to 19), or 20 to quit: 
0
Enter first name, last name, age, and gpa separated by spaces: 
Bubba Smith 20 2.2
Record #0 was correctly located in file  "students.data". 
Record #0 was correctly written to file  "students.data". 
     0       Bubba       Smith   20  2.2  
Enter student number (0 to 19), or 20 to quit: 
5
Enter first name, last name, age, and gpa separated by spaces: 
Surfer Dude 40 4.0
Record #5 was correctly located in file  "students.data". 
Record #5 was correctly written to file  "students.data". 
     5      Surfer        Dude   40  4.0  
Enter student number (0 to 19), or 20 to quit: 
1
Enter first name, last name, age, and gpa separated by spaces: 
Sally Suzuki 29 3.3
Record #1 was correctly located in file  "students.data". 
Record #1 was correctly written to file  "students.data". 
     1       Sally      Suzuki   29  3.3  
Enter student number (0 to 19), or 20 to quit: 
20
File connection to "students.data" closed successfully.


 */
