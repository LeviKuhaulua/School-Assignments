/*
 * @Author: Levi Kuhaulua
 * @Date : 10/21/2022
 * 
 * Assignment: Motorcycle Lab
 * 
 * Algorithm: 
 * Create a class named Motorcyles that has the following fields: 
 * - year: year that motorcyle was created
 * - make: the brand of the motorcyle
 * - speed: motorcyle's current speed
 * Constructors: 
 * - Motorcyles with arguments year and make assigned to respective fields and setting speed to 0
 * - Motorcyles with no arguments
 * Getters that get the values of the fields
 * Accelerate function that adds 5 to the speed field each time it is called
 * - Program should call it four times
 * brake function that subtracts 5 from the speed field each time its called
 * - Program should call it three times
 * toString should print out the contents of the object
 * ------------------------------------------------------------------------------------------------
 * Have user input the year of the motorcyle from 1900-2021
 * Have user input the make of the motorcyle (harley, kawasaki)
 * output the statement
 * - a (Year) (Brand) going 0 miles per hour.
 * Output the new statements calling the accelerate function and brake function following same format. 
 */
import java.util.*; 
import java.util.regex.*;

public class lab8_Motorcycle {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);// user input
        int year; // year motorcycle was made
        String input; // check the year of motorcycle; 
        String brand; // brand of the motorcyle
        System.out.println("Enter the year of your Motorcycle (1900-2021)");
        
        input = keyboard.nextLine(); // will get the year of the motorcycle
        
        // going to check the year range to see if it's in a valid format and in the range
        while(!Pattern.matches("([1][9][0-9]{2})|(20[1][0-9])|(20[2][0-1])", input)) {
            System.out.println("Please enter a valid range in the years 1900-2021");
            input = keyboard.nextLine(); 
        }
        
        //set the year to the integer value of the input
        year = Integer.valueOf(input); 

        // get the brand of the motorcycle
        System.out.println("Enter the make of the motorcycle (like Harley or Kawasaka)");
        brand = keyboard.nextLine(); 

        // create a motorcycle object with the parameters of year and brand. 
        Motorcycles motorcycle = new Motorcycles(year, brand); 

        // output the motorcycles year, brand, and how fast it is going
        System.out.println(motorcycle.toString());
        
        // to have the motorcycle increase speed. 
        for (int i = 0; i < 4; i++) {
            motorcycle.speedUp(); 
           System.out.println(motorcycle.toString()); 
        }
        
        // to have motorcycle decrease speed. 
        for (int i = 0; i < 3; i++) {
            motorcycle.slowDown(); 
            System.out.println(motorcycle.toString());
        }
        keyboard.close();
    }
}
