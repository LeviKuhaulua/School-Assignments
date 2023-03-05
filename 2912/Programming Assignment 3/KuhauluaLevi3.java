/**
 * A program that will use a file that has only numbers as input. It will then use a Merge Sort algorithm to sort 
 * the numbers in ascending order and then output the sorted list.
 * @author: Levi Kuhaulua
 * @date: 2/28/2023
 * @assignment: Programming Assignment 3
 */

import java.util.*;
import java.io.*; 
public class KuhauluaLevi3 {
    public static void main(String[] args) {
        
        // Getting user input
        Scanner keyboard = new Scanner(System.in);  
        String fileName = null; 
        System.out.print("Please Input File Name to Sort >> "); 
        fileName = keyboard.nextLine().trim(); 
        
        // Variables for gathering File Data & staring MergeSort algorithm
        ArrayList<Double> doubleArray = new ArrayList<Double>(); 
        double[] unsortedArray = null; 
        double numberInFile; 

        // Check if input for file has multiple arguments or is blank
        while(!checkFileInput(fileName)) {
            System.out.println("Invalid command-line arguments");
            System.out.print("\n" + "Please Input File Name to Sort >> ");
            fileName = keyboard.nextLine().trim(); 
        }

        // Tries to read the file, catches if file isn't found or if there were any other errors
        try {
            // Variables to read the file and add contents into array
            BufferedReader readFileContent = new BufferedReader(new FileReader(fileName)); 
            String fileLine = readFileContent.readLine(); 
            
            // Validates each line of the file 
            do { 
                StringTokenizer lineContent = new StringTokenizer(fileLine, " ");
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
            } while (fileLine != null); 

            readFileContent.close(); // Closing the file
            
            // "Unboxing" numbers and adding to the double[] array 
            unsortedArray = new double[doubleArray.size()];
            for (int i = 0; i < doubleArray.size(); i++) {
                unsortedArray[i] = doubleArray.get(i); 
            }

            // Merge Sort algorithm to sort array
            mergeSort(unsortedArray); 
            
            // Print out sorted list 
            for (double i : unsortedArray) System.out.println(i);

            
        } catch (FileNotFoundException e) { // If file isn't found
            System.out.println("File Not Found: " + fileName);
            System.out.println("Error Message: " + e.getMessage());
            System.exit(-1); 
        } catch (IOException e) { // If any other error occurs for reading file 
            System.out.println("Failed to read input file: " + fileName);
            System.exit(-1); 
        }
        keyboard.close(); 
      
        
    }

    /**
     * checkFileInput - method to prevent user from leaving file name blank or inputting multiple files
     * @param fileName - name of the file passed on by user
     * @return returns True if input is only one file, otherwise false
     */
    public static boolean checkFileInput(String fileName) { 
        // Checks for empty value or if there are multiple tokens
        StringTokenizer checkFileName = new StringTokenizer(fileName, " ,"); 
        if (fileName.isBlank() || checkFileName.countTokens() > 1) return false;
        else return true; 
    }

    /**
     * mergeSort() - takes in an unsorted array and then sorts it
     * using this and helper method. 
     * @param array - the unsorted array 
     */
    public static void mergeSort(double[] array) {
        // Creating scratch array to help with sorting 
        double[] scratch = new double[array.length]; 
        
        // Calling MergeSort algorithm
        mergeSort(array, scratch, 0, array.length - 1);

    }
    
    /**
     * mergeSort - helper method for MergeSort algorithm.
     * @param values - the unsorted array
     * @param scratch - a duplicate array to help with sorting 
     * @param min - the minimum index of unsorted array
     * @param max - the last index of unsorted array
     */
    private static void mergeSort(double[] values, double[] scratch, int min, int max) {
        // Base Case: 
        if (min == max) return; 

        // Last index for left sub array and starting index for right sub array
        int middleLeft = (int) Math.floor((min + max) / 2); 
        int middleRight = middleLeft + 1;

        // Calling MergeSort 
        mergeSort(values, scratch, min, middleLeft); // For left array
        mergeSort(values, scratch, middleRight, max); // For right array
        
        // Copying elements from unsorted array into scratch array
        for (int i = 0; i < values.length; i++) scratch[i] = values[i]; 

        // Indexes to compare values for left and right array 
        int lIndex = min; 
        int rIndex = middleRight; 
        int sIndex= min; // Sorted Array index

        // Comparing values of left and right array, then adding smaller one to sorted array
        while (lIndex <= middleLeft && rIndex <= max) {
            if (scratch[lIndex] < scratch[rIndex]) { 
                values[sIndex] = scratch[lIndex];
                lIndex++; 
            }
            else {
                values[sIndex] = scratch[rIndex]; 
                rIndex++; 
            }
            sIndex++; 
        }

        // Adding leftover numbers in left array
        while (lIndex <= middleLeft) {
            values[sIndex] = scratch[lIndex]; 
            lIndex++; 
            sIndex++;
        }

        // Adding leftover numbers in right array 
        while (rIndex <= max) {
            values[sIndex] = scratch[rIndex]; 
            rIndex++; 
            sIndex++;
        }
    }
}