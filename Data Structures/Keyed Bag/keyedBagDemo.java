public class keyedBagDemo {
    public static void main(String[] args) {
        
        KeyedBag a = new KeyedBag(); 
        KeyedBag b = new KeyedBag(5); 

        System.out.println("Checking Constructors");
        System.out.printf("KeyedBag a - Expected Capacity: 10 | Actual: %d %n", a.getCapacity());
        System.out.printf("KeyedBag b - Expected Capacity: 5 | Actual: %d %n", b.getCapacity());
        // b = new KeyedBag(-1); 

    }
}