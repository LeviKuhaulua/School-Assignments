/**
 * A program that will optimize the cost between restaurants by finding the middle ground
 * between expensive and cheap in a 2D array
 * @author Kuhaulua, Levi 
 * @assignment CSCI 2912 Assignment 1 
 * @date 1/18/23
 */

import java.io.*;
import java.util.*;
public class KuhauluaLevi1 {
    public static void main(String[] args) throws IOException {
        // 2D array for the intersections between the streets and avenues in manhuttan
        int[][] intersections = null; 
        int streets, avenues; 
        streets = avenues = 0; 
        // variables for Emma and Jack's pick for the restaurant 
        int lowest, highest; 
        lowest = highest = 0; 
        int[] dinnerOptions = null; 

        String fileName = null; 

        try {
            // getting input for the file to read
            Scanner keyboard = new Scanner(System.in); 
            System.out.println("Please input a file name to read for the assignment: ");
            fileName = keyboard.nextLine(); 
            keyboard.close(); 
            
            // Reading the file
            Scanner readFile = new Scanner(new File(fileName));
            // Getting information to create 2D array or "map" of restaurants
            streets = readFile.nextInt(); 
            avenues = readFile.nextInt();  
            intersections = copyFileInfo(streets, avenues, readFile); 
            dinnerOptions = new int[streets];
            readFile.close(); 
             
             
           
            // finding the minimum costs for dinner on each street
            for (int i = 0; i < intersections.length; i++) {
                lowest = intersections[i][0];
                for(int j = 1; j < intersections[i].length; j++) {
                    if (lowest > intersections[i][j]) lowest = intersections[i][j];
                }
                dinnerOptions[i] = lowest; // adding the minimum cost for dinner here 
            }
                 
            // Emma's choice for street
            highest = dinnerOptions[0];
            for (int i = 1; i < dinnerOptions.length; i++) {
                if (highest < dinnerOptions[i]) highest = dinnerOptions[i]; 
            }
            
            // Output for the couples cost of dinner. 
            System.out.println(highest);
            System.exit(0); 
        } catch (FileNotFoundException e) {
            System.out.println("File not found. No dinner cost available.");
            System.out.println("Exception: " + e.getMessage());
            System.exit(-1); 
        } catch (NoSuchElementException e) {
            System.out.println("File is empty. No dinner cost available.");
            System.out.println("Exception: " + e.getMessage());
            System.exit(-1); 
        }
        
    }

    /**
     * copyFileInfo - reads the file and uses the file as input for the 2D array. 
     * @param rows - the streets of Manhattan
     * @param columns - the avenues of Manhattan 
     * @param file - the scanner for the file 
     * @return a 2D array or "map" of the restaurants of Manhattan 
     */
    public static int[][] copyFileInfo(int rows, int columns, Scanner file) {
        int[][] arr = new int[rows][columns];
        file.nextLine(); 
        String[] lineInfo = null; 
        for (int i = 0; i < arr.length; i++) {
            lineInfo = file.nextLine().split(" "); 
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(lineInfo[j]);
            }
        }
        return arr; 
    }



   
}
    
