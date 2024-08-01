package Project;

import java.net.*;
import java.io.*;

public class BJMultiServer {
    public static void main(String[] args) throws IOException {
        int portNumber = 4401;
        boolean listening = true;

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
