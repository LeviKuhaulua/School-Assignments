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
        // String fileName; 
        // System.out.print("Input File name >> ");
        // fileName = keyboard.nextLine(); 
        
        // Checks for invalid file name inputs 
        // checkInvalidFileName(fileName); 
        keyboard.close(); 

        // Initializing variables for reading data in file
        BufferedReader readFileContent = null; 
        StringTokenizer fileLineTokenizer = null; 
        String lineToken = null; 
        String lineContent = null;  
          
        
        

        try {
            Svg svgTag = null; 
            readFileContent = new BufferedReader(new FileReader("input.txt")); 
            
            // Checks the svg header line of the file 
            fileLineTokenizer = new StringTokenizer(readFileContent.readLine(), " "); 
            invalidSvgHeader(fileLineTokenizer);
            svgTag = createSvgTag(fileLineTokenizer);
             
            // Loop over all the lines in the file 
            while (readFileContent.readLine() != null) {
                lineContent = readFileContent.readLine(); 
                fileLineTokenizer = new StringTokenizer(lineContent, " "); // creates new tokenizer of the line 
                lineToken = fileLineTokenizer.nextToken(); // Gets the command line token for each line 
                // Check if command line token is a valid shape tag 
                if (lineToken.equalsIgnoreCase("line")) {
                    System.out.println("This is a line");
                    System.out.println(fileLineTokenizer.countTokens());
                } else if (lineToken.equalsIgnoreCase("rect")) {
                    System.out.println("This is a rectangle");
                    System.out.println(fileLineTokenizer.countTokens());
                } else if (lineToken.equalsIgnoreCase("circle")) {
                    System.out.println("This is a circle");
                    System.out.println(fileLineTokenizer.countTokens());
                } else {
                    System.out.println("Invalid Token: " + encapsulateToken(lineToken));
                    System.exit(-1); 
                }
            }
             
            
            
            
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


    /**
     * invalidSvgHeader will check if the very first element does not start with the svg keyword 
     * @param fileLine is the line with all the files 
     */
    public static void invalidSvgHeader(StringTokenizer fileLine) {
        String headerToken = fileLine.nextToken(); 
        if (!headerToken.equalsIgnoreCase("svg") || headerToken.isBlank()) {
            System.out.println("Invalid Token: " + encapsulateToken(headerToken)); // highlights token to user 
            System.exit(-1); 
        }
    }
    
    /**
     * createSvgTag will try to create 
     * @param svgObject is the svg tag that is going to be created
     * @param fileLine is all the elements within the line
     * @return an svg tag with it's width and height dimensions 
     */
    public static Svg createSvgTag(StringTokenizer fileLineTokens) {
        String token = null; 
        try {
            double[] shapeAttributes = null; // container for dimensions of svg tag
            shapeAttributes = new double[fileLineTokens.countTokens()]; 
            int attributeIndex = 0; // to help with storing tokens inside double array 
            // Add the tokens into the array 
            while (fileLineTokens.hasMoreTokens()) {
                token = fileLineTokens.nextToken(); 
                shapeAttributes[attributeIndex] = Double.parseDouble(token); 
                attributeIndex++; 
            }
            return new Svg(shapeAttributes[0], shapeAttributes[1]);
        } catch (NumberFormatException wrongFormat) {
            // highlight the token that caused the error 
            System.out.println("Invalid Token: " + encapsulateToken(token));
            System.exit(-1); 
            return null; 
        } 
    }
    
    /**
     * encapsulateToken takes a token and encapsulates the token with single quotation marks 
     * @param token that needs to be encapsulated by single quotation marks
     * @return token with single quotation marks 
     */
    public static String encapsulateToken(String token) {
        return "'" + token + "'";
    }
}