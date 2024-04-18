import java.net.ServerSocket; 
import java.net.Socket; 
import java.io.IOException; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStreamReader; 
import java.io.DataInputStream; 
import java.io.DataOutputStream; 
import java.nio.file.Files; 
import static java.nio.file.StandardOpenOption.*;
import java.nio.file.Path; 
import java.nio.file.Paths; 
import java.util.Random; 

public class Server {
    public static void main(String[] args) {
        BufferedReader fromClient = null; 
        PrintWriter toClient = null; 
        String line = null; 
        Random r = new Random(); 
        String initFileName = "ServerXXX.txt"; 

        // Establish server
        try (ServerSocket server = new ServerSocket(12345); 
             Socket client = server.accept();) {

            // Set up connection between server and client. 
            fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); 
            toClient = new PrintWriter(client.getOutputStream(), true); 

            // Wait for aloha message, then send welcome received message. 
            while ((line = fromClient.readLine()) != null) {
                if (line.equalsIgnoreCase("Aloha")) {
                    toClient.println("Aloha mai kakou"); 
                    break; 
                }
            }

            int randNum = r.nextInt(100, 1000); 
            initFileName = initFileName.replace("XXX", String.valueOf(randNum)); 
            Path uploadedFile = Paths.get(initFileName); 

            DataInputStream getFileContent = new DataInputStream(client.getInputStream()); 
            DataOutputStream uploadFileContent = new DataOutputStream(Files.newOutputStream(uploadedFile, CREATE, APPEND)); 
            byte[] fileContentBytes; 
           
            // Receive the length of the file then read that amount into the byte[] array. 
            int length = getFileContent.readInt(); 
            fileContentBytes = getFileContent.readNBytes(length); 

            uploadFileContent.write(fileContentBytes, 0, length); 
            uploadFileContent.flush(); // immediately write content to file. 

            toClient.println("Your file named \"" + uploadedFile.getFileName().toString() + "\" with a size of " 
            + (int) Files.size(uploadedFile) + " bytes has been uploaded correctly");

            // Close connection
            fromClient.close(); 
            toClient.close(); 
            getFileContent.close(); 
            uploadFileContent.close(); 
            server.close(); 
        } catch (IOException e) {
            System.err.println("Unable to establish connection. " + e.getMessage());
            System.exit(-1); 
        }
    }
}