/**
 * Program that will read the drawing commands from a text file
 * and writes scalable vector graphics to Standard Output 
 * 
 * @author Levi Kuhaulua 
 * @date 04/04/2023
 * @assignment Programming Assignment 4
 */
// Setting up for the next programming assignment; 
import java.util.*; 
import java.io.*;
public class KuhauluaLevi4 {
    public static void main(String[] args) {
        // Getting user input on the file that will be read 
        Scanner keyboard = new Scanner(System.in); 
        String fileName; 
        System.out.print("Input File name >> ");
        fileName = keyboard.nextLine(); 
        
        // Checks for invalid file name inputs 
        checkInvalidFileName(fileName); 
        keyboard.close(); 

        // Initializing variables for reading data in file
        BufferedReader readFileContent = null; 
        StringTokenizer fileLineTokens = null; 
        

        try {
            readFileContent = new BufferedReader(new FileReader(fileName)); 
            System.out.println(readFileContent.readLine()); 
        } catch (FileNotFoundException missingFile){
            System.out.println("Failed to read input file: " + missingFile.getMessage()); 
            System.exit(-1);
        } catch (IOException someIOException) {
            System.out.println("Failed to read input file: " + someIOException.getMessage());
            System.exit(-1); 
        }
    }

    /**
     * checkInvalidFileName will check to see if the file name contains invalid arguments: no file name or multiple file names
     * @param fileName - name of the file that user wants program to read
     */
    public static void checkInvalidFileName(String fileName) {
        StringTokenizer fileArguments = new StringTokenizer(fileName, " ,"); 
        // Check for no input or more than one file. 
        if (fileName.isBlank() || fileArguments.countTokens() > 1) {
            System.out.println("Invalid command-line arguments");
            System.exit(-1); 
        }
    }
}