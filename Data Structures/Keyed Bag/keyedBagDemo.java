public class keyedBagDemo {
    public static void main(String[] args) {
        
        keyedBag a = new keyedBag(); 
        keyedBag b = new keyedBag(5);  

        // System.out.println("Checking Constructors");
        // System.out.printf("keyedBag a - Expected Capacity: 10 | Actual: %d %n", a.getCapacity());
        // System.out.printf("keyedBag b - Expected Capacity: 5 | Actual: %d %n", b.getCapacity());
        // b = new KeyedBag(-1); 

        System.out.println("\nChecking Add and Size method");
        a.add(0, "Levi"); 
        a.add(1, "Leviticus"); 
        System.out.printf("Expected Size: 2 | Actual: %d %n", a.size());
        a.add(-12, "Invalid"); 
    }
}