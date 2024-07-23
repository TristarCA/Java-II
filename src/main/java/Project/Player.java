package Project;

import java.util.ArrayList;
import java.util.Objects;

import static Project.CardDeck.stream;

public class Player {
    private double cash;
    private ArrayList<PlayingCard> hand;
    private int total;


    public Player(double cash) {
        this.total = 0;
        this.cash = cash;
        hand = new ArrayList<>();
    }

    public double getMoney() {
        return cash;
    }

    public ArrayList<PlayingCard> getHand() {
        for (PlayingCard card : hand) {
            PlayingCard.printAsciiCard(card, stream);
            stream.println();
        }
        return null;
    }

    public void receiveCard(PlayingCard card) {
        hand.add(card);
    }

    public int getScore() {
        for (PlayingCard card : hand) {
            char cardChar = card.toString().charAt(0);
            System.out.println(cardChar);
            if (cardChar == 'J' || cardChar == 'Q' || cardChar == 'K') {
                total += 10;
            } else if (cardChar == 'A') {
                if (total + 10 > 21) {
                    total += 1;
                } else {
                    total += 11;
                }
            } else {
                total += card.getValue();
            }
        }
        return total;
    }
}
