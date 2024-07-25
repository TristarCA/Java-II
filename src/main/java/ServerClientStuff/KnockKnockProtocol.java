package ServerClientStuff;
import Project.Dealer;
import Project.Player;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class KnockKnockProtocol {
    private static final int WAITING = 0;
    private static final int SENTKNOCKKNOCK = 1;
    private static final int SENTCLUE = 2;
    private static final int ANOTHER = 3;

    private static final int NUMJOKES = 5;

    private int state = WAITING;
    private int currentJoke = 0;

    private String[] clues = { "Turnip", "Little Old Lady", "Atch", "Who", "Who" };
    private String[] answers = { "Turnip the heat, it's cold in here!",
            "I didn't know you could yodel!",
            "Bless you!",
            "Is there an owl in here?",
            "Is there an echo in here?" };

    public String processInput(String theInput) {
        String theOutput = null;

        if (state == WAITING) {
            theOutput = "Would you like to play BlackJack? Y/N:";
            state = SENTKNOCKKNOCK;
        } else if (state == SENTKNOCKKNOCK) {
            if (theInput.equalsIgnoreCase("Y")) {
                Scanner input = new Scanner(System.in);
                PrintStream stream = new PrintStream(System.out);
                Dealer dealer = new Dealer();
                Player player = new Player(100.00);

                boolean isGameOver = false;
                while (!isGameOver) {
                    stream.println("You have $" + player.getMoney() + ". How much would you like to bet?");
                    double bet = input.nextDouble();
                    while (bet > player.getMoney() || bet <= 0) {
                        stream.println("Invalid bet. Please enter a valid amount up to $" + player.getMoney());
                        bet = input.nextDouble();
                    }

                    player.receiveCard(dealer.dealCard());
                    player.receiveCard(dealer.dealCard());
                    dealer.receiveCard(dealer.dealCard());
                    dealer.receiveCard(dealer.dealCard());

                    stream.println("Dealer's hand:");
                    dealer.showHand();
                    stream.println("Player's hand:");
                    player.showHand();

                    boolean playerTurn = true;
                    while (playerTurn && player.getScore() < 21) {
                        stream.println("Hit (1) or Stay (2)?");
                        int choice = input.nextInt();
                        if (choice == 1) {
                            player.receiveCard(dealer.dealCard());
                            player.showHand();
                            if (player.getScore() > 21) {
                                stream.println("Player busts. Dealer wins.");
                                player.adjustCash(-bet);
                                playerTurn = false;
                            }
                        } else {
                            playerTurn = false;
                        }
                    }

                    if (player.getScore() <= 21) {
                        while (dealer.getScore() < 17) {
                            dealer.receiveCard(dealer.dealCard());
                        }
                        dealer.showHand();

                        if (dealer.getScore() > 21 || player.getScore() > dealer.getScore()) {
                            stream.println("Player wins!");
                            player.adjustCash(bet);
                        } else {
                            stream.println("Dealer wins.");
                            player.adjustCash(-bet);
                        }
                    }

                    stream.println("Continue playing? (Yes = 1, No = 0)");
                    if (input.nextInt() == 0 || player.getMoney() <= 0) {
                        isGameOver = true;
                    } else {
                        dealer.reset();
                        player.reset();
                    }
                }

                stream.println("Game over! Your final balance is $" + player.getMoney());
                input.close();
                state = SENTCLUE;
            } else if (theInput.equalsIgnoreCase("N")) {
                theOutput = "Bye.";
            } else {
                theOutput = "Please choose Y or N";
            }
        } else if (state == SENTCLUE) {
            if (theInput.equalsIgnoreCase(clues[currentJoke] + " who?")) {
                theOutput = answers[currentJoke] + " Want another? (y/n)";
                state = ANOTHER;
            } else {
                theOutput = "You're supposed to say \"" +
                        clues[currentJoke] +
                        " who?\"" +
                        "! Try again. Knock! Knock!";
                state = SENTKNOCKKNOCK;
            }
        } else if (state == ANOTHER) {
            if (theInput.equalsIgnoreCase("y")) {
                theOutput = "Knock! Knock!";
                if (currentJoke == (NUMJOKES - 1))
                    currentJoke = 0;
                else
                    currentJoke++;
                state = SENTKNOCKKNOCK;
            } else {
                theOutput = "Bye.";
                state = WAITING;
            }
        }
        return theOutput;
    }
}
