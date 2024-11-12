/*
  Creating a file for 20 fixed-length records
*/
#include <stdio.h>   
#include <stdlib.h>
#include "student.h"

int main(){       
   int i = 0;      
   Student blank = {-1, "", "", 0, 0.0 };      
   FILE *filePointer = NULL;    
   char *fileName = "students.data"; //This is a binary file, not a text file 
   int fileClosed = 0; 
   int writeError = 0;
  
   printf("sizeof(Student)=%d\n", sizeof(Student));
  
  //open a connection to a file
   filePointer = fopen(fileName,"wb"); //"wb" to write to binary file
  //if error, filePointer is NULL 
   if(filePointer == NULL){
      printf("File \"%s\" could not be opened. \n", fileName); 
      exit(1); //end the program
   }//end of else          
   else {                
      for(i=0;i<MAX_RECORDS;i++){
      /*
      Make room to add records to a file.
      Variable "blank": is written to the file.
      sizeof(): calculates the number of bytes in the struct.
      Integer 1: means we are writing just one record to the file.
      filePointer: is the file we are writing to.
      */
         writeError = fwrite(&blank,sizeof(Student),1,filePointer); 
         if(1 == writeError){
            printf("Record #%d was correctly written to file  \"%s\". \n", i, fileName);
         }
         else{
            printf("Record #%d was NOT correctly written to file  \"%s\". \n", i, fileName);
         }
      }//end of for loop
    //close the file connection
      fileClosed = fclose(filePointer);
      if(0 == fileClosed){
         printf("File connection to \"%s\" closed successfully.\n", fileName);
      }//end of if
      else{
         printf("File connection to \"%s\" did NOT close successfully.\n", fileName);
      }//end of else    
   }//end of else         
   return 0;
}

/*

sizeof(Student)=40
Record #0 was correctly written to file  "students.data". 
Record #1 was correctly written to file  "students.data". 
Record #2 was correctly written to file  "students.data". 
Record #3 was correctly written to file  "students.data". 
Record #4 was correctly written to file  "students.data". 
Record #5 was correctly written to file  "students.data". 
Record #6 was correctly written to file  "students.data". 
Record #7 was correctly written to file  "students.data". 
Record #8 was correctly written to file  "students.data". 
Record #9 was correctly written to file  "students.data". 
Record #10 was correctly written to file  "students.data". 
Record #11 was correctly written to file  "students.data". 
Record #12 was correctly written to file  "students.data". 
Record #13 was correctly written to file  "students.data". 
Record #14 was correctly written to file  "students.data". 
Record #15 was correctly written to file  "students.data". 
Record #16 was correctly written to file  "students.data". 
Record #17 was correctly written to file  "students.data". 
Record #18 was correctly written to file  "students.data". 
Record #19 was correctly written to file  "students.data". 
File connection to "students.data" closed successfully.

 */

