package Project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import org.json.simple.JSONObject;

/**
 * The Client2 class handles the client-side communication with the BlackJack server.
 * It connects to the server, sends user inputs, receives game states, and displays messages to the user.
 */
public class Client2 {
    public static void main(String[] args) throws IOException {
        String hostName = "localhost";
        int portNumber = 4401;

        /**
         * Establishes a connection to the server and handles the game flow.
         * The client sends user inputs to the server and processes the responses.
         */
        try (
                Socket socket = new Socket(hostName, portNumber);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))
        ) {
            String userInput;

            String fromServer = in.readLine();
            JSONObject gameState = (JSONObject) org.json.simple.JSONValue.parse(fromServer);
            processGameMessage(gameState);

            // Continuously read user input, send it to the server, and process the server's response
            while ((userInput = stdIn.readLine()) != null) {
                JSONObject inputJson = new JSONObject();
                inputJson.put("input", userInput);

                out.println(inputJson.toJSONString());

                fromServer = in.readLine();
                gameState = (JSONObject) org.json.simple.JSONValue.parse(fromServer);
                if (processGameMessage(gameState)) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Processes the game message received from the server and displays it to the user.
     * If the message contains "Bye.", the client will terminate the connection.
     *
     * @param gameState The JSONObject representing the game state received from the server.
     * @return True if the game is over and the client should disconnect, otherwise false.
     */
    private static boolean processGameMessage(JSONObject gameState) {
        System.out.println("Server: " + gameState.get("message"));

        String message = (String) gameState.get("message");
        if (message != null && message.contains("Bye.")) {
            return true;
        }
        return false;
    }
}
