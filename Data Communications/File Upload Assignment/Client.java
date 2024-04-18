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
import java.util.regex.Matcher;
import java.util.regex.Pattern; 
import static java.nio.file.StandardOpenOption.*; 

public class Client {

    public static void main(final String[] args) throws IOException{
        
        String hostname = "localhost";  // Default if no args specified when running file. 
        BufferedReader fromServer = null; 
        PrintWriter toServer = null; 
        String line = null; 
        BufferedReader stdIn = null; 
        

        // In case user specifies a hostname. 
        if (args.length > 0) {
            hostname = args[0]; 
        }

        
        // Establish connection with server. 
        try (Socket client = new Socket(hostname, 12345)) {
            
            fromServer = new BufferedReader(new InputStreamReader(client.getInputStream())); 
            toServer = new PrintWriter(client.getOutputStream(), true); 

            // Get client to say hi to the server. 
            stdIn = new BufferedReader(new InputStreamReader(System.in)); 
            while ((line = stdIn.readLine()) == null || !line.equalsIgnoreCase("Aloha")) {
                System.out.println("Say \"Aloha\" to the server: "); 
            }

            toServer.println(line); 

            while ((line = fromServer.readLine()) != null) {
                if (line.trim().equalsIgnoreCase("Aloha Mai Kakou")) {
                    System.out.println("Server: " + line);
                    break; 
                } 
            }

            
            // Name of file to upload. 
            Path fileToUpload = Paths.get("hello.txt"); 
            byte[] fileContentBytes; 

            // Streams to gather file data and then send that to the server. 
            DataInputStream getFileContent = new DataInputStream(Files.newInputStream(fileToUpload, READ)); 
            DataOutputStream sendFileContent = new DataOutputStream(client.getOutputStream()); 
            
            int len; 
            String expected = "Your file named \"Server[0-9]{3}.txt\" with a size of XXXX bytes has been uploaded correctly"; 
            
            fileContentBytes = getFileContent.readAllBytes(); 
            len = fileContentBytes.length; 
            expected = expected.replace("XXXX", String.valueOf(len));
            // Send the length first so that server knows when to stop.  
            sendFileContent.writeInt(len); 
            sendFileContent.write(fileContentBytes, 0, len); 
            sendFileContent.flush(); 
            
            if ((line = fromServer.readLine()).matches(expected)) {
                // Close connections. 
                System.out.println(line);
                client.close(); 
                getFileContent.close(); 
                sendFileContent.close(); 
                fromServer.close(); 
                toServer.close(); 
            } else {
                System.err.println("Something went wrong with uploading file.");
            }
            
            // Close connection anyways even if file wasn't able to upload properly. 
            client.close(); 
            getFileContent.close(); 
            sendFileContent.close(); 
            fromServer.close(); 
            toServer.close(); 
            
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