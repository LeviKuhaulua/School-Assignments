/*
 * @Author: Levi Kuhaulua
 * @Date: 9/23/2022
 * 
 * Assignment: Sales File
 * 
 * Algorithm: 
 * Create a File calles sales.txt
 * Have user input for 4 options: 
 *  - 1) Enter Sales Figures (in Files) *has to be done first
 *  - 2) Display Sales Figures
 *  - 3) Display the Total Sales
 *  - 4) Or Exit Program 
 * Add user's data to the file 
 * Output certain data depending on choices above
 * 
 * Extra Credit, Add 2 more options to menu
 */

 import java.util.*;
 import java.io.*;

public class lab4_Sales {
    public static void main(String[] args) throws IOException{

        // User Input
        Scanner keyboard = new Scanner(System.in);
        int userChoice; // To ensure user puts in a valid input 

        // Variables for the Sales. 
        float salesFigures; // Allow user to input the sales 
        int salesAmt; // Be able for user to report the amount of weeks of sales
        float totalSales = 0;  //accumulator for the total amt of sales user made
    

        // Files for validation 

        File readSales = new File ("sales.txt"); // read the files 



        System.out.println("Welcome! Please specify what you want to do? \n" +
        "1) Enter Sales Figures (Please do this first if no data)\n" +
        "2) Display Sales Figures \n" + "3) Display Total Sales \n" +
        "4) Exit Program");

        // Input Validation 
        while (!keyboard.hasNextInt()) {
            System.out.println("Please input an integer."); 
            keyboard.nextLine(); 
        }

        userChoice = keyboard.nextInt();

        while(userChoice < 0 || userChoice > 4) {
            System.out.println("That number is out of range, please select a valid number from 1 through 4");
            userChoice = keyboard.nextInt(); 
        }
        
        boolean fileExists = (userChoice == 2 || userChoice == 3) && !readSales.exists(); // to check if the file exists
        
    
        if (userChoice == 4) {
            System.out.println("You have exited the program.");
            System.exit(0);  
        } else if (fileExists) { // checks to see if the file exists before user can see any data (total or sales figure);
            System.out.println("Your file for sales does not exist, please select option 1"); 
            System.exit(0); 
        } else { // create a file and have user input sales figures
            PrintWriter salesFile = new PrintWriter("sales.txt"); // Open up a file called sales.txt
            System.out.println("How many weeks of sales would you like to report?");
            
            // input validation 
            while(!keyboard.hasNextInt()) {
                System.out.println("Please input a valid integer: ");
                keyboard.nextLine(); 
            }

            salesAmt = keyboard.nextInt(); 
            
            while (salesAmt < 0) {
                System.out.println("Please input a valid amount of weeks: ");
                salesAmt = keyboard.nextInt(); 
            }
            
            // Have user input sales amount for however many weeks they inputted
            for (int i = 1; i <= salesAmt; i++) {
                System.out.println("Enter week " + i + " sales: ");
                salesFigures = keyboard.nextFloat(); 

                salesFile.println(salesFigures); // input sales data into the file 
            }
            salesFile.close(); // close the file once added

            // keeps running the program until user selects option 4 
            while (userChoice != 4) {
                System.out.println("*****Files Operation Menu***** \n"
                + "1) Enter Sales Figure \n"
                + "2) Display Sales Figure \n" + "3) Display Total Sales \n"
                + "4) Exit Program");
                
                // input validation
                while(!keyboard.hasNextInt()) {
                    System.out.println("Please input a valid integer.");
                    keyboard.nextLine(); 
                }
            
                userChoice = keyboard.nextInt(); 
            
                while (userChoice < 0 || userChoice > 4) {
                    System.out.println("Please input a number in the range. ");
                    userChoice = keyboard.nextInt(); 
            }
                
                if (userChoice == 1) {
                    FileWriter addSale = new FileWriter("sales.txt", true); 
                    PrintWriter append = new PrintWriter(addSale); // append new sales figures to sales.txt

                    System.out.println("How many weeks would you like to add?");
                
                    salesAmt = keyboard.nextInt(); 
                    
                    // input validation
                    while (salesAmt < 0) {
                        System.out.println("Please input a valid amount");
                        salesAmt = keyboard.nextInt(); 
                }

                    for (int i = 1; i <= salesAmt; i++ ) {
                        System.out.println("Enter Sales Figure: ");
                        salesFigures = keyboard.nextFloat(); 

                        append.println(salesFigures); // Append any new sales to the file sales.txt
                }

                    append.close(); // close file to make sure data is added 
                } else if (userChoice == 2) {
                    Scanner readSalesFile = new Scanner(readSales); // used to read the data of sales.txt
                
                    System.out.println("Sales Figures for the weeks: ");
                
                    // check all the data within sales.txt and output to the user each week's sale data
                    while (readSalesFile.hasNext()) {
                        salesFigures = readSalesFile.nextFloat(); 
                        System.out.println(salesFigures);
                }

                    readSalesFile.close(); 
                } else if (userChoice == 3) {
                    totalSales = 0; // resets total amount of sales in case user wishes to see the total amount again
                    Scanner readSalesFile = new Scanner(readSales); // reading sales file once again
                
                    System.out.println("Total Sales: ");
                    
                    // read each data within sales file and then sum them all up 
                    while (readSalesFile.hasNext()) { 
                        salesFigures = readSalesFile.nextFloat(); 
                    
                        totalSales = totalSales + salesFigures; 
                     }

                    System.out.print(totalSales + "\n");

                    readSalesFile.close(); 
                } 

                if (userChoice == 4) {
                    System.out.println("Exiting Program");
                    System.exit(0);
                }
             }
            
            }
            
            keyboard.close(); 
        }

    }
