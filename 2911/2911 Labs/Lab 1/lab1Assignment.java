import java.util.*;

/*
 * @author Levi Kuhaulua
 * @date 9/9/2022
 * Assignment: Lab1Assignment.java
 * 
 * Algorithm
 * Ask the user for his/her name
 * Ask the user for their height in feet and inches
 * Convert height into inches 
 * Ask for their weight 
 * Calculate their BMI 
 *      - Multiply height in inches by itself
 *      - Divide weight(lbs) by result in step 1
 *      - Multiply result from step 2 by 703
 * Output the person's name, BMI, and the category
 * 
 * 
 */




public class lab1Assignment {
    
    
    public static void main(String[] args) {

        //Keyboard input
        Scanner keyboard = new Scanner(System.in); 

        //Variable for height, weight, name, and BMI 
        double weight; 
        String name = ""; 
        double heightFeet; 
        double heightInches; 
        double bodyMassIndex;
        double heightTotalInches; 
        

        // User input for name, weight, height
        System.out.println("What is your name? ");
        name = keyboard.nextLine(); 
        
        System.out.println("What is your weight? ");

        // Validate if user put in anything other than a number (same for other whiles for different variables)
        while (!keyboard.hasNextFloat()) {
            System.out.println("Please input an integer: "); 
            keyboard.nextLine(); 
        }

        weight = keyboard.nextDouble();
        // Validate if user put in a negative number (same for other whiles for different variables) 
        while (weight <= 0) {
            System.out.println("Please input a positive integer too: ");
            weight = keyboard.nextDouble();
        }
        
        System.out.println("What is your height. Input feet ");
       
        while(!keyboard.hasNextInt()) {
            System.out.println("Please input a number: "); 
            keyboard.nextLine(); 
        };
       
        heightFeet = keyboard.nextDouble(); 
       
        while (heightFeet <= 0) {
            System.out.println("Please input a positive number: "); 
            heightFeet = keyboard.nextDouble(); 
        }
       
        System.out.println("What is your height. Input inches");
       
        while(!keyboard.hasNextInt()) {
            System.out.println("Please input a number: "); 
            keyboard.nextLine(); 
        };
       
        heightInches = keyboard.nextDouble();
       
        while (heightInches <= 0) {
            System.out.println("Please input a positive number: "); 
            heightInches = keyboard.nextDouble(); 
        }
        
       
        // Calculating for BMI 
        heightFeet = heightFeet * 12;
        heightTotalInches = heightFeet + heightInches;
        heightTotalInches = heightTotalInches * heightTotalInches;  
        bodyMassIndex =  703 * (weight / heightTotalInches);
        
        // Truncate BMI to 1 decimal places
         bodyMassIndex = Math.round(bodyMassIndex * Math.pow(10, 1 )) / Math.pow(10, 1);
        

        
      
        if (bodyMassIndex > 30) {
            System.out.println("Hello, " + name + ". It seems like your BMI is: " + Double.toString(bodyMassIndex) + ". Sorry but you fall into the obese category.");
        }
        else if (bodyMassIndex > 25 && bodyMassIndex < 30) {
            System.out.println("Hello, " + name + ". It seems like your BMI is: " + Double.toString(bodyMassIndex) + ". This puts you in the overweight category.");
        }
        else if (bodyMassIndex >= 19 && bodyMassIndex < 25) {
            System.out.println("Hey great job, " + name + ". Your BMI is: " + Double.toString(bodyMassIndex) + ". This means you're healthy." );
        }
        else {
            System.out.println("Hello, " + name + ". Your BMI is: " + Double.toString(bodyMassIndex) + ". This means you're underweight.");
        };
        keyboard.close();
}



}