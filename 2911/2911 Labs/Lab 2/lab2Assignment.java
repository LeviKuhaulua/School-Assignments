import java.util.*;
/*
 * @author Levi Kuhaulua
 * @date 9/9/2022
 * Assignment: KuhauluaLeviA2.java
 * 
 * Algorithm
 * Ask User for fish
 * Computer Randomly select a fish from list : Ahi, Opah, Mahimahi, Ono
 * Compare computer choice to user choice
 * if computer choice = user choice, add to correct guesses
 * Output computer choice and user choice 
 * Rep 10 times
 * report amount of guesses that is correct
 */

public class lab2Assignment {
    public static void main(String[] args) {
        // take input from user 
        Scanner keyboard = new Scanner(System.in);

        // initialize a correct amount of guesses, will be used later for the report
        int guessCorrect = 0; 

        //Set for random number 
        Random random = new Random(); 
        int randnum = random.nextInt(4);

        // Variables for the game
        String computerFish = ""; 
        String userFish = ""; 
        int counter = 0; 
        int repetition = 10;
        System.out.println("I'm thinking of a fish. ");
        String upperFishUser = userFish.toUpperCase(); 
    
       while (counter < repetition) {
            // Computer can repeat the question
            System.out.println("Is it Ahi, Mahimahi, Opah, Ono: ");
            userFish = keyboard.nextLine();
            randnum = random.nextInt(4);
            upperFishUser = userFish.toUpperCase(); 
            System.out.println("This is attempt: " + (counter + 1));
            
            while(!(upperFishUser.equals("AHI")) && !(upperFishUser.equals("MAHIMAHI")) && !(upperFishUser.equals("OPAH")) && !(upperFishUser.equals("ONO"))) {
                System.out.println("That's not apart of the list. Choose Again:"); 
                userFish = keyboard.nextLine(); 
                upperFishUser = userFish.toUpperCase();
            } 
            
            
            if (randnum == 0 ) {
                computerFish = "AHI"; 
            } 
            else if (randnum == 1) {
                computerFish = "MAHIMAHI"; 
            }
            else if (randnum == 2) {
                computerFish = "OPAH"; 
            }
            else if (randnum == 3) {
                computerFish = "ONO"; 
            }
         
            if (upperFishUser.equals(computerFish)) {
                guessCorrect ++; 
            }    
            counter ++;

            System.out.println("You chose " + upperFishUser);
            System.out.println("Computer chose " + computerFish); 
            
       };

       System.out.println("You got " + Integer.toString(guessCorrect) + " correct"); 
       keyboard.close(); 
    }
}
