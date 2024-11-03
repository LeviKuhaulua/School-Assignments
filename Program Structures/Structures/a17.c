// Author: Levi Kuhaulua
// Date Created: 11-02-2024
/* Program Description:
*  Program shuffles and shows the deck of cards to the user. 
*  The suit, rank, and color is displayed to the user. 
*/

// Library and/or Macro Definitions
#include<stdio.h>
#include <time.h> 
#include <stdlib.h> 
#include <string.h>
#define MAX 9
#define MAX_CARDS 52
#define MAX_RANKS 13
#define MAX_SUITS 4
#define COLS 3 

// Structure and typedef for card 
struct card{ 
  char *rank;    
  char suit[MAX];  
};

typedef struct card Card;

// Array of pointers to strings for ranks
char *ranks[MAX_RANKS] = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", 
			  "Eight", "Nine", "Ten", "Jack", "Queen", "King"};

// Two-dimensional array of strings for suits
char suits[MAX_SUITS][MAX] = {"Clubs", "Diamonds", "Hearts", "Spades"};


// Function Prototypes for Card Structure
void initialize(Card []);
void shuffle(Card []);
void display(const Card[]);

int main(int argc, char *argv[]){

    // Declare an array of 52 cards
    Card deck[MAX_CARDS] = {"",""};
    initialize(deck);

    printf("Display an ordered deck of cards:\n");
    display(deck);
    
    // Repeat while loop
    char newline = '\n'; 
    
    // Allow user to re-shuffle deck if they press Enter
    while('\n' == newline){
        printf("\nshuffling deck ... \n");
        shuffle(deck);
        display(deck);
        printf("\nWould you like to shuffle again?\nIf so, press \"Enter\" key. If not, press any other key. ");
        newline = getchar();
    }
    
    return 0;
}

/*
  initialize the deck of cards to string values
  deck: an array of structure cards 
*/
void initialize(Card deck[]){
  int i = 0;
  for(i=0;i<MAX_CARDS;i++){
    deck[i].rank = ranks[i%MAX_RANKS];
    strncpy(deck[i].suit, suits[i/MAX_RANKS], MAX);
  }
}

/*
  use the pseudo-random number generator to shuffle the cards
  deck: an array of structure cards 
*/
void shuffle(Card deck[]){
  //index of card to be swapped
  int swapper = 0; 
  // counter
  int i = 0; 

  //temp holding place for swap
  Card temp = {"", ""}; 

  //seed the random numbers with current time
  srand(time(NULL)); 
  for(i=0;i<MAX_CARDS;i++){
    //generate a pseudo-random number from 0 to 51
    swapper = rand() % MAX_CARDS; 
    //swap current card with da swapper
    temp = deck[i];
    deck[i] = deck[swapper];
    deck[swapper] = temp;
  }
}

/*
  display the deck of cards
  deck: an array of structure cards 
*/
void display(const Card deck[]){
  int i = 0;
  for(i=0;i<MAX_CARDS;i++){
    printf("%5s of %-12s", deck[i].rank, deck[i].suit);
    //put in a newline every %x loops
    if(0==((i+1)%COLS)){
      printf("\n");
    }
  }
}