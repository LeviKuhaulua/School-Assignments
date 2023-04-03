/*
 * Quick demo of how you could make Hash Map with a class
 */
import java.util.HashMap;
import java.util.Scanner; 
public class BankAccountDemo {
    public static void main(String[] args) {
        BankAccount oneBankAccount = new BankAccount("Checkings", 2001); 
        BankAccount twoBankAccount = new BankAccount("Savings", 2002); 
        BankAccount threeBankAccount = new BankAccount("Commercial", 2003); 

        // Person Associated with Account
        HashMap<String, BankAccount> customerAccount = new HashMap<>(); 
        customerAccount.put("Levi", oneBankAccount); 
        customerAccount.put("Shay", twoBankAccount); 
        customerAccount.put("Kula", threeBankAccount); 
        
        // Check if person doesn't exist
        Scanner keyboard = new Scanner(System.in); 
        String name; 
        System.out.println("What account would you like to look up");
        name = keyboard.nextLine(); 

        if(!customerAccount.containsKey(name)) {
            System.out.println("Person does not have an account here");
        } else customerAccount.get(name).displayAccountInfo();
        keyboard.close(); 
        

        
    }
}