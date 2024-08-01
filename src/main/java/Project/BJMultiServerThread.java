package Project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import org.json.simple.JSONObject;

public class BJMultiServerThread extends Thread {
    private Socket clientSocket;

    public BJMultiServerThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
        try (
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ) {
            BlackJackProtocol protocol = new BlackJackProtocol();
            String inputLine;

            // Send initial game state to client
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
