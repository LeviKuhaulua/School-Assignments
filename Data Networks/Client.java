import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.InputMismatchException;
public class Client {
    /**
     * Creates a client socket to connect to the Server to receive the txt file
     * 
     * @param args takes in a single argument that is the port # of the Server
     * @throws Exception for arguments that don't match expected input and for Socket errors
     */
    public static void main(String[] args) throws Exception {
        if (args.length > 1) {
            throw new InputMismatchException("Expecting 1 argument, but got multiple!");
        }

        if (args.length == 0) {
            throw new InputMismatchException("Expecting 1 argument, but got 0!");
        }

        if (args[0].matches("\\D")) {
            throw new InputMismatchException("Argument must be an int!");
        }
        int port = Integer.parseInt(args[0]);
        Socket client;
        BufferedInputStream fromServer;

        // Creates the file when it dne, should create in parent directory
        File serverOutput = new File("client_output.txt");
        BufferedOutputStream toFile = new BufferedOutputStream(new FileOutputStream(serverOutput));
        // Make sure to add line breaks

        // Attempts to download file from the server
        try {
            client = new Socket("localhost", port);
            System.out.println("Successfully connected to server!");
            fromServer = new BufferedInputStream(client.getInputStream());
            System.out.println("Receiving data...");

            // Constructs the text data for the new file
            byte[] data = new byte[client.getReceiveBufferSize()];
            int bytesRead;
            while((bytesRead = fromServer.read(data)) != -1) {
                // Prevents issue to writing to the file (i.e the same issue as Server.java)
                toFile.write(data, 0, bytesRead);
            }

            toFile.flush();
            System.out.println("Data received!");
            client.close();
            toFile.close();
            fromServer.close(); 
        } catch (IOException | IllegalArgumentException e) {
            throw e;
        }
        
        if (!client.isClosed()) {
            client.close();
        }
        fromServer.close();
        toFile.close();
        
    }
}