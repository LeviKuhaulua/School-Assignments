/*
 * @Author: Levi Kuhaulua
 * @Date: 12/2/2022
 * Assignment: Student Profiles (Graduate and Undergraduate)
 * 
 * Algorithm: 
 * Create a Student class with the following fields:  name, phone, email 
 * Methods for Student class: 
 * - No-arg constructor
 * - constructor with 3 arguments for fields
 * - setters
 * - getters
 * - toString method 
 * Create two sub classes for Student class (inherit) 
 * 
 * Undergraduate with field:  major, Gen Ed Credits, Major Credits
 * - create a no-arg constructor
 * - constructor with the arguments
 * - setters
 * - getters 
 * - toString 
 * 
 * Graduate class with fields: field of study, number of credits 
 * - create a no-arg constructor
 * - constructor with arguments
 * - setters
 * - getters
 * - toString 
 * 
 * Create a demo file that will 
 * ask user for information (phone, email, name)
 * ask user for field of study or major depending on the type of student 
 * output the user's information
 * 
 * Extra Credit: create equals and copy methods for Graduate and Undergraduate class. 
 */

import java.util.*;
import java.util.regex.*; 
public class StudentDemo {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in); 
        int menuOption; 
        menuOption = menu();  
        // while user's option is not 3, keep running
        while (menuOption != 3) {
            if (menuOption == 1) {
                // create an undergraduate student profile
                getUndergradInfo();
                menuOption = menu(); 
            }
            else if (menuOption == 2) {
                // create a graduate student profile. 
                getGradInfo();
                menuOption = menu(); 
            }
        }

        System.out.println("Thank you for using!");
        System.exit(0); 
        

        
        
    }

    /**
     * validatePhoneNum - will validate the user's phone number so that it follows the format
     * @return user's phone number they inputted
     */
    public static String validatePhoneNum() {
        Scanner keyboard = new Scanner(System.in); 
        String input = "unknown"; 
        System.out.println("What is your phone number? Format: (###)###-####");
        input = keyboard.nextLine(); 
        while(!Pattern.matches("\\([1-9][0-9]{2}\\)[0-9]{3}-[0-9]{4}", input)) {
            System.out.println("Input phone number in format. Example: (808)397-0447");
            input = keyboard.nextLine(); 
        }
        return input; 
    }

    /**
     * menu - create a menu for the user to add a new student 
     * @return user's option for the type of student they want to add
     */
    public static int menu() {
        Scanner keyboard = new Scanner(System.in); 
        int option = -1; // to make while statement true for validation
        String input; // user's input for their menu option
        System.out.println("Student Menu" + "\n*****************************************************"
         + "\n1) Add Undergraduate Student" + "\n2) Add Graduate Student" 
         + "\n3) Exit Program");

        // option is not 1, 2, or 3.
        while(option <= 0 || option > 3) {
            System.out.println("Please select an option: ");
            input = keyboard.nextLine(); 
            try {
                option = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid Option.");
                option = -1; 
            }
        }
        return option; 
    }

    /**
     * validateCredit - validate the user's input for the amount of credits they need. 
     * @return user's amount of credits that they need
     */
    public static int validateCredit() {
        Scanner keyboard = new Scanner(System.in); 
        int creditAmt = -1; // to make while statement true 
        String input; 
        while(creditAmt < 0) {
            System.out.println("Credits: ");
            input = keyboard.nextLine(); 
            try {
                creditAmt = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                creditAmt = -1; 
            }
        }
        return creditAmt;
    }

    /**
     * getUndergradInfo - create a student profile and then output that information. 
     */
    public static void getUndergradInfo() {
        Scanner keyboard = new Scanner(System.in);
        // variables for undergrad information 
        String name, pNumber, email, major; 
        int genEdCredits, majorCredits;
        System.out.println("Name: ");
        name = keyboard.nextLine(); 
        // input validation for a student's name
        while(!Pattern.matches("[a-zA-z ]+", name)) {
            System.out.println("Invalid. Input name again.");
            name = keyboard.nextLine(); 
        }
        pNumber = validatePhoneNum(); 
        System.out.println("Email: ");
        email = keyboard.nextLine(); 
        while(!Pattern.matches("[a-zA-z]+[1-9]*[@]{1}my.hpu.edu", email)) {
            System.out.println("Invalid Email. Input again.");
            email = keyboard.nextLine(); 
        }
        System.out.println("Major: ");
        major = keyboard.nextLine(); 
        // input validation for the name of the major
        while(!Pattern.matches("[a-zA-z ]+", major)) {
            System.out.println("Invalid input. Input major again.");
            major = keyboard.nextLine(); 
        }
        System.out.println("Input General Education Credits: ");
        genEdCredits = validateCredit(); 
        System.out.println("Input Major Course Credits: ");
        majorCredits = validateCredit();
        // create an object with the information.
        Undergraduate student = new Undergraduate(name, pNumber, email, major, genEdCredits, majorCredits); 
        // ouput the information. 
        System.out.println(student.toString());
    }

    /**
     * getGradInfo - create a student profile for a graduate student and then output that information. 
     */
    public static void getGradInfo() {
        Scanner keyboard = new Scanner(System.in);
        // variables for undergrad information 
        String name, pNumber, email, fieldOfStudy; 
        int numOfCredits;
        System.out.println("Name: ");
        name = keyboard.nextLine(); 
        // input validation for a student's name
        while(!Pattern.matches("[a-zA-z ]+", name)) {
            System.out.println("Invalid. Input name again.");
            name = keyboard.nextLine(); 
        }
        System.out.println("phone number: ");
        pNumber = validatePhoneNum(); 
        System.out.println("Email: ");
        email = keyboard.nextLine(); 
        while(!Pattern.matches("[a-zA-z]+[1-9]*[@]{1}my.hpu.edu", email)) {
            System.out.println("Invalid Email. Input again.");
            email = keyboard.nextLine(); 
        }
        System.out.println("Field of Study: ");
        fieldOfStudy = keyboard.nextLine(); 
        // input validation for a student's field of study. 
        while(!Pattern.matches("[a-zA-Z ]+", fieldOfStudy)) {
            System.out.println("Invalid. Input Field of Study again.");
            fieldOfStudy = keyboard.nextLine(); 
        }
        System.out.println("Number of Credits Required: ");
        numOfCredits = validateCredit();
        // create a graduate student profile with the information obtained
        Graduate student = new Graduate(name, pNumber, email, fieldOfStudy, numOfCredits);
        // output the information
        System.out.println(student.toString());
    }
}
