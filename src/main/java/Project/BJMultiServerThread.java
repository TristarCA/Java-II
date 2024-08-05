package Project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import org.json.simple.JSONObject;

/**
 * The BJMultiServerThread class handles communication between the server and a single client in a multithreaded environment.
 * It manages the input/output streams for the client and processes the game logic using the BlackJackProtocol class.
 */
public class BJMultiServerThread extends Thread {
    private Socket clientSocket;

    /**
     * Constructs a new BJMultiServerThread with the specified client socket.
     *
     * @param clientSocket The socket connected to the client.
     */
    public BJMultiServerThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    /**
     * The main logic for handling client communication and processing game states.
     * This method runs in a separate thread for each client connection.
     */
    public void run() {
        try (
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ) {
            BlackJackProtocol protocol = new BlackJackProtocol();
            String inputLine;

            JSONObject initialMessage = protocol.processInput(null);
            out.println(initialMessage.toJSONString());

            while ((inputLine = in.readLine()) != null) {
                JSONObject inputJson = (JSONObject) org.json.simple.JSONValue.parse(inputLine);
                JSONObject outputJson = protocol.processInput(inputJson);
                out.println(outputJson.toJSONString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
