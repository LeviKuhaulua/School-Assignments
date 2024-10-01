// Author: Levi Kuhaulua
// Date Created: 09-28-2024
/* Program Description:
*  A rock, paper, scissors game against the computer. 
*  This program allows you to continously play against
*  the computer until an EOF character is submitted. 
*  At the end of the program, it will also display a 
*  game summary. 
*/

// Library and/or Macro Definitions
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <time.h>
#define START "Rock Paper Scissors!"
#define INPUT "Enter 'r', 'p', or 's': "
#define EXIT "To exit game, press CTRL + Z"


// Function Prototypes

char rpsSelect(void); 
bool checkValidInput(char); 
int game(char, char);



int main(void){  

    // Game Information
    printf("%26s\n", START);
    printf("%30s\n", EXIT);
    
    // Grab and hold choices for rock, paper, and scissors. 
    char userChoice = 0; 
    char computerChoice = 0; 
    
    // Hold game information. 
    int compareChoice = -1; 
    int userWins = 0; 
    int computerWins = 0; 
    int gamesPlayed = 0; 
    int ties = 0; 

    printf("\n"); 

    do {
        printf("%-s", INPUT); 
        
        userChoice = getchar();  
        
        // Remove newline character from input stream. 
        getchar(); 

        // Output Game Summary
        if (userChoice == EOF) {
            printf("\n\n"); 
            printf("Total Games Played: %i\n", gamesPlayed); 
            printf("Games Won: %i\n", userWins); 
            printf("Computer Wins: %i\n", computerWins); 
            printf("Ties: %i\n", ties); 
            return 0; 
        }

        // Ensures that user selected 'r', 'p', or 's'. 
        while(!checkValidInput(userChoice)) {
           printf("Invalid Input\n"); 
           printf("%s", INPUT);  
           userChoice = getchar(); 
           getchar(); 
        }


        // Computer choice for rock, paper, or scissors. 
        computerChoice = rpsSelect(); 
       
        // Check who wins and loses then update the tally info. 
        compareChoice = game(userChoice, computerChoice); 

        switch(compareChoice) { 
            case 0: 
                gamesPlayed++; 
                ties++; 
                printf("%c vs %c Draw.\n", userChoice, computerChoice); 
                break; 
            case 1: 
                gamesPlayed++; 
                userWins++; 
                printf("You chose %c vs %c You win!\n", userChoice, computerChoice); 
                break; 
            case -1: 
                gamesPlayed++; 
                computerWins++; 
                printf("You chose %c vs %c Computer Wins!\n", userChoice, computerChoice); 
                break; 
            default: 
                // Again, this shouldn't occur
                printf("How did we get here?\n"); 
                break; 
        }

    } while (userChoice != EOF); 


    return 0;
}


/* 
*  This will generate a random number from 1-3, then return
*  either 'r', 'p', or 's' based on the number.  
*/
char rpsSelect(void) {
    // Defines the seed for random number generation. 
    srand(time(NULL)); 


    // 1 = rock, 2 = paper, 3 = scissors
    int choice = 1 + rand() % 3; 

    switch(choice){
        case 1: 
            return 'r'; 
            break; 
        case 2: 
            return 'p'; 
            break; 
        case 3: 
            return 's'; 
            break; 
        default: 
            // This shouldn't occur. 
            return -1; 
    }
}

/* 
*  Return true if input from user is 'r', 'p', or 's'. 
*  Otherwise, false. 
*/
bool checkValidInput(char input) {
    if (input == 'r' || input == 'p' || input == 's') {
        return true; 
    }

    return false; 
}

/*
*  Compares the choices between the user and the computer
*  It will return one of the following: 
*  - 1 = user won
*  - 0 = draw
*  - -1 = computer won
*/
int game(char userChoice, char computerChoice) {

    // Player and Computer pick same option
    if (userChoice == computerChoice) {
        return 0; 
    }
    
    // Win/Lose Conditions for player
    if (userChoice == 'r' && computerChoice == 's') {
        return 1; 
    } else if (userChoice == 'r' && computerChoice == 'p') {
        return -1; 
    }
    
    if (userChoice == 'p' && computerChoice == 'r') {
        return 1; 
    } else if (userChoice == 'p' && computerChoice == 's') {
        return -1; 
    }

    if (userChoice == 's' && computerChoice == 'p') {
        return 1; 
    } else if (userChoice == 's' && computerChoice == 'r') {
        return -1; 
    }


}
    