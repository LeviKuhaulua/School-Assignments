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
#include <stdlib.h>
#include <ctype.h> 

// Function Prototypes


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

    return 0;
}