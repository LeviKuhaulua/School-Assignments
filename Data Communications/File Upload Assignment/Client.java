import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader; 
import java.io.PrintWriter; 

import java.net.Socket; 
import java.net.UnknownHostException;
import java.net.SocketException; 

import java.io.File;

public class Client {
    public static void main(final String[] args) throws IOException{
        // Initializating variables. 
        Socket client = null; 
        String hostName = "127.0.0.1"; // Make default - localhost
        String line; 
        BufferedReader fromServer = null; 
        PrintWriter toServer = null; 

        // Use diff. hostname if one found in arguments of Command Line. 
        if (args.length > 0) {
            hostName = args[0]; 
        }

        try {
            client = new Socket(hostName, 12345); 
            System.out.println("Connection to server established.");
        } catch (UnknownHostException e) {
            System.err.println("Unknown Host: " + hostName);
            System.exit(-1); 
        } catch (IOException e) {
            System.err.println("Socket error detected: " + e.getMessage());
        }

        fromServer = new BufferedReader(new InputStreamReader(client.getInputStream())); 
        toServer = new PrintWriter(client.getOutputStream(), true); 

        toServer.println("Aloha"); 
        
        while ((line = fromServer.readLine()) != null) {
            if (line.trim().equalsIgnoreCase("Aloha mai kakou")) {
                System.out.println("Welcome message received. Beginning file transfer.");
                break; 
            }
        }
        

        toServer.close(); 
        fromServer.close(); 
        client.close(); 

        System.exit(0); 
    }
}