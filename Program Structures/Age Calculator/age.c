// Author: Levi Kuhaulua
// Date Created: 09-10-2024
/* Purpose: 
* The program will prompt the user for input on their birth date.
* The user will have to input their birth month, year, and date. 
* Afterwards, the program will calculate the user's age in days and
* display it to the console. 
*/

#include <stdio.h>
#include "getdouble.h"

#define INTRO "Age Calculator Program: \n"
#define DATE "Today's Date: 09-17-2024"

int main(void) {

    puts(INTRO);

    // Getting the user's birth date, month, and year.

    double day;
    double month;
    double year;

    printf("What month were you born: ");
    month = getdouble(); 
    
    printf("What is the date you were born: ");
    day = getdouble();

    printf("what is the year you were born: ");
    year = getdouble();

    puts(DATE);

    // Age Calculation for Current Date
    // In this case current date is set to 9-17-2024 (assignment due date)
    double daysCurrentCalc;    
    daysCurrentCalc = (2024 * 365.25) + ((9 - 1) * 365.25 / 12.0) + 17;


    // Age Calculation for User's Birth Date
    double daysBornCalc = (year * 365.25) + ((month - 1) * 365.25 / 12.0) + day; 
    double diff = daysCurrentCalc;
    
    // Calculate the user's age. Then determine where the thousandths place is (to place comma).
    int age = (int) daysCurrentCalc - daysBornCalc;
    int ageThousandsPlace = age / 1000;
    int ageRestOfDigits = age % 1000;

    printf("You are %d,%d days old\n", ageThousandsPlace, ageRestOfDigits);
    
    return 0; 
}