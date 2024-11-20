// Author: Levi Kuhaulua
// Date Created: 11-19-2024
/* Program Description:
*  The program inputs a 25-75 integers inside a linked list (ranging from 0-100). 
*  It will then output the following data: sum, count, and floating point average. 
*/

// Library and/or Macro Definitions
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Function Prototypes
int setAmountIntegers(void);
int setIntegerValue(void);
int sum(NodePointer *);
int count(NodePointer *);
double average(int, int);
void displayContents(NodePointer);
void insertIntoLinkedList(int, NodePointer *); 

// Linked List Structure
struct node {
	int element; 
	struct node *next;
};

typedef struct node Node;
typedef struct node* NodePointer;

int main(void){
    // Setting seed for random number generation. 
    srand(time(NULL)); 

	// Defining variables that will specify linked list capacity and number to add.
    int amountOfIntegers = 0; 
	int integerToAdd = 0;   

	amountOfIntegers = setAmountIntegers(); 

    // Linked List Implementation

    // Points to the beginning / head of the linked list. 
    NodePointer head = NULL; 
	
	return 0;
}

/*
 * Generate a number from 25-75 (inclusive). This represents the amount of integers
 * to store / add to the linked list. 
*/

int setAmountIntegers(void){
	return 25 + rand() % 51; 
}

/* 
 * Get a random integer value from 0-100 (inclusive). This number WILL be added to the linkedlist.
*/
int setIntegerValue(void){
	return rand() % 100;
}


