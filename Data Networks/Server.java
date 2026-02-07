import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.InputMismatchException;

public class Server {
    /**
     * Creates the ServerSocket to send the txt file to the Client Socket
     * 
     * @param args takes a single argument specifying the port number
     * @throws Exception any errors regarding the arguments and the sockets
     */
    public static void main(String[] args) throws Exception {
        if (args.length > 1) {
            throw new InputMismatchException("Expected 1 arguments, but got multiple!");
        }

        if (args.length == 0) {
            throw new InputMismatchException("Expected 1 argument, but got 0!");
        }
        
        if (args[0].matches("\\D")) {
            throw new InputMismatchException("1st argument must be a int!");
        }
        
        int port = Integer.parseInt(args[0]);
        ServerSocket server;
        System.out.printf("Server created at %d%n", port);
        Socket client;
        // Create i/o streams from server file to Client
        BufferedInputStream fromFile;
        BufferedOutputStream toClient;
        
        // Attempts to send txt file to client socket
        try {
            server = new ServerSocket(port);
            client = server.accept();
            fromFile = new BufferedInputStream(new FileInputStream("server_file.txt"));
            toClient = new BufferedOutputStream(client.getOutputStream());
            System.out.println("Sending data to client...");
            
            // Holds the bytes and also the total # of bytes read from the file. 
            byte[] data = new byte[client.getReceiveBufferSize()];
            int bytesRead;
            while ((bytesRead = fromFile.read(data)) != -1) {
                /*
                 * Include the bytesRead to prevent sending bytes in buffer,
                 * BUT not in file. i.e bytes read from file only fill up half
                 * of the buffer (data).
                */
                toClient.write(data, 0, bytesRead);
            }

            toClient.flush();
            System.out.println("Data sent!");
            server.close();
            client.close();
            fromFile.close();
            toClient.close();
        } catch (BindException | IllegalArgumentException e) {
            throw e;
        }

        // When the sockets and streams don't close in try-catch
        if (!server.isClosed()) { 
            server.close(); 
        }
        if (!client.isClosed()) { 
            server.close(); 
        }
        fromFile.close();
        toClient.close();

    }
}