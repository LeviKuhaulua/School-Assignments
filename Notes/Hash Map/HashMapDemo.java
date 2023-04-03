/*
 * Learning how Hash Maps work and some applications
 */
import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) {
        /*
         * Initializing a HashMap
         * Keys are the first parameter 
         * Value is mapped to the key which in this case is Integer 
         */
        HashMap<String, Integer> studentIDs = new HashMap<>(); 
        HashMap<String, Integer> emptyStudentIDList = new HashMap<>(); 
        // Adding values to a Hash-Map 
        studentIDs.put("Levi", 54321); 
        studentIDs.put("Janica", 12345); 
        studentIDs.put("Shay", 67890);
        
        // Adding all elements of one Hash Map into another 
        emptyStudentIDList.putAll(studentIDs);

        // Printing Elements
        System.out.println(studentIDs); 
        System.out.println(studentIDs.keySet()); // Prints the keys 
        System.out.println(studentIDs.values()); // Prints values associated with keys 
        System.out.println(emptyStudentIDList); // Hash Map that added all values of another 

        // Finding elements in a Hash Map based on key
        System.out.println(studentIDs.get("Janica"));
        
        // Boolean Operation: 
        System.out.println(studentIDs.containsKey("Levi")); // Checks if key is in Hash Map 
        System.out.println(studentIDs.containsValue(54321)); // Checks if value is in Hash Map 

        // Removing Elements 
        studentIDs.remove("Levi"); 
        System.out.println(studentIDs);

        // Updating a Hash Map 
        // If key exists, then it will replace value
        studentIDs.put("Janica", 765432); 
        System.out.println(studentIDs);
        
        // Works only if key is present in Hash Map 
        studentIDs.replace("Levi", 876543); 
        System.out.println(studentIDs);

        // Works only if key is not in Hash Map 
        studentIDs.putIfAbsent("Levi", 123456);


        
    }
}