// Author: Levi Kuhaulua
// Date Created: 10-21-2024
/* Program Description:
*  The program will prompt the user to enter letters
*  in the alphabet (both lower and upper case) and 
*  output the amount of times the letter shows up
*/

// Library and/or Macro Definitions
#include <stdio.h>

// Function Prototypes
void outputLetterCount(int arr[]); 
void startOfProgram(void); 
void updateCharacterCount(int arr[], int); 

int main(void){
    // Defining an array to store letter counts. 
    int letters[26] = {0}; 

    startOfProgram(); 

    // Stores the character 
    int letter = 0; 

    // Stores the index of the character count in the letters array. 
    int index = -1; 

    // Continously read from input stream until end of file character is detected
    while (letter != EOF) {
        letter = getchar(); 
        
        // Update index if character is in the alphabet (both upper and lower case). 
        if (letter >= 97 && letter <= 122) {
            index = letter - 97; 
            updateCharacterCount(letters, index); 

        }  else if (letter >= 65 && letter <= 90) {
            index = letter - 65; 
            updateCharacterCount(letters, index); 
        }


    }

    outputLetterCount(letters); 

    return 0;
}

/*
* Prompt user on what to do to get program started. 
*/
void startOfProgram(void) {
    puts("Enter sentences or pipe a file into the program to get count of letters.\n"
         "To exit program, enter EOF (end of file) by pressing Ctrl+Z"); 
}

/*
*  Updates the count of a character by incrementing the value stored in the array's index. 
*  Parameters: 
*  - arr, an integer array that is used to store characters
*  - index, the index to be updated in the array. 
*/
void updateCharacterCount(int arr[], int index) {
    arr[index]++; 
}

/*
* Output the letter and how many times it appears in the input stream. 
*/
void outputLetterCount(int arr[]) {
    printf("Count of Letters in Input\n"); 
    for (int i = 0; i < 26; i++) {
        printf("%c : %i\n", (char) i + 97, arr[i]);
    }
}
