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
        String token = null; 
        String lineContent = null; 
        Svg svgTag = null; 
        double[] tagAttributes = null;  

          
        


        try {
            // Reading SVG header line or the first line in file 
            readFileContent = new BufferedReader(new FileReader("input.txt")); 
            
            fileLineTokenizer = new StringTokenizer(readFileContent.readLine(), " "); 
            token = fileLineTokenizer.nextToken(); 

            // If first token of file is not svg then throw an error message 
            if (!token.equalsIgnoreCase("svg")) {
                System.out.println("Invalid Token: " + encapsulateToken(token));
                System.exit(-1); 
            }

            // try to create an svg tag with it's width and height dimensions
            try {
                int index = 0; 
                tagAttributes = new double[2]; // width and height dimension 
                while (fileLineTokenizer.hasMoreTokens()) {
                    token = fileLineTokenizer.nextToken(); 
                    tagAttributes[index] = Double.parseDouble(token); 
                    index++; 
                } 
                // Creating the svg tag 
                svgTag = new Svg(tagAttributes[0], tagAttributes[1]); 
            } catch (NumberFormatException wrongFormat) {
                System.out.println("Invalid Token: " + encapsulateToken(token));
                System.exit(-1); 
            }

            // Adding Shape classes 
            while ((lineContent = readFileContent.readLine()) != null) {
                // Continuosly skips a line if it is empty 
                while (lineContent.equals("")) {
                    lineContent = readFileContent.readLine(); 
                }
                fileLineTokenizer = new StringTokenizer(lineContent, " "); 
                token = fileLineTokenizer.nextToken(); // gets the command line token             
                if (token.equalsIgnoreCase("line")) {
                    // Creating tags for each line token encountered
                    createTag(svgTag, "line", fileLineTokenizer); 
                } else if (token.equalsIgnoreCase("rect")) {
                    // Create tag for each rectangle token encountered
                    createTag(svgTag, "rect", fileLineTokenizer); 
                } else if (token.equalsIgnoreCase("circle")) {
                    // Create tag for each circle token encountered 
                    createTag(svgTag, "circle", fileLineTokenizer); 
                } else {
                    // Catches an invalid shape token 
                    System.out.println("Invalid Token: " + encapsulateToken(token));
                    System.exit(-1);
                }
            }
            
            svgTag.render(System.out); 
            
           
            
        } catch (FileNotFoundException missingFile){
            // Catch if file isn't found 
            System.out.println("Failed to read input file: " + missingFile.getMessage()); 
            System.exit(-1);
        } catch (IOException someIOException) {
            // Catch if another IO exception occured 
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

    public static void createTag(Svg svgTag, String tagHeader, StringTokenizer lineTokenizer) {
        String token = null; 
        double[] tagAttributes = null; 
        if (tagHeader.equalsIgnoreCase("line")) {
            try {
                int index = 0; 
                tagAttributes = new double[4]; 
                while (lineTokenizer.hasMoreTokens()) {
                    token = lineTokenizer.nextToken(); 
                    tagAttributes[index] = Double.parseDouble(token); 
                    index++; 
                }
                Line aLineTag = new Line(tagAttributes[0], tagAttributes[1], tagAttributes[2], tagAttributes[3]); 
                svgTag.addShape(aLineTag); 
            } catch (NumberFormatException wrongFormat) {
                System.out.println("Invalid Token: " + encapsulateToken(token));
                System.exit(-1); 
            }
        } else if (tagHeader.equalsIgnoreCase("circle")) {
            try {
                int index = 0; 
                tagAttributes = new double[3]; 
                while (lineTokenizer.hasMoreTokens()) {
                    token = lineTokenizer.nextToken();
                    tagAttributes[index] = Double.parseDouble(token); 
                    index++; 
                }
                Circle aCircleTag = new Circle(tagAttributes[0], tagAttributes[1], tagAttributes[2]); 
                svgTag.addShape(aCircleTag); 
            } catch (NumberFormatException wrongFormat) {
                System.out.println("Invalid Token: " + encapsulateToken(token));
                System.exit(-1); 
            }
        } else if (tagHeader.equalsIgnoreCase("rect")) {
            try {
                int index = 0; 
                tagAttributes = new double[4];
                while (lineTokenizer.hasMoreTokens()) {
                    token = lineTokenizer.nextToken(); 
                    tagAttributes[index] = Double.parseDouble(token); 
                    index++; 
                }
                Rectangle aRectangleTag = new Rectangle(tagAttributes[0], tagAttributes[1], tagAttributes[2], tagAttributes[3]); 
                svgTag.addShape(aRectangleTag);
            } catch (NumberFormatException wrongFormat) {
                System.out.println("Invalid Token: " + encapsulateToken(token));
                System.exit(-1); 
            }
        } else if (tagHeader.equalsIgnoreCase("svg")) {
            
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