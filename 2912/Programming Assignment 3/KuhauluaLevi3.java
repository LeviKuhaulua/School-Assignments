/**
 * A program that will use a file that has only numbers as input. It will then use a Merge Sort algorithm to sort 
 * the numbers in ascending order and then output the sorted list into the terminal. 
 * @Author: Levi Kuhaulua
 * @Date: 2/28/2023
 * @Assignment: Programming Assignment 3
 */

import java.util.*;
import java.io.*;
public class KuhauluaLevi3 {
    public static void main(String[] args) {
        
        // Getting user input
        Scanner keyboard = new Scanner(System.in);  
        String fileName = null; 
        System.out.print("Please Input File Name to Sort >> "); 
        fileName = keyboard.nextLine(); 
        
        // Variables for gathering File Data
        ArrayList<Double> doubleArray = new ArrayList<>(); 
        double numberInFile; 

        // Check if input for file has multiple arguments
        while(!checkFileInput(fileName)) {
            System.out.println("Invalid command-line arguments");
            System.out.print("\n" + "Please Input File Name to Sort >> ");
            fileName = keyboard.nextLine(); 
        }

        // Tries to read the file, catches if file isn't found or if there were any other errors
        try {
            // Variables to read the file and add contents into array
            BufferedReader readFileContent = new BufferedReader(new FileReader(fileName)); 
            String fileLine = readFileContent.readLine(); 
            StringTokenizer lineContent = new StringTokenizer(fileLine, " "); 
            
            // Check for empty line or can't parse into a Double 
            do {
                if (fileLine.isBlank()) { // checks for empty line
                    System.out.println("Empty Line Encountered");
                    System.exit(-1); 
                } else if (lineContent.countTokens() > 1) { // checks for more than one argument 
                    System.out.println("Invalid Line Encountered: " + lineContent.nextToken()); 
                    System.exit(-1); 
                } else { // checks to see if content can parse to double 
                    try {
                        numberInFile = Double.parseDouble(fileLine); 
                        doubleArray.add(numberInFile); 
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Line Encountered: " + lineContent.nextToken());
                        System.exit(-1); 
                    }
                }
                fileLine = readFileContent.readLine(); 
            } while (fileLine != null); 
            readFileContent.close(); // Closing file once done;
            
           // for (double i : doubleArray) System.out.println(i);

            
        } catch (FileNotFoundException e) { 
            System.out.println("File Not Found: " + fileName);
            System.out.println("Error Message: " + e.getMessage());
            System.exit(-1); 
        } catch (IOException e) {
            System.out.println("Error Reading File: " + fileName);
            System.exit(-1); 
        }
        
        keyboard.close(); 
      
        
    }

    /**
     * checkFileInput - method to prevent user from leaving argument blank or inputting multiple files
     * @param fileName - name of the file passed on by user
     * @return returns True if input is only one file, otherwise false
     */
    public static boolean checkFileInput(String fileName) { 
        // Checks for empty value or if there are multiple tokens
        StringTokenizer checkFileName = new StringTokenizer(fileName, " ,"); 
        if (fileName.isBlank() || checkFileName.countTokens() > 1) return false;
        else return true; 
    }
    


}