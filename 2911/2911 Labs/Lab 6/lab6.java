/*
 * @Author: Levi Kuhaulua
 * @Date: 10/7/2022
 * Assignment: Math Quizzer
 * 
 * Algorithm: 
 * Create program that asks for 4 options
 *  - Addition 
 *  - Subtraction 
 *  - Multiplication
 *  - Exit 
 * Make program run continously until user quits
 *  - Operation they select will run 10 times
 * For each problem, have two randomly generated numbers 
 *  - For subtraction, make sure that answer isn't negative 
 * Output score 
 */

import java.util.*;
public class lab6 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in); // user input for the quiz
 
        int amtRight, amtWrong; // variables for amount of questions user gets right or wrong
        int qTotal = 10; // determine amount of questions wrong
        int userChoice; // get user input for menu

        // menu option
        System.out.println("MATH QUIZ: "); 
        System.out.println("\n1: Addition " + 
        "\n2: Subtraction " + "\n3: Multiplication " 
        + "\n4: Exit");

        userChoice = -1; //make while statement true; 

        // makes program run continously until user selects to exit program 
        while(userChoice != 4) {
            userChoice = getMenuOption();
            if (userChoice == 1) {
                amtRight = additionQuiz(qTotal); 
                amtWrong = qTotal - amtRight; 
                System.out.println("You got " + amtRight + " questions right, and " + amtWrong + " questions wrong.");
            } else if (userChoice == 2) {
                amtRight = subtractionQuiz(qTotal);
                amtWrong = qTotal - amtRight; 
                System.out.println("You got " + amtRight + " questions right, and " + amtWrong + " questions wrong."); 
            } else if (userChoice == 3) {
                amtRight = multiplyQuiz(qTotal);
                amtWrong = qTotal - amtRight; 
                System.out.println("You got " + amtRight + " questions right, and " + amtWrong + " questions wrong.");
            }
        }
        keyboard.close();
        System.out.println("Thank you for using! See you next time!");
        System.exit(0); 
        
    }

    /**
     * getMenuOption - get user's input for the menu
     * @return Menu Option
     */
    public static int getMenuOption() {
        Scanner keyboard = new Scanner(System.in); 
        int menuOption = -1; // make the while condition true
        
        while (menuOption <= 0 || menuOption > 4) {
            System.out.println("Select a number from 1 to 4!");
            String input = keyboard.nextLine(); 
            try {
                menuOption = Integer.valueOf(input); 
            } catch (NumberFormatException e) { // validates user input if number is out of range or not an integer
                System.out.println("That doesn't seem to work... Try Again!");
                menuOption = -1;
            }
        }
        keyboard.close();
        return menuOption;
    }
    /**
     * additionQuiz - generate a 10 question quiz and have user answer the problem 
     * @param totalQs
     * @return amount of questions right
     */
    public static int additionQuiz(int totalQs) {
        Scanner keyboard = new Scanner (System.in);
        int qsRight = 0; // accumulator 
        int numOne, numTwo, sum, userInput; // variables for numbers one, two, sum of both, and user's answer
        Random random = new Random(); // generate random numbers
        
        for (int i = 1; i <= totalQs; i++) {
            numOne = random.nextInt(10); // randomly generated number from 0-9;
            numTwo = random.nextInt(10); 
            sum = numOne + numTwo;
            System.out.println(numOne + " + " + numTwo);
            
            // input validation
            while (!keyboard.hasNextInt()) {
                System.out.println("Please type in a number: ");
                keyboard.nextLine(); 
            }

            userInput = keyboard.nextInt(); 

            if (userInput == sum) { // if user's answer equals the quiz answer then user get's one point
                System.out.println("Great Job! You got it correct!");
                qsRight = qsRight + 1;
            } else {
                System.out.println("Sorry, seems like you got it wrong.");
            }
        }
        keyboard.close();
        return qsRight; // return the amount of questions user got right
    }
    /**
     * subtractionQuiz - generate a 10 question quiz (no negative answers) and have user answer the problem
     * @param totalQs
     * @return amount of questions right 
     */
    public static int subtractionQuiz(int totalQs) {
        Scanner keyboard = new Scanner(System.in); 
        int qsRight = 0; // accumulator
        int numOne, numTwo, difference, userInput; // variables for the numbers, difference, and user's answer

        Random random = new Random(); 

        for (int i = 1; i <= totalQs; i++) { // to generate each question
            numOne = random.nextInt(10); 
            numTwo = random.nextInt(10);
           
            if(numTwo > numOne) { // if number two is bigger than number one then put number two first 
                System.out.println(numTwo + " - " + numOne);
                difference = numTwo - numOne; 
            } else { // if number one is bigger than number two then put number one first
                System.out.println(numOne + " - " + numTwo);
                difference = numOne - numTwo;
            }
            
            // input validation
            while(!keyboard.hasNextInt()) {
                System.out.println("That doesn't seem to work. Try again!");
                keyboard.nextLine(); 
            }

            userInput = keyboard.nextInt(); 

            while(userInput < 0) { // ensure user doesn't put in a negative
                System.out.println("That doesn't seem to work. Try Again!");
                userInput = keyboard.nextInt(); 
            }
            
            //checks user's answer with quiz answer
            if (userInput == difference) {
                System.out.println("Great Job! You got it correct!");
                qsRight = qsRight + 1;
            } else {
                System.out.println("Sorry... seems like you got it wrong.");
            }
        }
        keyboard.close();
        return qsRight; //return amount of questions correct
    }
    /**
     * multiplyQuiz - generate a 10 question quiz and have user answer the problem. 
     * @param qTotal
     * @return amount of questions right 
     */
    public static int multiplyQuiz(int qTotal) {
        Scanner keyboard = new Scanner(System.in); 
        Random random = new Random(); 

        int numOne, numTwo, product, userInput; // variables for each number, product, and user's answer
        int qsRight = 0; //accumulator

        for (int i = 1; i <= qTotal; i++) {
            numOne = random.nextInt(10); // randomnly generated number from 0-9
            numTwo = random.nextInt(10); 
            product = numOne * numTwo; 

            System.out.println(numOne + " * " + numTwo);

            // input validation
            while(!keyboard.hasNextInt()) {
                System.out.println("That doesn't seem to work. Try again!");
                keyboard.nextLine(); 
            }

            userInput = keyboard.nextInt(); 
            
            if(userInput == product) { // checks to see if user's answer is correct 
                System.out.println("Great Job! You got it Correct!");
                qsRight = qsRight + 1;
            } else {
                System.out.println("Sorry... seems like you got it wrong.");
            }

        }
        keyboard.close();
        return qsRight; // return the amount of questions right
    }
}
