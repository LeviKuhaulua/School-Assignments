/*
 * @Author: Levi Kuhaulua
 * @Date: 10/14/2022
 * 
 * Assignment: Input Validation with RegEx
 * 
 * Algorithm: 
 * Get user to input their: 
 * - first name
 * - student id
 * - phone number
 * - birthdate
 * Using RegEx to validate user's input
 * - First name: no numbers; minimum of 1 char and max of 10 char
 * - Student id: consist of @ and nine digits
 * - Phone Number:  should be entered in following format (###)###-####
 * - Birthdate should be entered in the following format ##/##/#### 
 *   - the birth month's first number should only be 0 or 1
 * Output User's Information
 */

import java.util.*; 
import java.util.regex.*;

public class lab7_RegEx_Validation {
    public static void main(String[] args) {
        String fName, sId, phoneNum, birthDate; // variables for user's first name, student id, phone number, and birth date
       
        System.out.println("*******HPU Verification*********");
        
        // Ask for user's information and then validate it. 
        fName = fNameValidation(); 
        sId = sIdValidation();
        phoneNum = phNumValidation();
        birthDate = bDateValidation();
        System.out.println("First Name: " + fName // nicely format user's information
        + "\nStudent ID: " + sId + 
        "\nPhone Number: " + phoneNum 
        + "\nBirth Date: " + birthDate);
       
    }

    /**
     * fNameValidation - will check the user's input for their first name and correct format. 
     * @param firstName
     * @return fName
     */
    public static String fNameValidation() {
        Scanner keyboard = new Scanner(System.in); // user input
        System.out.println("Please enter your first name: ");
        String fName = keyboard.nextLine(); 

        // keeps asking user for an acceptable entry
        while(!(Pattern.matches("[a-zA-Z]{1,11}", fName))) { 
            System.out.println("Invalid entry: Try again"); // if format is invalid then have user try again
            fName = keyboard.nextLine(); 
        }        
        return fName; // return user's input
    }
    /**
     * sIdValidation - will check to see if student ID number is valid and follows correct format
     * @param studentId
     * @return sId
     */

    public static String sIdValidation() { 
        Scanner keyboard = new Scanner(System.in); // user input
        System.out.println("Please enter your Student ID, " +
        "Format: @#########");
        String sId = keyboard.nextLine(); 
       
        while(!Pattern.matches("@[0-9]{9}", sId)) { // keeps checking if user's format for id is acceptable, else try again
            System.out.println("Invalid entry: Try again" +
            "\nValid Entry: @031371245");
            sId = keyboard.nextLine(); 
        }
        return sId; // returns the student id
    }

    /**
     * phNumValidation - will check if the user's phone number is valid and in correct formatting. 
     * @param phNum
     * @return phoneNum
     */
    public static String phNumValidation() {
        Scanner keyboard = new Scanner(System.in); // user input
        System.out.println("Please enter your phone number, " + 
        "Format: (###)###-####");
        String phoneNum = keyboard.nextLine();

        // will keep checking user's input for phone number until they type in a valid entry with a valid format
        while(!Pattern.matches("\\([1-9]\\d{2}\\)\\d{3}-\\d{4}", phoneNum)) {
            System.out.println("Invalid entry: Try again" + "\nValid Entry: (808)397-0447");
            phoneNum = keyboard.nextLine(); 
        }
        return phoneNum; // returns the user's phone number
    }

    /**
     * bDateValidation - will check to see if user's birth date is correct and follows correct formatting. 
     * @param birthDate
     * @return bDate
     */
    public static String bDateValidation() {
        Scanner keyboard = new Scanner(System.in); // for user input
        System.out.println("Please enter your birthdate, " +
        "Format: ##/##/####");
        String bDate = keyboard.nextLine(); 
        
        // will keep checking user's Date of Birth until user types in a valid DOB with a valid format. 
        while(!Pattern.matches("(0[1-9]|1[0-2])/([0-2][0-9]|[3][0-1])/[1-2][0-9]{3}", bDate)) {
            System.out.println("Invalid entry: try again " + "\nValid Entry: 08/14/1994");
            bDate = keyboard.nextLine();  
        }
        return bDate; // returns the date of birth.  
    }
}
