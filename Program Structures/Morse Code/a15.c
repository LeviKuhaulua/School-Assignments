// Author: Levi Kuhaulua
// Date Created: 10-29-2024
/* Program Description:
*  Program will take in Morse Code from the command line
*  arguments, then translate and display them to standard 
*  output. 
*/

// Library and/or Macro Definitions
#include <stdio.h>

// Libraries associated with String and Characters. Update libraries when needed. 
#include <string.h>
#include <stdbool.h>

// Function Prototypes
bool checkLength(int, int); 


// Defining Morse Code Dictionary
const char *morse[36] = {
    "0 ----- ",
    "1 .---- ",
    "2 ..--- ",
    "3 ...-- ",
    "4 ....- ",
    "5 ..... ",
    "6 -.... ",
    "7 --... ",
    "8 ---.. ",
    "9 ----. ",
    "a .- ",
    "b -... ",
    "c -.-. ",
    "d -.. ",
    "e . ",
    "f ..-. ",
    "g --. ",
    "h .... ",
    "i .. ",
    "j .--- ",
    "k -.- ",
    "l .-.. ",
    "m -- ",
    "n -. ",
    "o --- ",
    "p .--. ",
    "q --.- ",
    "r .-. ",
    "s ... ",
    "t - ",
    "u ..- ",
    "v ...- ",
    "w .-- ",
    "x -..- ",
    "y -.-- ",
    "z --.. ",
};

int main(int argc, char *argv[]){
    
    // Checking if Morse Code arguments were entered. 
    if (argc < 2) {
        printf("No morse code detected. Exiting Program..."); 
        return 0; 
    }

    // Initializing an array based on the count of the arguments. 
    char *morseWords[argc - 1]; 

    // Used to check if morse word command argument is a substring in the morse dictionary.
    char *substr = NULL; 

    // Used to compare and check length of strings. 
    int lengthMorse = 0; 
    int lengthArg = 0; 

    for (int i = 1; i < argc; i++) {

        for (int j = 0; j < 36; j++) {
            substr = strstr(morse[j], argv[i]); 

            /*
            *  Length of string in morse array follows format: 
            *  CHARACTER + SPACE + MORSE + SPACE
            *  CHARACTER = morse translation
            */
            lengthMorse = strlen(morse[j]); 

            // 3 represents the CHARACTER, SPACE, SPACE in format specified above ^. 
            lengthArg = strlen(argv[i]) + 3; 
            
            // Output morse code if it matches these conditions. 
            if (substr != NULL && checkLength(lengthMorse, lengthArg)) {
                printf("%c", morse[j][0]); 
            } 
        }

    }


    return 0;
}

/* checkLength Function:
*  Params: 
*   - length, integer. Represents the length of a word. 
*   - argLength, integer. Represents the length of the word argument inputted in terminal. 
*  
*  Returns True if length of word is equal to the length of the word argument, otherwise False. 
*
*/
bool checkLength(int length, int argLength) {
    return length == argLength; 
}