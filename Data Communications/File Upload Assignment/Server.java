import java.net.ServerSocket; 
import java.net.SocketException; 
import java.net.Socket; 

import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.io.PrintWriter;
import java.io.IOException;  

import java.util.Random;
public class Server {
    public static void main(String[] args) throws IOException {
        
        ServerSocket server = null; 
        Socket client = null; 
        String line; 
        String initFileName = "ServerXXX"; 
        Random r = new Random(); 

        try {
            server = new ServerSocket(12345); 
            System.out.println("Server Socket established.");
        } catch (IOException e) {
            System.err.println("Could not listen on Port 12345");
            System.exit(-1); 
        }

        try {
            client = server.accept(); 
            System.out.println("Connection established with client.");
        } catch (IOException e) {
            System.err.println("Connection failed");
            System.exit(-1); 
        }

        BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); 
        PrintWriter toClient = new PrintWriter(client.getOutputStream(), true); 

        while ((line = fromClient.readLine()) != null) {
            if (line.trim().equalsIgnoreCase("Aloha")) {
                System.out.println("Welcome message received. Sending one back");
                toClient.println("Aloha mai kakou"); 
                break; 
            }
        }

        toClient.close(); 
        fromClient.close(); 
        client.close(); 
        server.close(); 

        System.exit(0); 
    }
}