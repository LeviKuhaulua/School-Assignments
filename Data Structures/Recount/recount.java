import java.util.Scanner;  
import java.util.Collections; 
import java.util.HashMap; 
import java.util.regex.Pattern; 

/**
 * Solving the <A HREF="https://open.kattis.com/problems/recount">Recount</A> problem found on the Kattis website. 
 * Given a list of candidates, output the candidate with a simple/absolute majority or {@code Runoff!} if no majority is
 * found. 
 * 
 * <P> 
 *  <B>INPUT:</B> A list of names. Each name can consist of hyphens and multiple words. The end of the list is denoted by 
 *  a single line with the characters {@code ***}. 
 * </P> 
 * @author 
 *  <A HREF="MAILTO:levi.kuhaulua@outlook.com">Levi Kuhaulua</A> 
 * @version
 *  11.0.21
 */
public class recount {

    public static void main(String[] args) {
        
        // Get each candidate of the list. 
        Scanner input = new Scanner(System.in); 
        String line = null; 

        // Key-Value pair mapping for candidates and the amount of votes they receive. 
        HashMap<String, Integer> candidates = new HashMap<>(); 
        
        while (input.hasNext() && !(line = input.nextLine()).equals("***")) {

            // Skip over any inputs that are not valid. Valid characters are letters, hyphens, and spaces. 
            if (!Pattern.matches("[A-Za-z- ]+", line) || line.isBlank()) {
                continue; 
            }

            candidates.computeIfPresent(line, (key, value) -> value += 1); 
            candidates.putIfAbsent(line, 1); 

        }

        input.close(); 

        // Debugging Purposes. 
        // candidates.forEach((key, value) -> 
        //     System.out.printf("%s: %d %n", key, value)
        // ); 

        if (candidates.size() == 0) {
            throw new IllegalArgumentException("Empty list detected"); 
        }

        int maxVote = Collections.max(candidates.values()); 

        if (Collections.frequency(candidates.values(), maxVote) > 1) {
            // Case: No candidate has a simple / absolute majority, therefore output Runoff!
            System.out.println("Runoff!");
        } else {
            // Case: There does exist a candidate with a majority, therefore iterate through the list and find the candidate. 
           for (String i : candidates.keySet()) { 
                if (candidates.get(i) == maxVote) {
                    System.out.println(i);
                    break; 
                }
           }
        }
    
    }
}