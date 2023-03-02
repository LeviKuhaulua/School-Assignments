/**
 * A program that will act as a user's address book that contains the list of contacts and allows user 
 * to find contacts. 
 * 
 * @author Kuhaulua, Levi
 * @assignment CSCI 2912 Programming Assignment 2
 * @date 02/02/2023
 */
import java.util.*; 
public class KuhauluaLevi2 {
    public static void main(String[] args) {
        // variables for the user's input for the program
        String userInput; 
        Scanner keyboard = new Scanner(System.in);  

        // Variables for the program 
        AddressBook usersList = new AddressBook(); 
        ArrayList<Contact> potentialList; 
        String name, phoneNum, search;
       
        // Address Book Program 
        boolean quitProgram = false; 
        // Runs program until user quits 
        while(!quitProgram) {
            // Give menu options to user
            printMenu();
            userInput = keyboard.nextLine().trim(); 

            // Determine which Address Book function to perform based on user input
            if (userInput.equalsIgnoreCase("Add")) {
                // Adding contact's information, phone number and name, for Address Book 
                System.out.println("Name: ");
                name = keyboard.nextLine().trim(); 
                while(name.isBlank()) { // checks if name is empty 
                    System.out.println("Invalid Input. Please enter Name: ");
                    name = keyboard.nextLine().trim(); 
                }
                System.out.println("Phone Number: ");
                phoneNum = keyboard.nextLine().trim(); 
                while(phoneNum.isBlank() || phoneNum.matches("[a-zA-Z]+")) { // checks for emptiness or invalid format
                    System.out.println("Invalid Input. Please enter Phone Number: ");
                    phoneNum = keyboard.nextLine(); 
                }
                usersList.addContact(new Contact(name, phoneNum)); // Add contact to the address book 
                System.out.println("Added: " + name + ", " + phoneNum); // visual confirmation for user 
            } else if (userInput.equalsIgnoreCase("Find")) { 
                // Find potential contacts for user 
                System.out.println("Search for: ");
                search = keyboard.nextLine().trim(); 
                while (search.isBlank()) { // checks to see if input is blank 
                    System.out.println("Invalid Input. Please Enter Search Term(s): ");
                    search = keyboard.nextLine().trim(); 
                }
                potentialList = usersList.findContact(search); // get found contacts 
                if (potentialList.isEmpty()) System.out.println("No Contacts Found"); 
                else {
                    // Output the potential contacts 
                    for (Contact i : potentialList) {
                        System.out.println(i.toString());
                    }
                    System.out.println("Number of Contacts Found: " + potentialList.size()); 
                }
            } else if (userInput.equalsIgnoreCase("Print")) System.out.println(usersList.toString()); // Output contact list
            else if (userInput.equalsIgnoreCase("Quit")) quitProgram = true; // When user opts to quit the program
            else {
                // When input does not match any of the functions 
                System.out.println("Invalid Command");
                printMenu(); 
                userInput = keyboard.nextLine().trim(); 
            }
        }
    
        // Exit program 
        System.exit(0); 
        keyboard.close(); 
        
    }

    /**
     * printMenu - Prints the menu options for the user 
     */
    public static void printMenu() {
        // Menu 
        System.out.println("~ Address Book Menu ~" 
        + "\n+-----------------------------+\n"
        + "ADD   Adds a contact\n" + "FIND   Finds a contact\n" 
        + "PRINT   Prints contacts\n" + "QUIT   Quits\n"
        + "+-----------------------------+"); 
    }
}
