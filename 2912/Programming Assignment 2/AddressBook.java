
/**
 * Class that will help with creating the Address Book program. This will allow to
 * add and find contacts for the user's address book. 
 * 
 * @author Kuhaulua, Levi 
 * @assignment CSCI 2912 Programming Assignment 2 
 * @date 02/02/2023
 */

import java.util.*; 
public class AddressBook {
    // private variable for list of contacts for user to add and search for contacts 
    private ArrayList<Contact> listOfContacts = new ArrayList<Contact>(); 

  
    /**
     * addContact() - takes in user's input for the contact and adds that to the address book 
     * @param c - the contacts phone number and name
     */
    public void addContact(Contact c) {
        // adding the contact into the address book 
        listOfContacts.add(c);
    }

    /**
     * findContact - will find suggested contacts that the user may be looking for based on the user's input
     * @param s - the user's input
     * @return an ArrayList of the potential found contacts
     */
    public ArrayList<Contact> findContact(String s) {
        // List of potential contacts
        ArrayList<Contact> foundContacts = new ArrayList<Contact>(); 
        
        // Go through each contact in Address Book 
        for(Contact i : listOfContacts) {
            // Check if search terms match name or phone number of contact 
            if (i.toString().toUpperCase().contains(s.toUpperCase())) foundContacts.add(i); 
        }
        
        // returning the list of potential contacts 
        return foundContacts; 
    }

    /**
     * toString() Output the information of the list of contacts
     * @return - Title of the list available to the user 
     */
    public String toString() {
        // Checks if there are contacts to output
        if (listOfContacts.isEmpty()) return "No contacts available";
        else {
            // Creates list for the user 
            String list = "Contacts: \n";
            for (Contact i : listOfContacts) {
                list = list.concat(i.toString() + "\n");
            } 
            return list + "\n" + "Number of Contacts: " + listOfContacts.size(); 
        }
    }
    
}
