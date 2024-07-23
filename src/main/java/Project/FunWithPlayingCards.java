package Project;

import java.util.Scanner;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 * The FunWithPlayingCards class is a simple interactive program that allows users
 * to perform actions with a deck of playing cards, such as drawing cards, drawing a hand,
 * displaying the hand, shuffling the deck, and printing the entire deck.
 */
public class FunWithPlayingCards {

    /**
     * The main method where the program starts execution.
     *
     * @param args The command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        Dealer dealer = new Dealer();

        Scanner input = new Scanner(System.in);
        PrintStream stream = new PrintStream(System.out);
        int choice;
        int cont = 1;
        ArrayList<PlayingCard> hand = new ArrayList<>();
        stream.println("Fun with Playing Cards!");
        stream.println("Creating Deck....");
        Player player = new Player(100.00);
        stream.println(player.getMoney());
        stream.println("DEALERS HAND");
        dealer.getHand();
        ArrayList<PlayingCard> cardsForPlayer = dealer.dealCards();
        stream.println("PLAYERS HAND");
        for (PlayingCard card : cardsForPlayer) {
            player.receiveCard(card);
        }
        player.getHand();

        while (cont != 0) {
            stream.println("****What would you like to do?****");
            stream.printf("        CURRENT SCORE: %s\n", player.getScore());
            stream.printf("        DEALER SCORE:  %s \n", dealer.getScore());
            stream.println("-------------------------------------");
            stream.println("|1.| Draw a Card.");
            stream.println("|2.| Draw a Hand (5 Cards).");
            stream.println("|3.| Display the Hand.");
            stream.println("|5.| Print the Deck.");
            choice = input.nextInt();

            if (choice == 1) {
                hand.add(dealer.getTopCard());
            }  else if (choice == 3) {
                for (PlayingCard card : hand) {
                    PlayingCard.printAsciiCard(card, stream);
                    stream.println();
                }
            } else {
                stream.println("Not a valid Choice. Try Again.....");
            }

            stream.println("Continue....?(0 to exit)");
            cont = input.nextInt();
        } stream.println("BYE BYE!");
    }
}
