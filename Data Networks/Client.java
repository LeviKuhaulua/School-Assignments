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
        try {
            client = new Socket("localhost", port);
            System.out.println("Successfully connected to server!");


            client.close();
        } catch (IOException e) {
            throw e;
        }
        
        if (!client.isClosed()) {
            client.close();
        }
        
    }
}