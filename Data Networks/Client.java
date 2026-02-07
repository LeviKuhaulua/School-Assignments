import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
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

        File client_status = new File("client_status.txt");
        FileWriter out;

        int port = Integer.parseInt(args[0]);
        Socket client;
        BufferedInputStream fromServer;

        // Creates the file when it dne, should create in parent directory
        File serverOutput = new File("client_output.txt");
        BufferedOutputStream toFile;

        // Attempts to download file from the server
        try {
            client = new Socket("localhost", port); 
            out = new FileWriter(client_status);
            out.write("Successfully connected to server at port " + port + "\n");
            fromServer = new BufferedInputStream(client.getInputStream());
            toFile = new BufferedOutputStream(new FileOutputStream(serverOutput));
            out.write("Receiving data...\n");

            // Constructs the text data for the new file
            byte[] data = new byte[client.getReceiveBufferSize()];
            int bytesRead;
            while((bytesRead = fromServer.read(data)) != -1) {
                // Prevents issue to writing to the file (i.e the same issue as Server.java)
                toFile.write(data, 0, bytesRead);
            }

            toFile.flush();
            out.write("Data received!");

            client.close();
            toFile.close();
            fromServer.close(); 
            out.close();
        } catch (IOException | IllegalArgumentException e) {
            throw e;
        }
        
        // When resources not closed
        if (!client.isClosed()) {
            client.close();
        }
        fromServer.close();
        toFile.close();
        out.close();
        
    }
}