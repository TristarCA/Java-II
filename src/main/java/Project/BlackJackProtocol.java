package Project;

import org.json.simple.JSONObject;

/**
 * The BlackJackProtocol class manages the state and flow of a Blackjack game.
 * It processes player inputs and updates the game state accordingly.
 * This class communicates with clients using JSON objects.
 */
public class BlackJackProtocol {
    // Game states
    private static final int WAITING = 0;
    private static final int IN_GAME = 1;
    private static final int BETTING = 2;
    private static final int PLAYER_TURN = 3;
    private static final int GAME_OVER = 4;

    private int state = WAITING;
    private Dealer dealer;
    private Player player;
    private double bet;

    /**
     * Processes the input from the client and returns the appropriate game state and message.
     *
     * @param inputJson The input JSON object received from the client.
     * @return A JSON object containing the response message and current game state.
     */
    public JSONObject processInput(JSONObject inputJson) {
        String theOutput = "";

        // Initial state: Waiting for the client to connect and start the game
        if (inputJson == null) {
            state = IN_GAME;
            JSONObject initialMessage = new JSONObject();
            theOutput = "Welcome! Would you like to play BlackJack? Y/N:";
            initialMessage.put("message", theOutput);
            initialMessage.put("state", state);
            return initialMessage;
        }

        String theInput = (String) inputJson.get("input");

        switch (state) {
            /**
             * IN_GAME state: The client is prompted to start a new game.
             * If the client agrees, the game transitions to the BETTING state.
             */
            case IN_GAME:
                if ("Y".equalsIgnoreCase(theInput)) {
                    dealer = new Dealer();
                    player = new Player(100.00);
                    theOutput = String.format("You have $%.2f. How much would you like to bet?\n", player.getMoney());
                    state = BETTING;
                } else if ("N".equalsIgnoreCase(theInput)) {
                    theOutput = "Bye.\n";
                    state = WAITING;
                } else {
                    theOutput = "Please choose Y or N\n";
                }
                break;

            /**
             * BETTING state: The client places a bet and is then dealt cards.
             * The game transitions to the PLAYER_TURN state after dealing the cards.
             */
            case BETTING:
                try {
                    bet = Double.parseDouble(theInput);
                    if (bet > player.getMoney() || bet <= 0) {
                        theOutput = String.format("Invalid bet. Please enter a valid amount up to $%.2f\n", player.getMoney());

                    } else {
                        player.receiveCard(dealer.dealCard());
                        player.receiveCard(dealer.dealCard());
                        dealer.receiveCard(dealer.dealCard());
                        dealer.receiveCard(dealer.dealCard());

                        theOutput = "Dealer's hand:\n" + dealer.showHand() + "\nPlayer's hand:\n" + player.showHand();
                        theOutput += "\nHit (1) or Stay (2)?\n";
                        state = PLAYER_TURN;
                    }
                } catch (NumberFormatException e) {
                    theOutput = "Invalid input. Please enter a numeric value for the bet.\n";
                }
                break;

            /**
             * PLAYER_TURN state: The client chooses whether to hit (draw another card) or stay.
             * If the player busts, the game transitions to GAME_OVER. Otherwise, the dealer's turn begins.
             */
            case PLAYER_TURN:
                if ("1".equals(theInput)) {
                    player.receiveCard(dealer.dealCard());
                    theOutput = "Player's hand:\n" + player.showHand();
                    if (player.getScore() > 21) {
                        player.adjustCash(-bet);
                        theOutput += "\nPlayer busts. Dealer wins. ";
                        if (player.getMoney() > 0) {
                            theOutput += "Continue playing? (Yes = Y, No = N)\n";
                            state = GAME_OVER;
                        } else {
                            theOutput += "You have no money left. Game over. Bye.\n";
                            state = WAITING;
                        }
                    } else {
                        theOutput += "\nHit (1) or Stay (2)?\n";
                    }
                } else if ("2".equals(theInput)) {
                    while (dealer.getScore() < 17) {
                        dealer.receiveCard(dealer.dealCard());
                    }
                    theOutput = "Dealer's hand:\n" + dealer.showHand();

                    if (dealer.getScore() > 21 || player.getScore() > dealer.getScore()) {
                        theOutput += "\nPlayer wins!\n";
                        player.adjustCash(bet);
                    } else {
                        theOutput += "\nDealer wins.\n";
                        player.adjustCash(-bet);
                    }
                    if (player.getMoney() > 0) {
                        theOutput += "\nContinue playing? (Yes = Y, No = N)\n";
                        state = GAME_OVER;
                    } else {
                        theOutput += "You have no money left. Game over. Bye.\n";
                        state = WAITING;
                    }
                } else {
                    theOutput = "Invalid choice. Hit (1) or Stay (2)?\n";
                }
                break;

            /**
             * GAME_OVER state: The client decides whether to continue playing or end the game.
             * If the player chooses to continue, the game resets and transitions to the BETTING state.
             * If the player chooses to quit, the final payout is displayed and the game ends.
             */
            case GAME_OVER:
                if ("Y".equalsIgnoreCase(theInput)) {
                    dealer.reset();
                    player.reset();
                    state = BETTING;
                    theOutput = String.format("You have $%.2f. How much would you like to bet?\n", player.getMoney());
                } else if ("N".equalsIgnoreCase(theInput)) {
                    theOutput = String.format("Game over. Your final payout is $%.2f. Bye.\n", player.getMoney());
                    state = WAITING;
                } else {
                    theOutput = "Please choose Y or N\n";
                }
                break;
        }

        JSONObject responseJson = new JSONObject();
        responseJson.put("message", theOutput);
        responseJson.put("state", state);
        return responseJson;
    }
}
