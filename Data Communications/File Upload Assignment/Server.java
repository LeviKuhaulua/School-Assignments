import java.net.ServerSocket; 
import java.net.SocketException; 
import java.net.Socket; 

import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.io.PrintWriter;
import java.io.IOException;  

public class Server {
    public static void main(String[] args) {
        
        ServerSocket server; 
        Socket client; 
        String line; 

        try {
            server = new ServerSocket(12345); 
            client = server.accept(); 
            
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); 
            PrintWriter toClient = new PrintWriter(client.getOutputStream(), true); 

            while ((line = fromClient.readLine()) != null) {
               
                if (line.equalsIgnoreCase("Bye")) {
                    break; 
                }

                System.out.println("From Client: " + line);
                toClient.println("Server: " + line); 
            }

            fromClient.close(); 
            toClient.close(); 
            client.close(); 
            server.close(); 
        } catch (SocketException e) {
            e.printStackTrace();
            System.exit(-1); 
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1); 
        }
        System.exit(0); 
    }
}