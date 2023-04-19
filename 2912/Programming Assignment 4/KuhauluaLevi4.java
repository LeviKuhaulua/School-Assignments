/**
 * Program that will take SVG tag information from a file 
 * and output that into the appropriate format. 
 * 
 * @author Levi Kuhaulua 
 * @date 04/04/2023
 * @assignment Programming Assignment 4
 */
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
        StringTokenizer fileLineTokenizer = null; 
        String token = null; 
        String lineContent = null; 
        Svg svgTag = null; 
        double[] tagAttributes = null;  

          
        


        try {
            // Reading SVG header line or the first line in file 
            readFileContent = new BufferedReader(new FileReader(fileName)); 
            
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

            // Add shapes  
            while ((lineContent = readFileContent.readLine()) != null) {
                // skips empty lines 
                if (lineContent.equals("")) lineContent = readFileContent.readLine(); 
                
                // Checks if file reached the end of file 
                try {
                    fileLineTokenizer = new StringTokenizer(lineContent, " ");
                } catch (NullPointerException nullValue) {
                    break; 
                }
                

                token = fileLineTokenizer.nextToken(); // gets the command line token   
                   
                if (token.equalsIgnoreCase("line")) {
                    // Creating tags for each line token encountered
                    Shape aLineTag = createTag("line", fileLineTokenizer);
                    svgTag.addShape(aLineTag); 

                    // Checks if line used to create shape tag contains style keys and attributes 
                    while(fileLineTokenizer.hasMoreTokens()) {
                        token = fileLineTokenizer.nextToken(); 
                        // Checks if token is end 
                        if (!token.equalsIgnoreCase("end")) {
                            String attribute = fileLineTokenizer.nextToken(); // get value of style key 
                            aLineTag.addStyle(token, attribute); // add line style 
                        }
                    }

                    // Add style of the shape until it reaches end token 
                    while (!token.equalsIgnoreCase("end")) {
                        fileLineTokenizer = new StringTokenizer(readFileContent.readLine(), " "); 
                        token = fileLineTokenizer.nextToken(); 
                        if (!token.equalsIgnoreCase("end")) {
                            String attribute = fileLineTokenizer.nextToken(); 
                            aLineTag.addStyle(token, attribute);
                        }
                    }
                } else if (token.equalsIgnoreCase("rect")) {
                    // Create tag for each rectangle token encountered
                    Shape aRectangleTag = createTag("rect", fileLineTokenizer);
                    svgTag.addShape(aRectangleTag);

                    // checks if line used to create shape tag contains style keys and attributes
                    while (fileLineTokenizer.hasMoreTokens()) {
                        token = fileLineTokenizer.nextToken(); 
                        // checks if token is not end token 
                        if (!token.equalsIgnoreCase("end")) {
                            String attribute = fileLineTokenizer.nextToken(); // get value of style key 
                            aRectangleTag.addStyle(token, attribute); // add style of shape 
                        }
                    }

                    // Checks the following lines for styling the shape
                    while (!token.equalsIgnoreCase("end")) {
                        fileLineTokenizer = new StringTokenizer(readFileContent.readLine(), " "); 
                        token = fileLineTokenizer.nextToken(); // get style key 
                        if (!token.equalsIgnoreCase("end")) {
                            String attribute = fileLineTokenizer.nextToken(); // get style attribute
                            aRectangleTag.addStyle(token, attribute);
                        }
                    }
                } else if (token.equalsIgnoreCase("circle")) {
                    // Create tag for each circle token encountered  
                    Shape aCircleTag = createTag("circle", fileLineTokenizer);
                    svgTag.addShape(aCircleTag); 

                    // checks if line used to create shape tag has more style tokens 
                    while (fileLineTokenizer.hasMoreTokens()) {
                        token = fileLineTokenizer.nextToken(); 
                        // checks if token does not equal end 
                        if (!token.equalsIgnoreCase("end")) {
                            String attribute = fileLineTokenizer.nextToken(); // get value of style key 
                            aCircleTag.addStyle(token, attribute); // add attribute 
                        }
                    }

                    // check the other lines for style keys and attributes if none found in previous line 
                    while (!token.equalsIgnoreCase("end")) {
                        fileLineTokenizer = new StringTokenizer(readFileContent.readLine(), " "); 
                        // get style key 
                        token = fileLineTokenizer.nextToken(); 
                        if (!token.equalsIgnoreCase("end")) {
                            // get style key attribute 
                            String attribute = fileLineTokenizer.nextToken(); 
                            aCircleTag.addStyle(token, attribute);
                        }
                    } 
                } else {
                    // Catches an invalid shape token 
                    System.out.println("Invalid Token: " + encapsulateToken(token));
                    System.exit(-1);
                }
            }
            
            // Create svg tag with the shape tags 
            svgTag.render(System.out); 
            readFileContent.close(); 
           
            
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

    /**
     * createTag will take the tag header and use that information to create a line, 
     * rectangle or circle object. 
     * @param tagHeader - either line, rectangle, or circle 
     * @param lineTokenizer - the rest of the attributes for the line tag
     * @return a line rectangle or circle object 
     */
    public static Shape createTag(String tagHeader, StringTokenizer lineTokenizer) {
        // Initializing variables to gather information on the shape 
        String token = null; 
        double[] tagAttributes = null; 
        Shape shapeTag = null; 
        // create a line, rectangle, or circle object 
        if (tagHeader.equalsIgnoreCase("line")) {
            try {
                int index = 0; 
                tagAttributes = new double[4]; // stores attributes for line tag 
                // Store the attributes to the array 
                while (index < 4) {
                    token = lineTokenizer.nextToken(); 
                    tagAttributes[index] = Double.parseDouble(token); 
                    index++; 
                }
                // Creating a shape tag and returning it 
                shapeTag = new Line(tagAttributes[0], tagAttributes[1], tagAttributes[2], tagAttributes[3]); 
                return shapeTag;
            } catch (NumberFormatException wrongFormat) {
                // Catch anything that can't be parsed into a double
                System.out.println("Invalid Token: " + encapsulateToken(token));
                System.exit(-1); 
            }
        } else if (tagHeader.equalsIgnoreCase("circle")) {
            try {
                int index = 0; 
                tagAttributes = new double[3]; // attributes for circle tag 
                // stores the attributes into double array 
                while (index < 3) {
                    token = lineTokenizer.nextToken();
                    tagAttributes[index] = Double.parseDouble(token); 
                    index++; 
                }
                // return the circle tag 
                shapeTag = new Circle(tagAttributes[0], tagAttributes[1], tagAttributes[2]);
                return shapeTag;
            } catch (NumberFormatException wrongFormat) {
                // catch if token can't be parsed into double 
                System.out.println("Invalid Token: " + encapsulateToken(token));
                System.exit(-1); 
            }
        } else if (tagHeader.equalsIgnoreCase("rect")) {
            try {
                int index = 0; 
                tagAttributes = new double[4]; // attributes for rectangle 
                // stores the attributes into the double array 
                while (index < 4) {
                    token = lineTokenizer.nextToken(); 
                    tagAttributes[index] = Double.parseDouble(token); 
                    index++; 
                }
                // return the rectangle tag 
                shapeTag = new Rectangle(tagAttributes[0], tagAttributes[1], tagAttributes[2], tagAttributes[3]);
                return shapeTag; 
            } catch (NumberFormatException wrongFormat) {
                // catches if token cannot be parsed into a double
                System.out.println("Invalid Token: " + encapsulateToken(token));
                System.exit(-1); 
            }
        }
        return shapeTag; // return an empty shape tag 
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