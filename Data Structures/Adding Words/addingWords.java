import java.util.Arrays; 
import java.util.HashMap; 
import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.io.IOException; 

/**
 * Solution to the <A HREF="https://open.kattis.com/problems/addingwords">Adding Words</A> problem found in Kattis. 
 * Program will take in a list of commands: def, calc, and clear and output the equations found in the calc command 
 * with the result. Note that the result will be a word or <CODE>Unknown</CODE> if the word wasn't previously defined 
 * with the <CODE>def</CODE> command or if the result is not equal to any of the known words. 
 * @author 
 *  <A HREF="MAILTO:levi.kuhaulua@outlook.com">Levi Kuhaulua</A> 
 * @version 
 *  11.0.21
 */
public class addingWords {
    public static void main(String[] args) throws IOException{
        
        // Variables for commands found within input. 
        final String DEF = "def"; 
        final String CALC = "calc"; 
        final String CLR = "clear"; 

        String line[] = null; 
        String output = ""; 
        String input; 
        HashMap<String, Integer> words = new HashMap<>(); 
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in)); 
        
        while ((input = r.readLine()) != null) {
            line = input.split("[ ]+"); 
            
            if (line[0].equals(CLR)) {
                // Check if clear command inputted has arguments. 
                if (line.length > 1) {
                    throw new IllegalArgumentException("Cannot have arguments with clear command"); 
                }
                if (words.size() == 0) {
                    continue; 
                }
                words.clear(); 
            } else if (line[0].equals(DEF)) {
                // Check if input is trying to define multiple values for one word. 
                if (line.length > 3) { 
                    throw new IllegalArgumentException("Can't define more than one value for: " + line[1]); 
                } 
                if (Integer.valueOf(line[2]) < -1000 || Integer.valueOf(line[2]) > 1000) {
                    // Range specified in Kattis problem. 
                    throw new IllegalArgumentException("Value for: " + line[1] + " has to be in range [-1000, 1000]");
                }
                words.put(line[1], Integer.valueOf(line[2])); 
            } else if (line[0].equals(CALC)) {
                // System.out.println(Arrays.toString(line)); // Debugging purposes. 
               
                if(input.contains("*") | input.contains("/")) {
                    throw new IllegalArgumentException("Calculations only allowed are '+' or '-'"); 
                }

                
                int result = 0; 
                boolean isNull = false; 
                String operation = null; 
                
                if (words.get(line[1]) == null) {
                    isNull = true; 
                } else {
                    result = words.get(line[1]); 
                }

                // Iterate through the loop and sum or subtract the "words". 
                for (int i = 2; i < (line.length - 1) && !isNull; i++) {
                    
                    if (i % 2 == 0) {
                        // Store the arithmetic operation for later use.
                        operation = line[i]; 
                        continue; 
                    } else if (line[i].equals("+") || line[i].equals("-")) {
                        throw new IllegalArgumentException("Can't have two operations in a row in calculations"); 
                    }

                    if (words.get(line[i]) == null) { 
                        // Break out of loop should the word variable not have been previously defined. 
                        isNull = true; 
                        break; 
                    } else if (operation.equals("+")) { // Only do arithmetic operations if the word has been defined. 
                        result += words.get(line[i]); 
                    } else {
                        result -= words.get(line[i]); 
                    }
                    
                }

                // Logic: create the output statement. 
                for (String i : line) {
                    if (i.equalsIgnoreCase(CALC)) {
                        continue; 
                    }

                    output += i + " "; 
                }

                // If word is null or result is not mapped to any word, use "unknown" after '=' sign. 
                if (isNull) {
                    System.out.println(output + "unknown");
                } else if (!words.containsValue(result)) {
                    System.out.println(output + "unknown"); 
                } else {
                    // Output all the words that are mapped to the result. 
                    for (String i : words.keySet()) {
                        if (words.get(i) == result) {
                            System.out.println(output + i);
                        }
                    }
                }
                
                output = "";
                
            } else {
                throw new IllegalArgumentException("Command entered does not match any acceptable commands"); 
            }
        }
             
       r.close(); 
    }
}