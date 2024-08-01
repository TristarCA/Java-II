package Project;

import org.json.simple.JSONObject;

public class BlackJackProtocol {
    private static final int WAITING = 0;
    private static final int IN_GAME = 1;
    private static final int BETTING = 2;
    private static final int PLAYER_TURN = 3;
    private static final int GAME_OVER = 4;

    private int state = WAITING;
    private Dealer dealer;
    private Player player;
    private double bet;

    public JSONObject processInput(JSONObject inputJson) {
        String theOutput = "";

        if (inputJson == null) {
            JSONObject initialMessage = new JSONObject();
            initialMessage.put("message", "Welcome please join us at the table");
            initialMessage.put("state", WAITING);
            return initialMessage;
        }

        String theInput = (String) inputJson.get("input");

        switch (state) {
            case WAITING:
                theOutput = "Would you like to play BlackJack? Y/N:";
                state = IN_GAME;
                break;

            case IN_GAME:
                if ("Y".equalsIgnoreCase(theInput)) {
                    dealer = new Dealer();
                    player = new Player(100.00);
                    theOutput = "You have $" + player.getMoney() + ". How much would you like to bet?\n";
                    state = BETTING;
                } else if ("N".equalsIgnoreCase(theInput)) {
                    theOutput = "Bye.\n";
                    state = WAITING;
                } else {
                    theOutput = "Please choose Y or N\n";
                }
                break;

            case BETTING:
                try {
                    bet = Double.parseDouble(theInput);
                    if (bet > player.getMoney() || bet <= 0) {
                        theOutput = "Invalid bet. Please enter a valid amount up to $" + player.getMoney() + "\n";
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
                        theOutput += "\nYou have no money left. Game over. Bye.\n";
                        state = WAITING;
                    }
                } else {
                    theOutput = "Invalid choice. Hit (1) or Stay (2)?\n";
                }
                break;

            case GAME_OVER:
                if ("Y".equalsIgnoreCase(theInput)) {
                    dealer.reset();
                    player.reset();
                    state = BETTING;
                    theOutput = "You have $" + player.getMoney() + ". How much would you like to bet?\n";
                } else {
                    theOutput = "Bye.\n";
                    state = WAITING;
                }
                break;
        }

        JSONObject responseJson = new JSONObject();
        responseJson.put("message", theOutput);
        responseJson.put("state", state);
        // Convert Dealer and Player objects to simple JSON strings
        if (dealer != null) {
            responseJson.put("dealerHand", dealer.getHand().toString());
            responseJson.put("dealerScore", dealer.getScore());
        }
        if (player != null) {
            responseJson.put("playerHand", player.getHand().toString());
            responseJson.put("playerScore", player.getScore());
        }
        return responseJson;
    }
}
