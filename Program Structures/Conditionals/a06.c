// Author: Levi Kuhaulua
// Date Created: 09-16-2024
/* Purpose: 
*  The program will prompt a user to enter a number from 0-9. 
*  After getting the number, the program will write the number
*  in 'Olelo Hawai'i
*/

#include <stdio.h>
#define PURPOSE "Program will display the Hawaiian word for a number of your choice.\n"
#define GETNUM "Enter a number from 0-9: "


int main(void) {
    // Beginning of Program. See #define statements above. 
    printf(PURPOSE);
    printf(GETNUM);

    printf("\n"); 

    // Getting number from user. 
    char input = getchar();

    // Checking the character that user entered. 
    // Output: Hawaiian equivalent word or error message.
    switch(input) {
        case '0': 
            printf("\n'Olelo Hawai'i: 'Ole");
            break; 
        case '1': 
            printf("\n'Olelo Hawai'i: 'Ekahi"); 
            break; 
        case '2': 
            printf("\n'Olelo Hawai'i: 'Elua");
            break; 
        case '3': 
            printf("\n'Olelo Hawai'i: 'Ekolu");
            break; 
        case '4': 
            printf("\n'Olelo Hawai'i: 'Eha"); 
            break; 
        case '5': 
            printf("\n'Olelo Hawai'i: 'Elima"); 
            break; 
        case '6': 
            printf("\n'Olelo Hawai'i: 'Eono");
            break;
        case '7': 
            printf("\n'Olelo Hawai'i: 'Ehiku"); 
            break; 
        case '8': 
            printf("\n'Olelo Hawai'i: 'Ewalu"); 
            break; 
        case '9': 
            printf("\n'Olelo Hawai'i: 'Eiwa");
            break; 
        default: 
            printf("\n%c is not a number.\nPlease try again.", input); 
            break; 
    }

    return 0;
}