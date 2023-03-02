/*
 * @Author: levi Kuhaulua
 * @Date: 9/30/2022
 * Assignment: Exchange Rates
 * 
 * Algorithm
 * Create a menu with 4 options
 *  - Convert to Yen (Japanese)
 *  - Convert to Canadian Dollar
 *  - Convert to Thai Baht
 *  - Or exit program 
 * Make menu run until user selects to exit program
 * Ask user for their option
 * Convert US dollars into type of currency selected
 * Output how much of that currency is equal to the amount of US Dollars inputted
 */

 import java.util.*;
 

public class lab5_ExchangeRates {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in); // user input


        double usDollarAmt; // Variable to take in User's input for a dollar
        int userChoice; // variable for user's input on menu options

        userChoice = menuOption(); 
         
        while (userChoice != 4) {
            if(userChoice == 1) {
                usDollarAmt = usDollarValidation(); // Will ask user for US Dollars and validate input
                convertToYen(usDollarAmt); // Use usDollarAmt and convert it into Japanese Yen. 
                userChoice = menuOption();
            } 
            else if (userChoice == 2) {
                usDollarAmt = usDollarValidation();
                convertToCDollar(usDollarAmt); // takes usDollarAmt as a parameter and convert to Canadian Dollars
                userChoice = menuOption();
            }
            else if (userChoice == 3) {
                usDollarAmt = usDollarValidation();
                convertToBaht(usDollarAmt); // takes in parameter and converts to Thai Baht
                userChoice = menuOption(); // ask user for menu option again to convert to different currency or exit menu. 
            }
        }
        keyboard.close();
        System.out.println("Thank you for using this program!");
        System.exit(0);


}

    /*
     * Method: menuOption()
     * Will display the menu and ask for the option that the user wants to convert to. 
     * It will then evaluate the user's input and return it
     * if its valid or else it will keep asking user to input a valid option. 
     */
    public static int menuOption() {
        Scanner keyboard = new Scanner(System.in);
        int input;
        System.out.println("\n********************************************");
        System.out.println("US Dollar(s) Currency Conversion\n\n" +
         "1) Convert to Yen (Japanese)\n" + 
         "2) Convert to Canadian Dollar\n" +
         "3) Convert to Thai Baht\n" +
         "4) Exit Program\n");

        System.out.println("Please input an option: ");
        
        while (!keyboard.hasNextInt()) {
            System.out.println("Invalid Entry. Please enter a valid integer: ");
            keyboard.next();
        }

        input = keyboard.nextInt(); 

        while (input <= 0 || input > 4) {
            System.out.println("Please input a valid menu option: ");
            input = keyboard.nextInt(); 
        }
        keyboard.close();
        return input; // returns the input once it evaluates that user's input is valid
    }

    /*
     * Method: usDollarValidation()
     * Will ask the user for the amount they want converted. Once they have that
     * then the method will check if the amount is a valid amount (no negatives or words). 
     * Finally it will return the US Dollar amount. 
     */
    public static double usDollarValidation() {
        Scanner keyboard = new Scanner (System.in);
        double dollarAmt;
        System.out.println("Please enter amount of USD you would like converted: ");
        
        while(!keyboard.hasNextDouble()) {
            System.out.println("Please input a number: ");
            keyboard.nextLine(); 
        }

        dollarAmt = keyboard.nextDouble(); 

        while(dollarAmt < 0) {
            System.out.println("Please input a valid amount");
            dollarAmt = keyboard.nextDouble(); 
        }
        keyboard.close();
        return dollarAmt;
    }

    /*
     * Method: convertToYen();
     * This is a void method that will take in the parameter -- dollarAmt -- US Dollars. 
     * It will then use that number and the conversion number to convert US Dollars into 
     * Japanese Yen and output it. 
     */

    public static void convertToYen(double dollarAmt) {
        double conversionNum = 144.39;
        double yenAmt = dollarAmt * conversionNum;
        System.out.print(dollarAmt + " US Dollars: ");
        System.out.printf("%.2f",yenAmt); // round to two decimal places
        System.out.print(" Japanese Yen"); 
    }
    /*
     * Method: convertToCDollar(); 
     * Void method that takes in parameter -- dollarAmt -- US Dollars. 
     * It will then convert US Dollars into Canadian Dollars using the conversion number and output it. 
     */
    public static void convertToCDollar(double dollarAmt) {
        double conversionNum = 1.37;
        double cDollarAmt = dollarAmt * conversionNum;
        System.out.print(dollarAmt + " US Dollars: ");
        System.out.printf("%.2f", cDollarAmt ); // round to two decimal places
        System.out.print(" Canadian Dollars");
    }

    /*
     * Method convertToBaht(); 
     * Void method that takes in parameter -- dollarAmt -- US Dollars. 
     * It will then convert the US Dollars into Thai Baht using the conversion number and output it. 
     */

    public static void convertToBaht(double dollarAmt) {
        double conversionNum = 37.81;
        double bahtAmt = dollarAmt * conversionNum;
        System.out.print(dollarAmt + " US Dollars: ");
        System.out.printf("%.2f", bahtAmt); // To round to 2 decimal places
        System.out.print(" Thai Baht");
    }
}
