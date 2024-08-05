package Project;

import java.net.*;
import java.io.*;

/**
 * The BJMultiServer class listens for client connections and starts a new thread to handle each client.
 * It allows multiple clients to connect simultaneously by creating a new BJMultiServerThread for each connection.
 */
public class BJMultiServer {
    public static void main(String[] args) throws IOException {
        int portNumber = 4401;
        boolean listening = true;

        /**
         * Creates a server socket and listens for client connections.
         * For each connection, a new BJMultiServerThread is started to handle communication with the client.
         */
        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            while (listening) {
                new BJMultiServerThread(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port " + portNumber);
            System.exit(-1);
        }
    }
}
