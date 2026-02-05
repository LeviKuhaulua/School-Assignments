import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.InputMismatchException;

public class Server {
    /**
     * Creates the ServerSocket to send the txt file to the Client Socket
     * 
     * @param args takes a single argument specifying the port number
     * @throws Exception any errors regarding the argument and the sockets
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
        
        // Attempts to send txt file to client socket
        try {
            server = new ServerSocket(port);
            Socket client = server.accept();



            server.close();
            client.close();
        } catch (BindException e) {
            throw e;
        }

        // For when there is error in try-catch
        if (!server.isClosed()) {
            server.close();
        }
    }
}