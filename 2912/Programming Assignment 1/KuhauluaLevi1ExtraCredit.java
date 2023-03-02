import java.io.FileNotFoundException;

/**
 * Optimizing the cost for dinner by finding the middle ground between cheap and expensive 
 * in a 2D array
 * @author Kuhaulua, Levi 
 * @assignment CSCI Programming Assignment 1 Extra Credit 
 * @date 1/21/2023
 */
import java.io.*; 
import java.util.*; 
public class KuhauluaLevi1ExtraCredit {
    public static void main(String[] args) {
        // variables for the 2D array
        int[][] intersections = null; 
        int streets, avenues; 
        streets = avenues = 0; 
        String fileName = null; 

        // variables to optimize the cost of dinner
        int lowest, highest; 
        lowest = highest = 0; 
        int[] dinnerOptions = null; 
        

        try {
            // User input for getting the file for the program 
            Scanner keyboard = new Scanner(System.in); 
            System.out.println("Please input a file name for the assignment: ");
            fileName = keyboard.nextLine();
            keyboard.close(); 

            // Scanner for reading the file and creating the 2D array. 
            Scanner readFile = new Scanner(new File(fileName)); 
            streets = readFile.nextInt(); 
            avenues = readFile.nextInt(); 
            intersections = copyFileInfo(streets, avenues, readFile);
            dinnerOptions = new int[avenues]; 
            readFile.close(); 

            // find the maximum costs using the avenues 
            for (int i = 0; i < avenues; i++) {
                highest = intersections[0][i]; 
                for (int j = 1; j < intersections.length; j++) {
                    if (highest < intersections[j][i]) highest = intersections[j][i]; 
                }
                dinnerOptions[i] = highest; 
            }
            
            // finding the lowest among the dinner costs
            lowest = dinnerOptions[0]; 
            for (int i = 1; i < dinnerOptions.length; i++) {
                if (lowest > dinnerOptions[i]) lowest = dinnerOptions[i]; 
            }

            // outputting the lowest cost 
            System.out.println(lowest);
            System.exit(0); 
            

        } catch (FileNotFoundException e) {
            System.out.println("File not found...");
            System.out.println("Exception: " + e.getMessage());
            System.exit(-1); 
        } catch (NoSuchElementException e) {
            System.out.println("File is empty. No cost available.");
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
