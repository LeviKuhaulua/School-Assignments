import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.HashSet; 
/**
 * Solution file to the Kattis problem: I've been everwhere man. 
 * Given a number representing amount of test cases / input. The program 
 * will calculate the amount of unique cities that has been traveled to. 
 * @author 
 *  <A HREF="MAILTO:levi.kuhaulua@outlook.com">Levi Kuhaulua</A> 
 * @version
 *  21.0.1 
 */
public class everywhere { 
    public static void main(String[] args) throws IOException { 
        int testCaseNum;  
        int numFlights; 
        String line; 
        HashSet<String> distinctCities = new HashSet<>(); 
        // boolean isAdded; 
        
        try (BufferedReader r = new BufferedReader(new InputStreamReader(System.in))) { 
            // First line: number of test cases. 
            testCaseNum = Integer.valueOf(r.readLine()); 

            for (int i = 0; i < testCaseNum; i++) { 
                // Test Case: Will specify number of flights taken. 
                numFlights = Integer.valueOf(r.readLine()); 
                for (int j = 0; j < numFlights; j++) {
                    // Add to the HashSet if it wasn't already added. 
                    line = r.readLine(); 
                    distinctCities.add(line); 
                    // Debugging purposes. 
                    // isAdded = distinctCities.add(line); 
                    // System.out.printf("Is %s distinct? -: %b %n", line, isAdded);
                    // System.out.printf("Was %s added? -: %b %n", line, isAdded); 
                }
                // Output the unique amount of citites traveled to before clearing the HashSet. 
                System.out.println(distinctCities.size());
                distinctCities.clear(); 
                
            }
            
        } catch (IOException e) { 
            System.err.println("Error reading input." + e.getMessage());
            System.exit(-1); 
        } catch (NumberFormatException e) {
            System.err.println("This should be a number: " + e.getMessage());
            System.exit(-1); 
        }

    }
}