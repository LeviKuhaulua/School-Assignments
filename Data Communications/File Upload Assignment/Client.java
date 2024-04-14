import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader; 
import java.io.PrintWriter; 

import java.net.Socket; 
import java.net.UnknownHostException;
import java.net.SocketException; 


public class Client {
    public static void main(final String[] args) {
        Socket client; 
        String hostName = "127.0.0.1"; 
        String line; 
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in)); 
        
        if (args.length > 0) {
            hostName = args[0]; 
        }

        try {
            client = new Socket(hostName, 12345); 
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream())); 
            PrintWriter toServer = new PrintWriter(client.getOutputStream(), true); 

            System.out.println(fromServer.readLine());
        } catch (UnknownHostException e) {
            System.err.println("Unknown Host Name: " + hostName);
            System.exit(-1); 
        } catch (SocketException e) {
            e.printStackTrace(); 
            System.exit(-1); 
        } catch (IOException e) {
            e.printStackTrace(); 
            System.exit(-1); 
        }
    }
}