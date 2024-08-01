package Project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import org.json.simple.JSONObject;

public class Client2 {
    public static void main(String[] args) throws IOException {
        String hostName = "localhost";
        int portNumber = 4401;

        try (
                Socket socket = new Socket(hostName, portNumber);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))
        ) {
            String userInput;

            // Read initial game state from server
            String fromServer = in.readLine();
            JSONObject gameState = (JSONObject) org.json.simple.JSONValue.parse(fromServer);
            processGameMessage(gameState);

            while ((userInput = stdIn.readLine()) != null) {
                JSONObject inputJson = new JSONObject();
                inputJson.put("input", userInput);

                out.println(inputJson.toJSONString());

                fromServer = in.readLine();
                gameState = (JSONObject) org.json.simple.JSONValue.parse(fromServer);
                if (processGameMessage(gameState)) {
                    break; // Disconnect if the game is over and the player has no money left
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean processGameMessage(JSONObject gameState) {
        System.out.println("Server: " + gameState.get("message"));

        String message = (String) gameState.get("message");
        // Check for game over message indicating no money left
        if (message != null && message.contains("You have no money left. Game over. Bye.")) {
            return true;
        }
        return false;
    }
}
