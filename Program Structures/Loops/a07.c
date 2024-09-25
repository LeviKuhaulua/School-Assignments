// Author: Levi Kuhaulua
// Date Created: 09-24-2024
/* Program Description: 
*  Program will count in 'Olelo Hawai'i from 1-9999
*  using loops and a condition statement.
*/

#include <stdio.h>

// All the words used for counting in 'Olelo Hawai'i 
#define ONE "kahi"
#define TWO "lua"
#define THREE "kolu"
#define FOUR "ha"
#define FIVE "lima"
#define SIX "ono"
#define SEVEN "hiku"
#define EIGHT "walu"
#define NINE "iwa"
#define TEN "umi"
#define TWENTY "iwakalua"
#define TENSPREFIX "kana"
#define JOIN "kuma"
#define SPECIALONE "ho'okahi"
#define HUNDRED "haneli"
#define THOUSAND "kaukani"

int main(void) {
    

    // Variables to store the individual digits
    int ones, tens, hundreds, thousands; 
    
    
    // Loop to count through all the numbers
    for (int i = 1; i <= 9999; i++) {

        // Getting all the individual digits of the number. 
        ones = i % 10; 
        tens = (i / 10) % 10; 
        hundreds = (i / 100) % 10; 
        thousands = (i / 1000) % 10; 

        // Beginning part of statement. 
        printf("%i = ", i); 

        // Print out the word for the thousands digit or none if thousands digit equals 0
        switch (thousands) {
            
            case 1: 
                printf("%s %s, ", SPECIALONE, THOUSAND);
                break; 
            
            case 2: 
                printf("%s %s, ", TWO, THOUSAND); 
                break; 
           
            case 3: 
                printf("%s %s, ", THREE, THOUSAND); 
                break; 
           
            case 4: 
                printf("%s %s, ", FOUR, THOUSAND); 
                break; 
           
            case 5: 
                printf("%s %s, ", FIVE, THOUSAND); 
                break; 
           
            case 6: 
                printf("%s %s, ", SIX, THOUSAND); 
                break; 
            
            case 7: 
                printf("%s %s, ", SEVEN, THOUSAND); 
                break; 
            
            case 8:  
                printf("%s %s, ", EIGHT, THOUSAND); 
                break; 
            
            case 9: 
                printf("%s %s, ", NINE, THOUSAND); 
                break; 
           
            default: 
                break; 
        }

        // Print out the word for the hundreds digit or none if the hundreds digit equals 0
        switch (hundreds) {
            case 1: 
                printf("%s %s ", SPECIALONE, HUNDRED); 
                break; 

            case 2:  
                printf("%s %s ", TWO, HUNDRED); 
                break; 
            case 3: 
                printf("%s %s ", THREE, HUNDRED); 
                break; 

            case 4: 
                printf("%s %s ", FOUR, HUNDRED); 
                break; 

            case 5: 
                printf("%s %s ", FIVE, HUNDRED); 
                break; 
                
            case 6: 
                printf("%s %s ", SIX, HUNDRED);
                break; 

            case 7: 
                printf("%s %s ", SEVEN, HUNDRED); 
                break;
                
            case 8: 
                printf("%s %s ", EIGHT, HUNDRED); 
                break; 

            case 9: 
                printf("%s %s ", NINE, HUNDRED); 
                break;

            default: 
                break; 
        }

        // Print out the word for the tens digit or none if the tens digit equals 0
        switch (tens) {
            case 1: 
                printf("%s", TEN); 
                break; 
            
            case 2: 
                printf("%s", TWENTY); 
                break; 
            
            case 3: 
                printf("%s%s", TENSPREFIX, THREE); 
                break; 
            
            case 4: 
                printf("%s%s", TENSPREFIX, FOUR);  
                break; 
            
            case 5: 
                printf("%s%s", TENSPREFIX, FIVE); 
                break; 
            
            case 6: 
                printf("%s%s", TENSPREFIX, SIX); 
                break; 
            
            case 7: 
                printf("%s%s", TENSPREFIX, SEVEN); 
                break; 
            
            case 8: 
                printf("%s%s", TENSPREFIX, EIGHT); 
                break; 
            
            case 9: 
                printf("%s%s", TENSPREFIX, NINE); 
                break; 
            
            default: 
                break; 
        
        } 
        
        
        /* 
        * Conditional checks to see if the ten's digit number exists (not 0). 
        * If it doesn't exist, then output only the word for the one's digit. 
        * If it does exist, then output the following sentence structure: 
        * 
        *   [Ten's Digit] + kuma + [One's Digit]
        * 
        */
        if (tens == 0) {
            switch (ones) {
                
                case 1: 
                    printf("%s", ONE); 
                    break; 
                
                case 2: 
                    printf("%s", TWO); 
                    break; 
                
                case 3: 
                    printf("%s", THREE); 
                    break; 
                
                case 4:
                    printf("%s", FOUR); 
                    break; 
                
                case 5: 
                    printf("%s", FIVE); 
                    break; 
                
                case 6: 
                    printf("%s", SIX); 
                    break; 
                
                case 7: 
                    printf("%s", SEVEN); 
                    break; 
                
                case 8: 
                    printf("%s", EIGHT); 
                    break; 
                
                case 9: 
                    printf("%s", NINE);
                    break; 
                
                default: 
                    break; 
            }
        } else { 
            switch (ones) {
                
                case 1: 
                    printf("%s%s", JOIN, ONE); 
                    break; 
                
                case 2: 
                    printf("%s%s", JOIN, TWO); 
                    break; 
                
                case 3: 
                    printf("%s%s", JOIN, THREE); 
                    break; 
                
                case 4:
                    printf("%s%s", JOIN, FOUR); 
                    break; 
                
                case 5: 
                    printf("%s%s", JOIN, FIVE); 
                    break; 
                
                case 6: 
                    printf("%s%s", JOIN, SIX); 
                    break; 
                
                case 7: 
                    printf("%s%s", JOIN, SEVEN); 
                    break; 
                
                case 8: 
                    printf("%s%s", JOIN, EIGHT); 
                    break; 
                
                case 9: 
                    printf("%s%s", JOIN, NINE);
                    break; 
                
                default: 
                    break; 
            }
        }
        
        // Makes sure that next translation starts on a new line. 
        printf("\n"); 
        
    }


    return 0; 
}