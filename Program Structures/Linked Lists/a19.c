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

// Linked List Structure
struct node {
	int element; 
	struct node *next;
};

typedef struct node Node;
typedef struct node* NodePointer;

// Function Prototypes
int setAmountIntegers(void);
int setIntegerValue(void);
int sum(NodePointer);
int count(NodePointer);
double average(int, int);
void displayContents(NodePointer);
void insertIntoLinkedList(int, NodePointer*); 


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

	// Adds a random amount of integers from 0-100 (inclusive) into the linked list
	for (int i = 0; i < amountOfIntegers; i++){
		integerToAdd = setIntegerValue();
		insertIntoLinkedList(integerToAdd, &head);
	}


	displayContents(head);

	// Display Statistics of Linked List: Sum, Count, Average (Floating Point)
	int sumOfList, countOfList;
	sumOfList = sum(head);
	countOfList = count(head);

	printf("Sum: %i\n", sumOfList);
	printf("Count: %i\n", countOfList);
	printf("Floating Point Average: %.2f\n", average(sumOfList, countOfList));


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
	return rand() % 101;
}

/*
* Return the sum of the linked list. 
* Params: 
* - node, NodePointer. Head or Start of the linked list. 
*/
int sum(NodePointer node){
	int sum = 0; 

	while (node != NULL){
		sum += node->element;
		node = node->next;
	}

	return sum;
}


/*
* Returns the number of nodes in the linked list.
* Params:
* - node, NodePointer. Head or Start of the linked list.
*/
int count(NodePointer node){
	int count = 0;

	while (node != NULL){
		// Increments count as long as there is another node in the list.
		count++;
		node = node->next;
	}

	return count;
}

/*
* Returns the floating point average of the linked list.
* Params: 
* - sum, int. Sum of the linked list.
* - count, int. Number of nodes inside the linked list.
*/
double average(int sum, int count){
	return (double) sum / (double) count;
}

/*
* Adds an integer into the linked list.
* Params: 
* - num, int. Number to be added into Linked List. 
* - node, NodePointer, head or start of the linked list.
*/
void insertIntoLinkedList(int num, NodePointer *node){
	// Creating pointers to assist in adding the element to the linked list. 
	NodePointer newNode = NULL;
	NodePointer curr = *node; 

	newNode = malloc(sizeof(Node));

	if (newNode == NULL) {
		printf("Unable to allocate memory to add new node into linked list.\n"); 
	} else {
		// Inserts node at beginning of list. 
		newNode->element = num; 
		newNode->next = curr; 
		*node = newNode; 
	}
}

/*
* Displays all the integers stored inside the linked list. 
* Params:
* - head, NodePointer, pointer to the beginning of the linked list.
*/
void displayContents(NodePointer head){

	if (head == NULL){
		printf("Empty linked list\n");
	} else {
		printf("Contents: \n");

		// Continously go through linked list until pointer points to NULL. 
		while (head != NULL){
			printf("%i ", head->element);
			head = head->next;
		}

		printf("\n"); 

	}
}
