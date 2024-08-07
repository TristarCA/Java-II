package ServerClientStuff;
import java.net.*;
import java.io.*;

public class EchoServer {
    public static void main(String[] args) throws IOException {

//        if (args.length != 1) {
//            System.err.println("Usage: java EchoServer <port number>");
//            System.exit(1);
//        }
//
//        int portNumber = Integer.parseInt(args[0]);

        int portNumber = 8800;

        try (
                ServerSocket serverSocket = new ServerSocket(portNumber);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out =
                        new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
        ) {
            String inputLine;
            int i = 1;
            while ((inputLine = in.readLine()) != null) {
                out.println(inputLine);
                System.out.printf("%d: %s\n", i, inputLine);
                i++;
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
