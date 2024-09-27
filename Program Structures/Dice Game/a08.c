// Author: Levi Kuhaulua
// Date Created: 09-26-2024
/* Program Description: 
*  Dice betting game between the user and the computer. 
*  The user can continously bet and play against the computer
*  until they don't have any money left. 
*  Winner is decided by who has the higher die value. 
*/

#include <stdio.h>
#include <math.h>
#include <time.h> 
#include <stdlib.h>
#include <stdbool.h>
#include "getdouble.h"

int main(void) {

    // Used to store the dice values for the players. 
    int userDice1 = 0; 
    int userDice2 = 0; 
    int computerDice1 = 0; 
    int computerDice2 = 0; 
    int userDiceSum = 0; 
    int computerDiceSum = 0; 

    // Balance for both players.
    double computerBalance = 500.00; 
    double userBalance = 0;  
    
    // Grab betting information from user. 
    double userBet = 0; 


    bool gameEnd = false; 


    // START OF GAME
    puts("Dice Betting Game"); 

    printf("Balance for today (you can even enter a negative number!): "); 
    userBalance = fabs(getdouble()); 

    if (userBalance == 0) {
        printf("Looks like you don't want to play today. Shootz!"); 
        return 0; 
    }

    do {

        // Setting the seed for random number generation. 
        srand(time(NULL)); 

        // Grab betting information from player. 
        printf("Enter bet: "); 
        userBet = getdouble(); 

        while ((userBalance - userBet) < 0 || userBet <= 0) {
            printf("Invalid bet entered.\n"); 
            printf(" * Bet cannot exceed your balance of: %.2f\n", userBalance); 
            printf(" * Bet cannot be less than or equal to 0\n"); 

            printf("Re-enter bet: "); 
            userBet = getdouble(); 
        }

        /* Game Condition/State: Computer matches the player's bet
        *  Code below checks to see if computer can match player's bet. 
        *  If it cannot then the player wins the game. 
        */
        if ((computerBalance - userBet) < 0) {
            printf("Computer can't match bet. You win!\n"); 
            gameEnd = true; 
        }

        
        // DICE ROLLING SECTION
        
        while (userDiceSum == computerDiceSum) {
            
            // Roll player's dice and calculate score.
            userDice1 = 1 + rand() % 6;
            userDice2 = 1 + rand() % 6; 
            userDiceSum = userDice1 + userDice2; 

            printf("You rolled: %i and %i\n", userDice1, userDice2);

            // Roll computer's dice and calculate score. 
            computerDice1 = 1 + rand() % 6; 
            computerDice2 = 1 + rand() % 6; 
            computerDiceSum = computerDice1 + computerDice2; 

            printf("Computer rolled: %i and %i\n", computerDice1, computerDice2); 
            
            // COMPARE SCORES SECTION
            printf("You have %i | computer has %i\n", userDiceSum, computerDiceSum); 

            
            if (userDiceSum > computerDiceSum) {
                printf("You Win!\n\n"); 
                computerBalance -= userBet; 
                userBalance += userBet; 
            } 
            
            if (computerDiceSum > userDiceSum) {
                printf("Computer Wins!\n\n"); 
                userBalance -= userBet; 
                computerBalance += userBet; 
            } 

            if (computerDiceSum == userDiceSum) {
                printf("\n"); 
                printf("Tie. Re-rolling..."); 
                printf("\n"); 
            }

            

        }

        // ROUND SUMMARY SECTION 

        // Reset the dice sum so that program can run through the dice rolling section again. 
        userDiceSum = 0; 
        computerDiceSum = 0; 

        // Display end of round information. 
        printf("Your balance: %.2f\n", userBalance);
        printf("Computer's balance: %.2f\n", computerBalance); 

        // Check if players can play another round. 
        if (userBalance == 0) {
            printf("You have no money anymore. See you next time."); 
            gameEnd = true; 
        }

        if (computerBalance == 0) {
            printf("Opponent has no money left. See you next time."); 
            gameEnd = true; 
        }

        // Newline for next round. 
        printf("\n"); 
        
    } while (!gameEnd);
    
   

    return 0; 
}