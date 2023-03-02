/*
 * @Author: Levi Kuhaulua
 * @Date: 9/16/2022
 * Assignment: Caesar Encryption
 * 
 * Algorithm: 
 * Have user type in message they want to encrypt
 * Have user type in the amt they want to shift
 * Encrypt the message following the shift key
 *  - Make sure that spaces and numbers aren't changed
 * Output the encrypted message to user
 */

import java.util.*; 
public class Lab3 {
    public static void main(String[] args) {
        // user input
        Scanner keyboard = new Scanner(System.in); 

        // User's input for message they want to encrypt
        String msg; 
        System.out.println("Enter a message to Encrypt: ");
        msg = keyboard.nextLine(); 
        //System.out.println(msg); 

        //User's input for the shift for Caesar's Cipher
        int shift; 
        System.out.println("Enter the shift key: "); 
        shift = keyboard.nextInt(); 
        //System.out.println(shift); 
        
        // Find characters of message and encrypt it 
        char letter; 
        int length = msg.length(); 
        //System.out.println(length);
        int shiftLetter;  

        

        //Encryption Machine
        for (int i = 0; i < length; i++) {
            letter = msg.charAt(i); 
            shiftLetter = (int)letter;

            if (((int)letter >= 65 && (int)letter <=90) || ((int)letter >= 97 && (int)letter <= 122)) { 
                if (((int)letter + shift) > 122) {
                    shiftLetter = letter + shift - 26; 
                } else if (((int)letter + shift) > 90 && ((int)letter + shift) < 97) {
                    shiftLetter = letter + shift - 26;
                } else {
                    shiftLetter = letter + shift;
                }
                 
            } else if (!((int)letter >= 65 && (int)letter <=90) || ((int)letter >= 97 && (int)letter <= 122)) {
                shiftLetter = (int)letter;
            }
            System.out.print((char)shiftLetter); 
        }
        keyboard.close(); 
    }
}

