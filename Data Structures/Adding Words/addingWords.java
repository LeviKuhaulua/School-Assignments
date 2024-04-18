import java.util.Arrays;
import java.util.HashMap; 
import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.io.IOException; 
import java.io.PrintWriter; 

public class addingWords {
    public static void main(String[] args) throws IOException{
        
        // Variables for commands found within input. 
        final String DEF = "def"; 
        final String CALC = "calc"; 
        final String CLR = "clear"; 

        String line[] = null; 
        String output = ""; 
        String input; 
        // Variables for storing words and their associated definitions. 
        HashMap<String, Integer> words = new HashMap<>(); 
        HashMap<Integer, String> values = new HashMap<>(); 
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in)); 
        PrintWriter out = new PrintWriter(System.out, true); 
        
        // Get the input and store them into a String[] array. 
        while ((input = r.readLine()) != null) {
            line = input.split("[ ]+"); 
            
            if (line[0].equalsIgnoreCase(CLR)) {
                words.clear(); 
                values.clear(); 
            } else if (line[0].equalsIgnoreCase(DEF)) {
                words.put(line[1], Integer.valueOf(line[2])); 
                values.put(Integer.valueOf(line[2]), line[1]); 
            } else if (line[0].equalsIgnoreCase(CALC)) {
                // System.out.println(Arrays.toString(line));
                int result = 0; 
                boolean isNull = false; 
                String operation = null; 
                
                if (words.get(line[1]) == null) {
                    isNull = true; 
                } 

                // Set result equal to the first word variable in the calc command. 
                result = words.get(line[1]); 

                for (int i = 2; i < (line.length - 1) && !isNull; i++) {
                    
                    if (i % 2 == 0) {
                        // Store the arithmetic operation for later use.
                        operation = line[i]; 
                        continue; 
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


                for (String i : line) {
                    if (i.equalsIgnoreCase(CALC)) {
                        continue; 
                    }

                    output += i + " "; 
                }

                if (isNull) {
                    out.println(output + "unknown");
                } else if (values.get(result) == null) {
                    out.println(output + "unknown"); 
                } else {
                    out.println(output + values.get(result)); 
                }
                
                out.flush(); 
                output = ""; 
                
            } else {
                throw new IllegalArgumentException("Command entered does not match any acceptable commands"); 
            }
        }
             
       r.close(); 
       out.close(); 
    }
}