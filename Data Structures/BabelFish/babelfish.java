import java.util.HashMap; 
import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.io.IOException; 
import java.util.Arrays; 
/**
 * Solution to the Babelfish problem found in <A HREF="https://open.kattis.com">Kattis</A>. This will take input and then output
 * a translation of foreign words to their English equivalent or <CODE>eh</CODE> if no translation is found. 
 * @author <A HREF="MAILTO:levi.kuhaulua@outlook.com">Levi Kuhaulua</A>
 * @version 11.0.21 
 */
public class babelfish {
    
    
    public static void main(String[] args) {

        // Initializing variables for reading and storing input. 
        BufferedReader input; 
        String line = null; 
        String[] entries = null; 
        HashMap<String, String> dictionary = new HashMap<>(); 
        
        try {
            
            input = new BufferedReader(new InputStreamReader(System.in)); 
            
            // First Segment: Getting the Dictionary Entries. 
            while ((line = input.readLine()) != null) {
                
                // End of dictionary entries is marked by a blank line. 
                if (line.isBlank()) {
                    break; 
                }

                entries = line.split(" "); 

                if (entries.length > 2) {
                    throw new IllegalArgumentException("Dictionary entry contains more than 2 values: " + Arrays.toString(entries));
                }

                // Debugging Purposes. 
                // System.out.printf("English Word: %s | Foreign Equivalent: %s %n", entries[0], entries[1]);

                dictionary.putIfAbsent(entries[1], entries[0]); 
            }

            // Debugging Purposes. 
            // dictionary.forEach((k, v) -> 
            //     System.out.println("Key: " + k + "| Value: " + v));

            // Second Segment: Get sentence then translate to English equivalent or "eh" if not found. 
            while ((line = input.readLine()) != null) {
                
                // Skip over empty lines. 
                if (line.isBlank()) {
                    continue; 
                }

                if (dictionary.containsKey(line)){
                    System.out.println(dictionary.get(line));
                } else {
                    System.out.println("eh");
                }
            }

            input.close(); 

        } catch(IOException e) {
            e.printStackTrace(); 
        }

        
    }

}