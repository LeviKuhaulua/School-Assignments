public class keyedBagDemo {
    public static void main(String[] args) {
        
        keyedBag a = new keyedBag(); 
        keyedBag b = new keyedBag(2); 
        keyedBag nullBag = null; 
        keyedBag notInitBag;  

        // Constructors and capacity method. 
        // System.out.println("Checking Constructors");
        // System.out.printf("keyedBag a - Expected Capacity: 10 | Actual: %d %n", a.getCapacity());
        // System.out.printf("keyedBag b - Expected Capacity: 2 | Actual: %d %n", b.getCapacity());

        // Testing add, trimToSize, getItem, and size method. 
        a.add(1, "Levi"); 
        a.add(2, "Lucas"); 
        a.add(3, "Luka"); 

        // System.out.printf("Expected Size: 3 | Actual Size: %d %n", a.size()); 
        // System.out.printf("Size before trim: %d | ", a.getCapacity()); 
        // a.trimToSize(); 
        // System.out.printf("Size after trim: %d %n", a.getCapacity()); 

        // System.out.printf("Getting value with key 1. Expected value: Levi | Actual Value: %s %n", a.getItem(1)); 
        // System.out.printf("Getting an invalid search key. Expected value: null | Actual value: %s %n", a.getItem(100)); 

        // Testing addMany, addAll method. 
        b.add(4, "Leviticus"); 
        b.add(5, "Larry"); 
        b.add(1, "Lovely");

        a = keyedBag.union(a, b); 

        

        // int[] keys = {10, 11, 12}; 
        // String[] items = {"Levites", "Lana", "Loyd"}; 

        // a.addMany(keys, items); 
        // System.out.printf("keyedBag a - new size should be 6 | Actual %d %n", a.size()); 
        // a.addAll(b); 
        // System.out.printf("keyedBag a - new size should be 8 | Actual size: %d %n", a.size()); 
        // System.out.printf("Confirming it added. Get value of key 4: %s | Get value of key 10: %s. SHOULD NOT BE NULL"
        // , a.getItem(4), a.getItem(10)); 

        // Clone method
        keyedBag c = a.clone(); 
        // System.out.printf("Does a.equals(c) result to true? %b %n", a.equals(c)); 
        // System.out.printf("Does a == c result in true? %b %n", a == c); 

        // // Union method
        // c = keyedBag.union(a, b); 
        // System.out.printf("Expected size: 5 | Actual: %d %n", c.size()); 

        // Remove and Ensure Capacity
        // b.ensureCapacity(20); 
        // System.out.printf("Expectes Capacity: 20 | Actual: %d %n", b.getCapacity()); 

        // System.out.printf("Did it actually remove key 4 and item associated? %b %n", b.remove(4)); 
        // System.out.printf("Expected value when removing a search key not in bag: false | actual: %b %n", b.remove(100)); 

        // checkForKey method
        // System.out.printf("Expected value when looking for key 4: true | actual: %b %n", b.checkForKey(4)); 
        // System.out.printf("Expected value when looking for key 100: false | actual: %b %n", b.checkForKey(100)); 

        // Boundary Testing
        int reallyLargeNumber = Integer.MAX_VALUE; 

        keyedBag d = new keyedBag(); 
        // d = new keyedBag(reallyLargeNumber); 
        // System.out.println(d.getCapacity()); // OutOfMemory Error
        // d = new keyedBag(-1); 
        // System.out.println(d.getCapacity()); // IllegalArgumentException

        // d.ensureCapacity(reallyLargeNumber); // OutOfMemoryError
        // d.ensureCapacity(-1); // IllegalArgumentException

        // d.addAll(nullBag); // NullPointerException

        // a.add(1, "Levi"); // IllegalArgumentException 
        // a.add(reallyLargeNumber + 1, "Levites"); // Arithmetic overflow. 
        


        
      
    }
}