
/**
 * A class that will help with designing an address book program by allowing for creation of contacts. 
 * 
 * @author Kuhaulua, Levi
 * @assignment CSCI 2912 Programming Assignment 2
 * @date 02/02/2023
 */
public class Contact {
    // private variables for the name and phone number of the contact 
    private String name, phone;
    
    /**
     * Contact() - constructor that takes in the arguments for a person's name and phone and sets the variables to them
     * @param name - Full name of the contact 
     * @param phone - the phone number of the contact
     */
    public Contact(String name, String phone) {
        this.name = name; 
        this.phone = phone; 
    }
   
    /**
     * toString() - outputs the contact's information.
     * @return returns the name and phone number of the contact 
     */
    public String toString() {
        return name + ", " + phone; 
    }
}
