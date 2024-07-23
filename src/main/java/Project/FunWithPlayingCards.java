package Project;

import java.util.Scanner;
import java.io.PrintStream;

public class FunWithPlayingCards {
    public static void main(String[] args) {
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
    }
}
