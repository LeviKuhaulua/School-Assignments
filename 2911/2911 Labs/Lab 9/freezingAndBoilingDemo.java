/**
 * @Author: Levi Kuhaulua
 * @Date: 10/28/2022
 * 
 * Assignment: Freezing and Boiling Report
 * 
 * Algorithm: 
 * Create a class called FreezingAndBoiling that will have the attribute temperature
 *   - Create a no arg constructor
 *   - Create a constructor that takes in the argument temperature
 *   - Create the appropriate getter and setter for temperature
 *   - Create a method that will check these elements if it's going to freeze or boil
 *       - Ethyl Alcohol: Freezing Point - -173, Boiling Point: 172
 *       - Oxygen: Freezing Point - -362, Boiling Point - 306
 *       - Water: Freezing Point - 32, Boiling Point - 212
 * 
 * For Program: 
 * Ask the user to enter a temperature
 * output the list of substances that will freeze/boil at that temperature 
 */


import java.util.*;
public class freezingAndBoilingDemo {
    public static void main(String[] args) {
        double temp; // temperature
        temp = validateTemp(); // setting the temperature and validating user input
        FreezingAndBoiling temperature = new FreezingAndBoiling(temp);

        // will check to see if a substance would be boiling or freezing and output that statement
        if (temperature.isEthylBoiling()) {
            System.out.println("Ethyl Alcohol is boiling");
        }
        if (temperature.isEthylFreezing()) {
            System.out.println("Ethyl Alcohol is freezing");
        }
        if(temperature.isOxygenBoiling()) {
            System.out.println("Oxygen is boiling");
        }
        if(temperature.isOxygenFreezing()) {
            System.out.println("Oxygen is freezing");
        }
        if(temperature.isWaterBoiling()) {
            System.out.println("Water is boiling");
        }
        if(temperature.isWaterFreezing()) {
            System.out.println("Water is freezing");
        }
        
    }

    /**
     * validateTemp - will check to see if the temp is a double value. 
     * @return temperature - the temperature of the substance
     */
    public static Double validateTemp() {
        Scanner keyboard = new Scanner(System.in);
        double temperature; 

        System.out.println("Please enter a temperature: ");
        // input validation for checking if value is a double 
        while(!keyboard.hasNextDouble()) {
            System.out.println("Invalid entry, please enter a number.");
            keyboard.nextLine();
        }

        temperature = keyboard.nextDouble(); 
        keyboard.close();
        return temperature;
    }
   

}
