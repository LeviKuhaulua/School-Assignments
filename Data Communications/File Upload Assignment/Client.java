import java.net.Socket; 
import java.net.UnknownHostException; 
import java.io.IOException; 
import java.io.DataInputStream; 
import java.io.DataOutputStream; 
import java.io.InputStreamReader; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.nio.file.Paths; 
import static java.nio.file.StandardOpenOption.*; 
import java.util.Arrays; 

public class Client {

    private static void print(String[] arr) {
        for (String i : arr) {
            System.out.println(i);
        }
    }
    public static void main(final String[] args) throws IOException{
        
        String hostname = "localhost";  // Default if no args specified when running file. 
        BufferedReader fromServer = null; 
        BufferedReader stdIn = null; 
        PrintWriter toServer = null; 
        String line = null; 
        

        // In case user specifies a hostname. 
        if (args.length > 0) {
            hostname = args[0]; 
        }

        
        // Establish connection with server. 
        try (Socket client = new Socket(hostname, 12345)) {
            
            fromServer = new BufferedReader(new InputStreamReader(client.getInputStream())); 
            toServer = new PrintWriter(client.getOutputStream(), true); 

            // Client Side: Send "Aloha" welcome message. 
            toServer.println("Aloha"); 

            while ((line = fromServer.readLine()) != null) {
                if (line.trim().equalsIgnoreCase("Aloha Mai Kakou")) {
                    System.out.println("Welcome message received. Starting file transfer.");
                    break; 
                } 
            }


            stdIn = new BufferedReader(new InputStreamReader(System.in)); 
            Path dir = Paths.get(".\\"); 
            String[] fileNames = Files.list(dir).map(f -> f.getFileName().toString()).toArray(String[]::new); 
            
            // Print out directory for user to pick a file. 
            System.out.println("Pick a file to upload: "); 
            print(fileNames); 
            
            // Continue to get user input if file does not match any of those found in the directory. 
            while(Arrays.binarySearch(fileNames, (line = stdIn.readLine())) == -1) {
                System.out.println("Pick a file to upload: \n");
                print(fileNames); 
            }

            stdIn.close();
            
            // File chosen by user. 
            Path fileToUpload = Paths.get(line); 
            byte[] fileContentBytes; 

            
                       
            
            
        } catch (UnknownHostException e) {
            System.err.println("Unknown Host: " + hostname);
            System.exit(-1); 
        } catch (IOException e) {
            System.err.println("Error connecting to server." + e.getMessage());
            System.exit(1); 
        } finally {
            stdIn.close(); 
            fromServer.close(); 
            toServer.close(); 
        }
    }

    
    
}