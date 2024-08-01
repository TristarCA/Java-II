package ServerClientStuff;

import Project.BJMultiServerThread;

import java.net.*;
import java.io.*;

public class KnockKnockServer {
    public static void main(String[] args) throws IOException {
        int portNumber = 4401;

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            while (true) {
                new BJMultiServerThread(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port " + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
